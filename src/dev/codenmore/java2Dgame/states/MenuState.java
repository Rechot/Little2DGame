package dev.codenmore.java2Dgame.states;

import dev.codenmore.java2Dgame.Game;
import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.graphics.Assets;
import dev.codenmore.java2Dgame.ui.ClickListener;
import dev.codenmore.java2Dgame.ui.UIImageButton;
import dev.codenmore.java2Dgame.ui.UIManager;

import java.awt.*;

public class MenuState extends State{

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(handler.getGame().getWidth() / 2, handler.getGame().getHeight() / 2,
                275, 98,
                Assets.menuButtonStart,
                new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                // Without upper statement after switching to gameState app will still wait for any UI input,
                // which means all the buttons will be still there on the screen covered by a rendered level.
                // This setting and unsetting uiManager is kinda crud.
                State.setCurrentState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void tick() {
//        For test purposes only
//        System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
//        if(handler.getMouseManager().isRightMouseButtonPressed()&& handler.getMouseManager().isLeftMouseButtonPressed())
//            {State.setCurrentState(handler.getGame().gameState);}
        uiManager.tick();
    }

    @Override
    public void render(Graphics graphics) {
//        For test purposes only
//        Red square follows mouse wherever it points
//        graphics.setColor(Color.red);
//        graphics.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 10,10);
        uiManager.render(graphics);
    }
}
