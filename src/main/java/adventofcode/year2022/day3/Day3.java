package adventofcode.year2022.day3;

import adventofcode.utils.Converters;
import adventofcode.utils.FileHandler;

import java.util.*;

public class Day3 {
    /**
     * In ASCII table lowercase letters start at 97, uppercase letters start at 65.
     * We need to transform them to this format:
     * - Lowercase item types a through z have priorities 1 through 26.
     * - Uppercase item types A through Z have priorities 27 through 52.
     */
    private static final int LOWERCASE_REDUCE_AMOUNT = 96;
    private static final int UPPERCASE_REDUCE_AMOUNT = 38;

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        List<Character> duplicatedItems = new ArrayList<>();

        for (String line : lines) {

            int midChar = line.length() / 2;

            Set<Character> firstCompartment = Converters.stringToCharSet(line.substring(0, midChar));
            Set<Character> secondCompartment = Converters.stringToCharSet(line.substring(midChar));

            char duplicate = firstCompartment.stream().filter(secondCompartment::contains).findFirst().orElseThrow();

            duplicatedItems.add(duplicate);
        }

        int totalPriority = 0;
        for (Character item : duplicatedItems) {
            int asciiCode = item;
            totalPriority += convertFromAsciiToPriority(asciiCode);
        }

        return totalPriority;
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        int totalPriority = 0;
        for (int i = 0; i < lines.size(); i += 3) {

            Set<Character> firstRucksack = Converters.stringToCharSet(lines.get(i));
            Set<Character> secondRucksack = Converters.stringToCharSet(lines.get(i + 1));
            Set<Character> thirdRucksack = Converters.stringToCharSet(lines.get(i + 2));
            int asciiCode = findCommonChar(List.of(firstRucksack, secondRucksack, thirdRucksack));
            totalPriority += convertFromAsciiToPriority(asciiCode);
        }

        return totalPriority;
    }


    private int convertFromAsciiToPriority(int asciiCode) {
        int priority;
        if (asciiCode >= LOWERCASE_REDUCE_AMOUNT) {
            priority = asciiCode - LOWERCASE_REDUCE_AMOUNT;
        } else {
            priority = asciiCode - UPPERCASE_REDUCE_AMOUNT;
        }
        return priority;
    }

    private char findCommonChar(List<Set<Character>> rucksacks) {
        Map<Character, Integer> items = new HashMap<>();

        for (Set<Character> rucksack : rucksacks) {
            rucksack.forEach(i -> items.merge(i, 1, Integer::sum));
        }

        return items.entrySet().stream()
                .filter(entry -> entry.getValue() > 2)
                .findFirst()
                .map(Map.Entry::getKey).orElseThrow();
    }

}
