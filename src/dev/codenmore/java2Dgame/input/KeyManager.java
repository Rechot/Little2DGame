package dev.codenmore.java2Dgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    public boolean up, down, left, right;
    private boolean[] keys;

    public boolean attackUp, attackDown, attackLeft, atackRight;

    public KeyManager(){
        keys = new boolean[256];
    }

    public void tick(){
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];

        atackRight = keys[KeyEvent.VK_A];
        attackDown = keys[KeyEvent.VK_S];
        attackLeft = keys[KeyEvent.VK_D];
        attackUp = keys[KeyEvent.VK_W];
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
