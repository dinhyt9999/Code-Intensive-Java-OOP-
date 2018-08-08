package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import game.enemyfollow.EnemyFollow;
import physic.BoxCollider;

import java.awt.*;

public class BulletPlayer extends GameObject {
    public Vector2D velocity;
    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(5,5);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 2.5f,this.position.y - 2.5f);
        EnemyFollow enemyFollow = GameObjectManager.instance.checkCollision1(this);
        if(enemyFollow!=null){
            this.isAlive = false;
            enemyFollow.isAlive = false;
        }
        Enemy enemy = GameObjectManager.instance.checkCollision2(this);
        if(enemy!=null){
            this.isAlive = false;
            enemy.isAlive = false;
        }
    }
    public void render(Graphics graphics) {
        graphics.fillOval((int)this.position.x-2,(int)this.position.y-2,5,5);
    }
}
