package CId3;

import java.awt.*;

public class Background {
    public Vector2D position;
    private Renderer renderer;

    public Background() {
        this.position = new Vector2D();
        position.x = 0;
        position.y = 0;
        this.renderer = new RectRenderer(Color.BLACK,1024,600);
    }

    public void render(Graphics graphics) {
        renderer.render(graphics,this.position);
    }
}
