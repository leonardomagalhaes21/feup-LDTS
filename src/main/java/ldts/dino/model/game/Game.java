package ldts.dino.model.game;

import ldts.dino.model.game.elements.Dino;
import ldts.dino.model.game.elements.Ground;
import ldts.dino.model.game.elements.obstacles.Building;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Dino dino;
    private final Ground ground;
    private final List<Building> buildingsList;

    public Game() {
        this.dino = new Dino();
        this.ground = new Ground();
        this.buildingsList = new ArrayList<>();
    }

    public Dino getDino() {
        return dino;
    }

    public Ground getGround() {
        return ground;
    }

    public List<Building> getBuildings() {
        return buildingsList;
    }

    public void addBuilding(Building building) {
        buildingsList.add(building);
    }


}