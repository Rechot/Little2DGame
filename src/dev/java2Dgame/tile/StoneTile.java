package dev.java2Dgame.tile;

import dev.java2Dgame.graphics.Assets;

public class StoneTile extends Tile{

    public StoneTile(int id) {
        super(Assets.stoneTile, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
