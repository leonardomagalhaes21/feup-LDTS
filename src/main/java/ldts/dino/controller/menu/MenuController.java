package ldts.dino.controller.menu;

import ldts.dino.Game;
import ldts.dino.controller.Controller;
import ldts.dino.gui.GUI;
import ldts.dino.model.menu.Menu;

public abstract class MenuController<T extends Menu> extends Controller<T> implements MenuInterface {
    public MenuController(T model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                entrySelected(game);
                break;
            case BACK:
                backSelected(game);
                break;
            case QUIT: game.setState(null);
                break;
        }
    }
}