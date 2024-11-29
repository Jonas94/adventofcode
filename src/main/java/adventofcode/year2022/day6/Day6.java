package adventofcode.year2022.day6;

import adventofcode.utils.FileHandler;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day6 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        String datastreamBuffer = lines.get(0);
        
        return findIndexOfFirstUniqueSequence(4, datastreamBuffer);
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        String datastreamBuffer = lines.get(0);

        return findIndexOfFirstUniqueSequence(14, datastreamBuffer);
    }

    private int findIndexOfFirstUniqueSequence(int sizeOfUniqueSequence, String datastreamBuffer) {
        for (int i = sizeOfUniqueSequence; i < datastreamBuffer.length(); i++) {
            Set<Character> chars = datastreamBuffer.substring(i - sizeOfUniqueSequence, i).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

            if (chars.size() == sizeOfUniqueSequence) {
                return i;
            }
        }
        return -1;
    }
}
