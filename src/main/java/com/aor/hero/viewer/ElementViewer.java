package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.elements.Element;

public interface ElementViewer<T extends Element> {
    void drawElement(T element, GUI gui);
}
