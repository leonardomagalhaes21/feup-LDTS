package ldts.dino.model.game.creators;

import ldts.dino.model.game.elements.collectables.*;

import java.util.Random;

public class CollectableCreator extends Creator<Collectable> {
    private final Random random;

    public CollectableCreator() {
        this.random = new Random();
    }

    @Override
    public Collectable create() {
        int randomObstacle = random.nextInt(4);
        return switch (randomObstacle) {
            case (0) -> new Bomb();
            case (1) -> new Boots();
            case (2) -> new Coin();
            case (3) -> new Shield();
            default -> null;
        };
    }
}