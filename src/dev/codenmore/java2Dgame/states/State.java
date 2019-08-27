package dev.codenmore.java2Dgame.states;

import java.awt.*;

public abstract class State {

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
