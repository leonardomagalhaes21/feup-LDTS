package ldts.dino.controller.game;

import ldts.dino.Application;
import ldts.dino.controller.Controller;
import ldts.dino.gui.GUI;
import ldts.dino.model.game.Game;

public class GameController extends Controller<Game> {
    public GameController(Game model) {
        super(model);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        switch (action) {
            case QUIT:
                application.setState(null);
                break;
        }
    }
}
