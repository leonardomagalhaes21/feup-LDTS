package ldts.dino.controller.game.elements;

import ldts.dino.Application;
import ldts.dino.controller.Controller;
import ldts.dino.gui.GUI;
import ldts.dino.model.game.Game;
import ldts.dino.model.game.elements.collectables.Collectable;
import ldts.dino.model.game.elements.obstacles.Obstacle;

import java.util.Iterator;

public class MotionController extends Controller<Game> {
    public MotionController(Game model) {
        super(model);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        moveObstacles();
        moveCollectables();
        difficultyControl();
    }

    private void moveObstacles() {
        Iterator<Obstacle> obstacleIterator = getModel().getObstacles().iterator();
        while (obstacleIterator.hasNext()) {
            Obstacle obstacle = obstacleIterator.next();
            obstacle.move();
            if (obstacle.isOutOfScreen()) {
                obstacleIterator.remove();
            }
        }
    }

    private void moveCollectables() {
        Iterator<Collectable> collectableIterator = getModel().getCollectables().iterator();
        while (collectableIterator.hasNext()) {
            Collectable collectable = collectableIterator.next();
            collectable.move();
            if (collectable.isOutOfScreen()) {
                collectableIterator.remove();
            }
        }
    }

    private void difficultyControl() {
        if (getModel().getScore() == 250) {
            Obstacle.incrementSpeed();
            Collectable.incrementSpeed();
        }

        else if (getModel().getScore() == 500) {
            Obstacle.incrementSpeed();
            Collectable.incrementSpeed();
        }

        else if (getModel().getScore() == 1000) {
            Obstacle.incrementSpeed();
            Collectable.incrementSpeed();
        }

        else if (getModel().getScore() == 1500) {
            Obstacle.incrementSpeed();
            Collectable.incrementSpeed();
        }

        else if (getModel().getScore() == 2000) {
            Obstacle.incrementSpeed();
            Collectable.incrementSpeed();
        }
    }
}