package dev.codenmore.java2Dgame.graphics;

import java.awt.image.BufferedImage;

public class Assets {
    //An asset is any image, sound and piece of music in our game
    //InstanceFields
    //TestAssets
    //Entire class should be refactored.
    public static BufferedImage adventurer, groundTile, darkGroundTile, stoneTile, darkStoneTile, gothicWindow;

    //Actual Assets
    public static BufferedImage[] adventurerIdle;
    public static BufferedImage[] adventurerWalk;
    public static BufferedImage[] adventurerAtack01;
    public static BufferedImage[] adventurerJump;
    public static BufferedImage[] adventurerGotHit;
    public static BufferedImage[] adventurerKO;

    private static final int width = 32, height = 32;

    //Constructors

    //The class contains one method init(), it's gonna load everything for our game and it's gonna be called once.
    public static void initAssets(){
        SpriteSheet adventurerSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Adventurer Sprite Sheet v1.1.png"));
        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tileset.png"));

        //Initializing adventurer animation sprites

        adventurerIdle = new BufferedImage[13];
        adventurerWalk = new BufferedImage[8];
        adventurerAtack01 = new BufferedImage[10];
        adventurerJump = new BufferedImage[6];
        adventurerGotHit = new BufferedImage[4];
        adventurerKO = new BufferedImage[7];

        //Cropping everything from sprite sheet;

        adventurerIdle = adventurerSheet.cropInALoopFromSpriteSheet(0,0,width, height,13,adventurerSheet,adventurerIdle);
        adventurerWalk = adventurerSheet.cropInALoopFromSpriteSheet(0,32,width, height,8,adventurerSheet,adventurerWalk);
        adventurerAtack01 = adventurerSheet.cropInALoopFromSpriteSheet(0,64,width, height,10,adventurerSheet,adventurerAtack01);
        adventurerJump = adventurerSheet.cropInALoopFromSpriteSheet(0,96,width, height,6,adventurerSheet,adventurerJump);
        adventurerGotHit = adventurerSheet.cropInALoopFromSpriteSheet(0,128,width, height,4,adventurerSheet,adventurerGotHit);
        adventurerKO = adventurerSheet.cropInALoopFromSpriteSheet(0,160,width, height,7,adventurerSheet,adventurerKO);

        adventurer = adventurerSheet.crop(0,0,width,height);
        groundTile = tileSheet.crop(0,0,width,height);
        darkGroundTile = tileSheet.crop(0,8*height,width,height);
        stoneTile = tileSheet.crop(8*width,0,width,height);
        darkStoneTile = tileSheet.crop(233,264,30,height);
        gothicWindow = tileSheet.crop(8*width,8*height,width,height);
    }
}
