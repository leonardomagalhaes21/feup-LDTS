package ldts.stickhero.controller.menu;

import ldts.stickhero.Game;
import ldts.stickhero.controller.Controller;
import ldts.stickhero.gui.GUI;
import ldts.stickhero.model.menu.Menu;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch (action) {
            case QUIT -> game.setState(null);
        }
    }
}