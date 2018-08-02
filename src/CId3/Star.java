package CId3;

import java.awt.*;

public class Star {
    //get set bằng alt + insert;
    public Vector2D position;
    public Vector2D velocity;
    public Renderer renderer;

    public Star() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources-rocket-master/resources/images/star.png",5,5);
    }

    public void run() {
        this.position.subtractBy(this.velocity);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics,this.position);
    }
}
