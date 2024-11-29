package adventofcode.year2022.day12;

import adventofcode.utils.FileHandler;
import adventofcode.utils.GridHelper;

import java.awt.*;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class Day12 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        char[][] grid = GridHelper.initCharGrid(lines);

        Set<Character> allowedStartingChars = new HashSet<>();
        allowedStartingChars.add('S');

        return bfs(possibleStartingNodes(grid, allowedStartingChars).get(0), grid);
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        char[][] grid = GridHelper.initCharGrid(lines);
        Map<Integer, Point> numberOfStepsFromStartingPoints = new HashMap<>();
        Set<Character> allowedStartingChars = new HashSet<>();
        allowedStartingChars.add('a');
        allowedStartingChars.add('S');

        for (Point point : possibleStartingNodes(grid, allowedStartingChars)) {
            numberOfStepsFromStartingPoints.put(bfs(point, grid), point);
        }

        return numberOfStepsFromStartingPoints.keySet().stream()
                .filter(steps -> steps > 0).sorted().limit(1).toList().get(0);
    }

    private int bfs(Point point, char[][] grid) {
        Queue<Node> queue = new LinkedList<>();
        Node startingNode = new Node(point, 0);

        queue.add(startingNode);
        Set<Point> visited = new HashSet<>();
        int currentDistance = 0;

        visited.add(startingNode.point());
        boolean foundE = false;
        while (!queue.isEmpty()) {
            if (foundE) {

                return currentDistance;
            }
            Node current = queue.poll();
            currentDistance = current.distance();

            for (Point neighbour : findNeighbours(current.point(), grid)) {
                char currentChar = grid[current.point().x][current.point().y];
                char neighbourChar = grid[neighbour.x][neighbour.y];
                if (neighbourChar == 'E' && isTraversable(currentChar, neighbourChar)) {
                    currentDistance++;
                    foundE = true;
                }
                if (!visited.contains(neighbour) && isTraversable(currentChar, neighbourChar)) {
                    Node newNode = new Node(neighbour, currentDistance + 1);
                    queue.add(newNode);
                    visited.add(newNode.point());
                }
            }
            visited.add(new Point(current.point().x, current.point().y));
        }
        return 0;
    }

    private List<Point> findNeighbours(Point point, char[][] grid) {
        List<Point> neighbours = new ArrayList<>();

        if (isValidPoint(getRightNeighbour(point), grid)) {
            neighbours.add(getRightNeighbour(point));
        }

        if (isValidPoint(getLeftNeighbour(point), grid)) {
            neighbours.add(getLeftNeighbour(point));
        }

        if (isValidPoint(getBelowNeighbour(point), grid)) {
            neighbours.add(getBelowNeighbour(point));
        }

        if (isValidPoint(getAboveNeighbour(point), grid)) {
            neighbours.add(getAboveNeighbour(point));
        }

        return neighbours;
    }

    private Point getAboveNeighbour(Point currentPosition) {
        return new Point(currentPosition.x - 1, currentPosition.y);
    }

    private Point getBelowNeighbour(Point currentPosition) {
        return new Point(currentPosition.x + 1, currentPosition.y);
    }

    private Point getLeftNeighbour(Point currentPosition) {
        return new Point(currentPosition.x, currentPosition.y - 1);
    }

    private Point getRightNeighbour(Point currentPosition) {
        return new Point(currentPosition.x, currentPosition.y + 1);
    }

    private boolean isValidPoint(Point point, char[][] grid) {
        return point.x < grid.length && point.x >= 0 && point.y < grid[0].length && point.y >= 0;
    }

    private boolean isTraversable(char current, char neighbour) {
        if (neighbour == 'E') {
            return current == 'y' || current == 'z';
        }

        return neighbour == 'S' || current == 'S' || neighbour - current <= 1;
    }

    private List<Point> possibleStartingNodes(char[][] grid, Set<Character> allowedStartingChars) {

        List<Point> startingNodes = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (allowedStartingChars.contains(grid[i][j])) {
                    startingNodes.add(new Point(i, j));
                }
            }
        }
        return startingNodes;
    }


    private record Node(Point point, int distance) {
    }
}
