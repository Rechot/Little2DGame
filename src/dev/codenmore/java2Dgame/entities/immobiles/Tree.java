package dev.codenmore.java2Dgame.entities.immobiles;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.graphics.Assets;
import dev.codenmore.java2Dgame.tile.Tile;

import java.awt.*;

public class Tree extends ImmobileEntity{

    private boolean isDebugOn = false;

    public Tree(float x, float y, Handler handler) {
        super(x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2, handler, "Tree");

        collisionBounds.x = (int) (0.75 * (width / 2f ));
        collisionBounds.y = (int) (0.3 *height);
        collisionBounds.width = (int) (0.25 * width);
        collisionBounds.height = (int) (0.48 * height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.simpleTree,(int) (x - handler.getGameCamera().getxOffset()),(
                int) (y -handler.getGameCamera().getyOffset()),width,height,null);
//        isDebugOn = true;
        if(isDebugOn){
            graphics.setColor(Color.red);
            graphics.fillRect((int) (x + collisionBounds.x - handler.getGameCamera().getxOffset()),
                    (int) (y + collisionBounds.y - handler.getGameCamera().getyOffset()),
                    collisionBounds.width, collisionBounds.height);
        }

    }
}
