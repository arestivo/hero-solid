package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.elements.Element;

public class MonsterViewer implements ElementViewer {
    @Override
    public void drawElement(Element monster, GUI gui) {
        gui.drawMonster(monster.getPosition());
    }
}
