package view.sites;

import view.styles.MyButton;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {
    private static final long serialVersionUID = 1L;
    private static Footer footer;

    private MyButton[] buttons = {new MyButton("Übersicht"), new MyButton("Neues Tierchen"), new MyButton("Beenden")};

    private Footer() {
        setLayout(new GridLayout(1, 3));
        for (MyButton button : buttons) {
            add(button);
        }

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
