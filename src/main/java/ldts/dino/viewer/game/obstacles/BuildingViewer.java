package ldts.dino.viewer.game.obstacles;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.obstacles.Building;
import ldts.dino.viewer.game.ElementViewer;

public class BuildingViewer implements ElementViewer<Building> {
    @Override
    public void draw(Building building, GUI gui) {
        if(building.getHeight() == Building.SMALL_BUILDING_HEIGHT) {
            gui.drawImageFromFile(building.getPosition(), "smallBuilding");
        } else {
            gui.drawImageFromFile(building.getPosition(), "largeBuilding");
        }
    }
}