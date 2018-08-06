package game.player;

import base.FrameCounter;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;

public class PlayerAttack implements PlayerShoot{

    public List<BulletPlayer> bulletPlayers = new ArrayList<>();
    private FrameCounter frameCounter = new FrameCounter();
    @Override
    public void run(Player player) {
        if (this.frameCounter.compare(40)){
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(player.velocity.copy().multiply(1.5f));
            GameObjectManager.instance.add(bulletPlayer);
        }
        frameCounter.run();
    }
}
