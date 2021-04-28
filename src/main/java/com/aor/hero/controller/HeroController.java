package com.aor.hero.controller;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.arena.Arena;

public class HeroController extends GameController {
    public HeroController(Arena arena) {
        super(arena);
    }

    public void moveHeroLeft() {
        moveHero(arena.getHero().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(arena.getHero().getPosition().getRight());
    }

    public void moveHeroUp() {
        moveHero(arena.getHero().getPosition().getUp());
    }

    public void moveHeroDown() {
        moveHero(arena.getHero().getPosition().getDown());
    }

    private void moveHero(Position position) {
        if (arena.isEmpty(position)) {
            arena.getHero().setPosition(position);
            if (arena.isMonster(position)) arena.getHero().decreaseEnergy();
        }
    }

    public void doAction(GUI.ACTION action) {
        if (action == GUI.ACTION.UP) moveHeroUp();
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.DOWN) moveHeroDown();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
    }
}
