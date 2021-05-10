package com.aor.hero.controller;

import com.aor.hero.Game;
import com.aor.hero.controller.game.MonsterController;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Hero;
import com.aor.hero.model.game.elements.Monster;
import com.aor.hero.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MonsterControllerTest {
    private MonsterController controller;
    private Hero hero;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        hero = new Hero(5, 5);
        arena.setHero(hero);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());

        controller = new MonsterController(arena);

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveMonsters() throws IOException {
        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));

        controller.step(game, GUI.ACTION.NONE, 1000);

        assertNotEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersClosed() throws IOException {
        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4),
                new Wall(5, 6)
        ));

        for (int i = 0; i < 10; i++)
            controller.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersGap() throws IOException {
        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4)
        ));

        long time = 0;

        while (monster.getPosition().equals(new Position(5, 5))) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE, time);
        }

        assertEquals(new Position(5, 6), monster.getPosition());
    }
}