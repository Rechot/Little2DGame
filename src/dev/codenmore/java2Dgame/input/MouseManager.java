package dev.codenmore.java2Dgame.input;

import dev.codenmore.java2Dgame.ui.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    //InstanceFields

    private boolean leftMouseButtonPressed;
    private boolean rightMouseButtonPressed;
    private int mouseX, mouseY;

    private UIManager uiManager;

    //Getters

    public boolean isLeftMouseButtonPressed(){
        return leftMouseButtonPressed;
    }

    public  boolean isRightMouseButtonPressed(){
        return rightMouseButtonPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public UIManager getUiManager() {
        return uiManager;
    }

    //Setters

    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }


    //Methods

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {leftMouseButtonPressed = true;}
        else
        if(e.getButton() == MouseEvent.BUTTON3) {rightMouseButtonPressed = true;}
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {leftMouseButtonPressed = false;}
        else
        if(e.getButton() == MouseEvent.BUTTON3) {rightMouseButtonPressed = false;}
        if(uiManager != null) {uiManager.onMouseRelease(e);}
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        if(uiManager != null) {uiManager.onMouseMove(e);}
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }


}
