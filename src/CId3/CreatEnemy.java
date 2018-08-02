package CId3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatEnemy {
    public List<Enemy> enemies = new ArrayList<>();
    public Enemy enemy;
    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter();

    public void run() {
        if (this.frameCounter.compare(300)) {
            this.enemy = new Enemy();
            this.enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            this.enemy.velocity.set(this.random.nextInt(3) + 1, this.random.nextInt(3) + 1);
            this.enemy.velocity = enemy.velocity.normalize();
            this.enemies.add(enemy);
        }
        this.frameCounter.run();
        this.enemies.forEach(enemy -> enemy.run());
    }

    public void render(Graphics graphics) {
        this.enemies.forEach(enemy -> enemy.render(graphics));
    }
}
