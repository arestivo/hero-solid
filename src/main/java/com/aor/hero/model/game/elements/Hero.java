package com.aor.hero.model.game.elements;

public class Hero extends Element {
    private int energy;

    public Hero(int x, int y) {
        super(x, y);
        this.energy = 10;
    }

    public void decreaseEnergy() {
        this.energy--;
    }

    public int getEnergy() {
        return energy;
    }
}
