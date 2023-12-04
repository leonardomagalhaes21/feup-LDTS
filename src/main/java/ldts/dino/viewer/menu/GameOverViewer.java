package ldts.dino.viewer.menu;

import ldts.dino.gui.GUI;
import ldts.dino.model.menu.GameOverMenu;
import ldts.dino.utils.Position;

public class GameOverViewer extends MenuViewer<GameOverMenu>{

    public GameOverViewer(GameOverMenu gameOverMenu) {
        super(gameOverMenu, new Position(25, 17));
    }

    @Override
    protected void drawEntries(GUI gui, Integer entriesX, Integer entriesY) {

    }

    @Override
    protected void drawTextMenu(GUI gui, Integer entriesX, Integer entriesY) {

    }
}
