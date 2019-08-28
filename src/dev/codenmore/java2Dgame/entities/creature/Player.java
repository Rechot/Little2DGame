package dev.codenmore.java2Dgame.entities.creature;

import dev.codenmore.java2Dgame.graphics.Assets;

import java.awt.*;

public class Player extends Creature{

    public Player(float x, float y, int health) {
        super(x, y, health);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.adventurer, (int)x, (int)y, null);
    }
}
