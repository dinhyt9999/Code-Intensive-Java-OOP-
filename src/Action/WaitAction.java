package Action;

import base.FrameCounter;
import base.GameObject;

public class WaitAction implements Action {

    private FrameCounter frameCounter;
    private int timeInterval;
    public WaitAction(int timeInterval){
        this.timeInterval = timeInterval;
        this.frameCounter = new FrameCounter();
    }

    @Override
    public boolean run(GameObject owner) {
        this.frameCounter.run();
        return this.frameCounter.compare(this.timeInterval);
    }

    @Override
    public void reset() {

    }
}
