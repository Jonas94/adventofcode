package adventofcode.year2024;

import adventofcode.utils.FileHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Day4 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        char[][] grid = initGrid(lines);

        List<Point> xPoints = findAllX(grid);


        return findWords(xPoints, grid);
    }


    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        char[][] grid = initGrid(lines);

        

        return 0;
    }


    public char[][] initGrid(List<String> lines) {
        char[][] grid = new char[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        return grid;
    }

    public List<Point> findAllX(char[][] grid) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'X') {
                    points.add(new Point(i, j));
                }

            }
        }
        return points;
    }

    public long findWords(List<Point> startingPoints, char[][] grid) {

        long countOfWords = 0;
        for (Point point : startingPoints) {
            if (tryRight(grid, point)) {
                countOfWords++;
            }
            if (tryLeft(grid, point)) {
                countOfWords++;
            }
            if (tryUp(grid, point)) {
                countOfWords++;
            }
            if (tryDown(grid, point)) {
                countOfWords++;
            }

            if (tryDiagonalTopRight(grid, point)) {
                countOfWords++;
            }
            if (tryDiagonalTopLeft(grid, point)) {
                countOfWords++;
            }
            if (tryDiagonalBottomRight(grid, point)) {
                countOfWords++;
            }
            if (tryDiagonalBottomLeft(grid, point)) {
                countOfWords++;
            }

        }

        return countOfWords;
    }


    public boolean tryRight(char[][] grid, Point xPoint) {
        if (xPoint.y > grid[0].length - 3) {
            return false;
        }

        return grid[xPoint.x][xPoint.y + 1] == 'M' && grid[xPoint.x][xPoint.y + 2] == 'A' && grid[xPoint.x][xPoint.y + 3] == 'S';
    }

    public boolean tryLeft(char[][] grid, Point xPoint) {
        if (xPoint.y < 3) {
            return false;
        }

        return grid[xPoint.x][xPoint.y - 1] == 'M' && grid[xPoint.x][xPoint.y - 2] == 'A' && grid[xPoint.x][xPoint.y - 3] == 'S';
    }

    public boolean tryDown(char[][] grid, Point xPoint) {
        if (xPoint.x > grid.length - 3) {
            return false;
        }

        return grid[xPoint.x + 1][xPoint.y] == 'M' && grid[xPoint.x + 2][xPoint.y] == 'A' && grid[xPoint.x + 3][xPoint.y] == 'S';
    }

    public boolean tryUp(char[][] grid, Point xPoint) {
        if (xPoint.x < 3) {
            return false;
        }

        return grid[xPoint.x - 1][xPoint.y] == 'M' && grid[xPoint.x - 2][xPoint.y] == 'A' && grid[xPoint.x - 3][xPoint.y] == 'S';
    }


    public boolean tryDiagonalTopRight(char[][] grid, Point xPoint) {
        if (xPoint.y > grid[0].length - 4 || xPoint.x < 3) {
            return false;
        }

        return grid[xPoint.x - 1][xPoint.y + 1] == 'M' && grid[xPoint.x - 2][xPoint.y + 2] == 'A' && grid[xPoint.x - 3][xPoint.y + 3] == 'S';
    }

    public boolean tryDiagonalTopLeft(char[][] grid, Point xPoint) {
        if (xPoint.y < 3 || xPoint.x < 3) {
            return false;
        }

        return grid[xPoint.x - 1][xPoint.y - 1] == 'M' && grid[xPoint.x - 2][xPoint.y - 2] == 'A' && grid[xPoint.x - 3][xPoint.y - 3] == 'S';
    }

    public boolean tryDiagonalBottomLeft(char[][] grid, Point xPoint) {
        if (xPoint.y < 3 || xPoint.x > grid.length - 4) {
            return false;
        }

        return grid[xPoint.x + 1][xPoint.y - 1] == 'M' && grid[xPoint.x + 2][xPoint.y - 2] == 'A' && grid[xPoint.x + 3][xPoint.y - 3] == 'S';
    }

    public boolean tryDiagonalBottomRight(char[][] grid, Point xPoint) {
        if (xPoint.y > grid[0].length - 4 || xPoint.x > grid.length - 4) {
            return false;
        }

        return grid[xPoint.x + 1][xPoint.y + 1] == 'M' && grid[xPoint.x + 2][xPoint.y + 2] == 'A' && grid[xPoint.x + 3][xPoint.y + 3] == 'S';
    }

}
