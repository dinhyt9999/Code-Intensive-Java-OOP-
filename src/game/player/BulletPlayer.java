package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import game.enemyfollow.EnemyFollow;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;

import java.awt.*;

public class BulletPlayer extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(5, 5);
        this.runHitObject = new RunHitObject(EnemyFollow.class,Enemy.class);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 2.5f, this.position.y - 2.5f);
        this.runHitObject.run(this);
        if(this.position.x > 1024 || this.position.x < 0 || this.position.y > 600 || this.position.y < 0){
            this.isAlive = false;
        }
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    public void render(Graphics graphics) {
        graphics.fillOval((int) this.position.x - 2, (int) this.position.y - 2, 5, 5);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
