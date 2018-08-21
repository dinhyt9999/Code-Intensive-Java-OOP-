package game.player;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;

public class CreatShield extends GameObject {
    private FrameCounter frameCounter = new FrameCounter();
    @Override
    public void run(){
        if(frameCounter.compare(1000)){
            Shield shield = GameObjectManager.instance.recycle(Shield.class);
            shield.HP = 20;
            this.position = new Vector2D();
            System.out.println(shield.HP);
        }
        frameCounter.run();
    }
}
