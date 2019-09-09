package dev.codenmore.java2Dgame.items;

import dev.codenmore.java2Dgame.graphics.Animation;
import dev.codenmore.java2Dgame.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CoinItem extends Item {

    public static Item goldCoinItem = new CoinItem(Assets.goldCoinItem, "Gold Coin Animated", 0) ;
    public static Item silverCoinItem = new CoinItem(Assets.silverCoinItem, "Silver Coin Animated", 1) ;
    public static Item redCoinItem = new CoinItem(Assets.redCoinItem, "Silver Coin Animated", 2) ;

    public CoinItem(BufferedImage[] itemTextures, String name, int id) {
        super(itemTextures, name, id);
        animationIdle = new Animation(250, itemTextures);
    }

    @Override
    public void tick() {
        animationIdle.tick();
    }

    @Override
    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(GetCurrentAnimationFrame(), x, y, ITEM_WIDTH, ITEM_HEIGHT, null);
    }

    @Override
    public Item createNewItem(int x, int y) {
        CoinItem coinItem = new CoinItem(itemTextures, name, id);
        coinItem.setItemPosition(x,y);
        return coinItem;
    }

    private BufferedImage GetCurrentAnimationFrame(){
//        System.out.println("Weszło!");
        return animationIdle.getCurrentAnimationFrame();
    }
}
