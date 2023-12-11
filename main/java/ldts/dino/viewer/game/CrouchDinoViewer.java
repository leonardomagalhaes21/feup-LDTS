package ldts.dino.viewer.game;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.dino.CrouchDino;
import ldts.dino.model.game.elements.dino.NormalDino;

public class CrouchDinoViewer implements ElementViewer<CrouchDino>{
    @Override
    public void draw(CrouchDino element, GUI gui) {
        gui.drawImageFromFile(element.getPosition(), "crouch");
    }
}