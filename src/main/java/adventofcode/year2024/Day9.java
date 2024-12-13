package adventofcode.year2024;

import adventofcode.utils.FileHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day9 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        String line = lines.getFirst();
        Map<Integer, Integer> map = initMap(line);


        while (hasGap(map)) {

            int dataIndex = highestIndexOfData(map);
            Integer data = map.get(dataIndex);

            int freeSpaceIndex = lowestIndexOfGap(map);

            map.put(freeSpaceIndex, data);
            map.remove(dataIndex);
        }

        return calcChecksum(map);
    }

    private Map<Integer, Integer> initMap(String line) {
        Map<Integer, Integer> map = new HashMap<>();
        int currentId = 0;
        int currentPosition = 0;
        for (int i = 0; i < line.length(); i++) {
            Integer currentNumber = Integer.parseInt(String.valueOf(line.charAt(i)));

            if (i % 2 == 0) {
                //file

                for (int j = 0; j < currentNumber; j++) {
                    map.put(currentPosition, currentId);
                    currentPosition++;
                }

                currentId++;

            } else {
                for (int j = 0; j < currentNumber; j++) {
                    map.put(currentPosition, null);
                    currentPosition++;
                }
            }

        }
        return map;
    }

    private Integer highestIndexOfData(Map<Integer, Integer> map) {

        int highestIndexOfData = -1;
        for (int i = map.keySet().size() - 1; i > 0; i--) {

            if (map.get(i) != null) {
                highestIndexOfData = i;
                break;
            }
        }
        return highestIndexOfData;
    }

    private Integer lowestIndexOfGap(Map<Integer, Integer> map) {
        for (int i = 0; i < map.keySet().size(); i++) {

            if (map.get(i) == null) {
                return i;
            }

        }
        return -1;
    }

    private boolean hasGap(Map<Integer, Integer> map) {
        return highestIndexOfData(map) > lowestIndexOfGap(map);
    }

    private long calcChecksum(Map<Integer, Integer> map) {
        long total = 0;
        for (int i = 0; i < map.keySet().size(); i++) {

            if (map.get(i) == null) {
                continue;
            }

            total = total + i * map.get(i);
        }
        return total;
    }

    private void printMap(Map<Integer, Integer> map) {

        for (Integer integer : map.values()) {
            System.out.print(integer == null ? "." : integer);
        }

    }


    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        String line = lines.getFirst();
        Map<Integer, Integer> map = initMap(line);


        while (hasGap(map)) { //TODO: replace with something else

            int dataIndex = highestIndexOfData(map);
            Integer data = map.get(dataIndex);

            int freeSpaceIndex = lowestIndexOfGap(map);

            map.put(freeSpaceIndex, data);
            map.remove(dataIndex);
        }

        return calcChecksum(map);
    }

}
