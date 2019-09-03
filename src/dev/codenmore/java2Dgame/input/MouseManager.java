package dev.codenmore.java2Dgame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    //InstanceFields

    private boolean leftMouseButtonPressed;
    private boolean rightMouseButtonPressed;
    private int mouseX, mouseY;

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
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
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
