package dev.codenmore.java2Dgame.states;

import dev.codenmore.java2Dgame.Game;
import dev.codenmore.java2Dgame.Handler;

import java.awt.*;

public class MenuState extends State{

    public MenuState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        //For test purposes only
        System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
        if(handler.getMouseManager().isRightMouseButtonPressed()&& handler.getMouseManager().isLeftMouseButtonPressed())
            {State.setCurrentState(handler.getGame().gameState);}
    }

    @Override
    public void render(Graphics graphics) {
        //For test purposes only
        //Red square follows mouse wherever it points
        graphics.setColor(Color.red);
        graphics.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10,10);
    }
}
