package CId3;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player{
    public BufferedImage image;
    public int[] x = new int[3];
    public int[] y = new int[3];
    public int valocity;
    public void render(Graphics graphics){
        graphics.setColor(Color.WHITE);
        graphics.drawPolygon(this.x, this.y, 3);
    }
}
