package CId3;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {
    public BufferedImage image;
    //get set bằng alt + insert;
    public int x;
    public int y;
    public int width;
    public int height;
    public int valocityx;
    public void run(){
        this.x += this.valocityx;
    }
    public void render(Graphics graphics){
        if(image != null)
            graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);
    }
}
