package ldts.dino.model.game.elements.dino;

import ldts.dino.model.game.elements.Ground;
import ldts.dino.utils.Position;

public class CrouchDino extends Dino {
    public static int HEIGHT = 20;
    public static int WIDTH = 40;

    public CrouchDino() {
        super(new Position(30, Ground.HEIGHT - HEIGHT), WIDTH, HEIGHT);
    }
}