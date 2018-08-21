package game.enemy;

import Action.Action;
import Action.LimitAction;
import Action.SequenceAction;
import Action.WaitAction;
import base.GameObject;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Action.ActionAdapter;

public class CreatEnemy extends GameObject {
    private Random random = new Random();
    private List<Enemy> enemies;

    public CreatEnemy() {
        this.enemies = new ArrayList<>();
        this.configAction();
    }

    public void configAction() {
        List<Enemy> enemies = new ArrayList<>();
        Action createAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
                enemy.position.set(random.nextInt(1024), random.nextInt(600));
                enemy.velocity.set(random.nextInt(3) + 1, random.nextInt(3) + 1);
                Action move = new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                        int count = 0;
                        if (count < 1000) {
                            enemy.position.addUp(enemy.velocity);
                            count++;
                        }
                        return true;
                    }
                };
                Action shoot = new ActionAdapter() {
                    @Override
                    public boolean run(GameObject owner) {
                        EnemyShoot enemyShoot = new EnemyAttack();
                        int count = 0;
                        if (count < 1000) {
                            enemyShoot.run(enemy);
                            count++;
                        }
                        return true;
                    }
                };
                enemies.add(enemy);
                return true;
            }
        };

        Action waitAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                enemies.removeIf(enemy -> !enemy.isAlive);
                return enemies.isEmpty();
            }
        };
        this.addAction(
                new SequenceAction(
                        new WaitAction(20),
                        new LimitAction(
                                4,
                                new SequenceAction(
                                        createAction,
                                        waitAction
                                )
                        )
                )
        );
    }
}
//    @Override
//    public void run() {
//        super.run();
//        if (this.frameCounter.compare(300)) {
//            Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
//            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
//            enemy.velocity.set(this.random.nextInt(3) + 1, this.random.nextInt(3) + 1);
//            enemy.velocity = enemy.velocity.normalize();
//        }
//        this.frameCounter.run();
//    }
