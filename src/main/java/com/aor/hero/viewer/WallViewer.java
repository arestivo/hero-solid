package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.elements.Element;
import com.aor.hero.model.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void drawElement(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
