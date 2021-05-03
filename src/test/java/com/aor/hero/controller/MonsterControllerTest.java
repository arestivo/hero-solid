package com.aor.hero.controller;

import com.aor.hero.model.Position;
import com.aor.hero.model.arena.Arena;
import com.aor.hero.model.elements.Hero;
import com.aor.hero.model.elements.Monster;
import com.aor.hero.model.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MonsterControllerTest {
    private MonsterController controller;
    private Hero hero;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        hero = new Hero(5, 5);
        arena.setHero(hero);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());

        controller = new MonsterController(arena);
    }

    @Test
    void moveMonsters() {
        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));

        controller.moveMonsters();

        assertNotEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersClosed() {
        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4),
                new Wall(5, 6)
        ));

        for (int i = 0; i < 10; i++)
            controller.moveMonsters();

        assertEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersGap() {
        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4)
        ));

        while (monster.getPosition().equals(new Position(5, 5)))
            controller.moveMonsters();

        assertEquals(new Position(5, 6), monster.getPosition());
    }
}