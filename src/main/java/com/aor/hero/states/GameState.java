package com.aor.hero.states;

import com.aor.hero.controller.Controller;
import com.aor.hero.controller.game.ArenaController;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.viewer.Viewer;
import com.aor.hero.viewer.game.GameViewer;

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
