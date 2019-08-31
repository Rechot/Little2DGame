package dev.codenmore.java2Dgame.entities;

import dev.codenmore.java2Dgame.Game;
import dev.codenmore.java2Dgame.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected float x,y; //Why not int, because calculations in our game will not result in fixed numbers.
    protected int width, height;

    //Getters

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    //Setters

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Entity(float x, float y, int width, int height, Handler handler){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);
}
