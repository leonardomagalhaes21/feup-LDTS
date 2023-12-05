package ldts.dino.viewer.game;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.Game;
import ldts.dino.model.game.elements.Element;
import ldts.dino.model.game.elements.obstacles.City;
import ldts.dino.model.game.elements.obstacles.Obstacle;
import ldts.dino.utils.Colors;
import ldts.dino.viewer.Viewer;
import ldts.dino.viewer.game.obstacles.BuildingViewer;
import ldts.dino.viewer.game.obstacles.CityViewer;

import java.util.List;

public class GameViewer extends Viewer<Game> {

    public GameViewer(Game model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.paintBackground(Colors.BLUE.getHex());
        drawElement(gui, getModel().getGround(), new GroundViewer());
        drawElement(gui, getModel().getDino(), new DinoViewer());
        drawObstacles(gui, getModel().getObstacles());
    }

    private void drawObstacles(GUI gui, List<Obstacle> obstacles) {
        for (Obstacle obstacle : obstacles) {
            if(obstacle.getClass() == City.class) {
                new CityViewer().draw((City) obstacle, gui);
            }
        }
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}