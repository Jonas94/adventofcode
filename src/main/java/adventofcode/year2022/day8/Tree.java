package adventofcode.year2022.day8;

import java.awt.*;

public class Tree {
    private Point point;
    private int height;

    public Tree(Point point, int height) {
        this.point = point;
        this.height = height;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
