package ldts.dino.controller.menu;

import ldts.dino.Application;
import ldts.dino.model.game.Game;
import ldts.dino.model.menu.MainMenu;
import ldts.dino.state.GameState;

public class MainMenuController extends MenuController<MainMenu> {
    public MainMenuController(MainMenu menu) {
        super(menu);
    }

    public void entrySelected(Application application) {
        if(getModel().isSelectedStart()) application.setState(new GameState(new Game()));
        if(getModel().isSelectedInstructions()) System.out.println("Intruções");
        if(getModel().isSelectedLeaderboard()) System.out.println("Top Score");
        if(getModel().isSelectedExit()) application.setState(null);
    }

    @Override
    public void backSelected(Application application) {

    }
}