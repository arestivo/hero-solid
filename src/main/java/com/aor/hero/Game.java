package com.aor.hero;

import com.aor.hero.controller.ArenaController;
import com.aor.hero.gui.GUI;
import com.aor.hero.gui.LanternaGUI;
import com.aor.hero.model.arena.Arena;
import com.aor.hero.model.arena.RandomArenaBuilder;
import com.aor.hero.viewer.ArenaViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        createGame(20, 20, 8);
    }

    private static void createGame(int width, int height, int numberOfMonsters) throws FontFormatException, IOException, URISyntaxException {
        GUI gui = new LanternaGUI(width, height);

        Arena arena = new RandomArenaBuilder(width, height, numberOfMonsters).createArena();
        ArenaViewer viewer = new ArenaViewer(gui);
        ArenaController controller = new ArenaController(arena, viewer, gui);

        controller.start();
    }
}
