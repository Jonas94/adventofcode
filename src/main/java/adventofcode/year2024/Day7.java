package adventofcode.year2024;

import adventofcode.utils.FileHandler;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Day7 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        return calculate(lines, false);
    }


    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);


        return calculate(lines, true);
    }

    private long calculate(List<String> lines, boolean includeConcat) {

        long total = 0;
        for (String line : lines) {

            long testValue = Long.parseLong(line.split(":")[0]);
            List<Long> integers = Arrays.stream(line.split(":")[1].split(" ")).filter(value -> !value.isEmpty()).map(Long::parseLong).toList();
            List<Long> tempResults = new ArrayList<>();
            tempResults.add(integers.get(0));
            List<Long> newTempResults = new ArrayList<>();


            for (int i = 1; i < integers.size(); i++) {
                for (int j = 0; j < tempResults.size(); j++) {
                    long tempResult = tempResults.get(j);
                    long currentNumber = integers.get(i);

                    newTempResults.add(tempResult * currentNumber);
                    newTempResults.add(tempResult + currentNumber);
                    if (includeConcat) {
                        newTempResults.add(Long.parseLong(tempResult + "" + currentNumber));

                    }
                }
                tempResults.clear();

                tempResults.addAll(newTempResults);
                newTempResults.clear();
            }

            if (tempResults.contains(testValue)) {
                total += testValue;
            }

            tempResults.clear();
        }



        return total;
    }


}
