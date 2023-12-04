package ldts.dino.controller.menu;

import ldts.dino.Application;
import ldts.dino.model.menu.InstructionsMenu;
import ldts.dino.model.menu.MainMenu;
import ldts.dino.state.MainMenuState;

public class InstructionsController extends MenuController<InstructionsMenu>  {
    public InstructionsController(InstructionsMenu model) {
        super(model);
    }

    @Override
    public void entrySelected(Application application) {
        application.setState(new MainMenuState(new MainMenu()));
    }

    @Override
    public void backSelected(Application application) {
        application.setState(new MainMenuState(new MainMenu()));
    }
}
