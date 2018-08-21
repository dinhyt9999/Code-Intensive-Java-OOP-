package Action;

import base.GameObject;

public interface Action {
    boolean run(GameObject owner);
    void reset();
}
