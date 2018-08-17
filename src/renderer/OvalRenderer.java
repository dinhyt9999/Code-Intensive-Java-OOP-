package renderer;

import base.Vector2D;

import java.awt.*;

public class OvalRenderer implements Renderer{
    private int width;
    private int height;
    private Color color;
    public OvalRenderer(Color color,int width, int height){
        this.color = color;
        this.height = height;
        this.width = width;
    }
    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.drawOval((int)position.x,(int)position.y,this.width,this.height);
    }
}
