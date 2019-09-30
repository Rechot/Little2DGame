package dev.java2Dgame.ui;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject{

    //InstanceFields

    private BufferedImage[] images;
    private ClickListener clickListener;

    //Constructors

    public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clickListener) {
        super(x, y, width, height);
        this.images = images;
        this.clickListener = clickListener;
    }

    //Methods

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        if(hovering)
            { graphics.drawImage(images[1], (int)x, (int)y, width, height, null); }
        else
            { graphics.drawImage(images[0], (int)x, (int)y, width, height, null);}
    }

    @Override
    public void onClick() {
        clickListener.onClick();
    }
}
