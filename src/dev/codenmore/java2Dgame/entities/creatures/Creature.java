package dev.codenmore.java2Dgame.entities.creatures;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.entities.Entity;
import dev.codenmore.java2Dgame.tile.Tile;

public abstract class Creature extends Entity {

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 6.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 128,
                            DEFAULT_CREATURE_HEIGHT = 128; //My tile game will have squares of 128 x 128 pixels.

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
        moveX();
        moveY();
    }

    public void moveX(){
        int temporalX;

        //Moving right
        if(xMove > 0) {
            temporalX = (int) (x + xMove + collisionBounds.x + collisionBounds.width)/ Tile.TILE_WIDTH;
            if(!collisionWithTile(temporalX, (int) (y + collisionBounds.y) / Tile.TILE_HEIGHT) &&
                    !collisionWithTile(temporalX, (int) (y + collisionBounds.y + collisionBounds.height) / Tile.TILE_HEIGHT)){
                x += xMove;
            } else {
                //Collision with solid tile happens, bellow is a hack that makes your player be right next to solid surface.
                x = temporalX * Tile.TILE_WIDTH - collisionBounds.x - collisionBounds.width -1;
            }
        }
        //Moving left
        if(xMove < 0) {
            temporalX = (int) (x + xMove + collisionBounds.x )/ Tile.TILE_WIDTH;
            if(!collisionWithTile(temporalX, (int) (y + collisionBounds.y) / Tile.TILE_HEIGHT) &&
                    !collisionWithTile(temporalX, (int) (y + collisionBounds.y + collisionBounds.height) / Tile.TILE_HEIGHT)){
                x += xMove;
            } else {
                //Collision with solid tile happens, bellow is a hack that makes your player be right next to solid surface.
                x = temporalX * Tile.TILE_WIDTH  + Tile.TILE_WIDTH - collisionBounds.x;
            }
        }
    }

    public void moveY(){
        int temporalY;

        //Moving down
        if(yMove > 0) {
            temporalY = (int) (y + yMove + collisionBounds.y + collisionBounds.height)/ Tile.TILE_WIDTH;
            if(!collisionWithTile((int) (x + collisionBounds.x) / Tile.TILE_HEIGHT, temporalY ) &&
                    !collisionWithTile((int) (x + collisionBounds.x + collisionBounds.width) / Tile.TILE_HEIGHT, temporalY)){
                y += yMove;
            } else {
                //Collision with solid tile happens, bellow is a hack that makes your player be right next to solid surface.
                y = temporalY * Tile.TILE_HEIGHT - collisionBounds.y - collisionBounds.height -1;
            }
        }
        //Moving up
        if(yMove < 0) {
            temporalY = (int) (y + yMove + collisionBounds.y )/ Tile.TILE_WIDTH;
            if(!collisionWithTile((int) (x + collisionBounds.x) / Tile.TILE_HEIGHT, temporalY ) &&
                    !collisionWithTile((int) (x + collisionBounds.x + collisionBounds.width) / Tile.TILE_HEIGHT, temporalY)){
                y += yMove;
            } else {
                //Collision with solid tile happens, bellow is a hack that makes your player be right next to solid surface.
                y = temporalY * Tile.TILE_HEIGHT  + Tile.TILE_HEIGHT - collisionBounds.y;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y){
        return handler.getLevel().getTile(x,y).isSolid();
    }
}
