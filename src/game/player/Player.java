package game.player;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject {
    public Vector2D velocity;
    public PlayerShoot playerShoot;
    public Vector2D temp;
    public FrameCounter frameCounter = new FrameCounter();

    public Player() {
        this.velocity = new Vector2D();
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8));
        this.playerShoot = new PlayerAttack();
        this.temp = this.velocity;
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        ((PlayerAttack) this.playerShoot).bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        ((PolygonRenderer) this.renderer).angle += KeyBoardEvent.instance.angle;
        backToScreen();
        this.playerShoot.run(this);
    }

    @Override
    public void updateVelocity() {
        this.velocity.set(this.temp.rotate(KeyBoardEvent.instance.angle).normalize().multiply(KeyBoardEvent.instance.coefficient));}

    private void backToScreen() {
        if (this.position.x > 1024) this.position.set(0, this.position.y);
        if (this.position.x < 0) this.position.set(1024, this.position.y);
        if (this.position.y > 600) this.position.set(this.position.x, 0);
        if (this.position.y < 0) this.position.set(this.position.x, 600);
    }

}
