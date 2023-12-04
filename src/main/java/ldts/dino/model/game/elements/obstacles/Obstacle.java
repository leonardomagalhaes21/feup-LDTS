package ldts.dino.model.game.elements.obstacles;

import ldts.dino.model.game.elements.Element;
import ldts.dino.utils.Position;

public abstract class Obstacle extends Element {
    public Obstacle(Position position, int width, int height) {
        super(position, width, height);
    }
}