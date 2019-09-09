package dev.codenmore.java2Dgame.items;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.graphics.Animation;
import dev.codenmore.java2Dgame.graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {

    //InstanceFields

    //Handler, just like Tile class
    // id's are important, because when we save our game we want to make sure we know where every item is and what's players current inventory;
    // item can be in 2 states: in the level ground or in the player's inventory.

    public static Item[] items = new Item[256];

    public static Item silverCoinItem = new Item(Assets.goldCoinItem, "Silver Coin Animated", 1) ;
    public static Item redCoinItem = new Item(Assets.goldCoinItem, "Silver Coin Animated", 2) ;
    public static Item goldCoin = new Item(Assets.goldCoin, "Gold Coin", 0) ;

    public static final int ITEM_WIDTH = 64, ITEM_HEIGHT = 64, PICKED_UP = -1;

    protected final int id;
    protected int x,y, count;
    // count the amount of the object item represented by the given class;
    // one instance of an item, if we happen to have in the game inventory 3 such items we just change count value to 3
    // in the given instance;
    // if the count = -1 = PICKED_UP , we will remove item from the level world and add it to our player's inventory;
    protected Handler handler;
    protected BufferedImage itemTexture;
    protected BufferedImage[] itemTextures;
    protected String name;

    protected Animation animationIdle;

    //Constructors
        // For animated items, 2 frames and more.
    public Item( BufferedImage[] itemTextures, String name, int id) {
        this.itemTextures = itemTextures;
        this.name = name;
        this.id =id;
        count = 1;

        items[id] = this;
    }
        // For "1 frame" items.
    public Item( BufferedImage itemTexture, String name, int id) {
        this.itemTexture = itemTexture;
        this.name = name;
        this.id =id;
        count = 1;

        items[id] = this;
    }

    //Getters

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCount() {
        return count;
    }

    public Handler getHandler() {
        return handler;
    }

    public BufferedImage getItemTexture() {
        return itemTexture;
    }

    public String getName() {
        return name;
    }

    //Setters

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setItemTexture(BufferedImage itemTexture) {
        this.itemTexture = itemTexture;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Methods

    public void tick(){}

    public void render(Graphics graphics){
        if(handler == null) {return;}
        render(graphics, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
    }

    public void render(Graphics graphics, int x, int y){
        graphics.drawImage( itemTexture, x, y, ITEM_WIDTH, ITEM_HEIGHT, null);
    }

    public void setItemPosition(int x, int y){
        this.x = x;
        this.y =y;
    }

    // Item spawner, constructor wrapper
    public Item createNewOneFrameItem(int x, int y){
        Item item = new Item(itemTexture, name, id);
        item.setItemPosition(x,y);
        return item;
    }

    public Item createNewItem(int x, int y){
        Item item = new Item(itemTextures, name, id);
        item.setItemPosition(x,y);
        return item;
    }
}
