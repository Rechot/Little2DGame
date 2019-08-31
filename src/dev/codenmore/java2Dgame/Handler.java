package dev.codenmore.java2Dgame;

import dev.codenmore.java2Dgame.graphics.GameCamera;
import dev.codenmore.java2Dgame.input.KeyManager;
import dev.codenmore.java2Dgame.levels.Level;

public class Handler {

    //InstanceFields

    private Game game;
    private Level level;

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

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    //Setters

    public void setGame(Game game) {
        this.game = game;
    }

    public void setLevel(Level level) {
        this.level = level;
    }


}

