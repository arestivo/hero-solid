package com.aor.hero.controller.game;

import com.aor.hero.controller.Controller;
import com.aor.hero.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
