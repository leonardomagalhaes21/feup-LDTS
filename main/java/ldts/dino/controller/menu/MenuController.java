package ldts.dino.controller.menu;

import ldts.dino.Application;
import ldts.dino.controller.Controller;
import ldts.dino.gui.GUI;
import ldts.dino.model.menu.Menu;

public abstract class MenuController<T extends Menu> extends Controller<T> implements MenuInterface {
    public MenuController(T model) {
        super(model);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                entrySelected(application);
                break;
            case BACK:
                backSelected(application);
                break;
            case QUIT: application.setState(null);
                break;
        }
    }
}