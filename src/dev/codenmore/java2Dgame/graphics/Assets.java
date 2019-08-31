package dev.codenmore.java2Dgame.graphics;

import java.awt.image.BufferedImage;

public class Assets {
    //An asset is any image, sound and piece of music in our game
    //InstanceFields are testAssets
    public static BufferedImage adventurer, groundTile, darkGroundTile, stoneTile, darkStoneTile, gothicWindow;
    private static final int width = 32, height = 32;

    //Constructors

    //The class contains one method init(), it's gonna load everything for our game and it's gonna be called once.
    public static void initAssets(){
        SpriteSheet adventurerSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Adventurer Sprite Sheet v1.1.png"));
        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Tileset.png"));

        adventurer = adventurerSheet.crop(0,0,width,height);
        groundTile = tileSheet.crop(0,0,width,height);
        darkGroundTile = tileSheet.crop(0,8*height,width,height);
        stoneTile = tileSheet.crop(8*width,0,width,height);
        darkStoneTile = tileSheet.crop(233,264,30,height);
        gothicWindow = tileSheet.crop(8*width,8*height,width,height);
    }
}
