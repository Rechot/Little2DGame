package dev.codenmore.java2Dgame.entities.creature;

import dev.codenmore.java2Dgame.entities.Entity;

import java.awt.*;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64; //My tile game will have squares of 64 x 64 pixels.

    protected int health;
    protected float speed;

    //Getters

    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

    //Setters

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    //Constructors

    public Creature(float x, float y, int width, int height, int health, float speed) {
        super(x, y, width, height);
        this.health = health;
        this.speed = speed;
    }

    public Creature(float x, float y, int width, int height) {
        super(x, y, width, height);
        this.health = DEFAULT_HEALTH;
        this.speed = DEFAULT_SPEED;
    }

}
