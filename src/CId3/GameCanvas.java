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
    private List<Star> stars;
    private Star star = new Star();
    private List<Enemy> enemies;
    private Enemy enemy = new Enemy();
    public Player player = new Player();
    private BufferedImage backBuffered;
    public int positionXPlayer;
    public int positionYPlayer;
    private int timeIntervalEnemy = 0;
    private int timeIntervalStar = 0;
    private Graphics graphics;
    private Random random = new Random();

    private void creatStar() {
        if (this.timeIntervalStar == 30) {
            this.star = new Star();
            this.star.x = 0;
            this.star.y = this.random.nextInt(600);
            this.star.image = this.loadImage("resources-rocket-master/resources-rocket-master/resources/images/star.png");
            this.star.width = 5;
            this.star.height = 5;
            this.star.valocityx = 3;
            this.stars.add(star);
            this.timeIntervalStar = 0;
        } else timeIntervalStar++;
    }

    private void creatEnemy() {
        if (this.timeIntervalEnemy == 300) {
            this.enemy = new Enemy();
            this.enemy.x = this.random.nextInt(1008);
            this.enemy.y = this.random.nextInt(584);
            this.enemy.image = this.loadImage("resources-rocket-master/resources-rocket-master/resources/images/circle.png");
            this.enemy.width = 16;
            this.enemy.height = 16;
            this.enemy.valocityx = 3;
            this.enemy.valocityy = 3;
            this.enemies.add(enemy);
            this.timeIntervalEnemy = 0;
        } else timeIntervalEnemy++;
    }

    private void creatPlayer() {
        this.player.image = this.loadImage("resources-rocket-master/resources-rocket-master/resources/images/circle.png");
        this.player.x[1] = player.x[0] + 24;
        this.player.y[1] = player.y[0];
        this.player.x[2] = player.x[0] + 12;
        this.player.y[2] = player.y[0] + 21;
        this.player.valocity = 10;
    }

    public void runAll() {
        creatStar();
        creatEnemy();
        creatPlayer();
        this.stars.forEach(star -> star.run());
        this.enemies.forEach(enemy -> enemy.run());
    }

    public GameCanvas() {
        this.player.x[0]=random.nextInt(1000);
        this.player.y[0]=random.nextInt(576);
        this.setSize(1024, 600);
        setupBackBuffered();
        setupStar();
        setupEnemy();
        creatPlayer();
        this.setVisible(true);
    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    }

    private void setupEnemy() {
        this.enemies = new ArrayList<>();
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void renderBackground() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        renderBackground();
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.stars.forEach(star -> star.render(graphics));
        if(this.player.x[0]!=1800)
            this.player.render(graphics);
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

