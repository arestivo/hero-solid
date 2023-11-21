package com.aor.hero.model.game.arena;

import com.aor.hero.model.Position;
import com.aor.hero.model.game.elements.Door;
import com.aor.hero.model.game.elements.Hero;
import com.aor.hero.model.game.elements.Key;
import com.aor.hero.model.game.elements.Monster;
import com.aor.hero.model.game.elements.Wall;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Hero hero;

    private List<Monster> monsters;
    private List<Wall> walls;
    private List<Key> keys;
    private List<Door> doors;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        // Default starting Arena
        this.walls = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.keys = new ArrayList<>();
        this.doors = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        for (Door door : doors)
            if (door.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isKey(Position position) {
        for (Key key : keys)
            if (key.getPosition().equals(position))
                return true;
        return false;
    }

    public void removeKey(Position position) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i).getPosition().equals(position)) {
                keys.remove(keys.get(i));
                return;
            }
        }
    }

    public boolean isDoor(Position position) {
        for (Door door : doors)
            if (door.getPosition().equals(position))
                return true;
        return false;
    }

}
