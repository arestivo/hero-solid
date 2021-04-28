package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.elements.Element;

public class HeroViewer implements ElementViewer {
    @Override
    public void drawElement(Element hero, GUI gui) {
        gui.drawHero(hero.getPosition());
    }
}
