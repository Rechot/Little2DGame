package dev.codenmore.java2Dgame.entities.immobiles;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.graphics.Assets;
import dev.codenmore.java2Dgame.tile.Tile;

import java.awt.*;

public class Tree extends ImmobileEntity{

    public Tree(float x, float y, Handler handler) {
        super(x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2, handler);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.simpleTree,(int) (x - handler.getGameCamera().getxOffset()),(
                int) (y -handler.getGameCamera().getyOffset()),width,height,null);
    }
}
