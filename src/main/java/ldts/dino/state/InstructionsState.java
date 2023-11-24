package ldts.dino.state;

import ldts.dino.controller.Controller;
import ldts.dino.controller.menu.InstructionsController;
import ldts.dino.model.menu.InstructionsMenu;
import ldts.dino.viewer.Viewer;
import ldts.dino.viewer.menu.InstructionsViewer;

public class InstructionsState extends State<InstructionsMenu>{

    public InstructionsState (InstructionsMenu model) {
        super(model);
    }

    @Override
    protected Controller<InstructionsMenu> getController() {
        return new InstructionsController(getModel());
    }

    @Override
    protected Viewer<InstructionsMenu> getViewer() {
        return new InstructionsViewer(getModel());
    }
}
