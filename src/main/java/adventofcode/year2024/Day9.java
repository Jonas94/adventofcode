package adventofcode.year2024;

import adventofcode.utils.FileHandler;

import java.util.*;

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

            total = total + (long) i * map.get(i);
        }
        return total;
    }

    private void printMap(Map<Integer, Integer> map) {

        for (Integer integer : map.values()) {
            System.out.print(integer == null ? "." : integer);
        }
        System.out.println();
    }


    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        String line = lines.getFirst();
        Map<Integer, Integer> map = initMap(line);

        Set<Integer> fileIdsHandled = new HashSet<>();

        //     printMap(map);

        for (int i = map.keySet().size() - 1; i > 0; i--) {

            if (map.get(i) == null) {
                continue;
            }

            int currentNumber = map.get(i);

            List<Integer> wordIndexes = new ArrayList<>();
            wordIndexes.add(i);
            for (int j = i - 1; j > 0; j--) {
                if (map.get(j) == null) {
                    continue;
                }
                if (map.get(j) == currentNumber) {
                    wordIndexes.add(j);
                } else {
                    break;
                }
            }

            int startIndexOfFreeSpace = findStartIndexOfFreeSpace(wordIndexes.size(), map);

            if (fileIdsHandled.contains(currentNumber)) {
                continue;
            }

            fileIdsHandled.add(currentNumber);

            if (startIndexOfFreeSpace == -1 || startIndexOfFreeSpace > wordIndexes.get(wordIndexes.size() - 1)) {
                i = i - (wordIndexes.size() - 1);
                continue;
            }

            int y = 0;
            for (int j = 0; j < wordIndexes.size(); j++) {
                map.put(startIndexOfFreeSpace + y, map.get(wordIndexes.get(j)));
                map.put(wordIndexes.get(j), null);
                y++;
            }

//            printMap(map);

        }

        //     System.out.println();
        //printMap(map);
        return calcChecksum(map);
    }


    public int findStartIndexOfFreeSpace(int size, Map<Integer, Integer> map) {


        for (int i = lowestIndexOfGap(map); i < map.keySet().size(); i++) {

            boolean found = true;
            for (int j = 0; j < size; j++) {
                if (map.get(j + i) != null) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return i;

            }
        }
        return -1;
    }

}
