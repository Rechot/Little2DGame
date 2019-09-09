package dev.codenmore.java2Dgame.items;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.graphics.ImageLoader;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

//Item manager will store items that are currently in the game lying on the ground.

public class ItemManager {

    //InstanceFields

    private Handler handler;
    private ArrayList<Item> items;

    //Constructor

    public ItemManager(Handler handler){
        this.handler = handler;
        items = new ArrayList<Item>();
    }

    //Getters

    public Handler getHandler() {
        return handler;
    }

    //Methods

    public void tick(){
        Iterator<Item> iterator = items.iterator();
        while(iterator.hasNext()){
            Item item = iterator.next();
            item.tick();
            if(item.isPickedUp()){ iterator.remove();}
        }
    }

    public void render(Graphics graphics){
        for(Item item : items){
            item.render(graphics);
        }
    }

    public  void
    addItem(Item item){
        item.setHandler(handler);
        items.add(item);
    }
}
