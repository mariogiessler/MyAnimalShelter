package view;

import javax.swing.*;
import java.awt.*;

public class ViewManager {
    private static UserWindow window;

    public static void init() {
        window = UserWindow.getInstance();
        setHeader();
        setCenter();
        setFooter();
        window.setVisible(true);
    }

    private static void setHeader() {
        window.add(Header.getInstance(), BorderLayout.PAGE_START);

    }

    private static void setCenter() {
        window.add(Center.getInstance(), BorderLayout.CENTER);
        Welcome.getInstance();
    }

    public static void setCenterForm() {
        Center.getInstance().removeAll();
        Center.getInstance().add(Form.getInstance(), BorderLayout.CENTER);
        window.repaint();
        window.revalidate();
    }

    public static void setCenterTable() {
        Center.getInstance().removeAll();
        Center.getInstance().add(Table.getInstance());
        window.revalidate();
    }

    public static void login(){
        Login.getInstance();
    }

    private static void setFooter() {
        window.add(Footer.getInstance(), BorderLayout.PAGE_END);
    }

    public static void clearForm() {
        for (JTextField field : Form.getInstance().getFields()) {
            field.setText("");
        }
    }

    public static void setFramePosition(int mouseX, int mouseY) {
        window.setLocation(mouseX, mouseY);
    }

    public static UserWindow getFrame() {
        return window;
    }

    public static void displayConfirm() {
        JOptionPane.showMessageDialog(window, "Tier wurde erfolgreich hinzugefügt!");
    }

    public static void displayFail() {
        JOptionPane.showMessageDialog(window, "Das hat leider nicht funktioniert.");
    }
}
