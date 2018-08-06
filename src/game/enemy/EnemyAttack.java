package game.enemy;

import base.FrameCounter;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;

public class EnemyAttack implements EnemyShoot {
    private FrameCounter frameCounter = new FrameCounter();
    public List<BulletEnemy> bulletEnemies = new ArrayList<>();
    private int angle;
    private int i;

    @Override
    public void run(Enemy enemy) {
        if (this.frameCounter.compare(160)) {
            for (this.i = 1; this.i <= 10; this.i++) {
                angle += 36;
                BulletEnemy bulletEnemy = new BulletEnemy();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set(enemy.velocity.copy().multiply(1.5f).rotate(angle));
                GameObjectManager.instance.add(bulletEnemy);
            }
        }
        this.frameCounter.run();
    }
}

