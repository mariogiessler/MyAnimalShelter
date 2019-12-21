package view.sites;

import view.styles.MyButton;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {
    private static final long serialVersionUID = 1L;
    private static Footer footer;

    private Footer() {
        setLayout(new GridLayout(1, 4));

        MyButton button1 = new MyButton("Home");
        button1.setName("home");

        MyButton button2 = new MyButton("Übersicht");
        button2.setName("tableView");

        MyButton button3 = new MyButton("Neues Tierchen");
        button3.setName("newInput");

        MyButton button4= new MyButton("Beenden");
        button4.setName("exit");

        add(button1);
        add(button2);
        add(button3);
        add(button4);

        Cursor c = getToolkit().createCustomCursor(new ImageIcon("res/cursor/turtle.png").getImage(), new Point(10, 10), "Cursor");
        setCursor(c);
    }

    public static Footer getInstance() {
        if (footer == null) {
            footer = new Footer();
        }
        return footer;
    }

}
