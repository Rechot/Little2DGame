package dev.codenmore.java2Dgame.tile;

import dev.codenmore.java2Dgame.graphics.Assets;

public class DarkStoneTile extends Tile {
    public DarkStoneTile(int id) {
        super(Assets.darkStoneTile, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}

