package adventofcode.year2022.day2;

import adventofcode.utils.FileHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {

    private static final int WIN_SCORE = 6;
    private static final int DRAW_SCORE = 3;

    private static Map<Shape, Shape> winMapping = new HashMap<>();
    public int part1(String inputFile) {
        List<String> inputStrings = FileHandler.readFileIntoList(inputFile);

        int totalScore = 0;
        for (String round : inputStrings) {

            String[] actions = round.split(" ");

            Shape elfShape = parseToShape(actions[0]);
            Shape myShape = parseToShape(actions[1]);

            totalScore += calculateScore(elfShape, myShape);

        }
        return totalScore;
    }

    public int part2(String inputFile) {
        List<String> inputStrings = FileHandler.readFileIntoList(inputFile);

        int totalScore = 0;
        for (String round : inputStrings) {

            String[] actions = round.split(" ");

            Shape elfShape = parseToShape(actions[0]);
            ExpectedResult expectedResult = parseToExpectedResult(actions[1]);

            totalScore += calculateScoreWithExpectedResult(elfShape, expectedResult);
        }

        return totalScore;
    }

    private int calculateScore(Shape elfShape, Shape myShape) {
        int score = 0;

        if (myShape.equals(shapeNeededToWinOver(elfShape))) {
            score += WIN_SCORE;
        } else if (myShape.equals(elfShape)) {
            score += DRAW_SCORE;
        }
        score += getShapeScore(myShape);

        return score;
    }

    private Shape parseToShape(String action) {
        return switch (action) {
            case "A", "X" -> Shape.ROCK;
            case "B", "Y" -> Shape.PAPER;
            default -> Shape.SCISSORS;
        };
    }

    private ExpectedResult parseToExpectedResult(String action) {
        return switch (action) {
            case "X" -> ExpectedResult.LOSE;
            case "Y" -> ExpectedResult.DRAW;
            default -> ExpectedResult.WIN;
        };
    }

    private Shape shapeNeededToWinOver(Shape shape) {
        return switch (shape) {
            case SCISSORS -> Shape.ROCK;
            case PAPER -> Shape.SCISSORS;
            case ROCK -> Shape.PAPER;
        };
    }

    private Shape shapeNeededToLoseOver(Shape shape) {
        return switch (shape) {
            case SCISSORS -> Shape.PAPER;
            case PAPER -> Shape.ROCK;
            case ROCK -> Shape.SCISSORS;
        };
    }

    private int getShapeScore(Shape shape) {
        return switch (shape) {
            case ROCK -> 1;
            case PAPER -> 2;
            case SCISSORS -> 3;
        };
    }

    private int calculateScoreWithExpectedResult(Shape elfShape, ExpectedResult expectedResult) {
        int score = 0;
        Shape myShape = Shape.ROCK;
        if (expectedResult.equals(ExpectedResult.WIN)) {
            myShape = shapeNeededToWinOver(elfShape);
            score += WIN_SCORE;
        } else if (expectedResult.equals(ExpectedResult.DRAW)) {
            score += DRAW_SCORE;
            myShape = elfShape;
        } else if (expectedResult.equals(ExpectedResult.LOSE)) {
            myShape = shapeNeededToLoseOver(elfShape);
        }
        score += getShapeScore(myShape);

        return score;
    }
}
