package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Key;
import com.aor.hero.viewer.game.KeyViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class KeyViewerTest {
  private Key key;
  private KeyViewer viewer;
  private GUI gui;

  @BeforeEach
  void setUp() {
    key = new Key(8, 8);
    viewer = new KeyViewer();
    gui = Mockito.mock(GUI.class);
  }

  @Test
  void drawElement() {
    viewer.draw(key, gui);
    Mockito.verify(gui, Mockito.times(1)).drawKey(key.getPosition());
  }
}
