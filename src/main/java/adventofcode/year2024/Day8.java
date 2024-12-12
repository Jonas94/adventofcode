package adventofcode.year2024;

import adventofcode.utils.FileHandler;
import adventofcode.utils.GridHelper;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Day8 {

    private Map<Character, List<Point>> initCharMap(char[][] grid) {
        Map<Character, List<Point>> charmap = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Character key = grid[i][j];

                if (key == '.') {
                    continue;
                }
                if (charmap.containsKey(key)) {
                    charmap.get(key).add(new Point(i, j));
                } else {
                    List<Point> positions = new ArrayList<>();
                    Point firstPoint = new Point(i, j);
                    positions.add(firstPoint);
                    charmap.put(key, new ArrayList<>(positions));
                }
            }
        }
        return charmap;
    }

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        char[][] grid = GridHelper.initCharGrid(lines);
        Map<Character, List<Point>> charmap = initCharMap(grid);

        Set<Point> antinodePoints = new HashSet<>();

        for (Character key : charmap.keySet()) {
            List<Point> characterPositions = charmap.get(key);

            for (int i = 0; i < characterPositions.size(); i++) {
                for (int j = 0; j < characterPositions.size(); j++) {
                    if (i == j) {
                        continue;
                    }

                    Point point1;
                    Point point2;

                    if (characterPositions.get(i).x < characterPositions.get(j).x) {
                        point1 = characterPositions.get(i);
                        point2 = characterPositions.get(j);
                    } else {
                        point1 = characterPositions.get(j);
                        point2 = characterPositions.get(i);
                    }

                    Point antinode1;
                    Point antinode2;


                    if (point1.y < point2.y) {
                        antinode1 = new Point(point2.x + Math.abs(point1.x - point2.x), point2.y + Math.abs(point1.y - point2.y));
                        antinode2 = new Point(point1.x - Math.abs(point1.x - point2.x), point1.y - Math.abs(point1.y - point2.y));
                    } else {
                        antinode1 = new Point(point2.x + Math.abs(point1.x - point2.x), point2.y - Math.abs(point1.y - point2.y));
                        antinode2 = new Point(point1.x - Math.abs(point1.x - point2.x), point1.y + Math.abs(point1.y - point2.y));

                    }

                    if (insideGrid(grid, antinode1)) {
                        antinodePoints.add(antinode1);
                    }

                    if (insideGrid(grid, antinode2)) {
                        antinodePoints.add(antinode2);
                    }
                }
            }
        }
        return antinodePoints.size();
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        char[][] grid = GridHelper.initCharGrid(lines);
        Map<Character, List<Point>> charmap = initCharMap(grid);

        Set<Point> antinodePoints = new HashSet<>();
        for (Character key : charmap.keySet()) {
            List<Point> characterPositions = charmap.get(key);

            for (int i = 0; i < characterPositions.size(); i++) {
                for (int j = 0; j < characterPositions.size(); j++) {

                    if (i == j) {
                        continue;
                    }

                    Point point1;
                    Point point2;

                    if (characterPositions.get(i).x < characterPositions.get(j).x) {
                        point1 = characterPositions.get(i);
                        point2 = characterPositions.get(j);
                    } else {
                        point1 = characterPositions.get(j);
                        point2 = characterPositions.get(i);
                    }


                    boolean noMoreAntiNodes = false;
                    int k = 0;
                    while (!noMoreAntiNodes) {

                        noMoreAntiNodes = true;
                        Point antinode1;
                        Point antinode2;
                        if (point1.y < point2.y) {
                            antinode1 = new Point(point2.x + (Math.abs(point1.x - point2.x) * k), point2.y + (Math.abs(point1.y - point2.y) * k));
                            antinode2 = new Point(point1.x - (Math.abs(point1.x - point2.x) * k), point1.y - (Math.abs(point1.y - point2.y) * k));
                        } else {
                            antinode1 = new Point(point2.x + (Math.abs(point1.x - point2.x) * k), point2.y - (Math.abs(point1.y - point2.y) * k));
                            antinode2 = new Point(point1.x - (Math.abs(point1.x - point2.x) * k), point1.y + (Math.abs(point1.y - point2.y)) * k);

                        }


                        if (insideGrid(grid, antinode1)) {
                            antinodePoints.add(antinode1);
                            noMoreAntiNodes = false;
                        }

                        if (insideGrid(grid, antinode2)) {
                            antinodePoints.add(antinode2);
                            noMoreAntiNodes = false;

                        }
                        k++;
                    }
                }
            }
        }


        return antinodePoints.size();
    }

    private boolean insideGrid(char[][] grid, Point point) {
        return grid.length > point.x && grid[0].length > point.y && point.x >= 0 && point.y >= 0;
    }

}
