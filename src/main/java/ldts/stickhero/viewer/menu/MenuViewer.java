package ldts.stickhero.viewer.menu;

import ldts.stickhero.gui.GUI;
import ldts.stickhero.model.menu.Menu;
import ldts.stickhero.viewer.Colors;
import ldts.stickhero.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        //draw the menu stuff
        gui.paintBackground(Colors.MENU_BACKGROUND.getHex());
    }
}