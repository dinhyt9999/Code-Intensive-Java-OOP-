package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.BulletEnemy;
import game.enemy.Enemy;
import game.enemyfollow.EnemyFollow;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public int angle;
    public BoxCollider boxCollider;
    private int HP;

    public Player() {
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(12, 16);
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8));
        this.attributes.add(new PlayerShoot());
        this.attributes.add(new PlayerMove());
        this.HP=1;
    }
    @Override
    public void run(){
        super.run();
        ((PolygonRenderer) this.renderer).angle = this.angle;
        this.boxCollider.position.set(this.position.x - 10, this.position.y -8);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Enemy || gameObject instanceof EnemyFollow || gameObject instanceof BulletEnemy) {
            this.HP--;
        }
        if (HP == 0){
            int angle = 0;
            for (int i = 1; i <= 10; i++) {
                angle += 36;
                Die die = GameObjectManager.instance.recycle(Die.class);
                die.position.set(this.position);
                die.velocity.set(this.velocity.copy().multiply(1.5f).rotate(angle));
            }
            this.isAlive = false;
        }
    }
}