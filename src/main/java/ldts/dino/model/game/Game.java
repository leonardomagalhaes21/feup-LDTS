package ldts.dino.model.game;

import ldts.dino.model.game.elements.Dino;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.model.game.elements.obstacles.City;
import ldts.dino.model.game.elements.obstacles.Obstacle;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Dino dino;
    private final Ground ground;
    private final List<Obstacle> obstaclesList;
    private int clock;

    public Game() {
        this.dino = new Dino();
        this.ground = new Ground();
        this.obstaclesList = new ArrayList<>();
        this.clock = 0;
    }

    public Dino getDino() {
        return dino;
    }

    public Ground getGround() {
        return ground;
    }

    public int getClock() {
        return clock;
    }

    public void incrementClock() {
        clock++;
    }

    public List<Obstacle> getObstacles() {
        return obstaclesList;
    }

    public void addObstacle(Obstacle obstacle) {
        obstaclesList.add(obstacle);
    }
}