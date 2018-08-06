package game.enemyfollow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import renderer.ImageRenderer;

public class EnemyFollow extends GameObject {
    public Vector2D velocity;
    public Vector2D temp = new Vector2D();

    public EnemyFollow() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources-rocket-master/resources/images/circle.png", 16, 16);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
    }
    @Override
    public void updateVelocity() {
        this.temp.set(GameObjectManager.instance.list.get(1).position);
        this.velocity.set(this.temp.x-this.position.x,this.temp.y - this.position.y);
        this.velocity = this.velocity.normalize();
    }
}
