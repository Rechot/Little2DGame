package dev.java2Dgame.states;

import dev.java2Dgame.Handler;

import java.awt.*;

public abstract class State {

    //InstanceFields
    protected Handler handler;

    //Constructors

    public State(Handler handler){
        this.handler = handler;
    }

    //In-game state manager, static getter and setter
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
