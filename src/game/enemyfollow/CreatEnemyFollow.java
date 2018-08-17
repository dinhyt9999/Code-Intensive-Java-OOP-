package game.enemyfollow;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatEnemyFollow extends GameObject {
    private FrameCounter frameCounter = new FrameCounter();
    private Random random = new Random();

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.compare(300)) {
            EnemyFollow enemyFollow = GameObjectManager.instance.recycle(EnemyFollow.class);
            enemyFollow.position.set(random.nextInt(1024), random.nextInt(600));
        }
        this.frameCounter.run();
    }
}
