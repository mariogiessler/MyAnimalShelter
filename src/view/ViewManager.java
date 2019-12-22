package view;

import model.Database;
import view.messages.*;
import view.sites.*;
import view.styles.MyButton;

import javax.swing.*;
import java.awt.*;

// central controll for the view
// this is choose abstract to make sure of having no instance,
// because of only static methods and no objects

public abstract class ViewManager {
    private static UserWindow window;
    private static String input = "";

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
        Center.getInstance().add(Table.getInstance(Database.getAnimals(input), Form.getFormLabels()), BorderLayout.CENTER);

        MyButton searchButton = null;

        if (input.equals("")) {
            searchButton = new MyButton("Datenbank durchsuchen");
            searchButton.setName("search");

        } else {
            searchButton = new MyButton("komplette Datenbank anzeigen");
            searchButton.setName("tableAll");
        }
        searchButton.setPreferredSize(new Dimension(600, 30));

        Center.getInstance().add(searchButton, BorderLayout.PAGE_END);
        window.revalidate();
    }

    public static void setCenterTable(String in) {
        input = in;
        setCenterTable();
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

    public static String displaySearch() {
        MySearchInput.getInstance();
        return input;
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
