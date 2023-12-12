package ldts.dino.controller.menu;

import ldts.dino.Application;
import ldts.dino.controller.Controller;
import ldts.dino.gui.GUI;
import ldts.dino.model.menu.Menu;
import ldts.dino.utils.SoundManager;

public abstract class MenuController<T extends Menu> extends Controller<T> implements MenuInterface {
    public MenuController(T model) {
        super(model);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        switch (action) {
            case UP:
                SoundManager.getInstance().playMenuSelectionSound();
                getModel().previousEntry();
                break;
            case DOWN:
                SoundManager.getInstance().playMenuSelectionSound();
                getModel().nextEntry();
                break;
            case SELECT:
                SoundManager.getInstance().playMenuSelectionSound();
                entrySelected(application);
                break;
            case BACK:
                SoundManager.getInstance().playMenuSelectionSound();
                backSelected(application);
                break;
            case QUIT:
                application.setState(null);
                break;
        }
    }
}