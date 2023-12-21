package ldts.dino.model.game.elements.obstacles;

import ldts.dino.gui.LanternaGUI;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.utils.Position;

import java.util.List;
import java.util.Random;

public class Plane extends Obstacle {
    public Position position;
    public static final int WIDTH = 25;
    public static final int HEIGHT = 10;
    private final Random random;

    public Plane() {
        super(new Position(LanternaGUI.WIDTH, 50), WIDTH, HEIGHT);
        this.random = new Random();
        int y = random.nextInt(50, Ground.HEIGHT-HEIGHT);
        this.getPosition().setY(y);
    }

    @Override
    public void move() {
        this.getPosition().setX(this.getPosition().getX() - getSpeed());
    }
}