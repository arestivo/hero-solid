package com.aor.hero.model.arena;

import com.aor.hero.model.Position;
import com.aor.hero.model.elements.Hero;
import com.aor.hero.model.elements.Monster;
import com.aor.hero.model.elements.Wall;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Hero hero;

    private List<Monster> monsters;
    private List<Wall> walls;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }
}
