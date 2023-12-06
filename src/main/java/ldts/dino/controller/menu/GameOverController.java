package ldts.dino.controller.menu;

import ldts.dino.Application;
import ldts.dino.model.game.Game;
import ldts.dino.model.menu.GameOverMenu;
import ldts.dino.state.GameState;

public class GameOverController extends MenuController<GameOverMenu> {
    public GameOverController(GameOverMenu model) {
        super(model);
    }

    @Override
    public void entrySelected(Application application) {
        if(getModel().isSelectedRestart()) application.setState(new GameState(new Game()));
    }

    @Override
    public void backSelected(Application application) {

    }
}