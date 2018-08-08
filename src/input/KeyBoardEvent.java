package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardEvent implements KeyListener {
    public boolean isA = false;
    public boolean isW = false;
    public boolean isD = false;
    public boolean isSpace = false;
    static public KeyBoardEvent instance = new KeyBoardEvent();
    private KeyBoardEvent(){
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A){
            isA = true;
        }
        if (e.getKeyCode()==KeyEvent.VK_D){
            isD = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_W){
            isW = true;
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            isSpace = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            isW = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_D){
            isD = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_A){
            isA = false;
        }
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            isSpace = false;
        }
    }
}
