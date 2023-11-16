package ldts.stickhero.state;

import ldts.stickhero.controller.Controller;
import ldts.stickhero.controller.menu.MenuController;
import ldts.stickhero.model.menu.Menu;
import ldts.stickhero.viewer.Viewer;
import ldts.stickhero.viewer.menu.MenuViewer;

public class MenuState extends State<Menu>{
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }
}