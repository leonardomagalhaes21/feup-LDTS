package ldts.stickhero.controller;

import ldts.stickhero.Game;
import ldts.stickhero.gui.GUI;

public abstract class Controller<T> {
    private final T model;

    protected Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, GUI.ACTION action, long time);
}