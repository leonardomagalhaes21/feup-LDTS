package ldts.dino.model.game.elements;

import ldts.dino.gui.LanternaGUI;
import ldts.dino.utils.Position;

public class Ground extends Element{
    public static int HEIGHT = 120 ;
    public Ground() {
        super(new Position(0, HEIGHT), LanternaGUI.WIDTH, LanternaGUI.HEIGHT - HEIGHT + 1);
    }

    @Override
    public void move() {}
}