package adventofcode.year2024;

import adventofcode.utils.FileHandler;

import java.util.*;

public class Day11 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        return findCountOfStonesOptimized(lines, 25);

    }

    private long findCountOfStonesOptimized(List<String> lines, int runs) {
        long countOfStones = 0;
        for (String line : lines) {
            List<Long> stones = Arrays.stream(line.split(" ")).map(Long::parseLong).toList();

            Map<Long, Long> map = new HashMap<>();

            for (Long stone : stones) {
                map.put(stone, map.getOrDefault(stone, 0L) + 1);
            }


            for (int j = 0; j < runs; j++) {
                Map<Long, Long> tempMap = new HashMap<>();
                for (Long key : map.keySet()) {

                    if (key == 0) {
                        tempMap.put(1L, map.get(0L));
                    } else if (String.valueOf(key).length() % 2 == 0) {
                        String stoneString = String.valueOf(key);

                        long count = map.get(key);
                        int middle = stoneString.length() / 2;
                        Long leftStone = Long.parseLong(stoneString.substring(0, middle));
                        Long rightStone = Long.parseLong(stoneString.substring(middle));
                        if (tempMap.containsKey(leftStone)) {
                            tempMap.put(leftStone, tempMap.get(leftStone) + count);
                        } else {
                            tempMap.put(leftStone, count);
                        }
                        if (tempMap.containsKey(rightStone)) {
                            tempMap.put(rightStone, tempMap.get(rightStone) + count);
                        } else {
                            tempMap.put(rightStone, count);
                        }

                    } else {
                        long multiplicatedKey = key * 2024;
                        long countMult = map.get(key);
                        if (tempMap.containsKey(multiplicatedKey)) {
                            tempMap.put(multiplicatedKey, tempMap.get(multiplicatedKey) + countMult);
                        } else {
                            tempMap.put(multiplicatedKey, countMult);
                        }
                    }
                }
                map = new HashMap<>(tempMap);

            }
            countOfStones = findNumberOfStonesInMap(map);

        }
        return countOfStones;
    }

    private long findNumberOfStonesInMap(Map<Long, Long> map) {
        long count = 0;
        for (Long key : map.keySet()) {

            count = count + map.get(key);

        }
        return count;
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        return findCountOfStonesOptimized(lines, 75);
    }

}
