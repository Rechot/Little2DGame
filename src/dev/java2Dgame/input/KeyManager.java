package dev.java2Dgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    public boolean up, down, left, right;
    public boolean attackUp, attackDown, attackLeft, attackRight;
    private boolean[] keys, justPressed, cantPress;

    public KeyManager(){
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];
    }

    public void tick(){
        //Below is the very handy piece of code that solves many issues.
        for(int i=0; i < keys.length; i++){
            if(cantPress[i] && !keys[i]){ cantPress[i] = false;}
            else if(justPressed[i]) {
                cantPress[i] = true;
                justPressed[i] = false;
            }
            if(!cantPress[i] && keys[i]){ justPressed[i] = true;}
        }

        //Below is test code.
        if(keyJustPressed(KeyEvent.VK_E)){ System.out.println("Key E just has been pressed");}

        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];

        attackRight = keys[KeyEvent.VK_A];
        attackDown = keys[KeyEvent.VK_S];
        attackLeft = keys[KeyEvent.VK_D];
        attackUp = keys[KeyEvent.VK_W];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public boolean keyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= keys.length) {return false;}
        return justPressed[keyCode];
    }

    @Override //Method called whenever user press key on keyboard.
    public void keyPressed(KeyEvent e) {
        //Below is the code that makes keyboard input a little less error-prone
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {return;}
        keys[e.getKeyCode()] = true;
        //System.out.println("Key pressed");
    }

    @Override  //Method called whenever user stop pressing key on keyboard.
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        //System.out.println("Key released");
    }
}
