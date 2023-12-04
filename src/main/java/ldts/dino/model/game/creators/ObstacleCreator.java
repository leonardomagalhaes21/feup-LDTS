package ldts.dino.model.game.creators;

import ldts.dino.model.game.elements.obstacles.Building;

public class ObstacleCreator extends Creator {
    public Building createBuilding() {
        return new Building();
    }
}