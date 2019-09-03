package dev.codenmore.java2Dgame.entities;

import dev.codenmore.java2Dgame.Game;
import dev.codenmore.java2Dgame.Handler;

import java.awt.*;
import java.security.PublicKey;
import java.util.Objects;

public abstract class Entity {

    //InstanceFields

    protected float x,y; //Why not int, because calculations in our game will not result in fixed numbers.
    protected int width, height;
    protected Rectangle collisionBounds;
    protected Handler handler;
    protected String name;

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

    //Constructors

    public Entity(float x, float y, int width, int height, Handler handler, String name){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.handler = handler;
      this.name = name;
      collisionBounds = new Rectangle(0,0,width,height);
    }

    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        Entity entity = (Entity) o;
        return //Float.compare(entity.getX(), getX()) == 0 &&       // auto generated line of code that made player not be able to move;
                // Float.compare(entity.getY(), getY()) == 0 &&     //
                getWidth() == entity.getWidth() &&
                getHeight() == entity.getHeight() &&
                collisionBounds.equals(entity.collisionBounds) &&
                handler.equals(entity.handler) &&
                name.equals(entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getWidth(), getHeight(), collisionBounds, handler, name);
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);

    public Rectangle getCollisionBounds(float xOffset, float yOffset){

        return new Rectangle((int) (x + collisionBounds.x + xOffset), (int) (y + collisionBounds.y + yOffset),
                collisionBounds.width, collisionBounds.height);

    }

    //Method test whether (this.) Entity collides with any other entity, that poses collision boundaries.
    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(Entity e : handler.getLevel().getEntityManager().getEntities()){
            if(e.equals(this))
                {continue;}
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffset)))
                {return true;}
        }
        return false;
    }
}
