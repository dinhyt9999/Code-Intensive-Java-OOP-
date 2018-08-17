package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class BulletEnemy extends GameObject implements PhysicBody {
    public Vector2D velocity;
    private RunHitObject runHitObject;
    public BoxCollider boxCollider;

    public BulletEnemy() {
        this.runHitObject = new RunHitObject(Player.class);
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(5,5);
        this.renderer = new ImageRenderer("resources-rocket-master/resources-rocket-master/resources/images/circle.png",5,5);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x -2.5f,this.position.y-2.5f);
        if(this.position.x > 1024 || this.position.x < 0 || this.position.y > 600 || this.position.y < 0){
            this.isAlive = false;
        }
        this.runHitObject.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }
}