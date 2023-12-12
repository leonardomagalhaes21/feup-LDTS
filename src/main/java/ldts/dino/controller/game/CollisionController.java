package ldts.dino.controller.game;

import ldts.dino.Application;
import ldts.dino.controller.Controller;
import ldts.dino.gui.GUI;
import ldts.dino.model.game.Game;
import ldts.dino.model.game.elements.collectables.Bomb;
import ldts.dino.model.game.elements.collectables.Collectable;
import ldts.dino.model.game.elements.obstacles.Obstacle;
import ldts.dino.model.menu.GameOverMenu;
import ldts.dino.state.GameOverState;
import ldts.dino.utils.SoundEffect;

import java.util.Iterator;

public class CollisionController extends Controller<Game> {

    protected CollisionController(Game model) {
        super(model);
    }

    @Override
    public void step(Application application, GUI.ACTION action, long time) {
        if(getModel().getGround().isColliding(getModel().getDino())) {
            getModel().getDino().getPosition().setY(getModel().getGround().getPosition().getY() - getModel().getDino().getHeight());
        }

        Iterator<Obstacle> obstacleIterator = getModel().getObstacles().iterator();
        while (obstacleIterator.hasNext()) {
            Obstacle obstacle = obstacleIterator.next();
            if (obstacle.isColliding(getModel().getDino())) {
                if(getModel().isShieldActivated()) {
                    obstacleIterator.remove();
                } else {
                    SoundEffect.getInstance().playGameOverSound();
                    application.setState(new GameOverState(new GameOverMenu(), (int) getModel().getScore()));
                    return;
                }
            }
        }

        Iterator<Collectable> collectableIterator = getModel().getCollectables().iterator();
        while (collectableIterator.hasNext()) {
            Collectable collectable = collectableIterator.next();
            if (collectable.isColliding(getModel().getDino())) {
                SoundEffect.getInstance().playPickSound();
                if(collectable.getClass() != Bomb.class || getModel().getBombs() < Game.BOMBS_LIMIT) {
                    collectableIterator.remove();
                }
                getModel().consumeCollectable(collectable);
            }
        }
    }
}