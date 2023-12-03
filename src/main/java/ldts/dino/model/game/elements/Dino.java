package ldts.dino.model.game.elements;

import ldts.dino.gui.LanternaGUI;
import ldts.dino.utils.Position;

public class Dino extends Element {
    private int velocity = 1;
    public static int HEIGHT = 4;
    public static int WIDTH = 2;
    public static int X = 10;
    public Dino() {
        super(new Position(X, Ground.HEIGHT - HEIGHT), WIDTH, HEIGHT);
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}