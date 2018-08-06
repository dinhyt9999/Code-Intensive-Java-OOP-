package CId3;

import base.Vector2D;
import game.player.KeyBoardEvent;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    private long lastTime = 0;
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

    private void keyboardEvent(){
        this.addKeyListener(KeyBoardEvent.instance);
    }
//    private void keyboardEvent() {
//        this.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                if(e.getKeyCode()==KeyEvent.VK_W){
//                    gameCanvas.player.velocity.multiply(3);
//                }
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                gameCanvas.player.velocity.set(new Vector2D(2.5f,0 ).rotate(gameCanvas.player.angle));
//                if (e.getKeyCode() == KeyEvent.VK_A) {
//                    gameCanvas.player.angle += 5;
//                }
//                if (e.getKeyCode() == KeyEvent.VK_D) {
//                    gameCanvas.player.angle -= 5;
//                }
//                if (e.getKeyCode() == KeyEvent.VK_W) {
//                    gameCanvas.player.velocity.multiply(2.5f);
//                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                if(e.getKeyCode() == KeyEvent.VK_W){
//                    gameCanvas.player.velocity.set(new Vector2D(2.5f,0).rotate(gameCanvas.player.angle));
//                }
//
//            }
//        });
//    }

    private void mouseEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(60);
            }
        });
    }

    private void event() {
        this.mouseEvent();
        this.keyboardEvent();
    }

    public void gameLoop() {
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
