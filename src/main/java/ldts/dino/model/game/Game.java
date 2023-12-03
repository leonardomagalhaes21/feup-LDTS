package ldts.dino.model.game;

import ldts.dino.gui.LanternaGUI;
import ldts.dino.model.game.elements.Dino;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.utils.Position;

public class Game {
    private final Dino dino;
    private final Ground ground;

    public Game() {
        this.dino = new Dino();
        ground = new Ground();
    }

    public Dino getDino() {
        return dino;
    }

    public Ground getGround() {
        return ground;
    }
}