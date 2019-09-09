package dev.codenmore.java2Dgame.states;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.levels.Level;
import dev.codenmore.java2Dgame.ui.UIManager;

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
            if ( handler.getMouseManager().isRightMouseButtonPressed()) {
                State.setCurrentState(handler.getGame().menuState);
        }
        //game.getGameCamera().move(1,1); //Test purposes
        // handler.getMouseManager().setUiManager(handler.getGame().menuState.getUiManager);
        // The above does not work, getUIManager is not visible, don't know why though ...
        // The private field uiManager and the getter for it is there in Menu State class ...
        // The below works.
        if (handler.getMouseManager().getUiManager() == null) { handler.getMouseManager().setUiManager(handler.getUiManager());}
    }

    @Override
    public void render(Graphics graphics) {
        currentLevel.render(graphics);
    }
}
