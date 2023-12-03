package ldts.dino.viewer.game;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.Dino;
import ldts.dino.model.game.elements.Element;
import ldts.dino.utils.Colors;

public class DinoViewer implements ElementViewer<Dino>{
    @Override
    public void draw(Dino element, GUI gui) {
        gui.drawArea(element.getPosition(), element.getWidth(), element.getHeight(), Colors.BLACK.getHex());
    }
}