package dev.codenmore.java2Dgame.entities.creatures;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.graphics.Animation;
import dev.codenmore.java2Dgame.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MinotaurMonster extends Creature{

    private Animation animationIdle;
    private Animation animationGotHit;
    private Animation animationDies;

    public MinotaurMonster(float x, float y, int health, Handler handler, String name) {
        super(x, y, 192, 192, health, Creature.DEFAULT_SPEED, handler, name);
        collisionBounds.x = 70;
        collisionBounds.y = 64;
        collisionBounds.width = 45;
        collisionBounds.height = 52;

        //Minotaur animations
        animationIdle = new Animation(250, Assets.minotaurIdle);
        animationGotHit = new Animation(250,Assets.minotaurGotHit);
        animationDies = new Animation(250, Assets.minotaurDies);
    }

    @Override
    public void tick() {
        //Animation
        animationIdle.tick();
        animationGotHit.tick();
        animationDies.tick();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        //Bellow is the code for test purposes only.
        graphics.setColor(Color.red);
        graphics.fillRect((int) (x + collisionBounds.x - handler.getGameCamera().getxOffset()),
                (int) (y + collisionBounds.y - handler.getGameCamera().getyOffset()),
                collisionBounds.width, collisionBounds.height);
    }

    private BufferedImage getCurrentAnimationFrame(){
//        if(healthPoints <= 0) { return animationGotHit.getCurrentAnimationFrame(); }
//        else if ()
            return animationIdle.getCurrentAnimationFrame();
    }
}
