package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.elements.Element;
import com.aor.hero.model.elements.Monster;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void drawElement(Monster monster, GUI gui) {
        gui.drawMonster(monster.getPosition());
    }
}
