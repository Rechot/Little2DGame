package dev.codenmore.java2Dgame;

import dev.codenmore.java2Dgame.graphics.GameCamera;
import dev.codenmore.java2Dgame.input.KeyManager;
import dev.codenmore.java2Dgame.input.MouseManager;
import dev.codenmore.java2Dgame.levels.Level;
import dev.codenmore.java2Dgame.ui.UIManager;

public class Handler {

    //InstanceFields

    private Game game;
    private Level level;
    private UIManager uiManager;

    public Handler(Game game) {
        this.game = game;
    }

    //Getters

    public Game getGame() {
        return game;
    }

    public Level getLevel() {
        return level;
    }

    public int getGameWidth() {
        return game.getWidth();
    }

    public int getGameHeight() {
        return game.getHeight();
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager() { return game.getMouseManager();}

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public UIManager getUiManager() {
        return uiManager;
    }

    //Setters

    public void setGame(Game game) {
        this.game = game;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }

}

