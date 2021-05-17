package com.aor.hero.controller;

import com.aor.hero.controller.game.HeroController;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.arena.RandomArenaBuilder;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import java.util.List;

public class ArenaIsClosedTest {
    @Property
    void allArenasAreClosed(@ForAll @IntRange(min = 3, max = 50) int width, @ForAll @IntRange(min = 3, max = 50) int height, @ForAll List<GUI.@From("moveActions") ACTION> actions) {
        RandomArenaBuilder rab = new RandomArenaBuilder(width, height, 0);
        Arena arena = rab.createArena();
        HeroController controller = new HeroController(arena);

        for (GUI.ACTION action : actions) {
            controller.step(null, action, 100);
            assert (controller.getModel().getHero().getPosition().getX() > 0);
            assert (controller.getModel().getHero().getPosition().getY() > 0);
            assert (controller.getModel().getHero().getPosition().getX() < width - 1);
            assert (controller.getModel().getHero().getPosition().getY() < height - 1);
        }
    }

    @Provide
    Arbitrary<GUI.ACTION> moveActions() {
        return Arbitraries.of(GUI.ACTION.UP, GUI.ACTION.RIGHT, GUI.ACTION.DOWN, GUI.ACTION.LEFT);
    }
}
