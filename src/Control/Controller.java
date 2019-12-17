package Control;

import View.Center;
import View.UserWindow;

public class Controller {
    private static UserWindow window;

    public static void main(String[] args) {
        window = new UserWindow();
    }

    public static void changeView() {
        Center.setCenterForm();
        window.validate();
        window.repaint();
    }

    public static void setFramePosition(int mouseX, int mouseY) {
        window.setLocation(mouseX, mouseY);
    }

    public static UserWindow getFrame() {
        return window;
    }
}
