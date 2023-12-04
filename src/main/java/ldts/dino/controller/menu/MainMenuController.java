package ldts.dino.controller.menu;

import ldts.dino.Application;
import ldts.dino.model.game.Game;
import ldts.dino.model.menu.InstructionsMenu;
import ldts.dino.model.menu.MainMenu;
import ldts.dino.model.menu.ScoresMenu;
import ldts.dino.state.GameState;
import ldts.dino.state.InstructionsState;
import ldts.dino.state.ScoresState;

public class MainMenuController extends MenuController<MainMenu> {
    public MainMenuController(MainMenu menu) {
        super(menu);
    }

    public void entrySelected(Application application) {
        if(getModel().isSelectedStart()) application.setState(new GameState(new Game()));
        if(getModel().isSelectedInstructions()) application.setState(new InstructionsState(new InstructionsMenu()));
        if(getModel().isSelectedLeaderboard()) application.setState(new ScoresState(new ScoresMenu()));
        if(getModel().isSelectedExit()) application.setState(null);
    }

    @Override
    public void backSelected(Application application) {

    }
}