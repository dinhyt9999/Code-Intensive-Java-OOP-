package CId3;

import java.util.ArrayList;
import java.util.List;

public class EnemyAttack implements EnemyShoot {
    private FrameCounter frameCounter = new FrameCounter();
    public List<BulletEnemy> bulletEnemies = new ArrayList<>();
    private int timeInterval;
    private int angle;
    private int i;

    @Override
    public void run(Enemy enemy) {
        if (this.frameCounter.compare(40)) {
            for (this.i = 1; this.i <= 10; this.i++) {
                angle += 36;
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set(enemy.velocity.copy().multiply(1.5f).rotate(angle));
                this.bulletEnemies.add(bulletEnemy);
                this.timeInterval = 0;
            }
        }
        this.frameCounter.run();
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }
}

