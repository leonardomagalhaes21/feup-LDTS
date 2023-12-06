package ldts.dino.controller.game;

import ldts.dino.Application;
import ldts.dino.controller.Controller;
import ldts.dino.controller.game.elements.DinoController;
import ldts.dino.gui.GUI;
import ldts.dino.model.game.Game;
import ldts.dino.model.game.elements.obstacles.Obstacle;
import ldts.dino.model.menu.GameOverMenu;
import ldts.dino.state.GameOverState;

public class CollisionController extends Controller<Game> {

    protected CollisionController(Game model) {
        super(model);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        for(Obstacle obstacle: getModel().getObstacles()) {
            if (obstacle.isColliding(getModel().getDino())) {
                application.setState(new GameOverState(new GameOverMenu()));
                return;
            }
        }
    }
}