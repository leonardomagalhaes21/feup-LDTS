package ldts.dino.controller.menu;

import ldts.dino.Application;
import ldts.dino.model.menu.MainMenu;
import ldts.dino.model.menu.ScoresMenu;
import ldts.dino.state.MainMenuState;

public class ScoresController extends MenuController<ScoresMenu>{

    public ScoresController(ScoresMenu model) {
        super(model);
    }

    @Override
    public void entrySelected(Application application) {

    }

    @Override
    public void backSelected(Application application) {
        application.setState(new MainMenuState(new MainMenu()));
    }
}
