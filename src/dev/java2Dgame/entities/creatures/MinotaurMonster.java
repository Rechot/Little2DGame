package dev.java2Dgame.entities.creatures;

import dev.java2Dgame.Handler;
import dev.java2Dgame.graphics.Animation;
import dev.java2Dgame.graphics.Assets;
import dev.java2Dgame.items.AnimatedItem;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MinotaurMonster extends Creature{

    private boolean isDebugOn = false;
    private Animation animationIdle;
    private Animation animationGotHit;
    private Animation animationDies;

    public MinotaurMonster(float x, float y, int health, Handler handler, String name) {
        super(x, y, 192, 192, health, DEFAULT_SPEED, handler, name);
        collisionBounds.x = 70;
        collisionBounds.y = 64;
        collisionBounds.width = 45;
        collisionBounds.height = 52;

        //Minotaur animations
        animationIdle = new Animation(250, Assets.minotaurIdle);
        animationGotHit = new Animation(400,Assets.minotaurGotHit);
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
//        Bellow is the code for test purposes only.
//        isDebugOn =true;
        if(isDebugOn){
            graphics.setColor(Color.red);
            graphics.fillRect((int) (x + collisionBounds.x - handler.getGameCamera().getxOffset()),
                    (int) (y + collisionBounds.y - handler.getGameCamera().getyOffset()),
                    collisionBounds.width, collisionBounds.height);
        }
    }

    @Override
    public void die() {
        super.die();
//        handler.getLevel().getItemManager().addItem(Item.goldCoin.createNewOneFrameItem((int) (x + 32),(int) (y + 32)));
        handler.getLevel().getItemManager().addItem(AnimatedItem.silverCoinItem.createNewItem((int) (x+64), (int) (y+32)));
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(entityHurtAnimation){
          if(animationGotHit.getAnimationFramesLength() - 1 == animationGotHit.getIndex()) {
              this.setEntityHurtAnimation(false);
              return animationIdle.getCurrentAnimationFrame();
          }
          return animationGotHit.getCurrentAnimationFrame();
        }
//        else if (entityDeathAnimation){
//            this.setEntityDeathAnimation(false);
//            return animationDies.getCurrentAnimationFrame();}
        else
            return animationIdle.getCurrentAnimationFrame();
    }
}
