package base;


public class FrameCounter {
    private int timeInterval;

    public FrameCounter() {
        this.timeInterval = 0;
    }

    public boolean compare(int timeInterval){
        if (this.timeInterval % timeInterval == 0)
            return true;
        else return false;
    }
    public void run() {
        this.timeInterval = (this.timeInterval+1)%10000;
    }
}

