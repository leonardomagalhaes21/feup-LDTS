package ldts.dino.viewer.menu;

import ldts.dino.gui.GUI;
import ldts.dino.model.menu.ScoresMenu;
import ldts.dino.utils.Colors;
import ldts.dino.utils.Position;

public class ScoresViewer extends MenuViewer<ScoresMenu> {
    public ScoresViewer(ScoresMenu scoresMenu) {
        super(scoresMenu, new Position(25, 17));
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
