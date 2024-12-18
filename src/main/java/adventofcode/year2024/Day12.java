package adventofcode.year2024;

import adventofcode.utils.FileHandler;
import adventofcode.utils.GridHelper;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Day12 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        char[][] grid = GridHelper.initCharGrid(lines);

        Map<Point, List<Point>> neighbours = initNeighbourMap(grid);

        Set<Point> visited = new HashSet<>();
        long totalScore = 0;


        for (Point p : neighbours.keySet()) {

            Stack<Point> stack = new Stack<>();
            if (!visited.contains(p)) {
                stack.push(p);
            }

            int area = 0;
            int zonePerimeter = 0;


            while (!stack.isEmpty()) {
                Point current = stack.pop();
                List<Point> neighbourList = neighbours.get(current);
                int currentPerimeter = 4 - neighbourList.size();
                area++;

                zonePerimeter += currentPerimeter;
                for (Point neighbour : neighbourList) {
                    if (!visited.contains(neighbour) && !stack.contains(neighbour)) {
                        stack.push(neighbour);
                    }

                }

                visited.add(current);
            }

            totalScore = totalScore + (area * zonePerimeter);
        }


        return totalScore;
    }

    private Map<Point, List<Point>> initNeighbourMap(char[][] grid) {
        Map<Point, List<Point>> neighbours = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Point currentPoint = new Point(i, j);

                neighbours.put(currentPoint, new ArrayList<>());

                if (hasNeighbourRight(grid, currentPoint)) {
                    neighbours.get(currentPoint).add(new Point(currentPoint.x, currentPoint.y + 1));
                }

                if (hasNeighbourLeft(grid, currentPoint)) {
                    neighbours.get(currentPoint).add(new Point(currentPoint.x, currentPoint.y - 1));
                }

                if (hasNeighbourAbove(grid, currentPoint)) {
                    neighbours.get(currentPoint).add(new Point(currentPoint.x - 1, currentPoint.y));
                }

                if (hasNeighbourBelow(grid, currentPoint)) {
                    neighbours.get(currentPoint).add(new Point(currentPoint.x + 1, currentPoint.y));
                }
            }
        }
        return neighbours;
    }

    public boolean hasNeighbourLeft(char[][] grid, Point point) {
        if (point.y < 1) {
            return false;
        }

        return grid[point.x][point.y] == grid[point.x][point.y - 1];
    }

    public boolean hasNeighbourRight(char[][] grid, Point point) {
        if (point.y >= grid[0].length - 1) {
            return false;
        }

        return grid[point.x][point.y] == grid[point.x][point.y + 1];
    }

    public boolean hasNeighbourAbove(char[][] grid, Point point) {
        if (point.x < 1) {
            return false;
        }

        return grid[point.x][point.y] == grid[point.x - 1][point.y];
    }

    public boolean hasNeighbourBelow(char[][] grid, Point point) {
        if (point.x >= grid.length - 1) {
            return false;
        }

        return grid[point.x][point.y] == grid[point.x + 1][point.y];
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);


        return 0;
    }

}
