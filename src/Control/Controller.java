package Control;

import Model.Mongo;
import View.Center;
import View.UserWindow;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class Controller {
    private static UserWindow window;
    private static HashMap<String, Object> formValues = new HashMap<>();

    public static void main(String[] args) {
        window = new UserWindow();
        new Mongo();
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

    public static HashMap<String, Object> getFormFields() {
        HashMap<String, Object> map = new HashMap<>();
        for (Component e : UserWindow.center.getComponents()) {
            System.out.println("Hier!!!");
            if (e.getName() != null) {
                System.out.println(e.getName());
                map.put(e.getName(), ((JTextField) e).getText());
            }
        }
        return map;
    }

    public static HashMap<String, Object> getFormValues() {
        return formValues;
    }
}
