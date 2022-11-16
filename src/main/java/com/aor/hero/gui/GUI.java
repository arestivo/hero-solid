package com.aor.hero.gui;

import com.aor.hero.model.Position;

import java.io.IOException;
import java.util.List;

public interface GUI {
    List<ACTION> getNextActions() throws IOException;

    void drawHero(Position position);

    void drawWall(Position position);

    void drawMonster(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, QUIT, SELECT}
}
