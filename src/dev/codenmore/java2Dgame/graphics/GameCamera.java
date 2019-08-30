package dev.codenmore.java2Dgame.graphics;

import dev.codenmore.java2Dgame.Game;
import dev.codenmore.java2Dgame.entities.Entity;

public class GameCamera {

    //InstanceFields

    private float xOffset, yOffset;
    private Game game;

    //Constructors

    public GameCamera(float xOffset, float yOffset, Game game) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.game = game;
    }

    //Setters

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
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
    }

    public void centerOnEntity(Entity entity){
        xOffset = entity.getX() - game.getWidth() / 2 + entity.getWidth() / 2 ;
        yOffset = entity.getY() - game.getHeigth() / 2 + entity.getHeight() / 2;
    }
}
