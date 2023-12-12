package ldts.dino.viewer.menu;

import ldts.dino.gui.GUI;
import ldts.dino.gui.LanternaGUI;
import ldts.dino.model.menu.MainMenu;
import ldts.dino.utils.Colors;
import ldts.dino.utils.Position;

public class MainMenuViewer extends MenuViewer<MainMenu> {

    public MainMenuViewer(MainMenu mainMenu) {
        super(mainMenu, new Position(LanternaGUI.WIDTH / 2 - 50, 100));
    }

    @Override
    protected void drawEntries(GUI gui, Integer entriesX, Integer entriesY) {
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if (getModel().isSelected(i)) {
                drawText(gui, new Position(entriesX, entriesY + i * 15), getModel().getEntry(i), Colors.MENU.getHex());
            } else {
                drawText(gui, new Position(entriesX + 1, entriesY + i * 15), getModel().getEntry(i), Colors.WHITE.getHex());
            }
        }
    }

}