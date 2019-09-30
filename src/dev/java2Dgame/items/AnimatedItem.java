package dev.java2Dgame.items;

import dev.java2Dgame.graphics.Animation;
import dev.java2Dgame.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimatedItem extends Item {

    public static Item goldCoinItem = new AnimatedItem(Assets.goldCoinItem, "Gold Coin", 0) ;
    public static Item silverCoinItem = new AnimatedItem(Assets.silverCoinItem, "Silver Coin", 1) ;
    public static Item redCoinItem = new AnimatedItem(Assets.redCoinItem, "Red Coin", 2) ;

    public AnimatedItem(BufferedImage[] itemTextures, String name, int id) {
        super(itemTextures, name, id);
        animationIdle = new Animation(250, itemTextures);
    }

    @Override
    public void tick() {
        super.tick();
        animationIdle.tick();
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(GetCurrentAnimationFrame(), x, y, ITEM_WIDTH, ITEM_HEIGHT, null);
    }

    @Override
    public Item createNewItem(int x, int y) {
        AnimatedItem animatedItem = new AnimatedItem(itemTextures, name, id);
        animatedItem.setItemPosition(x,y);
        return animatedItem;
    }

    private BufferedImage GetCurrentAnimationFrame(){
//        System.out.println("Weszło!");
        return animationIdle.getCurrentAnimationFrame();
    }
}
