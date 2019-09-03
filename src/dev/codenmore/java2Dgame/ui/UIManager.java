package dev.codenmore.java2Dgame.ui;

import dev.codenmore.java2Dgame.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {

    //InstanceFields

    private Handler handler;
    private ArrayList<UIObject> objects;

    //Constructors

    public UIManager(Handler handler) {
        this.handler = handler;
        objects = new ArrayList<UIObject>();
    }

    //Getters

    public Handler getHandler() {
        return handler;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    //Setters

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }

    //Methods

    public void tick(){
        for(UIObject o : objects)
            o.tick();
    }

    public void render(Graphics graphics){
        for(UIObject o : objects)
            o.render(graphics);
    }

    public void onMouseMove(MouseEvent e){
        for(UIObject o : objects)
            o.onMouseMove(e);
    }

    public void onMouseRelease(MouseEvent e){
        for(UIObject o : objects)
            o.onMouseRelease(e);
    }

    public void addObject(UIObject uiObject){
        objects.add(uiObject);
    }

    public void removeObject(UIObject uiObject){
        objects.remove(uiObject);
    }

}
