package dev.codenmore.java2Dgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyManager implements KeyListener {

    public boolean up, down, left, right;
    private boolean[] keys;


    public KeyManager(){
        keys = new boolean[256];
    }

    public void tick(){
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override //Method called whenever user press key on keyboard.
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        //System.out.println("Key pressed");
    }

    @Override  //Method called whenever user stop pressing key on keyboard.
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        //System.out.println("Key released");
    }
}
