package com.aor.hero.viewer.game;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Key;

public class KeyViewer implements ElementViewer<Key> {

  @Override
  public void draw(Key element, GUI gui) {
    gui.drawKey(element.getPosition());
  }
}
