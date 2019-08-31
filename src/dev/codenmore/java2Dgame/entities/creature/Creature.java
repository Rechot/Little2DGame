package dev.codenmore.java2Dgame.entities.creature;

import dev.codenmore.java2Dgame.Game;
import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.entities.Entity;

import java.awt.*;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64; //My tile game will have squares of 64 x 64 pixels.

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    //Getters

    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    //Setters

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getyMove() {
        return yMove;

    }

    //Constructors

    public Creature(float x, float y, int width, int height, int health, float speed, Handler handler) {
        super(x, y, width, height, handler);
        this.health = health;
        this.speed = speed;
        xMove = 0;
        yMove = 0;
    }

    public Creature(float x, float y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        this.health = DEFAULT_HEALTH;
        this.speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    //Methods

    public void move(){
        x += xMove;
        y += yMove;
    }

}
