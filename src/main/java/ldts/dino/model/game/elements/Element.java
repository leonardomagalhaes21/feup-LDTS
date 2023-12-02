package ldts.dino.model.game.elements;

import ldts.dino.utils.Position;

public abstract class Element {
    private Position position;
    private int width;
    private int height;
    public Element(Position position) {
        this.position = position;
        width = 1;
        height = 1;
    }

    public Element(Position position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}