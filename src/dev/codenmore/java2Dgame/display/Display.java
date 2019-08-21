package dev.codenmore.java2Dgame.display;

import javax.swing.*;

public class Display {

    //InstanceFields
    private JFrame frame;
    private Misiu misiu;
    private String title;
    private int width, height; // pixels

    //Constructors

    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    //Methods

    public void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // very important! This makes sure your program close properly
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // window will appear at the center
        frame.setVisible(true); // window by default is invisible

    }


}
