package dev.codenmore.java2Dgame.graphics;

import java.awt.image.BufferedImage;

public class Animation {

    //InstanceFields

    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] animationFrames;
    private int animationFramesLenght;

    //Constructors

    public Animation(int speed, BufferedImage[] animationFrames) {
        this.speed = speed;
        this.animationFrames = animationFrames;
        this.animationFramesLenght = animationFrames.length;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    //Methods

    public void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){
            index++;
            timer = 0;
            if(index >= animationFrames.length){ index = 0; }
        }
    }

    public BufferedImage getCurrentAnimationFrame(){
        return animationFrames[index];
    }
}
