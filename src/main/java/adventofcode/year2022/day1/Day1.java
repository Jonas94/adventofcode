package adventofcode.year2022.day1;

import adventofcode.utils.FileHandler;
import adventofcode.utils.ParseHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Day1 {

    public int part1(String inputFile) {
        Map<Integer, List<Integer>> caloriesMap = readStringsToMapOfCalorieLists(inputFile);

        return sumEveryBackpack(caloriesMap).stream().mapToInt(v -> v).max().orElseThrow();
    }

    public int part2(String inputFile) {
        Map<Integer, List<Integer>> caloriesMap = readStringsToMapOfCalorieLists(inputFile);

        return sumEveryBackpack(caloriesMap)
                .stream()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .reduce(0, Integer::sum);
    }

    private List<Integer> sumEveryBackpack(Map<Integer, List<Integer>> calorieMap) {
        List<Integer> calorieList = new ArrayList<>();
        calorieMap.forEach((key, value) -> calorieList.add(value.stream().reduce(0, Integer::sum)));

        return calorieList;
    }

    private Map<Integer, List<Integer>> readStringsToMapOfCalorieLists(String inputFile) {
        List<String> inputStrings = FileHandler.readFileIntoList(inputFile);
        inputStrings.add(""); //Lazy workaround: empty string to add the last elf

        Map<Integer, List<Integer>> caloriesMap = new HashMap<>();
        List<Integer> currentElfCalories = new ArrayList<>();
        int elfId = 0;

        for (String calorieAmount : inputStrings) {
            if (!StringUtils.isEmpty(calorieAmount)) {
                currentElfCalories.add(ParseHelper.parseIntOrZero(calorieAmount));
            } else {
                caloriesMap.put(elfId, List.copyOf(currentElfCalories));
                currentElfCalories.clear();
                elfId++;
            }
        }
        return caloriesMap;
    }
}
