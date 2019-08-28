package dev.codenmore.java2Dgame.tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[256];
    public static Tile groundTile = new GroundTile(0);
    public static Tile darkGroundTile = new DarkGroundTile(1);
    public static Tile darkstoneTile = new StoneTile(2);
    public static Tile darkStoneTile = new DarkStoneTile(2);

    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

    protected final int id;
    protected BufferedImage texture;

    public int getId() {
        return id;
    }

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    public void tick(){}

    public void render(Graphics graphics, int x, int y){
        graphics.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean isSolid(){
        return false;
    }

}
