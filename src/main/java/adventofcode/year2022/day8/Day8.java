package adventofcode.year2022.day8;

import adventofcode.utils.FileHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day8 {

    public long part1(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);
        List<Tree> trees = initiateTreeGrid(lines);
        Set<Tree> visibleTrees = new HashSet<>();

        int maxX = findMaxX(trees);
        int maxY = findMaxY(trees);

        for (Tree tree : trees) {
            if (treeVisible(tree, trees, maxX, maxY)) {
                visibleTrees.add(tree);
            }
        }

        return visibleTrees.size();
    }

    private boolean treeVisible(Tree tree, List<Tree> trees, int maxX, int maxY) {
        Point point = tree.getPoint();

        if (point.x == 0 || point.x == maxX || point.y == 0 || point.y == maxY) {
            return true;
        }

        boolean visibleFromLeft = trees.stream()
                .filter(neighbour -> neighbour.getPoint().y < point.y)
                .filter(neighbour -> neighbour.getPoint().x == point.x)
                .noneMatch(neighbour -> neighbour.getHeight() >= tree.getHeight());

        boolean visibleFromRight = trees.stream()
                .filter(neighbour -> neighbour.getPoint().y > point.y)
                .filter(neighbour -> neighbour.getPoint().x == point.x)
                .noneMatch(neighbour -> neighbour.getHeight() >= tree.getHeight());

        boolean visibleFromTop = trees.stream()
                .filter(neighbour -> neighbour.getPoint().x < point.x)
                .filter(neighbour -> neighbour.getPoint().y == point.y)
                .noneMatch(neighbour -> neighbour.getHeight() >= tree.getHeight());

        boolean visibleFromBottom = trees.stream()
                .filter(neighbour -> neighbour.getPoint().x > point.x)
                .filter(neighbour -> neighbour.getPoint().y == point.y)
                .noneMatch(neighbour -> neighbour.getHeight() >= tree.getHeight());

        return visibleFromLeft || visibleFromRight || visibleFromBottom || visibleFromTop;
    }

    private int findMaxX(List<Tree> trees) {
        int maxX = 0;

        for (Tree tree : trees) {
            if (tree.getPoint().x > maxX) {
                maxX = tree.getPoint().x;
            }
        }
        return maxX;
    }

    private int findMaxY(List<Tree> trees) {
        int maxY = 0;

        for (Tree tree : trees) {
            if (tree.getPoint().y > maxY) {
                maxY = tree.getPoint().y;
            }
        }
        return maxY;
    }

    public long part2(String inputFile) {
        List<String> lines = FileHandler.readFileIntoList(inputFile);

        List<Tree> trees = initiateTreeGrid(lines);

        int maxX = findMaxX(trees);
        int maxY = findMaxY(trees);

        int highestScenicScore = 0;
        for (Tree tree : trees) {

            int scenicScore = calculateScenicScore(tree, trees, maxX, maxY);
            if (scenicScore > highestScenicScore) {
                highestScenicScore = scenicScore;
            }

        }

        return highestScenicScore;
    }

    public List<Tree> initiateTreeGrid(List<String> lines) {

        List<Tree> trees = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {

            char[] chars = lines.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                Point point = new Point(i, j);

                trees.add(new Tree(point, Integer.parseInt(String.valueOf(chars[j]))));
            }
        }
        return trees;

    }

    private int calculateScenicScore(Tree tree, List<Tree> trees, int maxX, int maxY) {
        Point point = tree.getPoint();

        //left
        int y = tree.getPoint().y;
        int x = tree.getPoint().x;

        int scoreLeft = 0;
        for (int i = y - 1; i >= 0; i--) {
            Tree neighbour = findTreeOnPosition(trees, point.x, i);
            if (neighbour != null) {
                scoreLeft++;
            }
            if (neighbour.getHeight() >= tree.getHeight()) {
                break;
            }
        }

        int scoreRight = 0;
        for (int i = y + 1; i <= maxY; i++) {

            Tree neighbour = findTreeOnPosition(trees, point.x, i);
            if (neighbour != null) {
                scoreRight++;
            }
            if (neighbour.getHeight() >= tree.getHeight()) {
                break;
            }
        }

        int scoreTop = 0;
        for (int i = x - 1; i >= 0; i--) {
            Tree neighbour = findTreeOnPosition(trees, i, point.y);
            if (neighbour != null) {
                scoreTop++;
            }
            if (neighbour.getHeight() >= tree.getHeight()) {
                break;
            }
        }

        int scoreBottom = 0;
        for (int i = x + 1; i <= maxX; i++) {
            Tree neighbour = findTreeOnPosition(trees, i, point.y);
            if (neighbour != null) {
                scoreBottom++;
            }
            if (neighbour.getHeight() >= tree.getHeight()) {
                break;
            }
        }

        return scoreLeft * scoreRight * scoreBottom * scoreTop;
    }

    private Tree findTreeOnPosition(List<Tree> trees, int x, int y) {
        return trees.stream().filter(tree -> tree.getPoint().x == x && tree.getPoint().y == y).findFirst().orElse(null);
    }
}
