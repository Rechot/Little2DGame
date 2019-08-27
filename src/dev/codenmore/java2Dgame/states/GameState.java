package dev.codenmore.java2Dgame.states;

import dev.codenmore.java2Dgame.graphics.Assets;

import java.awt.*;

public class GameState extends State{

    //Constructors
    public GameState(){

    }

    //Methods

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.adventurer,0,0,null);
    }
}
