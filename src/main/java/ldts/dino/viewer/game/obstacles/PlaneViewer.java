package ldts.dino.viewer.game.obstacles;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.elements.obstacles.Plane;
import ldts.dino.viewer.game.ElementViewer;

public class PlaneViewer implements ElementViewer<Plane> {
    @Override
    public void draw(Plane plane, GUI gui) {
        gui.drawImageFromFile(plane.getPosition(), "plane");
    }
}