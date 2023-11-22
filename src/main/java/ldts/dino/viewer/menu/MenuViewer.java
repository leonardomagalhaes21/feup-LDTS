package ldts.dino.viewer.menu;

import ldts.dino.gui.GUI;
import ldts.dino.model.menu.Menu;
import ldts.dino.viewer.Colors;
import ldts.dino.viewer.Viewer;

public abstract class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        //draw the menu stuff
        gui.paintBackground(Colors.MENU_BACKGROUND.getHex());

        drawEntries();
    }

    public void drawEntries(GUI gui) {
        /*
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            if (getModel().isSelected(i)) {
                drawText(gui, new Position(options_x, options_y + i), ">" + getModel().getEntry(i), Colors.ORANGE.getHex());
            } else {
                drawText(gui, new Position(options_x + 1, options_y + i), getModel().getEntry(i), Colors.WHITE.getHex());
            }
        }

         */
    }
}