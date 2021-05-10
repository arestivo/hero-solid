package com.aor.hero.states;

import com.aor.hero.controller.Controller;
import com.aor.hero.controller.game.ArenaController;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.viewer.GameViewer;
import com.aor.hero.viewer.Viewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
