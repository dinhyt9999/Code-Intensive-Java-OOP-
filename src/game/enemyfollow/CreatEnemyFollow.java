package game.enemyfollow;

import Action.ActionAdapter;
import Action.LimitAction;
import Action.SequenceAction;
import Action.WaitAction;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatEnemyFollow extends GameObject {
    private Random random = new Random();

    public CreatEnemyFollow() {
        this.configAction();

    }

    public void configAction() {
        this.addAction(
                new LimitAction(70,
                        new SequenceAction(
                                new WaitAction(600),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        EnemyFollow enemyFollow = GameObjectManager.instance.recycle(EnemyFollow.class);
                                        enemyFollow.position.set(random.nextInt(1024), random.nextInt(600));
                                        return true;
                                    }
                                }
                        )
                )
        );
    }
//    @Override
//    public void run() {
//        super.run();
//        if (this.frameCounter.compare(300)) {
//            EnemyFollow enemyFollow = GameObjectManager.instance.recycle(EnemyFollow.class);
//            enemyFollow.position.set(random.nextInt(1024), random.nextInt(600));
//        }
//        this.frameCounter.run();
//    }
}
