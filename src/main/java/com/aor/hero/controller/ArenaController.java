package com.aor.hero.controller;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.arena.Arena;
import com.aor.hero.viewer.ArenaViewer;

import java.io.IOException;

public class ArenaController extends GameController {

    private final HeroController heroController;
    private final MonsterController monsterController;

    private final ArenaViewer viewer;

    public ArenaController(Arena arena, ArenaViewer viewer) {
        super(arena);

        this.viewer = viewer;
        this.heroController = new HeroController(arena);
        this.monsterController = new MonsterController(arena);
    }

    public void start() throws IOException {
        int FPS = 20;
        int frameTime = 1000 / FPS;
        long lastMonsterMovement = 0;

        while (getArena().getHero().getEnergy() > 0) {
            long startTime = System.currentTimeMillis();

            viewer.draw(getArena());

            GUI.ACTION action = viewer.getNextAction();
            if (action == GUI.ACTION.QUIT) break;

            heroController.doAction(action);
            if (startTime - lastMonsterMovement > 500) {
                monsterController.moveMonsters();
                lastMonsterMovement = startTime;
            }

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            if (sleepTime > 0) try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) { }
        }

        viewer.close();
    }
}
