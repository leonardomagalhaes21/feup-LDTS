package ldts.dino.viewer.game;

import ldts.dino.gui.GUI;
import ldts.dino.model.game.Game;
import ldts.dino.model.game.elements.Element;
import ldts.dino.utils.Colors;
import ldts.dino.viewer.Viewer;

public class GameViewer extends Viewer<Game> {

    public GameViewer(Game model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.paintBackground(Colors.BLUE.getHex());
        drawElement(gui, getModel().getGround(), new GroundViewer());
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}