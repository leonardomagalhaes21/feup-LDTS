package ldts.dino.viewer.menu;

import ldts.dino.gui.GUI;
import ldts.dino.gui.LanternaGUI;
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
        gui.drawImageFromFile(new Position(0, 0), "background");

        gui.drawText(new Position(LanternaGUI.WIDTH / 2 - 50, 40), "DINO", 30, Colors.MENU.getHex());

        drawEntries(gui, entriesX, entriesY);

    }

    abstract protected void drawEntries(GUI gui, Integer entriesX, Integer entriesY);

    public void drawText(GUI gui, Position position, String text, String color) {
        gui.drawText(position, text, 10, color);
    }

}