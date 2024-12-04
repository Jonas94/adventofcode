package adventofcode.year2024;

import adventofcode.utils.FileHandler;
import adventofcode.year2020.day8.Instruction;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day3 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        List<String> instructions = new ArrayList<>();
        for (String line : lines) {
            instructions.addAll(findAllInstructions(line));
        }

        long total = 0;
        for (String instruction : instructions) {

            total = total + calculateInstruction(instruction);
        }

        return total;
    }

    private long calculateInstruction(String instruction) {
        String[] numberStrings = instruction.replaceAll("[^0-9,]", "").split(",");

        List<Integer> values = Arrays.stream(numberStrings).map(Integer::parseInt).collect(Collectors.toList());

        return (long) values.get(0) * values.get(1);

    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        int total = 0;
        boolean instructionsEnabled = true;
        for (String line : lines) {
            Map<Integer, String> actions = new HashMap<>();
            List<String> instructions = new ArrayList<>();
            List<Integer> enables = findIndexOfWord(line, "do()");
            List<Integer> disables = findIndexOfWord(line, "don't()");
            List<Integer> allIndexes = new ArrayList<>();

            allIndexes.addAll(enables);
            allIndexes.addAll(disables);
            allIndexes.sort(Comparator.naturalOrder());
            for (Integer index : enables) {
                actions.put(index, "do()");
            }

            for (Integer index : disables) {
                actions.put(index, "don't()");
            }

            int substringIndex = instructionsEnabled ? 0 : allIndexes.get(0);
            boolean hasRead = false;
            for (int i = 0; i < allIndexes.size(); i++) {
                int currentIndex = allIndexes.get(i);
                if (actions.get(currentIndex).equals("don't()")) {
                    if (!hasRead) {
                        System.out.println("READING FROM: " + substringIndex + " TO: " + currentIndex);
                        instructions.addAll(findAllInstructions(line.substring(substringIndex, currentIndex)));
                        hasRead = true;
                    }

                } else if (actions.get(currentIndex).equals("do()")) {
                    if (hasRead) {
                        substringIndex = currentIndex + 1;
                        hasRead = false;
                    }
                }
                if (i >= allIndexes.size() - 1) {
                    if (!hasRead) {
                        instructions.addAll(findAllInstructions(line.substring(substringIndex)));
                        System.out.println("READING FROM: " + substringIndex + " TO: " + line.length() + " (END)");
                    }
                }


            }

            if (actions.get(allIndexes.getLast()).equals("don't()")) {
                instructionsEnabled = false;
            } else {
                instructionsEnabled = true;
            }
            for (String instruction : instructions) {

                total = (int) (total + calculateInstruction(instruction));
            }

        }

        return total;
    }

    public List<String> findAllInstructions(String s) {
        String pattern = "mul\\(\\d+,\\d+\\)";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(s);

        List<String> matches = new ArrayList<>();
        while (matcher.find()) {
            matches.add(matcher.group());

        }
        return matches;
    }


    public List<Integer> findIndexOfWord(String instruction, String word) {
        List<Integer> positions = new ArrayList<>();
        int index = instruction.indexOf(word); // Find first occurrence

        while (index != -1) {
            positions.add(index); // Store the index
            index = instruction.indexOf(word, index + 1); // Find next occurrence
        }

        return positions;
    }
}
