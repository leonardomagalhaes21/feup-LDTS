package ldts.dino.viewer.menu;

import ldts.dino.gui.GUI;
import ldts.dino.model.menu.InstructionsMenu;
import ldts.dino.utils.Colors;
import ldts.dino.utils.Position;

public class InstructionsViewer extends MenuViewer<InstructionsMenu> {

    public InstructionsViewer(InstructionsMenu instructionsMenu) {
        super(instructionsMenu, new Position(10, 10));
    }

    @Override
    protected void drawEntries(GUI gui, Integer entriesX, Integer entriesY) {

    }

    @Override
    protected void drawTextMenu(GUI gui, Integer entriesX, Integer entriesY) {
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            drawText(gui, new Position(entriesX + 1, entriesY + i), getModel().getEntry(i), Colors.WHITE.getHex());
    }
}
