package com.aor.hero.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(10, 10);
    }

    @Test
    void getLeft() {
        assertEquals(9, position.getLeft().getX());
    }

    @Test
    void getRight() {
        assertEquals(11, position.getRight().getX());
    }

    @Test
    void getUp() {
        assertEquals(9, position.getUp().getY());
    }

    @Test
    void getDown() {
        assertEquals(11, position.getDown().getY());
    }
}