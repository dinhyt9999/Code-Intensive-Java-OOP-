package base;

import physic.BoxCollider;
import renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObject{
    public boolean isAlive = true;
    public Vector2D position;
    public Renderer renderer;
    public BoxCollider boxCollider;
    public List<Attribute> attributes;

    public GameObject() {
        this.position = new Vector2D();
        this.attributes = new ArrayList<>();
        this.boxCollider = new BoxCollider(0,0);
    }

    public void run() {
        this.attributes.forEach(attribute -> attribute.run(this));
    }
    public void render(Graphics graphics) {
        if (this.renderer != null)
            this.renderer.render(graphics, this.position);
    }
}
