package ldts.dino.viewer.menu;

import ldts.dino.model.menu.InstructionsMenu;
import ldts.dino.utils.Position;

public class InstructionsViewer extends MenuViewer<InstructionsMenu> {
    public InstructionsViewer(InstructionsMenu instructionsMenu) {
        super(instructionsMenu, new Position(25, 17));
    }
}
