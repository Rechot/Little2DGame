package dev.codenmore.java2Dgame.inventory;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.items.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory {

    //InstanceFields
    private boolean active = false;
    private boolean isDebugOn = false;
    private Handler handler;
    private ArrayList<Item> inventoryItems;

    //Constructor

    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();
    }

    //Getters

    public boolean isActive() {
        return active;
    }

    public Handler getHandler() {
        return handler;
    }

    //Setters

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    //Methods
    //We will not tick and render inventory if the player doesn't want to see it.
    //We want to be able turn the inventory ON/OFF.

    public void tick(){
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
            active = !active;
        if(!active){ return; }
        isDebugOn = true;
        if(isDebugOn){
            System.out.println("Inventory: ");
            for(Item i : inventoryItems){
                System.out.println("Item :  \"" + i.getName() + "\"   " + i.getCount());
            }
        }
    }

    public void render(Graphics graphics){
        if(!active){ return; }
    }

        //Inventory methods

    public void addItem(Item item){
        for(Item i : inventoryItems){
            if(i.getId() == item.getId()){
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }


}
