package base;

import Action.Action;
import physic.BoxCollider;
import renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObject{
    public boolean isAlive = true;
    public Vector2D position;
    public Renderer renderer;
    public List<Attribute> attributes;
    public List<Action> actions;

    public GameObject() {
        this.actions = new ArrayList<>();
        this.position = new Vector2D();
        this.attributes = new ArrayList<>();
    }

    public void run() {
        this.attributes.forEach(attribute -> attribute.run(this));
        this.actions.removeIf(action -> action.run(this));
    }
    public void render(Graphics graphics) {
        if (this.renderer != null)
            this.renderer.render(graphics, this.position);
    }
    public void addAction(Action action){
        this.actions.add(action);
    }
}
