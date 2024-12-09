package adventofcode.year2024;

import adventofcode.utils.FileHandler;
import adventofcode.utils.GridHelper;
import org.apache.commons.lang3.tuple.Pair;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Day6 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        char[][] grid = GridHelper.initCharGrid(lines);

        Point point = findStartingPoint(grid);

        Queue<Direction> directionQueue = new ArrayDeque<>();
        directionQueue.add(Direction.UP);
        directionQueue.add(Direction.RIGHT);
        directionQueue.add(Direction.DOWN);
        directionQueue.add(Direction.LEFT);

        Direction direction = getNextDirection(directionQueue);

        Set<Point> visited = new HashSet<>();

        visited.add(point);
        while (!isNextOutOfBounds(direction, grid, point)) {

            if (isNextOutOfBounds(direction, grid, point)) {
                break;
            }

            if (isNextPositionObstruction(direction, grid, point)) {
                direction = getNextDirection(directionQueue);

            } else {

                point = moveOneStep(direction, point);
                visited.add(point);
            }
        }

        return visited.size();
    }

    private Point moveOneStep(Direction direction, Point point) {
        if (direction == Direction.UP) {
            return new Point(point.x - 1, point.y);
        }

        if (direction == Direction.DOWN) {
            return new Point(point.x + 1, point.y);
        }

        if (direction == Direction.LEFT) {
            return new Point(point.x, point.y - 1);
        }
        if (direction == Direction.RIGHT) {
            return new Point(point.x, point.y + 1);
        }
        return null;

    }

    private Direction getNextDirection(Queue<Direction> directionQueue) {
        Direction next = directionQueue.poll();

        directionQueue.add(next);
        return next;
    }

    private boolean isNextPositionObstruction(Direction direction, char[][] grid, Point point) {
        if (direction == Direction.UP) {
            return grid[point.x - 1][point.y] == '#';
        }

        if (direction == Direction.DOWN) {
            return grid[point.x + 1][point.y] == '#';
        }

        if (direction == Direction.LEFT) {
            return grid[point.x][point.y - 1] == '#';
        }
        if (direction == Direction.RIGHT) {
            return grid[point.x][point.y + 1] == '#';
        }
        return false;
    }

    private boolean isNextOutOfBounds(Direction direction, char[][] grid, Point point) {
        if (direction == Direction.UP) {
            return point.x - 1 < 0;
        }

        if (direction == Direction.DOWN) {
            return point.x + 1 > grid.length - 1;
        }

        if (direction == Direction.LEFT) {
            return point.y - 1 < 0;
        }
        if (direction == Direction.RIGHT) {
            return point.y + 1 > grid[0].length - 1;
        }
        return false;
    }

    private Point findStartingPoint(char[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '^') {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        char[][] grid = GridHelper.initCharGrid(lines);


        int infiniteLoopCount = 0;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '#' || grid[i][j] == '^') {
                    continue;
                }
                grid[i][j] = '#';

                if (stuckInInfiniteLoop(grid)) {
                    infiniteLoopCount++;
                }

                grid[i][j] = '.';

            }
        }


        return infiniteLoopCount;
    }


    private boolean stuckInInfiniteLoop(char[][] grid) {
        Point point = findStartingPoint(grid);

        Queue<Direction> directionQueue = new ArrayDeque<>();
        directionQueue.add(Direction.UP);
        directionQueue.add(Direction.RIGHT);
        directionQueue.add(Direction.DOWN);
        directionQueue.add(Direction.LEFT);

        Direction direction = getNextDirection(directionQueue);

        List<Pair<Point, Direction>> visited = new ArrayList<>();

        visited.add(Pair.of(point, direction));

        while (!isNextOutOfBounds(direction, grid, point)) {

            if (isNextOutOfBounds(direction, grid, point)) {
                break;
            }

            if (isNextPositionObstruction(direction, grid, point)) {
                direction = getNextDirection(directionQueue);

            } else {

                point = moveOneStep(direction, point);

                Pair<Point, Direction> visit = Pair.of(point, direction);
                if (visited.contains(visit)) {
                    return true;
                }
                visited.add(Pair.of(point, direction));
            }
        }
        return false;
    }
}
