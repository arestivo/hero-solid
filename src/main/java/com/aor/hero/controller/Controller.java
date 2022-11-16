package com.aor.hero.controller;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;

import java.io.IOException;
import java.util.List;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, List<GUI.ACTION> actions, long time) throws IOException;
}
