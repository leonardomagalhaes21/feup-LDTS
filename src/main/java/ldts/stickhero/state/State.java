package ldts.stickhero.state;

import ldts.stickhero.Game;
import ldts.stickhero.controller.Controller;
import ldts.stickhero.gui.GUI;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;

    public State(T model) {
        this.model = model;
        this.controller = getController();
    }

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
    }

    // TO ADD: controller, viewer.
}