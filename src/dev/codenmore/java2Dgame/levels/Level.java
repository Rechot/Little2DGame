package dev.codenmore.java2Dgame.levels;

import dev.codenmore.java2Dgame.Game;
import dev.codenmore.java2Dgame.tile.Tile;
import dev.codenmore.java2Dgame.utilities.Utilities;

import java.awt.*;

public class Level {

    //InstanceFields
    private int playerPositionX, getPlayerPositionY; //in tiles e.g. position 0,0 means player get spawned on first tile at the top left of the level map;
    private int x,y; // for loop helpers;
    private int levelHeight, levelWidth; //in tiles e.g. 5 tiles(height) per 10 tiles(width) of a level map;
    private Game game;

    private int[][] tiles_ID;
    private String[] tokens;
    private Tile t;

    //Constructors

    public Level(String path, Game game){
        this.game = game;
        loadLevelFileAndParseItToStringArray(path);
        loadLevelSize(this.tokens);
        loadLevelPlayerPosition(this.tokens);
        loadLevelContentsByID(this.tokens);
    }

    //Methods

    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles_ID[x][y]];
        if(t == null){ return Tile.groundTile;}
        return t;
    }

    public void tick(){

    }

    public void render(Graphics graphics){
        for(y=0; y < levelHeight; y++){
            for(x=0; x < levelWidth; x++){
                getTile(x,y).render(graphics,(int) (x * Tile.TILE_WIDTH - game.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILE_HEIGHT - game.getGameCamera().getyOffset()));
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
        this.getPlayerPositionY = Utilities.parseInt(tokens[3]);
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
