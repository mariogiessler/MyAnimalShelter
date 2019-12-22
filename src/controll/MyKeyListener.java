package controll;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent keyEvent) {
        System.out.println(keyEvent.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println(keyEvent.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
