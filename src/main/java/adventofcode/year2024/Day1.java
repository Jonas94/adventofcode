package adventofcode.year2024;

import adventofcode.utils.FileHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day1 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        List<List<Integer>> lists = parseInputToSeparateLists(lines);
        List<Integer> leftList = lists.get(0);
        List<Integer> rightList = lists.get(1);

        int totalDistance = 0;
        for (int i = 0; i < leftList.size(); i++) {
            int left = leftList.get(i);
            int right = rightList.get(i);

            int distance = Math.abs(left - right);
            totalDistance = totalDistance + distance;
        }

        return totalDistance;
    }

    private List<List<Integer>> parseInputToSeparateLists(List<String> input) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for (String line : input) {
            String[] strings = line.split(" {3}");

            leftList.add(Integer.parseInt(strings[0]));
            rightList.add(Integer.parseInt(strings[1]));
        }

        leftList.sort(Comparator.naturalOrder());
        rightList.sort(Comparator.naturalOrder());
        return List.of(leftList, rightList);
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        List<List<Integer>> lists = parseInputToSeparateLists(lines);
        List<Integer> leftList = lists.get(0);
        List<Integer> rightList = lists.get(1);

        int totalSimilarityScore = 0;
        for (int i = 0; i < leftList.size(); i++) {
            int left = leftList.get(i);
            long numberOfOccurrencesInRightList = rightList.stream().filter(value -> value == left).count();
            totalSimilarityScore = (int) (totalSimilarityScore + (left * numberOfOccurrencesInRightList));
        }

        return totalSimilarityScore;
    }

}
