package ldts.dino.model.game.elements;

import ldts.dino.utils.Position;

public abstract class Element {
    private static int speed;
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

    public boolean isColliding(Element element) {
        Position thisPosition = this.getPosition();
        Position elementPosition = element.getPosition();

        boolean xOverlap = thisPosition.getX() <= elementPosition.getX() + element.getWidth() &&
                thisPosition.getX() + this.getWidth() >= elementPosition.getX();

        boolean yOverlap = thisPosition.getY() <= elementPosition.getY() + element.getHeight() &&
                thisPosition.getY() + this.getHeight() >= elementPosition.getY();

        return xOverlap && yOverlap;
    }

    public int getSpeed() {
        return speed;
    }

    public abstract void move();
}