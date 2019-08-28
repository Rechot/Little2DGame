package dev.codenmore.java2Dgame.states;

import dev.codenmore.java2Dgame.entities.creature.Player;
import dev.codenmore.java2Dgame.graphics.Assets;

import java.awt.*;

public class GameState extends State{

    //For tests purposes
    private Player player;

    //Constructors
    public GameState(){
        player = new Player(100,100, 100);
    }

    //Methods

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics graphics) {
        player.render(graphics);
    }
}
