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
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, health, Creature.DEFAULT_SPEED, handler, name);
        collisionBounds.x = 40;
        collisionBounds.y = 64;
        collisionBounds.width = 32;
        collisionBounds.height = 52;

        //Minotaur animations
        animationIdle = new Animation(250, Assets.minotaurIdle);
        animationGotHit = new Animation(250,Assets.minotaurGotHit);
        animationDies = new Animation(250, Assets.minotaurDies);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    private BufferedImage getCurrentAnimationFrame(){
        return animationIdle.getCurrentAnimationFrame();
    }
}
