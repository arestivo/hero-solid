package com.aor.hero.controller;

import com.aor.hero.controller.game.HeroController;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Hero;
import com.aor.hero.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroControllerTest {
    private HeroController controller;
    private Hero hero;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        hero = new Hero(5, 5);
        arena.setHero(hero);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());

        controller = new HeroController(arena);
    }

    @Test
    void moveHeroRightEmpty() {
        controller.moveHeroRight();
        assertEquals(new Position(6, 5), hero.getPosition());
    }

    @Test
    void moveHeroRightNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(6, 5)));
        controller.moveHeroRight();
        assertEquals(new Position(5, 5), hero.getPosition());
    }
}