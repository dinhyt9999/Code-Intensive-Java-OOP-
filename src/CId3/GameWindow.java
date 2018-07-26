package CId3;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindow extends JFrame {
    private long lastTime = 0;
    private Random random = new Random();
    private GameCanvas gameCanvas;

    public GameWindow() {
        this.setSize(1024, 600);
        setupGameCanvas();
        event();
        this.setVisible(true);
    }

    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void playerMove() {
        if (gameCanvas.player.x[0] < 0)
            gameCanvas.player.x[0] = 1000;
        if (gameCanvas.player.x[0] > 1000)
            gameCanvas.player.x[0] = 0;
        if (gameCanvas.player.y[0] < 21)
            gameCanvas.player.y[0] = 600;
        if (gameCanvas.player.y[0] > 600)
            gameCanvas.player.y[0] = 21;
    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    gameCanvas.player.x[0] -= gameCanvas.player.valocity;
                    playerMove();
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    gameCanvas.player.x[0] += gameCanvas.player.valocity;
                    playerMove();
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    gameCanvas.player.y[0] -= gameCanvas.player.valocity;
                    playerMove();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    gameCanvas.player.y[0] += gameCanvas.player.valocity;
                    playerMove();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

        private void mouseEvent () {
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(60);
                }
            });
        }

        private void event () {
            this.mouseEvent();
            this.keyboardEvent();
        }

        public void gameLoop () {
            while (true) {
                long currentTime = System.nanoTime();
                if (currentTime - this.lastTime >= 17_000_000) {
                    this.gameCanvas.runAll();
                    this.gameCanvas.renderAll();
                    lastTime = currentTime;
                }
            }
        }
    }
