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

    public static Item goldCoin = new Item(Assets.goldCoin, "Gold Coin", 4) ;
    public static Item woodLogs = new Item(Assets.woodLogs, "Wood Logs", 5);

    public static final int ITEM_WIDTH = 64, ITEM_HEIGHT = 64;

    protected final int id;
    protected int x,y, count;
    protected boolean pickedUp = false;
    // count the amount of the object item represented by the given class;
    // one instance of an item, if we happen to have in the game inventory 3 such items we just change count value to 3
    // in the given instance;

    protected Handler handler;
    protected BufferedImage itemTexture;
    protected BufferedImage[] itemTextures;
    protected String name;

    protected Animation animationIdle;
    protected Rectangle collisionBouns;

    //Constructors
        // For animated items, 2 frames and more.
    public Item( BufferedImage[] itemTextures, String name, int id) {
        this.itemTextures = itemTextures;
        this.name = name;
        this.id =id;
        count = 1;

        collisionBouns = new Rectangle(x, y, ITEM_WIDTH, ITEM_HEIGHT);

        items[id] = this;
    }
        // For "1 frame" items.
    public Item( BufferedImage itemTexture, String name, int id) {
        this.itemTexture = itemTexture;
        this.name = name;
        this.id =id;
        count = 1;

        collisionBouns = new Rectangle(x, y, ITEM_WIDTH, ITEM_HEIGHT);

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
        if((this instanceof Item) && !(this instanceof AnimatedItem)) {return itemTexture;}
        if((this instanceof Item) && (this instanceof AnimatedItem)) {return itemTextures[0];}
        return null;
    }

    public String getName() {
        return name;
    }

    public boolean isPickedUp() {
        return pickedUp;
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

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }

    //Methods

    public void tick(){
        if (handler.getLevel().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(collisionBouns)) {
            pickedUp = true;
            //Adding item to the inventory.
            handler.getLevel().getEntityManager().getPlayer().getInventory().addItem(this);
        }
    }

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
        this.collisionBouns.x = x;
        this.collisionBouns.y = y;
    }

    // Item spawners, constructor wrapper
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

    //Below method is for testing purposes only
    public Item createNewOneFrameItem(int count){
        Item item = new Item(itemTexture, name, id);
        item.setPickedUp(true);
        item.setCount(count);
        return item;
    }

    //Below method is for testing purposes only
    public Item createNewItem(int count){
        Item item = new Item(itemTextures, name, id);
        item.setPickedUp(true);
        item.setCount(count);
        return item;
    }
}
