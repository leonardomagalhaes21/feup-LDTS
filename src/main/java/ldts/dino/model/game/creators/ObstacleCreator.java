package ldts.dino.model.game.creators;

import ldts.dino.model.game.elements.obstacles.City;
import ldts.dino.model.game.elements.obstacles.Obstacle;
import ldts.dino.model.game.elements.obstacles.Plane;

import java.util.Random;

public class ObstacleCreator extends Creator<Obstacle> {
    private final Random random;

    public ObstacleCreator() {
        this.random = new Random();
    }

    @Override
    public Obstacle create() {
        int randomObstacle = random.nextInt(2);
        if (randomObstacle == 0) {
            return new Plane();
        } else {
            return new City();
        }
    }
}