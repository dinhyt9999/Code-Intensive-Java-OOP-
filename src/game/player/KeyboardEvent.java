package game.player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardEvent implements KeyListener {
    public int angle;
    public float coefficient;
    static public KeyBoardEvent instance = new KeyBoardEvent();
    private KeyBoardEvent(){
        this.angle = 0;
        this.coefficient = 1;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.coefficient = 1;
        if(e.getKeyCode() == KeyEvent.VK_A){
            angle += 5;
        }
        if (e.getKeyCode()==KeyEvent.VK_D){
            angle -= 5;
        }
        if(e.getKeyCode()==KeyEvent.VK_W){
            coefficient = 2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            coefficient = 1;
        }
    }
}
