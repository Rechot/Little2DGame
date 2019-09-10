package dev.codenmore.java2Dgame.inventory;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.graphics.Assets;
import dev.codenmore.java2Dgame.graphics.Text;
import dev.codenmore.java2Dgame.items.CoinItem;
import dev.codenmore.java2Dgame.items.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory {

    //InstanceFields
    private boolean active = false;
    private boolean isDebugOn = false;

    private  int inventoryX, inventoryY, inventoryHeight, inventoryWidth;
    //Inventory hardcoded center of ist Menu.
    private  int inventoryListCenterX, inventoryListCenterY;
    //private int inventoryListCenterX = inventoryX + 171, inventoryListCenterY = inventoryY + (inventoryHeight / 2) + 5;
    //fields are initialized first, than those fields can be replaced/initialized in constructor;
    private int inventoryListSpacing = 30; // pixels

    private int inventoryItemImageX = 452, inventoryItemImageY = 82,
                inventoryItemImageWidth = 64, inventoryItemImageHeight = 64;

    private int inventoryCountNumberX = 484, getInventoryCountNumberY = 172;

    private int selectedItem = 0; //index of the inventoryItems Array

    private Handler handler;
    private ArrayList<Item> inventoryItems;

    //Constructor

    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();

        //Testing purposes only
        addItem(Item.woodLogs.createNewOneFrameItem(3));
        addItem(CoinItem.redCoinItem.createNewItem(5));
        addItem(Item.woodLogs.createNewOneFrameItem(3));
        addItem(CoinItem.redCoinItem.createNewItem(5));
        addItem(Item.woodLogs.createNewOneFrameItem(3));
        addItem(CoinItem.redCoinItem.createNewItem(5));
        addItem(Item.woodLogs.createNewOneFrameItem(3));
        addItem(CoinItem.redCoinItem.createNewItem(5));
        addItem(Item.woodLogs.createNewOneFrameItem(3));
        addItem(CoinItem.redCoinItem.createNewItem(5));

        this.inventoryWidth = 512;
        this.inventoryHeight = 384;
        this.inventoryX = 64;
        this.inventoryY = 48;
        this.inventoryListCenterX = inventoryX + 171;
        this.inventoryListCenterY = inventoryY + (inventoryHeight / 2) + 5;
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
//        isDebugOn = true;
        if(isDebugOn){
            System.out.println("Inventory: ");
            for(Item i : inventoryItems){
                System.out.println("Item :  \"" + i.getName() + "\"   " + i.getCount());
            }
        }
        //Below codes makes you navigate inventory items list by keyboard.
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_NUMPAD8)){selectedItem--;}
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_NUMPAD2)){selectedItem++;}

        if(selectedItem < 0){selectedItem = inventoryItems.size() - 1;}
        else if(selectedItem >= inventoryItems.size()){selectedItem = 0;}
    }

    public void render(Graphics graphics){
        if(!active){ return; }
        graphics.drawImage(Assets.inventoryScreen, inventoryX, inventoryY, inventoryWidth, inventoryHeight, null);
//        Text.drawString(graphics, "> Coin item <", inventoryListCenterX, inventoryListCenterY, true, Color.WHITE, Assets.font28);

        int length = inventoryItems.size();
        if(length == 0){return;}

        for(int i = -5; i< 6; i++){
            if(selectedItem + i < 0 || selectedItem + i >= length){continue;}
            if(i == 0){
                Text.drawString(graphics, "> " + inventoryItems.get(selectedItem + i).getName() + " <", inventoryListCenterX,
                    inventoryListCenterY + i * inventoryListSpacing, true, Color.YELLOW, Assets.font28 );
            }else {
                Text.drawString(graphics, inventoryItems.get(selectedItem + i).getName(), inventoryListCenterX,
                        inventoryListCenterY + i * inventoryListSpacing, true, Color.WHITE, Assets.font28);
            }

            Item item = inventoryItems.get(selectedItem);
            graphics.drawImage(item.getItemTexture(),inventoryItemImageX, inventoryItemImageY, inventoryItemImageWidth, inventoryItemImageHeight, null);
            Text.drawString(graphics, Integer.toString(item.getCount()), inventoryCountNumberX, getInventoryCountNumberY, true, Color.WHITE, Assets.font28);
        }
    }

        //Inventory methods

    public void addItem(Item item){
//        for(Item i : inventoryItems){
//            if(i.getId() == item.getId()){
//                i.setCount(i.getCount() + item.getCount());
//                return;
//            }e
//        }
       inventoryItems.add(item);
    }


}
