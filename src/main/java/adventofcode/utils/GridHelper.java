package adventofcode.utils;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class GridHelper {
    public static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void printStringGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }


    public static String getStringGridAsString(String[][] grid) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                stringBuilder.append(grid[i][j]);
            }
            if (i < grid.length-1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }


    public static String[][] initStringGrid(int xSize, int ySize) {
        String[][] grid = new String[xSize][ySize];
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {

                grid[i][j] = ".";
            }
        }
        return grid;
    }

    public static void printGridOfPoints(LinkedList<Point> points, int size) {

        int startx = -size;
        int starty = -size;
        int endx = size;
        int endy = size;

        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = startx; i < endx; i++) {
            for (int j = starty; j < endy; j++) {
                if (points.contains(new Point(i, j))) {
                    System.out.print("#");

                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static char[][] initCharGrid(List<String> lines){
        char[][] grid = new char[lines.size()][lines.get(0).length()];

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < lines.get(0).length(); j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        return grid;
    }

}
