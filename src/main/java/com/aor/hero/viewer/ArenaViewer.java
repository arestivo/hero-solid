package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.arena.Arena;
import com.aor.hero.model.elements.Element;

import java.io.IOException;
import java.util.List;

public class ArenaViewer {
    private final GUI gui;

    public ArenaViewer(GUI gui) {
        this.gui = gui;
    }

    public void draw(Arena arena) throws IOException {
        gui.clear();

        drawElements(arena.getWalls(), new WallViewer());
        drawElements(arena.getMonsters(), new MonsterViewer());
        drawElement(arena.getHero(), new HeroViewer());

        gui.drawText(new Position(0, 0), "Energy: " + arena.getHero().getEnergy(), "#FFD700");

        gui.refresh();
    }

    private void drawElements(List<? extends Element> elements, ElementViewer viewer) {
        for (Element element : elements)
            drawElement(element, viewer);
    }

    private void drawElement(Element element, ElementViewer viewer) {
        viewer.drawElement(element, gui);
    }

    public void close() throws IOException {
        gui.close();
    }

    public GUI.ACTION getNextAction() throws IOException {
        return gui.getNextAction();
    }
}
