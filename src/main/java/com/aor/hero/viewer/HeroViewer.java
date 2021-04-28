package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.elements.Hero;

public class HeroViewer implements ElementViewer<Hero> {
    @Override
    public void drawElement(Hero hero, GUI gui) {
        gui.drawHero(hero.getPosition());
    }
}
