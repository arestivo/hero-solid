package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.elements.Element;

public class WallViewer implements ElementViewer {
    @Override
    public void drawElement(Element wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
