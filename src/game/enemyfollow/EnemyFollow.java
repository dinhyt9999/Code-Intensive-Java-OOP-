package game.enemyfollow;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import renderer.ImageRenderer;

public class EnemyFollow extends GameObject {
    public Vector2D velocity;

    public EnemyFollow() {
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(16,16);
        this.renderer = new ImageRenderer("resources-rocket-master/resources-rocket-master/resources/images/circle.png", 16, 16);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position.x - 8,this.position.y - 8);
        Player player = GameObjectManager.instance.findPlayer();
        if(player!=null){
            this.updateVelocity(player.position);
        }
        if(GameObjectManager.instance.checkCollision5(this)){
            player.isAlive = false;
        }
    }
    private void updateVelocity(Vector2D position) {
        this.velocity.set(position.x-this.position.x,position.y - this.position.y);
        this.velocity = this.velocity.normalize();
    }
}
