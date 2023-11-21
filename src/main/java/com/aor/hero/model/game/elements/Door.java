package com.aor.hero.model.game.elements;

public class Door extends Element {

  private boolean isLocked = true;

  public Door(int x, int y) {
    super(x, y);
  }

  public boolean isLocked() {
    return isLocked;
  }

  public void setLocked(boolean locked) {
    isLocked = locked;
  }
}
