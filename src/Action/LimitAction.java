package Action;

import base.GameObject;


public class LimitAction implements Action{
    private Action action;
    private int max;
    public LimitAction(int Max, Action action){
        this.max = max;
        this.action = action;
    }
    @Override
    public boolean run(GameObject owner) {
        if(this.action.run(owner)){
            this.action.reset();
            this.max--;
        }
        return this.max == 1;
    }

    @Override
    public void reset() {

    }
}
