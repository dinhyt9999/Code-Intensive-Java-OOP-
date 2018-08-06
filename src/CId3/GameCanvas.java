package CId3;

import base.GameObject;
import base.GameObjectManager;
import game.background.Background;
import game.enemy.CreatEnemy;
import game.enemyfollow.CreatEnemyFollow;
import game.player.Player;
import game.star.CreatStar;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    public Player player;
    private BufferedImage backBuffered;
    private Graphics graphics;

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(200, 300);
        GameObjectManager.instance.add(player);
    }

    public void runAll() {
        GameObjectManager.instance.list.forEach(gameObject -> gameObject.updateVelocity());
        GameObjectManager.instance.runAll();
    }

    public GameCanvas() {
        this.setSize(1024, 600);
        setupBackBuffered();
        setupCharacter();
        this.setVisible(true);
    }

    private void setupCharacter() {
        GameObjectManager.instance.add(new Background());
        setupPlayer();
        GameObjectManager.instance.add(new CreatEnemyFollow());
        GameObjectManager.instance.add(new CreatStar());
        GameObjectManager.instance.add(new CreatEnemy());
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
        GameObjectManager.instance.renderAll(graphics);
        this.repaint();
    }
}