package controll;

import view.ViewManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// makes the mainframe movable
// The reffered Object is designed in a singleton way

public class FrameMoveListener implements MouseListener, MouseMotionListener {
    private static int startDistanceX, startDistanceY;

    private static FrameMoveListener frameMoveListener = new FrameMoveListener();

    private FrameMoveListener() {
    }

    // calculate new mainframe position while dragging the mouse
    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        int mousePositionX = (int) mouseEvent.getLocationOnScreen().getX();
        int mousePositionY = (int) mouseEvent.getLocationOnScreen().getY();

        // repositioning of the mainframe
        ViewManager.setFramePosition(mousePositionX - startDistanceX, mousePositionY - startDistanceY);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    // get the default position of the mainframe and put it into static fields.
    // this is done at the beginning of the move action
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

    // singleton: to make only one instance of this object possible
    public static FrameMoveListener getInstance() {
        if (frameMoveListener == null) {
            frameMoveListener = new FrameMoveListener();
        }
        return frameMoveListener;
    }
}
