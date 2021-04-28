package com.aor.hero.controller;

import com.aor.hero.model.Position;
import com.aor.hero.model.arena.Arena;
import com.aor.hero.model.elements.Monster;

public class MonsterController extends GameController {
    public MonsterController(Arena arena) {
        super(arena);
    }

    public void moveMonsters() {
        for (Monster monster : arena.getMonsters())
            moveMonster(monster, monster.getPosition().getRandomNeighbour());
    }

    private void moveMonster(Monster monster, Position position) {
        if (arena.isEmpty(position)) {
            monster.setPosition(position);
            if (arena.getHero().getPosition().equals(position))
                arena.getHero().decreaseEnergy();
        }
    }
}
