package dev.codenmore.java2Dgame.entities.creature;

import dev.codenmore.java2Dgame.Game;
import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.graphics.Assets;

import java.awt.*;

public class Player extends Creature{

    //Constructors

    public Player(float x, float y, int health, float speed, Handler handler) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, health, speed, handler);

    }

    public Player(float x, float y, int health, Handler handler) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, health, Creature.DEFAULT_SPEED, handler);
    }

    @Override // Updating any variables for our object.
    public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.adventurer, (int)(x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){yMove = -speed;}
        if(handler.getKeyManager().down){yMove = speed;}
        if(handler.getKeyManager().left){xMove = -speed;}
        if(handler.getKeyManager().right){xMove = speed;}
    }
}
