package game.player;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class Die extends GameObject {
    public Vector2D velocity;
    public Die(){
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources-rocket-master/resources/images/circle.png",5,5);
    }
}
