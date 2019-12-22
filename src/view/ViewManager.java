package view;

import view.messages.MyConfirmMessage;
import view.messages.MyLogin;
import view.messages.MyLoginFailMessage;
import view.messages.MyNewInputFailMessage;
import view.sites.*;

import javax.swing.*;
import java.awt.*;

// central controll for the view
// this is choose abstract to make sure of having no instance,
// because of only static methods and no objects

public abstract class ViewManager {
    private static UserWindow window;

    // initalize frame
    public static void init() {
        window = UserWindow.getInstance();
        setHeader();
        setCenter();
        setFooter();
        window.setVisible(true);
    }

    // changing content
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

    public static void setHome() {
        Center.getInstance().removeAll();
        Welcome.getInstance();
        window.revalidate();
    }

    private static void setFooter() {
        window.add(Footer.getInstance(), BorderLayout.PAGE_END);
    }

    // clearing the formfields
    public static void clearForm() {
        for (JTextField field : Form.getInstance().getFields()) {
            field.setText("");
        }
    }

    // display messages
    public static void displayLogin() {
        MyLogin.getInstance();
    }

    public static void displayConfirm() {
        MyConfirmMessage.getInstance().validate();
        MyConfirmMessage.getInstance().setVisible(true);
    }

    public static void displayFail() {
        MyNewInputFailMessage.getInstance();
    }

    public static void displayLoginFail() {
        MyLoginFailMessage.getInstance();
    }

    // set frame position, to make it draggable
    public static void setFramePosition(int mouseX, int mouseY) {
        window.setLocation(mouseX, mouseY);
    }

    // getter for the frame
    public static UserWindow getFrame() {
        return window;
    }
}
