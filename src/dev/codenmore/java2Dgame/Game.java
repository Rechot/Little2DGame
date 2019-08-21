package dev.codenmore.java2Dgame;

import dev.codenmore.java2Dgame.display.Display;

public class Game {
    // the "main" class of our game, it will hold all the base code of our game
    // start everything, run it and close the app

    // InstanceFields
    //public int width, heigth;
    //public String title;
    private Display display;

    //Constructors
    public Game(String title, int width, int heigth){
       // this.width = width;
       // this.heigth = heigth;
        display = new Display(title, width, heigth);
    }
}
