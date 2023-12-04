package ldts.dino.viewer.menu;

import ldts.dino.gui.GUI;
import ldts.dino.model.menu.Menu;
import ldts.dino.state.State;
import ldts.dino.utils.Position;
import ldts.dino.utils.Colors;
import ldts.dino.viewer.Viewer;

public abstract class MenuViewer<T extends Menu> extends Viewer<T> {

    private final Integer entriesX, entriesY;

    public MenuViewer(T model, Position position) {
        super(model);
        this.entriesX = position.getX();
        this.entriesY = position.getY();
    }

    @Override
    public void drawElements(GUI gui) {
        //draw the menu stuff
        gui.paintBackground(Colors.MENU_BACKGROUND.getHex());

        drawEntries(gui, entriesX, entriesY);

        drawTextMenu(gui, entriesX, entriesY);
    }

    abstract protected void drawEntries(GUI gui, Integer entriesX, Integer entriesY);

    abstract protected void drawTextMenu(GUI gui, Integer entriesX, Integer entriesY);

    public void drawText(GUI gui, Position position, String text, String color) {
        gui.drawText(position, text, color, Colors.MENU_BACKGROUND.getHex());
    }

}