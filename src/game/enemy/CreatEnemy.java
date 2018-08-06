package game.enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import java.util.Random;

public class CreatEnemy extends GameObject {
    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter();
    @Override
    public void run() {
        super.run();
        if (this.frameCounter.compare(300)) {
            Enemy enemy = new Enemy();
            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            enemy.velocity.set(this.random.nextInt(3) + 1, this.random.nextInt(3) + 1);
            enemy.velocity = enemy.velocity.normalize();
            GameObjectManager.instance.add(enemy);
        }
        this.frameCounter.run();
    }
}
