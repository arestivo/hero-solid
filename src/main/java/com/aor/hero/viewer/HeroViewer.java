package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Hero;

public class HeroViewer implements ElementViewer<Hero> {
    @Override
    public void draw(Hero hero, GUI gui) {
        gui.drawHero(hero.getPosition());
    }
}
