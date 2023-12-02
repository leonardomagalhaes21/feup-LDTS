package ldts.dino.model.game.elements;

import ldts.dino.gui.LanternaGUI;
import ldts.dino.utils.Position;

public class Ground extends Element{
    public Ground(int y) {
        super(new Position(0, y), LanternaGUI.WIDTH, LanternaGUI.HEIGHT - y + 1);
    }
}