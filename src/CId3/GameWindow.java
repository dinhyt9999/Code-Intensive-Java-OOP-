package CId3;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindow extends JFrame {
    private long lastTime=0;
    private GameCanvas gameCanvas;

    public GameWindow(){
        Random random = new Random();
        this.setSize(1024, 600);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(60);
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_LEFT)||(e.getKeyCode() == KeyEvent.VK_A)){
                    gameCanvas.positionXPlayer = gameCanvas.positionXPlayer-10;
                    if(gameCanvas.positionXPlayer <=0){
                        gameCanvas.positionYPlayer = random.nextInt(590);
                        gameCanvas.positionXPlayer = 1024;
                    }
                }
                if ((e.getKeyCode() == KeyEvent.VK_RIGHT)||(e.getKeyCode() == KeyEvent.VK_D)){
                    gameCanvas.positionXPlayer = gameCanvas.positionXPlayer+10;
                    if(gameCanvas.positionXPlayer >=1024){
                        gameCanvas.positionYPlayer = random.nextInt(590);
                        gameCanvas.positionXPlayer = 0;
                    }
                }
                if ((e.getKeyCode() == KeyEvent.VK_UP)||(e.getKeyCode() == KeyEvent.VK_W)){
                    gameCanvas.positionYPlayer = gameCanvas.positionYPlayer-10;
                    if (gameCanvas.positionYPlayer <= 0)
                    {
                        gameCanvas.positionXPlayer = random.nextInt(1014);
                        gameCanvas.positionYPlayer = 600;
                    }
                }
                if ((e.getKeyCode() == KeyEvent.VK_DOWN)||(e.getKeyCode() == KeyEvent.VK_S)){
                    gameCanvas.positionYPlayer = gameCanvas.positionYPlayer+10;
                    if(gameCanvas.positionYPlayer >= 600){
                        gameCanvas.positionXPlayer = random.nextInt(1014);
                        gameCanvas.positionYPlayer = 0;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setVisible(true);
    }
    public void gameLoop(){
        int tempX=gameCanvas.positionXEnemy;
        int tempY=gameCanvas.positionYEnemy;
        while(true){
            long currentTime = System.nanoTime(); //số nano giây từ 1/1/1970 đến bây giờ
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.positionXStar = (this.gameCanvas.positionXStar+4)%1800;
                //this.gameCanvas.positionYStar = (this.gameCanvas.positionYStar+996)%1000;
                if (tempX <= -1024)
                    tempX = 1020;
                else tempX -= 4;
                if (tempY <= -600)
                    tempY = 596;
                else tempY -= 4;
                this.gameCanvas.positionXEnemy = Math.abs(tempX)%1024;
                this.gameCanvas.positionYEnemy = Math.abs(tempY)%600;
                this.gameCanvas.renderAll();
                lastTime = currentTime;
            }
        }
    }
}
