package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.BulletEnemy;
import game.enemy.Enemy;
import game.enemyfollow.EnemyFollow;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.OvalRenderer;

import java.awt.*;

public class Shield extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;
    public Vector2D velocity;
    public int HP;
    private RunHitObject runHitObject;

    public Shield() {
        this.position = new Vector2D(200, 100);
        this.velocity = new Vector2D(1, 1);
        this.boxCollider = new BoxCollider(40, 40);
        this.HP = 3;
        this.runHitObject = new RunHitObject(Player.class,Enemy.class,EnemyFollow.class,BulletEnemy.class);
        this.renderer = new OvalRenderer(Color.WHITE, 40, 40);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 20, this.position.y - 20);
        this.runHitObject.run(this);
        this.backToScreen();
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof Player) {
            this.position.set(gameObject.position.x-20,gameObject.position.y -20);
            this.velocity.set(((Player) gameObject).velocity);

        }
        if (gameObject instanceof Enemy || gameObject instanceof EnemyFollow || gameObject instanceof BulletEnemy){
                this.HP --;
        }
        if (this.HP == 0){
            this.isAlive = false;
        }
    }
    private void backToScreen() {
        if (position.x > 1024) position.set(0, position.y);
        if (position.x < 0) position.set(1024, position.y);
        if (position.y > 600) position.set(position.x, 0);
        if (position.y < 0) position.set(position.x, 600);
    }
}