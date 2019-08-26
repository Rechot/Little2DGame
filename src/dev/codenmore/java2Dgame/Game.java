package dev.codenmore.java2Dgame;

import dev.codenmore.java2Dgame.graphics.Assets;
import dev.codenmore.java2Dgame.graphics.ImageLoader;
import dev.codenmore.java2Dgame.display.Display;
import dev.codenmore.java2Dgame.graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{
    // the "main" class of our game, it will hold all the base code of our game
    // start everything, run it and close the app

    // InstanceFields

    public int width, heigth;
    public String title;
    private boolean isGameRunning = false;

    private Display display;
    private Thread thread;

    private BufferStrategy bufferStrategy; // BufferStrategy tells graphic card how it should draw things ona a screen
    private Graphics graphics;

    //Temporal code
    private BufferedImage testImage;
    private SpriteSheet sheet;
    // Constructors
    // Game sets and stores via InstanceFileds int height, width and String title in order
    // to pass it to Display constructor in init() method
    public Game(String title, int width, int heigth){
       this.width = width;
       this.heigth = heigth;
       this.title = title;
    }

    // Methods

    // Prepare method of game, initializing graphics
    private void init(){
        display = new Display(title, width, heigth);
        Assets.initAssets();
    }
    // Update method of game
    private void tick(){

    }

    private void render(){
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return; // Why?
        }
        graphics = bufferStrategy.getDrawGraphics();    // our paintbrush, allow drawing things to the canvas
                                                        // drawing rectangles, circles, lines, whole images
        // Clear screen
        graphics.clearRect(0,0,width,heigth);
        // Draw here.

        graphics.drawImage(Assets.adventurer,0,0,null);
        graphics.drawImage(Assets.groundTile,0,32,null);
        graphics.drawImage(Assets.groundTile,32,32,null);
        graphics.drawImage(Assets.groundTile,64,32,null);
        graphics.drawImage(Assets.groundTile,96,32,null);
        graphics.drawImage(Assets.groundTile,128,32,null);

        // End drawing.
        bufferStrategy.show();
        graphics.dispose();
    }


    // Method of Runnable Interface
    // run method is where majority of our actual game will run
    @Override
    public void run() {
        init();
        while (isGameRunning) {
            tick();
            render();
        }
        stop();
    }

    // Starting and stopping thread method.
    // You use synchronized whenever you work with threads directly.
    // Thread constructor takes class you want to run as a parameter.
    public synchronized void start(){
        if(isGameRunning){return;} // Better save than sorry

        isGameRunning = true;
        thread = new Thread(this);
        thread.start(); // invoking run() method
    }

    public synchronized void stop()  {
        if(!isGameRunning){return;} // Better save than sorry

        isGameRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
