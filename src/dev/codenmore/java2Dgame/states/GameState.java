package dev.codenmore.java2Dgame.states;

import dev.codenmore.java2Dgame.Game;
import dev.codenmore.java2Dgame.entities.creature.Player;
import dev.codenmore.java2Dgame.graphics.Assets;
import dev.codenmore.java2Dgame.levels.Level;
import dev.codenmore.java2Dgame.tile.Tile;

import java.awt.*;

public class GameState extends State{

    //For tests purposes
    private Player player;
    private Level level01;

    //Constructors
    public GameState(Game game){
        super(game);
        level01 = new Level("resources/leveldata/level01.txt");
        player = new Player(100,100,100, game);

    }

    //Methods

    @Override
    public void tick() {
        level01.tick();
        player.tick();
    }

    @Override
    public void render(Graphics graphics) {
        level01.render(graphics);
        player.render(graphics);
    }
}
