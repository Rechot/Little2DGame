package dev.java2Dgame.ui;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject {

    //InstanceFields

    protected float x, y;
    protected int width, height;
    protected boolean hovering = false;

    protected Rectangle bounds;

    //Constructors

    public UIObject(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle((int) x, (int) y, width, height);
    }

    //Getters

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isHovering() {
        return hovering;
    }

    //Setters

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }

    //Methods

    public abstract void tick();
    public abstract void render(Graphics graphics);
    public abstract void onClick();


    public void onMouseMove(MouseEvent e){
        if(bounds.contains(e.getX(),e.getY()))
            {hovering = true;}
        else
            {hovering = false;}
    }

    public void onMouseRelease(MouseEvent e){
        if(hovering && (e.getButton()!= MouseEvent.BUTTON3)){onClick();} //Hack-fix;
    }
}
