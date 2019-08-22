package dev.codenmore.java2Dgame;

import dev.codenmore.java2Dgame.display.Display;

public class Launcher {

    public static void main(String[] args){
        Game game = new Game("Tytuł gry", 640, 480);
        game.start();
    }

}
