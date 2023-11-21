package com.aor.hero.viewer.game;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Door;

public class DoorViewer implements ElementViewer<Door> {

  @Override
  public void draw(Door door, GUI gui) {
    gui.drawDoor(door.getPosition(), door.isLocked());
  }
}
