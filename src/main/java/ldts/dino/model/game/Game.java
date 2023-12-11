package ldts.dino.model.game;

import ldts.dino.model.game.elements.collectables.Shield;
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
    public float score = 0;
    private int clock = 0;

    private boolean shieldActivated = false;
    private int shieldClock = 0;

    public Game() {
        this.dino = new NormalDino();
        this.ground = new Ground();
        this.obstaclesList = new ArrayList<>();
        this.collectablesList = new ArrayList<>();

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

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void consumeCollectable(Collectable collectable) {
        collectable.consume(this);
    }

    // updateClock
    public void updateClock() {
        clock++;
        if(shieldActivated) {
            shieldClock++;
            if(shieldClock == Shield.CLOCK) {
                shieldActivated = false;
            }
        }
    }

    public void startShield() {
        shieldActivated = true;
        shieldClock = 0;
    }

    public boolean isShieldActivated() {
        return shieldActivated;
    }
}