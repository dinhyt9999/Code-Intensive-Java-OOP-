package CId3;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {
    public BufferedImage image;
    //get set bằng alt + insert;
    public Vector2D position;
    public int width;
    public int height;
    public Vector2D velocity;

    public Star() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
    }

    public void run() {
        this.position.subtractBy(this.velocity);
    }

    public void render(Graphics graphics) {
        if (image != null)
            graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, this.width, this.height, null);
    }
}
