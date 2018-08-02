package CId3;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BulletEnemy {
    public Vector2D position;
    public Vector2D velocity;
    private Renderer renderer;

    public BulletEnemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources-rocket-master/resources/images/circle.png",5,5);
    }
    public void run() {
        this.position.addUp(this.velocity);
    }
    public void render(Graphics graphics) {
        this.renderer.render(graphics,this.position);
    }
}