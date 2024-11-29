package adventofcode.year2019;

import java.awt.*;

public class PointCost {
    private int cost;
    private Point point;

    public PointCost(int cost, Point point) {
        this.cost = cost;
        this.point = point;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
