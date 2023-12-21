package ldts.dino.state;

import ldts.dino.controller.Controller;
import ldts.dino.controller.menu.MainMenuController;
import ldts.dino.model.menu.MainMenu;
import ldts.dino.viewer.Viewer;
import ldts.dino.viewer.menu.MainMenuViewer;

public class MainMenuState extends State<MainMenu> {

    public MainMenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }
}