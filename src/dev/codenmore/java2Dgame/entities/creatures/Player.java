package dev.codenmore.java2Dgame.entities.creatures;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.graphics.Animation;
import dev.codenmore.java2Dgame.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{

    //InstanceFields
    private Animation animationIdle;
    private Animation animationWalk;

    //Constructors

    public Player(float x, float y, int health, float speed, Handler handler, String name) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, health, speed, handler, name);
        collisionBounds.x = 40;
        collisionBounds.y = 64;
        collisionBounds.width = 32;
        collisionBounds.height = 52;
    }

    public Player(float x, float y, int health, Handler handler, String name) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, health, Creature.DEFAULT_SPEED, handler, name);
        collisionBounds.x = 40;
        collisionBounds.y = 64;
        collisionBounds.width = 32;
        collisionBounds.height = 52;

        animationIdle = new Animation(250, Assets.adventurerIdle);
        animationWalk = new Animation(250, Assets.adventurerWalk);
    }

    //Methods

    @Override // Updating any variables for our object.
    public void tick() {
        //Animation
        animationIdle.tick();
        animationWalk.tick();
        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        //Bellow is the code for test purposes only.
        //graphics.setColor(Color.red);
        //graphics.fillRect((int) (x + collisionBounds.x - handler.getGameCamera().getxOffset()),
        //        (int) (y + collisionBounds.y - handler.getGameCamera().getyOffset()),
        //       collisionBounds.width, collisionBounds.height);
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up){yMove = -speed;}
        if(handler.getKeyManager().down){yMove = speed;}
        if(handler.getKeyManager().left){xMove = -speed;}
        if(handler.getKeyManager().right){xMove = speed;}
    }

    private BufferedImage getCurrentAnimationFrame(){
         if(xMove >0 || xMove < 0 || yMove > 0 || yMove < 0){ return  animationWalk.getCurrentAnimationFrame(); }
         else { return animationIdle.getCurrentAnimationFrame(); }
    }
}
