package renderer;

import base.Vector2D;

import java.awt.*;

public class RectRenderer implements Renderer {
    private int width;
    private int height;
    private Color color;

    public RectRenderer(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(this.color);
        graphics.fillRect((int)position.x,(int) position.y, this.width, this.height);
    }
}
