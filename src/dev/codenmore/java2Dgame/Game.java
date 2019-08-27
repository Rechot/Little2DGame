package dev.codenmore.java2Dgame;

import dev.codenmore.java2Dgame.graphics.Assets;
import dev.codenmore.java2Dgame.graphics.ImageLoader;
import dev.codenmore.java2Dgame.display.Display;
import dev.codenmore.java2Dgame.graphics.SpriteSheet;
import dev.codenmore.java2Dgame.states.GameState;
import dev.codenmore.java2Dgame.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{
    // the "main" class of our game, it will hold all the base code of our game
    // start everything, run it and close the app

    // InstanceFields

    public int width, heigth, x;
    public String title;
    private boolean isGameRunning = false;

    private Display display;
    private Thread thread;

    private BufferStrategy bufferStrategy; // BufferStrategy tells graphic card how it should draw things ona a screen
    private Graphics graphics;

    private int rate, ticks, framePerSecond;
<<<<<<< HEAD

    private static final int oneSecondInNanoseconds = 1000000000; // 1 million nanoseconds equals 1 second;

=======
    private static final int oneSecondInNanoseconds = 1000000000; // 1 million nanoseconds;
>>>>>>> ad48df3e4c2dc53dcffabec009164c2b0694b6c5
    private long lastTime, now, timeSlice, timer;
    private double delta, fixedTimeSlicePerTick;

    //Temporal code
    private BufferedImage testImage;
    private SpriteSheet sheet;

<<<<<<< HEAD

    //States of "game", like Setting, Main Menu, actual game;
    private State gameState;

=======
>>>>>>> ad48df3e4c2dc53dcffabec009164c2b0694b6c5
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

        gameState = new GameState();
        State.setCurrentState(gameState);
    }
    // Update method of game
    private void tick(){
        if(State.getCurrentState() != null) {State.getCurrentState().tick();}
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

        if(State.getCurrentState() != null) {State.getCurrentState().render(graphics);}

        // End drawing.
        bufferStrategy.show();
        graphics.dispose();
    }


    // Method of Runnable Interface
    // run method is where majority of our actual game will run
    @Override
    public void run() {
        init();
        //Prepare variables for in-game loop mechanism
        //Basically setting variables here for while loop to work properly
        timer = 0;
        ticks = 0;
        lastTime = System.nanoTime();
        rate = 60;
        framePerSecond = rate;
        fixedTimeSlicePerTick = oneSecondInNanoseconds / rate;

        while (isGameRunning) {

            now = System.nanoTime();
            timeSlice = now - lastTime;
            delta += timeSlice / fixedTimeSlicePerTick; // summing little differential fraction and checking whether delta >= 1 later on;
<<<<<<< HEAD
            timer += timeSlice; // summing little time periods and checking whether timer >= second later on, optional, for game statistics only;
=======
            timer += timeSlice; // summing little time periods and checking whether timer >= second later on;
>>>>>>> ad48df3e4c2dc53dcffabec009164c2b0694b6c5
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta = 0; // or delta--;
            }

            if(timer >= oneSecondInNanoseconds){
                System.out.println("Ticks and frames: " + ticks);
                ticks = 0;
                timer = 0;
            }

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
