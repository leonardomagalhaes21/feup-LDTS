package ldts.dino.viewer.game.obstacles;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.Element;
import ldts.dino.utils.Colors;
import ldts.dino.viewer.game.ElementViewer;

public class BuildingViewer implements ElementViewer {
    @Override
    public void draw(Element element, GUI gui) {
        gui.drawArea(element.getPosition(), element.getWidth(), element.getHeight(), Colors.DARK_BLUE.getHex());
    }
}