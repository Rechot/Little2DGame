package dev.codenmore.java2Dgame.states;

import dev.codenmore.java2Dgame.Game;

import java.awt.*;

public abstract class State {

    //InstanceFields
    protected Game game;

    //Constructors

    public State(Game game){
        this.game = game;
    }

    //In-game state manager
    private static State currentState = null;

    public static void setCurrentState(State state){
        currentState = state;
    }

    public static State getCurrentState(){
        return currentState;
    }

    //Methods
    public abstract void tick();
    public abstract void render(Graphics graphics);
}
