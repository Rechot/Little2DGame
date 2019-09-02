package dev.codenmore.java2Dgame.states;

import dev.codenmore.java2Dgame.Game;
import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.entities.creature.Creature;
import dev.codenmore.java2Dgame.entities.creature.Player;
import dev.codenmore.java2Dgame.graphics.Assets;
import dev.codenmore.java2Dgame.levels.Level;
import dev.codenmore.java2Dgame.tile.Tile;

import java.awt.*;

public class GameState extends State{

    //For tests purposes
    private Player player;
    private Level currentLevel;

    //Constructors
    public GameState(Handler handler){
        super(handler);
        currentLevel = new Level("resources/leveldata/level01.txt", handler);
        handler.setLevel(currentLevel);
        player = new Player(currentLevel.getPlayerPositionX() * Creature.DEFAULT_CREATURE_WIDTH,
                            currentLevel.getPlayerPositionY() * Creature.DEFAULT_CREATURE_HEIGHT,
                            100, handler);
        //game.getGameCamera().move(0,0); //Test purposes
    }

    //Methods

    @Override
    public void tick() {
        currentLevel.tick();
        player.tick();
        //game.getGameCamera().move(1,1); //Test purposes
    }

    @Override
    public void render(Graphics graphics) {
        currentLevel.render(graphics);
        player.render(graphics);
    }
}
