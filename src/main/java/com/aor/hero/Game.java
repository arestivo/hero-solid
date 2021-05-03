package com.aor.hero;

import com.aor.hero.controller.ArenaController;
import com.aor.hero.gui.GUI;
import com.aor.hero.gui.LanternaGUI;
import com.aor.hero.model.arena.Arena;
import com.aor.hero.model.arena.LoaderArenaBuilder;
import com.aor.hero.viewer.ArenaViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        createGame(1);
    }

    private static void createGame(int level) throws FontFormatException, IOException, URISyntaxException {
        Arena arena = new LoaderArenaBuilder(level).createArena();
        GUI gui = new LanternaGUI(arena.getWidth(), arena.getHeight());

        ArenaViewer viewer = new ArenaViewer(gui);
        ArenaController controller = new ArenaController(arena, viewer, gui);

        controller.start();
    }
}
