package ldts.dino.utils;

public class Position {

    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    @Override
    public String toString() { return "(" + x + ", " + y + ")"; }

    public boolean equals(Position position) {
        return x == position.getX() && y == position.getY();
    }

    public Position offset(int x, int y) {
        return new Position(this.x + x, this.y + y);
    }
}