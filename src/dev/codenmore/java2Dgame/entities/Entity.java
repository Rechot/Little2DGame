package dev.codenmore.java2Dgame.entities;

import java.awt.*;

public abstract class Entity {

    protected float x,y; //Why not int, because calculations in our game will not result in fixed numbers.

    public Entity(float x, float y){
      this.x = x;
      this.y = y;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);
}
