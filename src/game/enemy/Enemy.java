package game.enemy;

import Action.Action;
import Action.ActionAdapter;
import Action.SequenceAction;
import Action.WaitAction;
import Action.RepeatActionForever;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Die;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

import java.awt.*;

public class Enemy extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public RunHitObject runHitObject;
    public BoxCollider boxCollider;
    public EnemyShoot enemyShoot;

    public Enemy() {
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(16, 16);
        this.renderer = new ImageRenderer("resources-rocket-master/resources-rocket-master/resources/images/circle.png", 16, 16);
        this.runHitObject = new RunHitObject(Player.class);
        this.enemyShoot = new EnemyAttack();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x - 8, this.position.y - 8);
//        this.enemyShoot.run(this);
        this.runHitObject.run(this);
        if (this.position.x > 1024 || this.position.x < 0 || this.position.y > 600 || this.position.y < 0) {
            this.isAlive = false;
        }
        this.backToScreen();
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        ((EnemyAttack) this.enemyShoot).bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
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
    public void backToScreen() {
        if (this.position.x > 1008 || this.position.x < 2) this.velocity.x = -this.velocity.x;
        if (this.position.y > 584 || this.position.y < 2) this.velocity.y = -this.velocity.y;
    }
}
