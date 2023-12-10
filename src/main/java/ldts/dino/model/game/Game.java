package ldts.dino.model.game;

import ldts.dino.model.game.elements.dino.Dino;
import ldts.dino.model.game.elements.dino.NormalDino;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.model.game.elements.collectables.Collectable;
import ldts.dino.model.game.elements.obstacles.Obstacle;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Dino dino;
    private final Ground ground;
    private final List<Obstacle> obstaclesList;
    private final List<Collectable> collectablesList;

    private int clock;

    public Game() {
        this.dino = new NormalDino();
        this.ground = new Ground();
        this.obstaclesList = new ArrayList<>();
        this.collectablesList = new ArrayList<>();
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

    public List<Collectable> getCollectables() {
        return collectablesList;
    }

    public void addObstacle(Obstacle obstacle) {
        obstaclesList.add(obstacle);
    }

    public void addCollectable(Collectable collectable) {
        collectablesList.add(collectable);
    }

    public void setDino(Dino dino) {
        this.dino = dino;
    }
}