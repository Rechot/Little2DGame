package dev.codenmore.java2Dgame.levels;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.tile.Tile;
import dev.codenmore.java2Dgame.utilities.Utilities;

import java.awt.*;

public class Level {

    //InstanceFields
    private int playerPositionX, playerPositionY; //in tiles e.g. position 0,0 means player get spawned on first tile at the top left of the level map;
    private int x,y; // for loop helpers;
    private int levelHeight, levelWidth; //in tiles e.g. 5 tiles(height) per 10 tiles(width) of a level map;
    private Handler handler;

    private int[][] tiles_ID;
    private String[] tokens;
    private Tile t;

    //Constructors

    public Level(String path, Handler handler){
        this.handler = handler;
        loadLevelFileAndParseItToStringArray(path);
        loadLevelSize(this.tokens);
        loadLevelPlayerPosition(this.tokens);
        loadLevelContentsByID(this.tokens);
    }

    //Getters

    public int getPlayerPositionX() {
        return playerPositionX;
    }

    public int getPlayerPositionY() {
        return playerPositionY;
    }

    public int getLevelWidth() {
        return levelWidth;
    }

    public int getLevelHeight() {
        return levelHeight;
    }

    //Methods

    public Tile getTile(int x, int y){
        //Safety measure to prevent glitch, when player would find a way to pass map boundaries.
        //That way games thinks he is still standing ona grassTile though he is not on the map anymore.
        if (x<0 || x>levelWidth || y<0 || y>levelHeight){ return Tile.groundTile;}

        Tile t = Tile.tiles[tiles_ID[x][y]];
        if(t == null){ return Tile.groundTile;}
        return t;
    }

    public void tick(){

    }

    public void render(Graphics graphics){

        // Method adjusted so the render() method will only render part of map user actually see
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
        //The first tile user see on the screen, on left side.
        int xEnd = (int) Math.min(levelWidth, (handler.getGameCamera().getxOffset()+ handler.getGameWidth()) / Tile.TILE_WIDTH + 1);
        //The last tile user see on the screen, on right side.
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
        //The first tile user see on the screen, on top side.
        int yEnd = (int) Math.min(levelHeight, (handler.getGameCamera().getyOffset()+ handler.getGameHeight()) / Tile.TILE_WIDTH + 1);
        //The last tile user see on the screen, on bottom side.

        for(y = yStart; y < yEnd; y++){
            for(x = xStart; x < xEnd; x++){
                getTile(x,y).render(graphics,(int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
    }

    private void loadLevelFileAndParseItToStringArray(String pathToFile){
        String file = Utilities.loadFileToString(pathToFile);
        System.out.println(file);
        this.tokens = file.split("\\s+");
        for(x=0; x<tokens.length; x++){
            System.out.print(tokens[x]);
        }
        System.out.print("\n");
    }

    private void loadLevelSize(String[] tokens){
       this.levelWidth = Utilities.parseInt(tokens[0]);
       this.levelHeight = Utilities.parseInt(tokens[1]);
        System.out.println("LevelWidth = " + levelWidth);
        System.out.println("LevelHeight = " + levelHeight);
    }

    private void loadLevelPlayerPosition(String[] tokens){
        this.playerPositionX = Utilities.parseInt(tokens[2]);
        this.playerPositionY = Utilities.parseInt(tokens[3]);
    }

    private void loadLevelContentsByID(String [] tokens){
        tiles_ID = new int[levelWidth][levelHeight]; // I forgot to initialize array, that is way i got java.lang.NullPointerException.
        for(y=0; y<levelHeight; y++){
            for (x=0; x<levelWidth; x++){
                tiles_ID[x][y] = Utilities.parseInt(tokens[(x + y * levelWidth)+4]); //This is pure magic. However it works.
                int tokenIndex = (x + y * levelWidth)+4;
                System.out.println("x, y, token " + x +" "+ y + " "+ tokenIndex + " " + tokens[tokenIndex]);
            }
        }
    }
}
