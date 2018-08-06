package game.enemy;

import base.GameObject;
import base.Vector2D;
import game.enemy.EnemyAttack;
import game.enemy.EnemyShoot;
import renderer.ImageRenderer;

import java.awt.*;

public class Enemy extends GameObject {
    public Vector2D velocity;
    private EnemyShoot enemyShoot;

    public Enemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources-rocket-master/resources/images/circle.png", 16, 16);
        this.enemyShoot = new EnemyAttack();
    }
    @Override
    public void run() {
        super.run();
        this.position = position.add(velocity);
        this.enemyShoot.run(this);
    }
    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        ((EnemyAttack) this.enemyShoot).bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}
