package ldts.dino.model.game.elements;

import ldts.dino.gui.LanternaGUI;
import ldts.dino.utils.Position;

public class Dino extends Element {
    public static int HEIGHT = 30;
    public static int WIDTH = 15;
    public int speed = 1;
    public final int MAX_SPEED = 3;
    public Dino() {
        super(new Position(30, Ground.HEIGHT - HEIGHT), WIDTH, HEIGHT);
    }

}