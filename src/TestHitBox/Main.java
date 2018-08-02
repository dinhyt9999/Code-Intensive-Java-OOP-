package TestHitBox;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        add(new CollisionDetection());
        setTitle("Collision detection test");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }
}
