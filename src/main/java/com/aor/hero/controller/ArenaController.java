package com.aor.hero.controller;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.arena.Arena;
import com.aor.hero.viewer.ArenaViewer;

import java.io.IOException;

public class ArenaController extends GameController {
    private final HeroController heroController;
    private final MonsterController monsterController;

    private final ArenaViewer viewer;
    private final GUI gui;

    public ArenaController(Arena arena, ArenaViewer viewer, GUI gui) {
        super(arena);

        this.viewer = viewer;

        this.gui = gui;

        this.heroController = new HeroController(arena);
        this.monsterController = new MonsterController(arena);
    }

    public void start() throws IOException {
        while (getArena().getHero().getEnergy() > 0) {
            viewer.draw(getArena());

            GUI.ACTION action = gui.getNextAction();
            if (action == GUI.ACTION.QUIT) break;

            heroController.doAction(action);
            monsterController.moveMonsters();
        }

        viewer.close();
    }
}
