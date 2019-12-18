package controll;

import view.ViewManager;

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
        ViewManager.setFramePosition(mousePositionX - startDistanceX, mousePositionY - startDistanceY);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        startDistanceX = (int) (mouseEvent.getLocationOnScreen().getX() - ViewManager.getFrame().getLocationOnScreen().getX());
        startDistanceY = (int) (mouseEvent.getLocationOnScreen().getY() - ViewManager.getFrame().getLocationOnScreen().getY());
        ViewManager.getFrame().getLocationOnScreen().getX();
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
