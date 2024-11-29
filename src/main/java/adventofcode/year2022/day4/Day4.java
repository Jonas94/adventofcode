package adventofcode.year2022.day4;

import adventofcode.utils.FileHandler;

import java.util.*;

public class Day4 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        int numberOfTotalOverlaps = 0;
        for (String line : lines) {

            String[] elfPair = line.split(",");

            List<Set<Integer>> pairs = getSections(elfPair);

            if (pairs.get(0).containsAll(pairs.get(1)) || pairs.get(1).containsAll(pairs.get(0))) {
                numberOfTotalOverlaps++;
            }
        }

        return numberOfTotalOverlaps;
    }

    private List<Set<Integer>> getSections(String[] elfPair) {
        List<Set<Integer>> pairs = new ArrayList<>();
        for (String elf : elfPair) {
            List<Integer> boundaries = Arrays.stream(elf.split("-")).map(Integer::parseInt).toList();
            Set<Integer> elfSections = new HashSet<>();

            for (int i = boundaries.get(0); i <= boundaries.get(1); i++) {
                elfSections.add(i);
            }
            pairs.add(elfSections);
        }
        return pairs;
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        int numberOfTotalOverlaps = 0;
        for (String line : lines) {
            String[] elfPair = line.split(",");

            List<Set<Integer>> pairs = getSections(elfPair);

            if (!Collections.disjoint(pairs.get(0), pairs.get(1))) {
                numberOfTotalOverlaps++;
            }
        }

        return numberOfTotalOverlaps;
    }

}
