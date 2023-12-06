package ldts.dino.viewer.game;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.Dino;
import ldts.dino.model.game.elements.Element;
import ldts.dino.utils.Colors;

public class DinoViewer implements ElementViewer<Dino>{
    @Override
    public void draw(Dino element, GUI gui) {
        if (element.getDinoForm() == 1) {
            gui.drawImageFromFile(element.getPosition(), "walk1");
        } else {
            gui.drawImageFromFile(element.getPosition(), "walk2");
        }
    }
}