package CId3;

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
            this.bulletPlayers.add(bulletPlayer);
        }
        frameCounter.run();
        this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.run());
    }
}
