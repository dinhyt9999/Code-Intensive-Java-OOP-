package CId3;

import java.awt.*;

public class EnemyFollow {
    public Vector2D position;
    public Vector2D velocity;
    private Renderer renderer;

    public EnemyFollow() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources-rocket-master/resources/images/circle.png", 16, 16);
    }

    public void run() {
        this.position.addUp(velocity);
    }

    public void updateVelocity(Vector2D vector2D) {
        velocity.set(vector2D.x - position.x, vector2D.y - position.y);
        velocity = velocity.normalize();
    }

    public void render(Graphics graphics) {
        renderer.render(graphics, this.position);
    }
}
