package ldts.dino.viewer.menu;

import ldts.dino.gui.GUI;
import ldts.dino.model.menu.InstructionsMenu;
import ldts.dino.utils.Position;

public class InstructionsViewer extends MenuViewer<InstructionsMenu> {

    public InstructionsViewer(InstructionsMenu instructionsMenu) {
        super(instructionsMenu, new Position(10, 10));
    }

    @Override
    public void drawElements(GUI gui) {
        super.drawElements(gui);
    }
}
