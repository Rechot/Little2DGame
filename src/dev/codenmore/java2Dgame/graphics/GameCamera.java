package dev.codenmore.java2Dgame.graphics;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.entities.Entity;
import dev.codenmore.java2Dgame.tile.Tile;

public class GameCamera {

    //InstanceFields

    private float xOffset, yOffset;
    private float maxXOffset, maxYOffset;
    private Handler handler;

    //Constructors

    public GameCamera(float xOffset, float yOffset, Handler handler) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.handler = handler;
        maxXOffset = handler.getLevel().getLevelWidth()* Tile.TILE_WIDTH - handler.getGameWidth();
        maxYOffset = handler.getLevel().getLevelHeight()* Tile.TILE_HEIGHT - handler.getGameHeight();
    }

    //Setters

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
        checkBlankSpace();
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
        checkBlankSpace();
    }

    //Getters

    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    //Methods

    public void move(float xAmt, float yAmt){
        this.xOffset += xAmt;
        this.yOffset += yAmt;
        checkBlankSpace();
    }

    public void checkBlankSpace(){

        if(xOffset < 0) { xOffset = 0; }
        else if (xOffset > maxXOffset)
           { xOffset = maxXOffset; }

        if(yOffset < 0) { yOffset = 0; }
        else if (yOffset > maxYOffset)
            { yOffset = maxYOffset; }
    }

    public void centerOnEntity(Entity entity){
        xOffset = entity.getX() - handler.getGameWidth() / 2 + entity.getWidth() / 2 ;
        yOffset = entity.getY() - handler.getGameHeight() / 2 + entity.getHeight() / 2;
        checkBlankSpace();
    }
}
