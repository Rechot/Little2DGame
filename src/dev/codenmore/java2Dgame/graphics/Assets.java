package dev.codenmore.java2Dgame.graphics;

import java.awt.image.BufferedImage;

public class Assets {
    //An asset is any image, sound and piece of music in our game
    //InstanceFields
    //TestAssets
    //Entire class should probably be refactored.

    // One frame assets.
    public static BufferedImage adventurer, groundTile, darkGroundTile, stoneTile, darkStoneTile, gothicWindow,
                                simpleTree, woodLogs, goldCoin, silverCoin, redCoin;

    // many frames = animation assets.
    public static BufferedImage[] adventurerIdle, adventurerWalk, adventurerMeleeAttack, adventurerJump, adventurerGotHit, adventurerKO;
    public static BufferedImage[] minotaurIdle,  minotaurWalk,  minotaurSlowWalk,  minotaurAxeSlash,  minotaurAxeThrust,  minotaurGuarding,
                                    minotaurRotarySlash,  minotaurLowHealth,  minotaurGotHit,  minotaurDies;
    public static BufferedImage[] goldCoinItem, silverCoinItem, redCoinItem;
    public static BufferedImage[] menuButtonStart;

    private static final int width = 32, height = 32;

    //Constructors

    //The class contains one method init(), it's gonna load everything for our game and it's gonna be called once.
    public static void initAssets(){
        // Initializing sprite sheets images

        SpriteSheet adventurerSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Adventurer Sprite Sheet v1.1.png"));
        SpriteSheet minotaurMonsterSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Minotaur - Sprite Sheet.png"));

        SpriteSheet goldCoinSheet, silverCoinSheet, redCoinSheet;
        goldCoinSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/CoinGems/MonedaD.png"));
        silverCoinSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/CoinGems/MonedaP.png"));
        redCoinSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/CoinGems/MonedaR.png"));

        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tileset.png"));

        SpriteSheet treesAndGrassTileSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/TreesAndGrassTiles.png"));
        SpriteSheet woodStuffSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/TileB.png"));
        SpriteSheet menuStartButtonSpriteSheet = new SpriteSheet((ImageLoader.LoadImage("/textures/MenuStartButtonSpriteSheet.png")));

        //Initializing adventurer animation sprites

        adventurerIdle = new BufferedImage[13];
        adventurerWalk = new BufferedImage[8];
        adventurerMeleeAttack = new BufferedImage[10];
        adventurerJump = new BufferedImage[6];
        adventurerGotHit = new BufferedImage[4];
        adventurerKO = new BufferedImage[7];

        //Initializing minotaur monster animation sprites

        minotaurIdle = new BufferedImage[4];
        minotaurWalk = new BufferedImage[8];
        minotaurSlowWalk = new BufferedImage[5];
        minotaurAxeSlash = new BufferedImage[9];
        minotaurAxeThrust = new BufferedImage[5];
        minotaurGuarding = new BufferedImage[6];
        minotaurRotarySlash = new BufferedImage[9];
        minotaurLowHealth = new BufferedImage[3];
        minotaurGotHit = new BufferedImage[3];
        minotaurDies = new BufferedImage[6];

        //Initializing drop items animation sprites

        goldCoinItem = new BufferedImage[5];
        silverCoinItem = new BufferedImage[5];
        redCoinItem = new BufferedImage[5];

        //Initializing Menu animation sprites

        menuButtonStart = new BufferedImage[2];

        //Cropping everything adventure from sprite sheet;

        adventurerIdle = adventurerSheet.cropInALoopFromSpriteSheet(0,0,width, height,13,adventurerSheet,adventurerIdle);
        adventurerWalk = adventurerSheet.cropInALoopFromSpriteSheet(0,32,width, height,8,adventurerSheet,adventurerWalk);
        adventurerMeleeAttack = adventurerSheet.cropInALoopFromSpriteSheet(0,64,width, height,10,adventurerSheet, adventurerMeleeAttack);
        adventurerJump = adventurerSheet.cropInALoopFromSpriteSheet(0,96,width, height,6,adventurerSheet,adventurerJump);
        adventurerGotHit = adventurerSheet.cropInALoopFromSpriteSheet(0,128,width, height,4,adventurerSheet,adventurerGotHit);
        adventurerKO = adventurerSheet.cropInALoopFromSpriteSheet(0,160,width, height,7,adventurerSheet,adventurerKO);

        //Cropping everything minotaur monster from sprite sheet;

        minotaurIdle = minotaurMonsterSheet.cropInALoopFromSpriteSheet(0,0,96,96,4,minotaurMonsterSheet,minotaurIdle);
        minotaurWalk = minotaurMonsterSheet.cropInALoopFromSpriteSheet(0,96,96,96,8,minotaurMonsterSheet,minotaurWalk);
        minotaurSlowWalk = minotaurMonsterSheet.cropInALoopFromSpriteSheet(0,192,96,96,5,minotaurMonsterSheet,minotaurSlowWalk);
        minotaurAxeSlash = minotaurMonsterSheet.cropInALoopFromSpriteSheet(0,288,96,96,9,minotaurMonsterSheet,minotaurAxeSlash);
        minotaurAxeThrust = minotaurMonsterSheet.cropInALoopFromSpriteSheet(0,384,96,96,5,minotaurMonsterSheet,minotaurAxeThrust);
        minotaurGuarding = minotaurMonsterSheet.cropInALoopFromSpriteSheet(0,480,96,96,6,minotaurMonsterSheet,minotaurGuarding);
        minotaurRotarySlash = minotaurMonsterSheet.cropInALoopFromSpriteSheet(0,576,96,96,9,minotaurMonsterSheet,minotaurRotarySlash);
        minotaurLowHealth = minotaurMonsterSheet.cropInALoopFromSpriteSheet(0,672,96,96,3,minotaurMonsterSheet,minotaurLowHealth);
        minotaurGotHit = minotaurMonsterSheet.cropInALoopFromSpriteSheet(0,768,96,96,3,minotaurMonsterSheet,minotaurGotHit);
        minotaurDies = minotaurMonsterSheet.cropInALoopFromSpriteSheet(0,864,96,96,6,minotaurMonsterSheet,minotaurDies);

        //Cropping items sprites from sprite sheet;

        goldCoinItem = goldCoinSheet.cropInALoopFromSpriteSheet(0,0,16,16,5,goldCoinSheet,goldCoinItem);
        silverCoinItem = silverCoinSheet.cropInALoopFromSpriteSheet(0,0,16,16,5,silverCoinSheet,silverCoinItem);
        redCoinItem = redCoinSheet.cropInALoopFromSpriteSheet(0,0,16,16,5,redCoinSheet,redCoinItem);

        //Cropping everything for our Menu from sprite sheet;

        menuButtonStart[0] = menuStartButtonSpriteSheet.crop(0,0,275, 98);
        menuButtonStart[1] = menuStartButtonSpriteSheet.crop(328,0,275, 98);

        //Cropping images (1 frame) objects

        adventurer = adventurerSheet.crop(0,0,width,height);

        groundTile = tileSheet.crop(0,0,width,height);
        darkGroundTile = tileSheet.crop(0,8*height,width,height);
        stoneTile = tileSheet.crop(8*width,0,width,height);
        darkStoneTile = tileSheet.crop(233,264,30,height);
        gothicWindow = tileSheet.crop(8*width,8*height,width,height);

        simpleTree = treesAndGrassTileSheet.crop(258,126,90,130);
        woodLogs = woodStuffSheet.crop(98,187,60,40);

        goldCoin = goldCoinSheet.crop(0,0,16,16);
        silverCoin = goldCoinSheet.crop(0,0,16,16);
        redCoin = goldCoinSheet.crop(0,0,16,16);
    }
}
