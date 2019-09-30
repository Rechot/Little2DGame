package dev.java2Dgame.entities.immobiles;

import dev.java2Dgame.Handler;
import dev.java2Dgame.entities.Entity;

public abstract class ImmobileEntity extends Entity {

    public ImmobileEntity(float x, float y, int width, int height, Handler handler, String name){
        super(x, y, width, height, handler, name);
    }

}
