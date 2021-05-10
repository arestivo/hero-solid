package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Hero;
import com.aor.hero.viewer.game.HeroViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HeroViewerTest {
    private Hero hero;
    private HeroViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        hero = new Hero(10, 10);
        viewer = new HeroViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(hero, gui);
        Mockito.verify(gui, Mockito.times(1)).drawHero(hero.getPosition());
    }
}