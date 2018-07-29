package CId3;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {
    public Vector2D position;
    public Vector2D velocity;
    private List<Vector2D> vertices;
    private Polygon polygon;
    private Random random = new Random();
    public float angle = 0;
    private int timeIntervalBullet;
    private int timeIntervalFollow;
    private List<BulletPlayer> bulletPlayers;
    private List<EnemyFollow> enemyFollows;

    public Player() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.vertices = Arrays.asList(
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.polygon = new Polygon();
        this.bulletPlayers = new ArrayList<>();
        this.enemyFollows = new ArrayList<>();
    }

    public void run() {
        this.position.addUp(this.velocity);
        this.shoot();
        this.follow();
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        this.updateTriangle();
        graphics.drawPolygon(this.polygon);
        graphics.fillPolygon(this.polygon);
        this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
        this.enemyFollows.forEach(enemyFollow -> enemyFollow.render(graphics));
    }

    private void updateTriangle() {
        this.polygon.reset();
        Vector2D center = this.vertices.stream().reduce(new Vector2D(), (v1, v2) -> v1.add(v2)).multiply(1.0f / (float) this.vertices.size()).rotate(this.angle);
        Vector2D translate = this.position.subtract(center);
        this.vertices.stream().map(vector2D -> vector2D.rotate(angle)).map(vector2D -> vector2D.add(translate)).forEach(vector2D -> polygon.addPoint((int) vector2D.x, (int) vector2D.y));
    }

    private void shoot() {
        if (this.timeIntervalBullet == 25) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.velocity = this.velocity.copy();
            bulletPlayer.position.set(this.position.x - 2, this.position.y - 2);
            bulletPlayer.velocity.multiply(1.5f);
            this.bulletPlayers.add(bulletPlayer);
            this.timeIntervalBullet = 0;
        } else {
            this.timeIntervalBullet += 1;
        }

        this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.run());
    }

    private void follow() {
        if (this.timeIntervalFollow == 300) {
            EnemyFollow enemyFollow = new EnemyFollow();
            try {
                enemyFollow.image = ImageIO.read(new File("resources-rocket-master/resources-rocket-master/resources/images/circle.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            enemyFollow.position.set(random.nextInt(1024), random.nextInt(600));
            this.enemyFollows.add(enemyFollow);
            this.timeIntervalFollow = 0;
        } else {
            this.timeIntervalFollow += 1;
        }

        this.enemyFollows.forEach(enemyFollow -> enemyFollow.run());
        this.enemyFollows.forEach(enemyFollow -> enemyFollow.updateVelocity(this.position));
    }
}
