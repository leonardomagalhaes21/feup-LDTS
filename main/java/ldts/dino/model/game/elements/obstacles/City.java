package ldts.dino.model.game.elements.obstacles;

import ldts.dino.gui.LanternaGUI;
import ldts.dino.model.game.elements.Element;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.utils.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.max;

public class City extends Obstacle {
    private List<Building> buildings;
    private final Random random;
    private Position lastPosition;

    public City() {
        super(new Position(LanternaGUI.WIDTH, Ground.HEIGHT), 0, 0);
        this.buildings = new ArrayList<>();
        this.random = new Random();
        this.lastPosition = new Position(0, Ground.HEIGHT);
        addBuildings();
    }

    public void addBuildings() {
        int numberOfBuildings = random.nextInt(3) + 1;

        boolean isSmall = random.nextBoolean();

        for (int i = 0; i < numberOfBuildings; i++) {

            Building newBuilding;
            if (isSmall) {
                Position nextPosition = new Position(lastPosition.getX(), Ground.HEIGHT - Building.SMALL_BUILDING_HEIGHT);
                newBuilding = Building.Factory.buildSmall(nextPosition);
            } else {
                Position nextPosition = new Position(lastPosition.getX(), Ground.HEIGHT - Building.LARGE_BUILDING_HEIGHT);
                newBuilding = Building.Factory.buildLarge(nextPosition);
            }

            this.setWidth(this.getWidth() + newBuilding.getWidth());
            this.setHeight(max(this.getHeight(), newBuilding.getHeight()));
            this.buildings.add(newBuilding);
            this.lastPosition = new Position(newBuilding.getPosition().getX() + newBuilding.getWidth() + 1, newBuilding.getPosition().getY());
        }
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public Position getBuildingAbsolutePosition(Building building) {
        return new Position(building.getPosition().getX() + this.getPosition().getX(), building.getPosition().getY());
    }
    @Override
    public boolean isColliding(Element element) {
        Position cityPos = this.getPosition();

        for(Building building : buildings) {
            Position buildingPosition = building.getPosition();
            Position newPos = new Position(cityPos.getX() + buildingPosition.getX(), buildingPosition.getY());
            Building buildingToCollide = Building.Factory.build(newPos, building.getHeight()) ;
            if(buildingToCollide.isColliding(element)) {
                return true;
            }
        }
        return false;
    }
}