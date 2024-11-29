package adventofcode.year2022.day9;

import adventofcode.utils.FileHandler;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day9 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        Point hLocation = new Point(0, 0);
        Point tLocation = new Point(0, 0);

        Set<Point> tLocationsVisited = new HashSet<>();

        tLocationsVisited.add(new Point(0, 0));
        for (String line : lines) {

            String[] instructions = line.split(" ");

            if (instructions[0].equals("R")) {
                for (int i = 0; i < Integer.parseInt(instructions[1]); i++) {
                    hLocation.y = hLocation.y + 1;

                    if (hLocation.x == tLocation.x && hLocation.y > tLocation.y + 1) {
                        tLocation.y++;
                        tLocationsVisited.add(new Point(tLocation.x, tLocation.y));
                    } else if (Math.abs(hLocation.x - tLocation.x) > 0 && Math.abs(hLocation.y - tLocation.y) > 1) {
                        tLocation.y++;

                        if (hLocation.x < tLocation.x) {
                            tLocation.x--;
                        } else {
                            tLocation.x++;
                        }

                        tLocationsVisited.add(new Point(tLocation.x, tLocation.y));
                    } else if (hLocation.x > tLocation.x + 1) {
                        tLocation.x++;

                        if (hLocation.y < tLocation.y) {
                            tLocation.y--;
                        } else {
                            tLocation.y++;
                        }
                        tLocationsVisited.add(new Point(tLocation.x, tLocation.y));
                    }

                }
            } else if (instructions[0].equals("L")) {
                for (int i = 0; i < Integer.parseInt(instructions[1]); i++) {
                    hLocation.y = hLocation.y - 1;

                    if (hLocation.x == tLocation.x && hLocation.y < tLocation.y - 1) {
                        tLocation.y--;
                        tLocationsVisited.add(new Point(tLocation.x, tLocation.y));
                    } else if (Math.abs(hLocation.x - tLocation.x) > 0 && Math.abs(hLocation.y - tLocation.y) > 1) {
                        tLocation.y--;

                        if (hLocation.x < tLocation.x) {
                            tLocation.x--;
                        } else {
                            tLocation.x++;
                        }
                        
                        tLocationsVisited.add(new Point(tLocation.x, tLocation.y));
                    } else if (hLocation.x > tLocation.x + 1) {
                        tLocation.x++;

                        if (hLocation.y < tLocation.y) {
                            tLocation.y--;
                        } else {
                            tLocation.y++;
                        }

                        tLocationsVisited.add(new Point(tLocation.x, tLocation.y));
                    }
                }
            } else if (instructions[0].equals("U")) {
                for (int i = 0; i < Integer.parseInt(instructions[1]); i++) {
                    hLocation.x = hLocation.x - 1;

                    if (hLocation.y == tLocation.y && hLocation.x < tLocation.x - 1) {
                        tLocation.x--;
                        tLocationsVisited.add(new Point(tLocation.x, tLocation.y));
                    } else if (hLocation.x < tLocation.x - 1) {
                        tLocation.x--;

                        if (hLocation.y < tLocation.y) {
                            tLocation.y--;
                        } else {
                            tLocation.y++;
                        }
                        
                        tLocationsVisited.add(new Point(tLocation.x, tLocation.y));
                    }
                }
            } else if (instructions[0].equals("D")) {
                for (int i = 0; i < Integer.parseInt(instructions[1]); i++) {
                    hLocation.x = hLocation.x + 1;

                    if (hLocation.y == tLocation.y && hLocation.x > tLocation.x + 1) {
                        tLocation.x++;
                        tLocationsVisited.add(new Point(tLocation.x, tLocation.y));
                    } else if (hLocation.x > tLocation.x + 1) {
                        tLocation.x++;

                        if (hLocation.y < tLocation.y) {
                            tLocation.y--;
                        } else {
                            tLocation.y++;
                        }
                        
                        tLocationsVisited.add(new Point(tLocation.x, tLocation.y));
                    }
                }
            }
        }
        return tLocationsVisited.size();
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);


        return 0;
    }

}
