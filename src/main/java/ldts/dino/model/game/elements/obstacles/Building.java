package ldts.dino.model.game.elements.obstacles;

import ldts.dino.utils.Position;


public class Building extends Obstacle {
    public static final int WIDTH = 10;

    public static final int SMALL_BUILDING_HEIGHT = 15;
    public static final int LARGE_BUILDING_HEIGHT = 25;

    private Building(Position position, int width, int height) {
        super(position, width, height);
    }

    public static final class Factory {

        private Factory() {
        }

        public static Building build(Position position, int height) {
            return new Building(position, Building.WIDTH, height);
        }

        public static Building buildLarge(Position position) {
            return build(position, LARGE_BUILDING_HEIGHT);
        }

        public static Building buildSmall(Position position) {
            return build(position, SMALL_BUILDING_HEIGHT);
        }
    }
    @Override
    public void move() {
    }
}
