package dev.codenmore.java2Dgame.entities.creature;

import dev.codenmore.java2Dgame.entities.Entity;

import java.awt.*;

public abstract class Creature extends Entity {

    protected int health;

    public Creature(float x, float y, int health) {
        super(x, y);
        this.health = health;
    }

}
