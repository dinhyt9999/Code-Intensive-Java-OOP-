package CId3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatStar {
    public List<Star> stars = new ArrayList<>();
    public Star star;
    public Random random = new Random();
    public FrameCounter frameCounter = new FrameCounter();
    public void run(){
        if (this.frameCounter.compare(30)) {
            this.star = new Star();
            this.star.position.set(1024, this.random.nextInt(600));
            this.star.velocity.set(this.random.nextInt(3) + 1, 0);
            this.stars.add(star);
        }
        this.frameCounter.run();
        this.stars.forEach(star -> star.run());
    }
    public void render(Graphics graphics){
        this.stars.forEach(star -> star.render(graphics));
    }
}
