package ldts.dino.viewer.game;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.Element;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.utils.Colors;

public class GroundViewer implements ElementViewer<Ground> {
    @Override
    public void draw(Ground ground, GUI gui) {
        gui.drawArea(ground.getPosition(), ground.getWidth(), ground.getHeight(), Colors.GREEN.getHex());
    }
}