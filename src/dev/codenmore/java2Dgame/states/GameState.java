package dev.codenmore.java2Dgame.states;

import dev.codenmore.java2Dgame.Game;
import dev.codenmore.java2Dgame.entities.creature.Player;
import dev.codenmore.java2Dgame.graphics.Assets;
import dev.codenmore.java2Dgame.tile.Tile;

import java.awt.*;

public class GameState extends State{

    //For tests purposes
    private Player player;

    //Constructors
    public GameState(Game game){
        super(game);
        player = new Player(100,100,100, game);
    }

    //Methods

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics graphics) {
        player.render(graphics);
        Tile.tiles[0].render(graphics,0,64);
    }
}
