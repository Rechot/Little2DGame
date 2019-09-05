package dev.codenmore.java2Dgame.entities;

import dev.codenmore.java2Dgame.Handler;

import java.awt.*;
import java.util.Objects;

public abstract class Entity {

    //InstanceFields

    public static final int DEFAULT_HEALTH = 3;

    protected float x,y; //Why not int, because calculations in our game will not result in fixed numbers.
    protected int width, height;
    protected Rectangle collisionBounds;
    protected Handler handler;
    protected String name;
    protected boolean entityIsActive = true;
    protected boolean entityHasAnimation = true;
    protected boolean entityHurtAnimation = false;
    protected boolean entityDeathAnimation = false;
    protected boolean entityCanBeHurt = true;
    protected int healthPoints;
    protected int currentHealthPoints;


    //Constructors

    public Entity(float x, float y, int width, int height, Handler handler, String name){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.handler = handler;
      this.name = name;
      this.healthPoints = DEFAULT_HEALTH;

      collisionBounds = new Rectangle(0,0,width,height);
    }

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

    public int getHealth() {
        return healthPoints;
    }

    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public boolean isEntityIsActive() {
        return entityIsActive;
    }

    public boolean isEntityHasAnimation() {
        return entityHasAnimation;
    }

    public boolean isEntityHurtAnimation() {
        return entityHurtAnimation;
    }

    public boolean isEntityDeathAnimation() {
        return entityDeathAnimation;
    }

    public boolean isEntityCanBeHurt() {
        return entityCanBeHurt;
    }

    public String getName() {
        return name;
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

    public void setHealth(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setCurrentHealthPoints(int currentHealthPoints) {
        this.currentHealthPoints = currentHealthPoints;
    }

    public void setEntityIsActive(boolean entityIsActive) {
        this.entityIsActive = entityIsActive;
    }

    public void setEntityHasAnimation(boolean entityHasAnimation) {
        this.entityHasAnimation = entityHasAnimation;
    }

    public void setEntityHurtAnimation(boolean entityHurtAnimation) {
        this.entityHurtAnimation = entityHurtAnimation;
    }

    public void setEntityDeathAnimation(boolean entityDeathAnimation) {
        this.entityDeathAnimation = entityDeathAnimation;
    }

    public void setEntityCanBeHurt(boolean entityCanBeHurt) {
        this.entityCanBeHurt = entityCanBeHurt;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity)) return false;
        Entity entity = (Entity) o;
        return //Float.compare(entity.getX(), getX()) == 0 &&       // auto generated line of code that made player not able to move;
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

    public void hurt(int healthPointsAmount){
        currentHealthPoints = healthPoints;
        if (!entityCanBeHurt) { return; }
        currentHealthPoints -= healthPointsAmount;
        if(currentHealthPoints <= 0 ) {
            entityIsActive = false;
            die();
        } else {
            entityHurtAnimation = true;
        }
        healthPoints = currentHealthPoints;
    }

    public void die(){
        entityDeathAnimation = true;
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
