package Control;

import View.UserWindow;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class FrameMoveListener implements MouseListener, MouseMotionListener {
    private static int startDistanceX, startDistanceY;

    public static FrameMoveListener instance = new FrameMoveListener();

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        int mousePositionX = (int) mouseEvent.getLocationOnScreen().getX();
        int mousePositionY = (int) mouseEvent.getLocationOnScreen().getY();
        Controller.setFramePosition(startDistanceX, startDistanceY, mousePositionX, mousePositionY);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        startDistanceX = (int) ((int) mouseEvent.getLocationOnScreen().getX() - Controller.getFrame().getLocationOnScreen().getX());
        Controller.getFrame().getLocationOnScreen().getX();
        startDistanceY = (int) ((int) mouseEvent.getLocationOnScreen().getY() - Controller.getFrame().getLocationOnScreen().getY());
        ;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
