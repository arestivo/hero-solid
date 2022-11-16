package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;

import java.util.List;

public class HeroController extends GameController {
    public HeroController(Arena arena) {
        super(arena);
    }

    public void moveHeroLeft() {
        moveHero(getModel().getHero().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(getModel().getHero().getPosition().getRight());
    }

    public void moveHeroUp() {
        moveHero(getModel().getHero().getPosition().getUp());
    }

    public void moveHeroDown() {
        moveHero(getModel().getHero().getPosition().getDown());
    }

    private void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getHero().setPosition(position);
            if (getModel().isMonster(position)) getModel().getHero().decreaseEnergy();
        }
    }

    @Override
    public void step(Game game, List<GUI.ACTION> actions, long time) {
        if (actions.contains(GUI.ACTION.UP)) moveHeroUp();
        if (actions.contains(GUI.ACTION.RIGHT)) moveHeroRight();
        if (actions.contains(GUI.ACTION.DOWN)) moveHeroDown();
        if (actions.contains(GUI.ACTION.LEFT)) moveHeroLeft();
    }
}
