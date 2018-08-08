package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.awt.*;

public class Enemy extends GameObject {
    public Vector2D velocity;
    private EnemyShoot enemyShoot;

    public Enemy() {
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(16,16);
        this.renderer = new ImageRenderer("resources-rocket-master/resources-rocket-master/resources/images/circle.png", 16, 16);
        this.enemyShoot = new EnemyAttack();
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x - 8,this.position.y - 8);
        this.enemyShoot.run(this);
        if(GameObjectManager.instance.checkCollision4(this)){
            Player player = GameObjectManager.instance.findPlayer();
            player.isAlive = false;
        }
    }
    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        ((EnemyAttack) this.enemyShoot).bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}
