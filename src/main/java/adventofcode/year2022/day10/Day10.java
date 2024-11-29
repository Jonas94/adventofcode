package adventofcode.year2022.day10;

import adventofcode.utils.FileHandler;
import adventofcode.utils.GridHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day10 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        int registerX = 1;
        int cycle = 0;

        Map<Integer, Integer> signalStrength = new HashMap<>();
        for (String instruction : lines) {

            if (instruction.equals("noop")) {
                cycle++;
                if (isInterestingSignalStrengthCycle(cycle)) {
                    signalStrength.put(cycle, cycle * registerX);
                }
            } else if (instruction.contains("addx")) {

                for (int i = 0; i < 2; i++) {
                    cycle++;
                    if (isInterestingSignalStrengthCycle(cycle)) {
                        signalStrength.put(cycle, cycle * registerX);
                    }

                    if (i > 0) {
                        String[] array = instruction.split(" ");
                        registerX += Integer.parseInt(array[1]);
                    }
                }
            }
        }

        return signalStrength.values().stream().reduce(0, Integer::sum);
    }

    private boolean isInterestingSignalStrengthCycle(int cycle) {
        return (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220);
    }

    private int getVerticalLine(int cycle) {
        if (cycle < 41) {
            return 0;
        } else if (cycle < 81) {
            return 1;
        } else if (cycle < 121) {
            return 2;
        } else if (cycle < 161) {
            return 3;
        } else if (cycle < 201) {
            return 4;
        } else if (cycle < 241) {
            return 5;
        }

        return -1;
    }

    private int getHorizontalLine(int cycle) {
        while (cycle > 40) {
            cycle -= 40;
        }
        return cycle;

    }

    public String part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        int registerX = 1;
        int cycle = 1;
        String[][] grid = GridHelper.initStringGrid(6, 40);

        for (String instruction : lines) {

            if (instruction.equals("noop")) {
                draw(grid, cycle, registerX);
                cycle++;


            } else if (instruction.contains("addx")) {

                for (int i = 0; i < 2; i++) {
                    draw(grid, cycle, registerX);

                    if (i > 0) {
                        String[] array = instruction.split(" ");
                        registerX += Integer.parseInt(array[1]);
                    }
                    cycle++;
                }
            }
        }
        GridHelper.printStringGrid(grid);
        return GridHelper.getStringGridAsString(grid);
    }

    private void draw(String[][] grid, int cycle, int registerX) {
        int horizontalLine = getHorizontalLine(cycle);
        
        if (horizontalLine == registerX || horizontalLine == registerX + 1 || horizontalLine == registerX + 2) {
            grid[getVerticalLine(cycle)][horizontalLine - 1] = "#";
        }
    }
}
