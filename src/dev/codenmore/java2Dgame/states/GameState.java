package dev.codenmore.java2Dgame.states;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.levels.Level;

import java.awt.*;

public class GameState extends State{

    //For tests purposes

    private Level currentLevel;

    //Constructors
    public GameState(Handler handler){
        super(handler);
        currentLevel = new Level("resources/leveldata/level01.txt", handler);
        handler.setLevel(currentLevel);
        //player = new Player(currentLevel.getPlayerPositionX() * Creature.DEFAULT_CREATURE_WIDTH,
        //                    currentLevel.getPlayerPositionY() * Creature.DEFAULT_CREATURE_HEIGHT,
        //                    100, handler);
        //game.getGameCamera().move(0,0); //Test purposes
    }

    //Methods

    @Override
    public void tick() {
        currentLevel.tick();

        //game.getGameCamera().move(1,1); //Test purposes
    }

    @Override
    public void render(Graphics graphics) {
        currentLevel.render(graphics);
    }
}
