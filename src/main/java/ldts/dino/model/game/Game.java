package ldts.dino.model.game;

import ldts.dino.model.game.elements.Element;
import ldts.dino.model.game.elements.dino.Dino;
import ldts.dino.model.game.elements.dino.NormalDino;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.model.game.elements.collectables.Collectable;
import ldts.dino.model.game.elements.obstacles.Obstacle;
import ldts.dino.utils.Position;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Dino dino;
    private final Ground ground;
    private final List<Obstacle> obstaclesList;
    private final List<Collectable> collectablesList;
    private int bombs;
    public float score = 0;
    private int clock = 0;
    private boolean shieldActivated = false;
    private int shieldClock = 0;
    private int bootsClock = 0;
    private int explosionClock = 0;
    private boolean bootsActivated = false;
    public static final int BOMBS_LIMIT = 5;
    public static final int CLOCK_LIMIT = 100;
    public static final int EXPLOSION_CLOCK = 5;

    private Position explosion = null;

    public Game() {
        this.dino = new NormalDino();
        this.ground = new Ground();
        this.obstaclesList = new ArrayList<>();
        this.collectablesList = new ArrayList<>();
        this.bombs = 0;
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

    public int getBombs() {
        return bombs;
    }

    public void addBomb() {
        bombs++;
    }

    public void removeBomb() {
        bombs--;
    }


    public void updateClock() {
        clock++;
        if(shieldActivated) {
            shieldClock++;
            if(shieldClock == CLOCK_LIMIT) {
                shieldActivated = false;
            }
        }
        if (bootsActivated) {
            bootsClock++;
            if (bootsClock == CLOCK_LIMIT) {
                bootsActivated = false;
            }
        }
        if(getExplosion() != null) {
            explosionClock++;
            if(explosionClock == EXPLOSION_CLOCK) {
                explosionClock = 0;
                setExplosion(null);
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

    public boolean isBootsActivated() {
        return bootsActivated;
    }

    public void startBoots() {
        bootsActivated = true;
        bootsClock = 0;
    }

    public Position getExplosion() {
        return explosion;
    }

    public void setExplosion(Position explosion) {
        this.explosion = explosion;
    }

    public int getShieldClock() {
        return shieldClock;
    }

    public int getBootsClock() {
        return bootsClock;
    }
}