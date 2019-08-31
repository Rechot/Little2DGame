package dev.codenmore.java2Dgame.tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //InstanceFields

    public static Tile[] tiles = new Tile[256];
    public static Tile groundTile = new GroundTile(0);
    public static Tile darkGroundTile = new DarkGroundTile(1);
    public static Tile stoneTile = new StoneTile(2);
    public static Tile darkStoneTile = new DarkStoneTile(3);

    public static final int TILE_WIDTH = 128, TILE_HEIGHT = 128;

    protected final int id;
    protected BufferedImage texture;

    //Geters

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
