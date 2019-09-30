package dev.java2Dgame.tile;

import dev.java2Dgame.graphics.Assets;

public class DarkStoneTile extends Tile {
    public DarkStoneTile(int id) {
        super(Assets.darkStoneTile, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}

