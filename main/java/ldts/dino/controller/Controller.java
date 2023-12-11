package ldts.dino.controller;

import ldts.dino.Application;
import ldts.dino.gui.GUI;

public abstract class Controller<T> {
    private final T model;

    protected Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Application application, GUI.ACTION action, long time);
}