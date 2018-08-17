package game.star;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import game.star.Star;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatStar extends GameObject {
    public List<Star> stars = new ArrayList<>();
    public Star star;
    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter();

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.compare(30)) {
            this.star = GameObjectManager.instance.recycle(Star.class);
            this.star.position.set(1024, this.random.nextInt(600));
            this.star.velocity.set(this.random.nextInt(3) + 1, 0);
        }
        this.frameCounter.run();
    }
}
