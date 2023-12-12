package ldts.dino.viewer.game;

import ldts.dino.gui.GUI;
import ldts.dino.gui.LanternaGUI;
import ldts.dino.model.game.Game;
import ldts.dino.model.game.elements.Element;
import ldts.dino.model.game.elements.collectables.*;
import ldts.dino.model.game.elements.dino.CrouchDino;
import ldts.dino.model.game.elements.dino.NormalDino;
import ldts.dino.model.game.elements.obstacles.City;
import ldts.dino.model.game.elements.obstacles.Obstacle;
import ldts.dino.model.game.elements.obstacles.Plane;
import ldts.dino.utils.Colors;
import ldts.dino.utils.Position;
import ldts.dino.viewer.Viewer;
import ldts.dino.viewer.game.collectables.BombViewer;
import ldts.dino.viewer.game.collectables.BootsViewer;
import ldts.dino.viewer.game.collectables.CoinViewer;
import ldts.dino.viewer.game.collectables.ShieldViewer;
import ldts.dino.viewer.game.obstacles.CityViewer;
import ldts.dino.viewer.game.obstacles.PlaneViewer;

import java.util.List;

public class GameViewer extends Viewer<Game> {

    public GameViewer(Game model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        drawBackground(gui);
        drawScore(gui);
        drawBombCounter(gui);
        drawElement(gui, getModel().getGround(), new GroundViewer());
        drawDino(gui);
        drawObstacles(gui, getModel().getObstacles());
        drawCollectables(gui, getModel().getCollectables());
        drawExplosion(gui);
        drawProgressBar(gui);
    }

    private void drawProgressBar(GUI gui) {
        if(getModel().isShieldActivated()) {
            gui.drawImageFromFile(new Position(1, 1), "shield");
            gui.drawArea(new Position(15, 3), (Game.CLOCK_LIMIT - getModel().getShieldClock()) / 2, 6, Colors.GREEN.getHex());
        }
        if(getModel().isBootsActivated()) {
            gui.drawImageFromFile(new Position(1, 15), "boots");
            gui.drawArea(new Position(15, 18), (Game.CLOCK_LIMIT - getModel().getBootsClock()) / 2, 6, Colors.GREEN.getHex());
        }
    }

    private void drawExplosion(GUI gui) {
        if(getModel().getExplosion() != null) {
            gui.drawImageFromFile(getModel().getExplosion(), "explosion");
        }
    }

    private void drawBackground(GUI gui) {
        gui.paintBackground(Colors.BLUE.getHex());
    }

    private void drawBombCounter(GUI gui) {
        gui.drawText(new Position(LanternaGUI.WIDTH - 40, 1),  getModel().getBombs() + "/" + Game.BOMBS_LIMIT,10, Colors.WHITE.getHex());
        gui.drawImageFromFile(new Position(getModel().getGround().getWidth()-10, 1), "bomb");
    }

    private void drawScore(GUI gui) {
        gui.drawText(new Position(LanternaGUI.WIDTH / 2 - 40,1), "SCORE: " + (int) getModel().getScore(), 10, Colors.WHITE.getHex());
    }

    private void drawDino(GUI gui) {
        if(getModel().getDino() instanceof NormalDino) {
            drawElement(gui, (NormalDino) getModel().getDino(), new NormalDinoViewer());
        } else {
            drawElement(gui, (CrouchDino) getModel().getDino(), new CrouchDinoViewer());
        }
    }

    private void drawObstacles(GUI gui, List<Obstacle> obstacles) {
        for (Obstacle obstacle : obstacles) {
            if(obstacle.getClass() == City.class) {
                new CityViewer().draw((City) obstacle, gui);
            } else {
                new PlaneViewer().draw((Plane) obstacle, gui);
            }
        }
    }

    private void drawCollectables(GUI gui, List<Collectable> collectables) {
        for (Collectable collectable : collectables) {
            if (collectable.getClass().equals(Bomb.class)) {
                new BombViewer().draw((Bomb) collectable, gui);
            } else if (collectable.getClass().equals(Boots.class)) {
                new BootsViewer().draw((Boots) collectable, gui);
            } else if (collectable.getClass().equals(Coin.class)) {
                new CoinViewer().draw((Coin) collectable, gui);
            } else if (collectable.getClass().equals(Shield.class)) {
                new ShieldViewer().draw((Shield) collectable, gui);
            } else {
                System.out.println("error");
            }
        }
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}