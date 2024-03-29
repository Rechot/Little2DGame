package dev.java2Dgame;

import dev.java2Dgame.display.Display;
import dev.java2Dgame.graphics.Assets;
import dev.java2Dgame.graphics.GameCamera;
import dev.java2Dgame.input.KeyManager;
import dev.java2Dgame.input.MouseManager;
import dev.java2Dgame.states.GameState;
import dev.java2Dgame.states.MenuState;
import dev.java2Dgame.states.SettingsState;
import dev.java2Dgame.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{
    // the "main" class of our game, it will hold all the base code of our game
    // start everything, run it and close the app

    // InstanceFields

    public String title;
    private int width, height, x;
    private boolean isGameRunning = false;
    private boolean isFrameRateDependencyOn = false;

    private Display display;
    private Thread thread;

    private BufferStrategy bufferStrategy; // BufferStrategy tells graphic card how it should draw things ona a screen
    private Graphics graphics;

    private int rate, ticks, framePerSecond;
    private static final int oneSecondInNanoseconds = 1000000000; // 1 billion nanoseconds equals 1 second;

    private long lastTime, now, timeSlice, timer;
    private double delta, fixedTimeSlicePerTickAndRender;

//    Temporal code
//    private BufferedImage testImage;
//    private SpriteSheet sheet;

    //States of "game", like Setting, Main Menu, actual game;
    public State gameState;
    public State menuState;
    public State settingsState;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;

    // Constructors

    // Game sets and stores via InstanceFields int height, width and String title in order
    // to pass it to Display constructor in init() method
    public Game(String title, int width, int height){
       this.width = width;
       this.height = height;
       this.title = title;
       keyManager = new KeyManager();
       mouseManager = new MouseManager();
       //isFrameRateDependencyOn = true;
    }

    //Getters

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getFramePerSecond() {
        return framePerSecond;
    }

    // Methods

    // Prepare method of game, initializing graphics
    private void init(){

        display = new Display(title, width, height);

        // Adding KeyListener to JFrame
        display.getJFrame().addKeyListener(keyManager);
        display.getCanvas().addKeyListener(keyManager);
        // Above statement must be added so whenever changing states e.g. from settingsState to gameState,
        // or from menuState to gameState KeyManager won't loose focus.

        // Adding MouseListener and MouseMotionListener to both JFrame and Canvas, that way it should work.
        display.getJFrame().addMouseListener(mouseManager);
        display.getJFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        Assets.initAssets();

        handler = new Handler(this);
        gameState = new GameState(handler);
        gameCamera = new GameCamera(0,0, handler);

        menuState = new MenuState(handler);
        settingsState = new SettingsState(handler);    //ToBeDone.

        State.setCurrentState(gameState);
    }

    // Update method of game

    private void tick() {
        keyManager.tick();
        if(isFrameRateDependencyOn){ x += 5; }

        if (State.getCurrentState() != null) { State.getCurrentState().tick();}
    }

    // Main rendering method

    private void render(){

        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(3);
            return; // Why?
        }
        graphics = bufferStrategy.getDrawGraphics();    // our paintbrush, allow drawing things to the canvas
                                                        // drawing rectangles, circles, lines, whole images
        // Clear screen
        graphics.clearRect(0,0,width, height);

        // Draw here.

        if(State.getCurrentState() != null) {State.getCurrentState().render(graphics);}
        if(isFrameRateDependencyOn){ graphics.drawImage(Assets.adventurer,400 + x,400,null); }//for tests only
        // End drawing.
        bufferStrategy.show();
        graphics.dispose();
    }


    // Method of Runnable Interface
    // run method is where majority of our actual game will run

    @Override
    public void run() {
        init();
        //Prepare variables for in-game loop mechanism.
        //Basically setting variables here for while loop to work properly.

        timer = 0;
        ticks = 0;
        lastTime = System.nanoTime();
        rate = 60;
        framePerSecond = rate; //fps
        fixedTimeSlicePerTickAndRender = oneSecondInNanoseconds / rate;

        while (isGameRunning) {
            if(isFrameRateDependencyOn){

                now = System.nanoTime();
                timeSlice = now - lastTime;
                tick();
                render();
                ticks++;
                timer += timeSlice;
                lastTime = now;

                if(timer >= oneSecondInNanoseconds) {
                    System.out.println("Ticks and frames: " + ticks);
                    System.out.println("Timer in nano seconds: " + timer);
                    ticks = 0;
                    timer = 0;
                }
            }

            if(!isFrameRateDependencyOn){
                now = System.nanoTime();
                timeSlice = now - lastTime;
                delta += timeSlice / fixedTimeSlicePerTickAndRender; // summing little differential fraction and checking whether delta >= 1 later on;
                timer += timeSlice; // summing little time periods and checking whether timer >= second later on, optional, for game statistics only;
                lastTime = now;

                if(delta >= 1){
                    tick();
                    render();
                    ticks++;
                    delta = 0; // or delta--;
                }

                if(timer >= oneSecondInNanoseconds){
                    System.out.println("Ticks and frames: " + ticks);
                    System.out.println("Timer in nano seconds: " + timer);
                    ticks = 0;
                    timer = 0;
                }
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
