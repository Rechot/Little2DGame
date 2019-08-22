package dev.codenmore.java2Dgame;

import dev.codenmore.java2Dgame.display.Display;

public class Game implements Runnable{
    // the "main" class of our game, it will hold all the base code of our game
    // start everything, run it and close the app

    // InstanceFields
    //public int width, heigth;
    //public String title;
    private Display display;
    private Thread thread;

    // Constructors
    public Game(String title, int width, int heigth){
       // this.width = width;
       // this.heigth = heigth;
        display = new Display(title, width, heigth);
    }

    // Methods

    // Method of Runnable Interface
    // run method is where majority of our actual game will run
    @Override
    public void run() {

    }

    // Starting and stopping thread method.
    // You use synchronized whenever you work with threads directly.
    // Thread constructor takes class you want to run as a parameter.
    public synchronized void start(){
        thread = new Thread(this);
        thread.start(); // invoking run() method
    }

    public synchronized void stop()  {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
