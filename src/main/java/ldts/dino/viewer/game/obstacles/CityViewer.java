package ldts.dino.viewer.game.obstacles;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.obstacles.City;
import ldts.dino.model.game.elements.obstacles.Building;
import ldts.dino.utils.Position;
import ldts.dino.viewer.game.ElementViewer;

public class CityViewer implements ElementViewer<City> {
    @Override
    public void draw(City city, GUI gui) {

        BuildingViewer buildingViewer = new BuildingViewer();

        Position cityPos = city.getPosition();

        for (Building building : city.getBuildings()) {

            Position buildingPosition = building.getPosition();

            Position newPos = new Position(cityPos.getX() + buildingPosition.getX(), buildingPosition.getY());

            Building buildingToDraw = Building.Factory.build(newPos, building.getHeight()) ;

            buildingViewer.draw(buildingToDraw, gui);
        }
    }
}