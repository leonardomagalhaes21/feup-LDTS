package ldts.dino.model.game.elements.collectables;

import ldts.dino.model.game.elements.Element;
import ldts.dino.utils.Position;

public abstract class Collectable extends Element {
    public final int speed = 1;
    public Collectable(Position position) {
        super(position);
    }
}