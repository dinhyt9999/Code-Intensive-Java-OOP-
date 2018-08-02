package CId3;

import java.awt.*;

public class Enemy {
    public Vector2D position;
    public Vector2D velocity;
    private Renderer renderer;
    private EnemyShoot enemyShoot;

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources-rocket-master/resources-rocket-master/resources/images/circle.png", 16, 16);
        this.enemyShoot = new EnemyAttack();
    }

    public void run() {
        this.position = position.add(velocity);
        this.enemyShoot.run(this);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
        ((EnemyAttack) this.enemyShoot).bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}
