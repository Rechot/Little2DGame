package dev.java2Dgame.display;

import javax.swing.*;
import java.awt.*;

public class Display {

    //InstanceFields
    private JFrame frame;
    private Canvas canvas;  // canvas allows us to draw graphics to it, then we will add that canvas to Jframe window
                            // we are able to see on the screen
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

    // Getters

    public Canvas getCanvas() {
        return canvas;
    }
    public JFrame getJFrame() {
        return frame;
    }

    public void createDisplay(){
        // setting JFrame window
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // very important! This makes sure your program close properly
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // window will appear at the center
        frame.setVisible(true); // window by default is invisible

        // setting canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));

        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        //Some computers need that for Key input to work!
        //canvas.setFocusable(false);

        // adding canvas to Jframe window
        frame.add(canvas);
        frame.pack(); // adjusting canvas to Jframe window
    }


}
