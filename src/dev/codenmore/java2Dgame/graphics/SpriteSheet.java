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
}
