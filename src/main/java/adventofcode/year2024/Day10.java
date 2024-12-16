package adventofcode.year2024;

import adventofcode.utils.FileHandler;
import adventofcode.utils.GridHelper;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Day10 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        char[][] grid = GridHelper.initCharGrid(lines);

        List<Point> trailheads = findTrailHeads(grid);


        /**
         * Initialize a stack, say S, with the starting cell coordinates as (0, 0).
         * Initialize an auxiliary boolean 2D array of dimension N * M with all values as false, which is used to mark the visited cells.
         * Declare a function isValid() to check if the cell coordinates are valid or not, i.e lies within the boundaries of the given matrix and is unvisited or not.
         * Iterate while the stack is not empty and perform the following steps:
         * Pop the cell present at the top of the stack and print the element at that cell.
         * Push the cell adjacent to the above-popped cells into the stack, if they are valid by checking using isValid() function.
         */

        Stack<Point> stack = new Stack<>();


        int total = 0;

        for (Point trailhead : trailheads) {
            Set<Point> foundTops = new HashSet<>();

            stack.push(trailhead);

            while (!stack.isEmpty()) {
                Point currentPoint = stack.pop();
                int currentNumber = grid[currentPoint.x][currentPoint.y];

                if (currentNumber == '9') {
                    foundTops.add(currentPoint);
                    continue;

                }

                int pointX = (int) currentPoint.getX();
                int pointY = (int) currentPoint.getY();

                //Check above
                Point abovePoint = new Point(pointX - 1, pointY);
                if (insideGrid(grid, abovePoint)) {
                    // Convert char to int
                    int num = grid[abovePoint.x][abovePoint.y];
                    if (currentNumber == num - 1) {
                        stack.push(abovePoint);
                    }
                }

                //check left
                Point leftPoint = new Point(pointX, pointY - 1);
                if (insideGrid(grid, leftPoint)) {
                    int num = grid[leftPoint.x][leftPoint.y];
                    if (currentNumber == num - 1) {
                        stack.push(leftPoint);
                    }
                }

                //check right
                Point rightPoint = new Point(pointX, pointY + 1);
                if (insideGrid(grid, rightPoint)) {
                    int num = grid[rightPoint.x][rightPoint.y];
                    if (currentNumber == num - 1) {
                        stack.push(rightPoint);
                    }
                }

                //check below
                Point belowPoint = new Point(pointX + 1, pointY);
                if (insideGrid(grid, belowPoint)) {
                    int num = grid[belowPoint.x][belowPoint.y];
                    if (currentNumber == num - 1) {
                        stack.push(belowPoint);
                    }
                }
            }
            System.out.println("TOPS:" + foundTops.size());

            total += foundTops.size();
        }

        return total;
    }

    private boolean insideGrid(char[][] grid, Point point) {
        return grid.length > point.x && grid[0].length > point.y && point.x >= 0 && point.y >= 0;
    }


    private List<Point> findTrailHeads(char[][] grid) {
        List<Point> trailheads = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '0') {
                    trailheads.add(new Point(i, j));
                }


            }
        }
        return trailheads;
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        char[][] grid = GridHelper.initCharGrid(lines);

        List<Point> trailheads = findTrailHeads(grid);

        Stack<Point> stack = new Stack<>();


        int total = 0;

        for (Point trailhead : trailheads) {
            stack.push(trailhead);

            int count = 0;
            while (!stack.isEmpty()) {
                Point currentPoint = stack.pop();
                int currentNumber = grid[currentPoint.x][currentPoint.y];

                if (currentNumber == '9') {
                    count++;
                    continue;

                }

                int pointX = (int) currentPoint.getX();
                int pointY = (int) currentPoint.getY();

                //Check above
                Point abovePoint = new Point(pointX - 1, pointY);
                if (insideGrid(grid, abovePoint)) {
                    // Convert char to int
                    int num = grid[abovePoint.x][abovePoint.y];
                    if (currentNumber == num - 1) {
                        stack.push(abovePoint);
                    }
                }

                //check left
                Point leftPoint = new Point(pointX, pointY - 1);
                if (insideGrid(grid, leftPoint)) {
                    int num = grid[leftPoint.x][leftPoint.y];
                    if (currentNumber == num - 1) {
                        stack.push(leftPoint);
                    }
                }

                //check right
                Point rightPoint = new Point(pointX, pointY + 1);
                if (insideGrid(grid, rightPoint)) {
                    int num = grid[rightPoint.x][rightPoint.y];
                    if (currentNumber == num - 1) {
                        stack.push(rightPoint);
                    }
                }

                //check below
                Point belowPoint = new Point(pointX + 1, pointY);
                if (insideGrid(grid, belowPoint)) {
                    int num = grid[belowPoint.x][belowPoint.y];
                    if (currentNumber == num - 1) {
                        stack.push(belowPoint);
                    }
                }
            }
            total += count;
        }

        return total;
    }

}
