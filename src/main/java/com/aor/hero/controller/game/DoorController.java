package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI.ACTION;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Door;
import java.io.IOException;

public class DoorController extends GameController{
  private long lastLockCheck;

  public DoorController(Arena arena) {
    super(arena);
    this.lastLockCheck = 0;
  }

  @Override
  public void step(Game game, ACTION action, long time) throws IOException {
    if (time - lastLockCheck > 500) {
      if (getModel().getKeys().isEmpty()) {
        for (Door door : getModel().getDoors()) {
          door.setLocked(false);
        }
      } else {
        // Allow for relocking doors
        for (Door door : getModel().getDoors()) {
          door.setLocked(true);
        }
      }
      this.lastLockCheck = time;
    }
  }
}
