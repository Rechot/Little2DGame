package dev.codenmore.java2Dgame.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    //InstanceFields
    private BufferedImage sheet;

    //Constructors
    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }

    //Methods
    public BufferedImage crop(int x, int y, int width, int height){
        return sheet.getSubimage(x,y,width,height);
    }

    public BufferedImage[] cropInALoopFromSpriteSheet(int x, int y, int width, int height, int imagesInSpriteSheetRow, SpriteSheet spriteSheet, BufferedImage[] spriteRow){
        for(int i = 0; i < imagesInSpriteSheetRow ; i++){
            spriteRow[i] = spriteSheet.crop(x,y,width,height);
            x += width;
        }
        return spriteRow;
    }
}
