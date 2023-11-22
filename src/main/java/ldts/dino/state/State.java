package ldts.dino.state;

import ldts.dino.Game;
import ldts.dino.controller.Controller;
import ldts.dino.gui.GUI;
import ldts.dino.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.controller = getController();
        this.viewer = getViewer();
    }

    protected abstract Controller<T> getController();

    protected abstract Viewer<T> getViewer();

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }

    // TO ADD: controller, viewer.
}