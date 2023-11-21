package com.aor.hero.model.game.arena;

import com.aor.hero.model.game.elements.Hero;
import com.aor.hero.model.game.elements.Key;
import com.aor.hero.model.game.elements.Monster;
import com.aor.hero.model.game.elements.Wall;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setHero(createHero());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setKeys(createKeys());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract List<Key> createKeys();

    protected abstract Hero createHero();
}
