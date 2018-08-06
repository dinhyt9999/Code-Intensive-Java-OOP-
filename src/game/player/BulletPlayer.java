package game.player;

import base.GameObject;
import base.Vector2D;

import java.awt.*;

public class BulletPlayer extends GameObject {
    public Vector2D velocity;
    public BulletPlayer() {
        this.velocity = new Vector2D();
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
    public void render(Graphics graphics) {
        graphics.fillOval((int)this.position.x-2,(int)this.position.y-2,5,5);
//        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, 5, 5, null);
    }
}
