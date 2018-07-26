package CId3;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public BufferedImage image;
    public int x;
    public int y;
    public int width;
    public int height;
    public int valocityx;
    public int valocityy;
    public void run(){
        this.x+=valocityx;
        this.y+=valocityy;
        if ((this.x<=0)||(this.x>=1008))
            valocityx = -valocityx;
        if ((this.y<=0)||(this.y>=584))
            valocityy = -valocityy;
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);
    }
}
