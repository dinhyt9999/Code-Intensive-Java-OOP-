package CId3;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    private BufferedImage starImage;
    private BufferedImage circleImage;
    private BufferedImage backBuffered;
    public int positionXEnemy = 600;
    public int positionYEnemy = 400;
    public int positionXStar = 1024;
    public int positionYStar = 100;
    public int positionXPlayer = 670;
    public int positionYPlayer = 400;
    private Graphics graphics;
    public GameCanvas(){

        this.setSize(1024, 600);
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
        //B1: load images
        try {
            this.starImage = ImageIO.read(new File("resources-rocket-master/resources-rocket-master/resources/images/star.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.circleImage = ImageIO.read(new File("resources-rocket-master/resources-rocket-master/resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //B2: draw
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //nơi vẽ gameCanvas
        g.drawImage(this.backBuffered, 0, 0, null);
    }
    public void renderAll(){
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,1024,600);
        graphics.drawImage(this.starImage, positionXStar, positionYStar, 10, 10, null);
        graphics.drawImage(this.circleImage, positionXPlayer, positionYPlayer, 25, 25, null);
        graphics.drawImage(this.circleImage, positionXEnemy,positionYEnemy, 15, 15, null);
        this.repaint();
    }
}
