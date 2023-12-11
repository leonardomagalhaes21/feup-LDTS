package ldts.dino.state;

import ldts.dino.controller.Controller;
import ldts.dino.controller.menu.GameOverController;
import ldts.dino.model.menu.GameOverMenu;
import ldts.dino.viewer.Viewer;
import ldts.dino.viewer.menu.GameOverViewer;

public class GameOverState extends State<GameOverMenu> {

    public GameOverState(GameOverMenu model) {
        super(model);
    }

    @Override
    protected Controller<GameOverMenu> getController() {
        return new GameOverController(getModel());
    }

    @Override
    protected Viewer<GameOverMenu> getViewer() {
        return new GameOverViewer(getModel());
    }
}
