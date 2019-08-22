package dev.codenmore.java2Dgame;

import dev.codenmore.java2Dgame.display.Display;

public class Game implements Runnable{
    // the "main" class of our game, it will hold all the base code of our game
    // start everything, run it and close the app

    // InstanceFields
    boolean isGameRunning = false;
    public int width, heigth;
    public String title;

    private Display display;
    private Thread thread;

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
    }
    // Update method of game
    private void tick(){

    }

    private void render(){

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
