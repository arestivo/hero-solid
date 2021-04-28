package com.aor.hero.controller;

import com.aor.hero.model.arena.Arena;

public abstract class GameController {
    protected final Arena arena;

    public GameController(Arena arena) {
        this.arena = arena;
    }

    public Arena getArena() {
        return arena;
    }
}
