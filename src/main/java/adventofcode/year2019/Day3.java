package adventofcode.year2019;

import adventofcode.utils.FileHandler;

import java.awt.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
    final static int STARTING_POINT_X = 0;
    final static int STARTING_POINT_Y = 0;
    static int CURRENT_POINT_X = STARTING_POINT_X;
    static int CURRENT_POINT_Y = STARTING_POINT_Y;
    List wire1Actions;
    List wire2Actions;
    static int cost = 0;

    public int solveDay3Part1() {
        List<String> inputs = readFileIntoStringArray();
     // String wire1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72";
 //     String wire2 = "U62,R66,U55,R34,D71,R55,D58,R83";

        String wire1 = inputs.get(0);
        String wire2 = inputs.get(1);
        wire1Actions = handleInput(wire1);
        wire2Actions = handleInput(wire2);

        List<PointCost> wire1Points = drawWire(wire1Actions);

        CURRENT_POINT_X = STARTING_POINT_X;
        CURRENT_POINT_Y = STARTING_POINT_Y;
        cost = 0;
        List<PointCost> wire2Points = drawWire(wire2Actions);

        List<PointCost> crossingPoints = findCrossingPoints(wire1Points, wire2Points);

        System.out.println(findFewestStepsToCrossing(crossingPoints, wire1Points, wire2Points));


        int shortestManhattanDistance = findShortestManhattanDistance(findCrossingPoints(wire1Points, wire2Points));
        return shortestManhattanDistance;
    }

    private int findFewestStepsToCrossing(List<PointCost> crossingPoints, List<PointCost> wire1Points, List<PointCost> wire2Points) {

        int lowestStepsNeeded = Integer.MAX_VALUE;

        for(PointCost pointCost : crossingPoints){
            int pointsWire1 = 0;
            int pointsWire2 = 0;
            for(PointCost wire1 : wire1Points) {
                if (wire1.getPoint().equals(pointCost.getPoint())) {
                    pointsWire1 = wire1.getCost();
                    break;
                }
            }
                for(PointCost wire2 : wire2Points) {
                    if (wire2.getPoint().equals(pointCost.getPoint())) {
                        pointsWire2 = wire2.getCost();
                        break;
                }
            }
                if (pointsWire1 + pointsWire2 < lowestStepsNeeded){
                    lowestStepsNeeded =pointsWire1 + pointsWire2;
                }
        }
        return lowestStepsNeeded;
    }

    private List<PointCost> drawWire(List<AbstractMap.SimpleEntry> actionList) {
        List<PointCost> points = new ArrayList<>();
        for (AbstractMap.SimpleEntry<String, Integer> actionEntry : actionList) {
            if (actionEntry.getKey().equals("R")) {
             points.addAll(goRight(actionEntry.getValue()));
            } else if (actionEntry.getKey().equals("L")) {
                points.addAll(goLeft(actionEntry.getValue()));
            } else if (actionEntry.getKey().equals("U")) {
                points.addAll(goUp(actionEntry.getValue()));
            } else if (actionEntry.getKey().equals("D")) {
                points.addAll(goDown(actionEntry.getValue()));
            }
        }
        return points;
    }

    public List<AbstractMap.SimpleEntry> handleInput(String input) {
        List<AbstractMap.SimpleEntry> actionList = new ArrayList<>();
        String[] actions = input.split(",");

        for (String action : actions) {
            AbstractMap.SimpleEntry<String, Integer> actionEntry = new AbstractMap.SimpleEntry<>(String.valueOf(action.charAt(0)), Integer.parseInt(action.substring(1)));
            actionList.add(actionEntry);

        }
        return actionList;
    }

    public List<PointCost> goRight(int length) {
        List<PointCost> pointCosts = new ArrayList<>();
        for (int i = CURRENT_POINT_Y + 1; i < CURRENT_POINT_Y + 1 + length; i++) {
            pointCosts.add(new PointCost(++cost,new Point(CURRENT_POINT_X, i)));
        }
        CURRENT_POINT_Y += length;

        return pointCosts;
    }

    public  List<PointCost> goLeft(int length) {
        List<PointCost> pointCosts = new ArrayList<>();
        for (int i = CURRENT_POINT_Y - 1; i > CURRENT_POINT_Y + -1 - length; i--) {
            pointCosts.add(new PointCost(++cost,new Point(CURRENT_POINT_X, i)));
        }
        CURRENT_POINT_Y -= length;
        return pointCosts;
    }

    public  List<PointCost> goUp(int length) {
        List<PointCost> pointCosts = new ArrayList<>();
        for (int i = CURRENT_POINT_X - 1; i > CURRENT_POINT_X + -1 - length; i--) {
            pointCosts.add(new PointCost(++cost,new Point(i, CURRENT_POINT_Y)));

        }
        CURRENT_POINT_X -= length;
        return pointCosts;
    }

    public List<PointCost> goDown(int length) {
        List<PointCost> pointCosts = new ArrayList<>();
        for (int i = CURRENT_POINT_X + 1; i < CURRENT_POINT_X + 1 + length; i++) {
            pointCosts.add(new PointCost(++cost, new Point(i, CURRENT_POINT_Y)));
        }
        CURRENT_POINT_X += length;
        return pointCosts;

    }

    public List<PointCost> findCrossingPoints(List<PointCost> wire1, List<PointCost> wire2){
        List<PointCost> crossings = new ArrayList<>();

        for(PointCost pointWire1 : wire1){
            for(PointCost pointWire2 : wire2){
                if(pointWire1.getPoint().x == pointWire2.getPoint().x && pointWire1.getPoint().y == pointWire2.getPoint().y){
                    crossings.add(pointWire1);
                }
            }
        }
        return crossings;
    }

    public int findShortestManhattanDistance(List<PointCost> points){
        int shortestDistance = Integer.MAX_VALUE;

        for(PointCost point : points){
            int distance = calculateManhattanDistance(point.getPoint());
            if (distance < shortestDistance){
                shortestDistance = distance;
            }
        }
        return shortestDistance;
    }

    public int calculateManhattanDistance(Point point){
        int distanceX = Math.abs(STARTING_POINT_X - point.x);
        int distanceY = Math.abs(STARTING_POINT_Y-point.y);

        return distanceX + distanceY;
    }

    public List<String> readFileIntoStringArray(){

        FileHandler fileHandler = new FileHandler();
        return fileHandler.readFile(getClass().getClassLoader().getResource("adventofcode/year2019/day3.txt").getFile());
    }
}