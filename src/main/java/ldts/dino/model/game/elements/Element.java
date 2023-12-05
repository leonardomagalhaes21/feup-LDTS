package ldts.dino.model.game.elements;

import ldts.dino.utils.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    private Position position;
    private int width;
    private int height;
    public Element(Position position) {
        this.position = position;
        this.width = 1;
        this.height = 1;
    }

    public Element(Position position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Position getPosition() {
        return this.position;
    }

    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<>();

        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                int x = getPosition().getX() + j;
                int y = getPosition().getY() + i;
                positions.add(new Position(x, y));
            }
        }

        return positions;
    }

    public boolean isColliding(Element element) {
        List<Position> l1 = getPositions();
        List<Position> l2 = element.getPositions();

        for (Position pos1 : l1) {
            for (Position pos2 : l2) {
                if (pos1.equals(pos2)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isOutOfScreen() {
        return this.getPosition().getX() + this.getWidth() < -1;
    }
}