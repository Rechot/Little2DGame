package dev.java2Dgame.graphics;

import java.awt.*;

public class Text {

    public static void drawString(Graphics graphics, String text, int xPosition, int yPosition, boolean center, Color color, Font font){
        graphics.setColor(color);
        graphics.setFont(font);
        int x = xPosition;
        int y = yPosition;
        if(center){
            FontMetrics fontMetrics = graphics.getFontMetrics(font);
            x = xPosition - fontMetrics.stringWidth(text) / 2;
            y = (yPosition - fontMetrics.getHeight() / 2) + fontMetrics.getAscent();
        }
        graphics.drawString(text, x, y);
    }
}
