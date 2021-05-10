package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Monster;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {
        gui.drawMonster(monster.getPosition());
    }
}
