package game.star;

import Action.Action;
import Action.WaitAction;
import base.GameObject;
import Action.ActionAdapter;
import base.GameObjectManager;
import Action.SequenceAction;
import Action.RepeatActionForever;
import java.util.Random;

public class CreatStar extends GameObject {
    private Random random = new Random();

    public CreatStar(){
        this.configAction();
    }
    public void configAction(){
        Action waitAction = new WaitAction(180);
        Action createAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner){
                Star star = GameObjectManager.instance.recycle(Star.class);
                star.position.set(1024,random.nextInt(600));
                star.velocity.set(random.nextInt(3)+1,0);
                return true;
            }
        };
        Action sequenceAction = new SequenceAction(waitAction, createAction);
        Action repeatAction = new RepeatActionForever(sequenceAction);
        this.addAction(repeatAction);
    }
}
