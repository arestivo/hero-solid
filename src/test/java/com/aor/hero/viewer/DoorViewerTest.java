package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Door;
import com.aor.hero.viewer.game.DoorViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DoorViewerTest {
  private Door door;
  private DoorViewer viewer;
  private GUI gui;

  @BeforeEach
  void setUp() {
    door = new Door(0, 0);
    viewer = new DoorViewer();
    gui = Mockito.mock(GUI.class);
  }

  @Test
  void drawElement() {
    viewer.draw(door, gui);
    Mockito.verify(gui, Mockito.times(1)).drawDoor(door.getPosition(), door.isLocked());
  }
}
