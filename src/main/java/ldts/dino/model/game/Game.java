package ldts.dino.model.game;

import ldts.dino.gui.LanternaGUI;
import ldts.dino.model.game.elements.Ground;

public class Game {
    private final Ground ground;

    public Game() {
        ground = new Ground(30);
    }

    public Ground getGround() {
        return ground;
    }
}