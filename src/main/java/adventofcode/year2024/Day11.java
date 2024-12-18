package adventofcode.year2024;

import adventofcode.utils.FileHandler;

import java.util.*;

public class Day11 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        return findCountOfStonesOptimized(lines, 25);

    }

    private long findCountOfStones(List<String> lines, int runs) {
        long countOfStones = 0;
        for (String line : lines) {
            List<Long> stones = Arrays.stream(line.split(" ")).map(Long::parseLong).toList();

            for (int j = 0; j < runs; j++) {
                int countOfSplits = 0;
                List<Long> newStones = new ArrayList<>(stones);
                //System.out.println(j);
                for (int i = 0; i < stones.size(); i++) {

                    Long stone = stones.get(i);
                    if (stone == 0) {
                        newStones.set(i + countOfSplits, 1L);
                    } else if (String.valueOf(stone).length() % 2 == 0) {

                        String stoneString = String.valueOf(stone);

                        int middle = stoneString.length() / 2;
                        Long leftStone = Long.parseLong(stoneString.substring(0, middle));
                        Long rightStone = Long.parseLong(stoneString.substring(middle));
                        newStones.set(i + countOfSplits, leftStone);
                        newStones.add(i + countOfSplits + 1, rightStone);
                        countOfSplits++;
                    } else {
                        newStones.set(i + countOfSplits, stone * 2024);
                    }
                }
                stones = new ArrayList<>(newStones);
                System.out.println(stones.size());

            }
            countOfStones = countOfStones + stones.stream().count();


        }
        //RULES
        return countOfStones;
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
                // System.out.println(j);

                Map<Long, Long> tempMap = new HashMap<>();
                for (Long key : map.keySet()) {

                    for (int y = 0; y < map.get(key); y++) {

                        if (key == 0 && y == 0) {
                            tempMap.put(1L, map.get(0L));
                        } else if (String.valueOf(key).length() % 2 == 0) {
                            String stoneString = String.valueOf(key);

                            int middle = stoneString.length() / 2;
                            Long leftStone = Long.parseLong(stoneString.substring(0, middle));
                            Long rightStone = Long.parseLong(stoneString.substring(middle));
                            if (tempMap.containsKey(leftStone)) {
                                tempMap.put(leftStone, tempMap.get(leftStone) + 1);
                            } else {
                                tempMap.put(leftStone, 1L);
                            }
                            if (tempMap.containsKey(rightStone)) {
                                tempMap.put(rightStone, tempMap.get(rightStone) + 1);
                            } else {
                                tempMap.put(rightStone, 1L);
                            }

                        } else if (key != 0) {
                            long multiplicatedKey = key * 2024;
                            if (tempMap.containsKey(multiplicatedKey)) {
                                tempMap.put(multiplicatedKey, tempMap.get(multiplicatedKey) + 1);
                            } else {
                                tempMap.put(multiplicatedKey, 1L);

                            }
                        }
                    }

                }
                map = new HashMap<>(tempMap);

                System.out.println(findNumberOfStonesInMap(map));

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
