package game.player;

import base.Attribute;
import base.GameObjectManager;
import game.enemy.BulletEnemy;
import input.KeyBoardEvent;

public class PlayerShoot implements Attribute<Player> {

    @Override
    public void run(Player gameObject) {
        if (KeyBoardEvent.instance.isSpace) {
            BulletPlayer bulletPlayer = GameObjectManager.instance.recycle(BulletPlayer.class);
            bulletPlayer.position.set(gameObject.position);
            bulletPlayer.velocity.set(gameObject.velocity.copy().multiply(1.5f));
        }
    }
}
