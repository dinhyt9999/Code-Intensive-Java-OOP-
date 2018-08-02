package CId3;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    private Background background = new Background();
    public Player player;
    private BufferedImage backBuffered;
    private Graphics graphics;
    private CreatStar creatStar = new CreatStar();
    private CreatEnemy creatEnemy = new CreatEnemy();
    private CreatEnemyFollow creatEnemyFollow = new CreatEnemyFollow();

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(200, 300);
        this.player.velocity.set(2.5f, 0);
    }

    public void runAll() {
        this.creatStar.run();
        if (this.creatStar.stars.size() > 100) {
            this.creatStar.stars.remove(0);
        }
        this.creatEnemy.run();
        if (this.creatEnemy.enemies.size() > 10) {
            this.creatEnemy.enemies.remove(0);
        }
        this.creatEnemyFollow.run();
        this.creatEnemyFollow.updateVelocity(this.player.position);
        this.player.run();
    }

    public GameCanvas() {
        this.setSize(1024, 600);
        setupBackBuffered();
        setupCharacter();
        this.setVisible(true);
    }

    private void setupCharacter() {
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
        this.creatStar.render(graphics);
        this.creatEnemy.render(graphics);
        this.creatEnemyFollow.render(graphics);
        this.player.render(graphics);
        this.repaint();
    }

}