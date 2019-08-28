package dev.codenmore.java2Dgame.entities.creature;

import dev.codenmore.java2Dgame.Game;
import dev.codenmore.java2Dgame.graphics.Assets;

import java.awt.*;

public class Player extends Creature{

    private Game game;

    //Constructors

    public Player(float x, float y, int health, float speed, Game game) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, health, speed);
        this.game = game;
    }

    public Player(float x, float y, int health, Game game) {
        super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, health, Creature.DEFAULT_SPEED);
        this.game = game;
    }

    @Override // Updating any variables for our object.
    public void tick() {
        if(game.getKeyManager().up) {y -= 3;}
        if(game.getKeyManager().down) {y += 3;}
        if(game.getKeyManager().right) {x += 3;}
        if(game.getKeyManager().left) {x -= 3;}
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.adventurer, (int)x, (int)y, width, height, null);
    }
}
