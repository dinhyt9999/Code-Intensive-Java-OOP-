package CId3;

import java.awt.*;

public class Player {
    public Vector2D position;
    public Vector2D velocity;
    public Renderer renderer;
    public PlayerShoot playerShoot;
    public float angle = 0;
    public Player() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8));
        this.playerShoot = new PlayerAttack();
    }
    public void render(Graphics graphics){
        this.renderer.render(graphics,this.position);
        ((PlayerAttack)this.playerShoot).bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }

    public void run() {
        this.position.addUp(this.velocity);
        ((PolygonRenderer)this.renderer).angle = this.angle;
        backToScreen();
        this.playerShoot.run(this);
    }
    private void backToScreen(){
        if(this.position.x>1024) this.position.set(0,this.position.y);
        if(this.position.x<0) this.position.set(1024,this.position.y);
        if(this.position.y>600) this.position.set(this.position.x, 0);
        if(this.position.y<0) this.position.set(this.position.x, 600);
    }

}
