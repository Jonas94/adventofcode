package adventofcode.year2018;

public class Claim {

    int inchFromLeft;
    int inchFromTop;
    int width;
    int height;
    int id;

    public Claim(int id, int inchFromLeft, int inchFromTop, int width, int height) {
        this.id = id;
        this.inchFromLeft = inchFromLeft;
        this.inchFromTop = inchFromTop;
        this.width = width;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInchFromLeft() {
        return inchFromLeft;
    }

    public void setInchFromLeft(int inchFromLeft) {
        this.inchFromLeft = inchFromLeft;
    }

    public int getInchFromTop() {
        return inchFromTop;
    }

    public void setInchFromTop(int inchFromTop) {
        this.inchFromTop = inchFromTop;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "inchFromLeft=" + inchFromLeft +
                ", inchFromTop=" + inchFromTop +
                ", width=" + width +
                ", height=" + height +
                ", id=" + id +
                '}';
    }
}
