package game.enemyfollow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.BulletEnemy;
import game.player.Die;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class EnemyFollow extends GameObject implements PhysicBody {
    public Vector2D velocity;
    private RunHitObject runHitObject;
    public BoxCollider boxCollider;

    public EnemyFollow() {
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(16, 16);
        this.runHitObject = new RunHitObject(Player.class);
        this.renderer = new ImageRenderer("resources-rocket-master/resources-rocket-master/resources/images/circle.png", 16, 16);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x - 8, this.position.y - 8);
        Player player = GameObjectManager.instance.findPlayer();
        if (player != null) {
            this.updateVelocity(player.position);
        }
        this.runHitObject.run(this);
    }

    @Override
    public void getHit(GameObject gameObject) {
        int angle = 0;
        for (int i = 1; i <= 10; i++) {
            angle += 36;
            Die die = GameObjectManager.instance.recycle(Die.class);
            die.position.set(this.position);
            die.velocity.set(this.velocity.copy().multiply(1.5f).rotate(angle));
        }
        this.isAlive = false;
    }

    private void updateVelocity(Vector2D position) {
        this.velocity.set(position.x - this.position.x, position.y - this.position.y);
        this.velocity = this.velocity.normalize();
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
