package ldts.dino.viewer.game;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.dino.NormalDino;

public class NormalDinoViewer implements ElementViewer<NormalDino>{
    @Override
    public void draw(NormalDino element, GUI gui) {
        if (element.getDinoForm() == 1) {
            gui.drawImageFromFile(element.getPosition(), "walk1");
        } else {
            gui.drawImageFromFile(element.getPosition(), "walk2");
        }
    }
}