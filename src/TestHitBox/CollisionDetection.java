package TestHitBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class CollisionDetection extends JPanel implements ActionListener {
    private MyCharacter myChar;
    private Circle circle;
    private Enemy enemy;
    private final int DELAY = 10;
    private Timer timer;

    public CollisionDetection() {
        myChar = new MyCharacter(50, 50, 50, 50);
        enemy = new Enemy(100, 100, 50, 50);
        addMouseMotionListener(new MyAdapter());
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(circle.getX() - circle.getRadius(), circle.getY() - circle.getRadius(), circle.getRadius() * 2, circle.getRadius() * 2);
        g.drawRect(myChar.getX(), myChar.getY(), myChar.getWidth(), myChar.getHeight());
        g.drawOval(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkCollision();
        if (checkColiision(myChar.getBound(), circle)) {
            System.out.println("Hinh chu nhat va cham hinh tron");
        }
        myChar.move();
        repaint();
    }

    public void checkCollision() {
        Rectangle myCharBound = myChar.getBound();
        Rectangle enemyBound = enemy.getBound();
        if (myCharBound.intersects(enemyBound)) {
            System.out.println("Va cham");
        }
    }

    private class MyAdapter extends MouseMotionAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            myChar.mouseMoved(e);
        }
    }

    public boolean checkColiision(Rectangle rect, Circle cir) {
        int rectLeft = (int) rect.getX();
        int rectRight = (int) (rect.getX() + rect.getWidth());
        int rectTop = (int) rect.getY();
        int rectBottom = (int) (rect.getY() + rect.getHeight());

        int xC = cir.getX();
        int yC = cir.getY();
        int xA = xC;
        int yA = yC;

        if (xC < rectLeft) {
            xA = rectLeft;
        } else if (xC > rectRight) {
            xA = rectRight;
        }

        if (yC < rectTop) {
            yA = rectTop;
        } else if (yC > rectBottom) {
            yA = rectBottom;
        }
        int dx = xA - xC;
        int dy = yA - yC;
        return (dx * dx + dy * dy) <= cir.getRadius() * cir.getRadius();
    }
}
