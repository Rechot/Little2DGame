package dev.codenmore.java2Dgame.levels;

import dev.codenmore.java2Dgame.Handler;
import dev.codenmore.java2Dgame.entities.EntityManager;
import dev.codenmore.java2Dgame.entities.creatures.Creature;
import dev.codenmore.java2Dgame.entities.creatures.MinotaurMonster;
import dev.codenmore.java2Dgame.entities.creatures.Player;
import dev.codenmore.java2Dgame.entities.immobiles.Tree;
import dev.codenmore.java2Dgame.items.ItemManager;
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

    private EntityManager entityManager;
    private ItemManager itemManager;

    //Constructors

    public Level(String path, Handler handler){
        this.handler = handler;

        loadLevelFileAndParseItToStringArray(path);
        loadLevelSize(this.tokens);
        loadLevelPlayerPosition(this.tokens);

        entityManager = new EntityManager(handler,
                new Player(this.playerPositionX * Creature.DEFAULT_CREATURE_WIDTH,
                this.playerPositionY * Creature.DEFAULT_CREATURE_HEIGHT, 100, handler,"ED"));
        itemManager = new ItemManager(handler);

        entityManager.addEntity(new Tree(Tile.TILE_WIDTH * 7, Tile.TILE_HEIGHT * 2, handler));
        entityManager.addEntity(new Tree(Tile.TILE_WIDTH * 9, Tile.TILE_HEIGHT * 4, handler));
        entityManager.addEntity(new Tree(Tile.TILE_WIDTH * 1, Tile.TILE_HEIGHT * 5, handler));
        entityManager.addEntity(new MinotaurMonster(Tile.TILE_WIDTH * 7,Tile.TILE_HEIGHT * 5, 4, handler,"Minotaur1"));
        entityManager.addEntity(new MinotaurMonster(Tile.TILE_WIDTH * 9,Tile.TILE_HEIGHT * 6, 4, handler,"Minotaur2"));

        loadLevelContentsByID(this.tokens);

        entityManager.getPlayer().setX(this.playerPositionX * Creature.DEFAULT_CREATURE_WIDTH);
        entityManager.getPlayer().setY(this.playerPositionY * Creature.DEFAULT_CREATURE_HEIGHT);
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

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Handler getHandler() {
        return handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    //Setters

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
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
        itemManager.tick();
        entityManager.tick();
    }

    public void render(Graphics graphics){

        //Rendering tiles.

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

        //After rendering tiles we render items
        itemManager.render(graphics);

        //After rendering items we render entities.
        entityManager.render(graphics);

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
        //System.out.println("LevelWidth = " + levelWidth);
        //System.out.println("LevelHeight = " + levelHeight);
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
//                System.out.println("x, y, token " + x +" "+ y + " "+ tokenIndex + " " + tokens[tokenIndex]);
            }
        }
    }
}
