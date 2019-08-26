package dev.codenmore.java2Dgame.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    public static BufferedImage LoadImage(String Path) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(Path)); //Returns the buffered image object of our loaded image
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1); //If we don't load an image to our game, we don't want to run our game.
        }
        return null; //Java makes you do that in order to rid of the possible errors.
    }
}
