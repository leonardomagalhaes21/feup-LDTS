package ldts.dino.viewer.menu;

import ldts.dino.gui.GUI;
import ldts.dino.gui.LanternaGUI;
import ldts.dino.model.menu.ScoresMenu;
import ldts.dino.utils.Colors;
import ldts.dino.utils.Position;

public class ScoresViewer extends MenuViewer<ScoresMenu> {
    public ScoresViewer(ScoresMenu scoresMenu) {
        super(scoresMenu, new Position(LanternaGUI.WIDTH / 2 - 50, 100));
    }

    @Override
    protected void drawEntries(GUI gui, Integer entriesX, Integer entriesY) {
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            drawText(gui, new Position(entriesX + 10, entriesY + i * 15), getModel().getEntry(i), Colors.WHITE.getHex());
    }
}