package com.aor.hero.viewer.game;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Door;
import com.aor.hero.model.game.elements.Key;

public class DoorViewer implements ElementViewer<Door> {

  @Override
  public void draw(Door element, GUI gui) {
    gui.drawDoor(element.getPosition());
  }
}
