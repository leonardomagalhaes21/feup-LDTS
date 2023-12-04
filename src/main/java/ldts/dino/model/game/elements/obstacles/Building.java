package ldts.dino.model.game.elements.obstacles;

import ldts.dino.gui.LanternaGUI;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.utils.Position;

public class Building extends Obstacle{
    public static int HEIGHT = 10;
    public static int WIDTH = 2;
    public static int VELOCITY = -1;

    public Building() {
        super(new Position(LanternaGUI.WIDTH, Ground.HEIGHT - HEIGHT), WIDTH, HEIGHT);
    }

    public int getVelocity() {
        return VELOCITY;
    }

    public boolean isOutOfScreen() {
        return this.getPosition().getX() < -1;
    }

    public void move() {
        this.setPosition(new Position(this.getPosition().getX() + getVelocity(), this.getPosition().getY()));
    }
}