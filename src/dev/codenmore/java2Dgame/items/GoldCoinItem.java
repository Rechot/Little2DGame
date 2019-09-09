package dev.codenmore.java2Dgame.items;

import dev.codenmore.java2Dgame.graphics.Animation;
import dev.codenmore.java2Dgame.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GoldCoinItem extends Item {

    public static Item goldCoinItem = new GoldCoinItem(Assets.goldCoinItem, "Gold Coin Animated", 0) ;

    public GoldCoinItem(BufferedImage[] itemTextures, String name, int id) {
        super(itemTextures, name, id);
        animationIdle = new Animation(250, Assets.goldCoinItem);
    }

    @Override
    public void tick() {
        animationIdle.tick();
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(GetCurrentAnimationFrame(), x, y, ITEM_WIDTH, ITEM_HEIGHT, null);
    }

    private BufferedImage GetCurrentAnimationFrame(){
        System.out.println("Weszło!");
        return animationIdle.getCurrentAnimationFrame();
    }
}
