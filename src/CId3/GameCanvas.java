package CId3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {
    //   private Star star;
    private Background background = new Background();
    private List<Star> stars;
    private Star star;
    private List<Enemy> enemies;
    private Enemy enemy;
    public Player player;
    private BufferedImage backBuffered;
    private int timeIntervalEnemy = 0;
    private int timeIntervalStar = 0;
    private Graphics graphics;
    private Random random = new Random();

    private void creatStar() {
        if (this.timeIntervalStar == 30) {
            this.star = new Star();
            this.star.position.set(1024, this.random.nextInt(600));
            this.star.image = this.loadImage("resources-rocket-master/resources-rocket-master/resources/images/star.png");
            this.star.width = 5;
            this.star.height = 5;
            this.star.velocity.set(this.random.nextInt(3) + 1, 0);
            this.stars.add(star);
            this.timeIntervalStar = 0;
        } else timeIntervalStar++;
    }

    private void creatEnemy() {
        if (this.timeIntervalEnemy == 300) {
            this.enemy = new Enemy();
            this.enemy.position.set(this.random.nextInt(1024),this.random.nextInt(600));
            this.enemy.image = this.loadImage("resources-rocket-master/resources-rocket-master/resources/images/circle.png");
            this.enemy.width = 16;
            this.enemy.height = 16;
            this.enemy.velocity.set(random.nextInt(3)+1,random.nextInt(3)+1);
            this.enemy.velocity = enemy.velocity.normalize();
            this.enemies.add(enemy);
            this.timeIntervalEnemy = 0;
        } else timeIntervalEnemy++;
    }

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(200,300);
        this.player.velocity.set(2.5f,0);
    }

    public void runAll() {
        creatStar();
        creatEnemy();
        this.player.run();
        this.stars.forEach(star -> star.run());
        this.enemies.forEach(enemy -> enemy.run());
    }

    public GameCanvas() {
        this.setSize(1024, 600);
        setupBackBuffered();
        setupStar();
        setupEnemy();
        setupCharacter();
        this.setVisible(true);
    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    }

    private void setupEnemy() {
        this.enemies = new ArrayList<>();
    }

    private void setupCharacter(){
        setupPlayer();
    }
    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        background.render(graphics);
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.stars.forEach(star -> star.render(graphics));
        this.player.render(this.graphics);
        this.repaint();
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}