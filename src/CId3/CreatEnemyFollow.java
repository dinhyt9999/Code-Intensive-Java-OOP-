package CId3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatEnemyFollow {
    public List<EnemyFollow> enemyFollows = new ArrayList<>();
    public EnemyFollow enemyFollow;
    private FrameCounter frameCounter = new FrameCounter();
    private Random random = new Random();

    public void run() {
        if (this.frameCounter.compare(300)) {
            this.enemyFollow = new EnemyFollow();
            this.enemyFollow.position.set(random.nextInt(1024), random.nextInt(600));
            this.enemyFollows.add(enemyFollow);
        }
        this.frameCounter.run();
        this.enemyFollows.forEach(enemyFollow -> enemyFollow.run());
    }
    public void render(Graphics graphics){
        this.enemyFollows.forEach(enemyFollow -> enemyFollow.render(graphics));
    }
    public void updateVelocity(Vector2D vector2D){
        this.enemyFollows.forEach(enemyFollow -> enemyFollow.updateVelocity(vector2D));
    }
}
