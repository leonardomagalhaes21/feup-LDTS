package ldts.dino.state;

import ldts.dino.controller.Controller;
import ldts.dino.controller.menu.ScoresController;
import ldts.dino.model.menu.ScoresMenu;
import ldts.dino.viewer.Viewer;
import ldts.dino.viewer.menu.ScoresViewer;

public class ScoresState extends State<ScoresMenu>{

    public ScoresState(ScoresMenu model) {
        super(model);
    }

    @Override
    protected Controller<ScoresMenu> getController() {
        return new ScoresController(getModel());
    }

    @Override
    protected Viewer<ScoresMenu> getViewer() {
        return new ScoresViewer(getModel());
    }
}
