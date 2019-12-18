package view;

import controll.Controller;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {
    private static final long serialVersionUID = 1L;
    private static Footer footer;

    private JButton[] buttons = {new JButton("Übersicht"), new JButton("Neues Tierchen"), new JButton("Beenden")};

    private Footer() {
        setLayout(new GridLayout(1, 3));
        for (JButton button : buttons) {
            button.setFocusPainted(false);
            button.addActionListener(Controller.getButtonListener());
            button.setBorder(BorderFactory.createRaisedBevelBorder());
            button.setPreferredSize(new Dimension(0, 50));
            button.setFont(Styles.MyFont.ButtonText.getValue());
            button.setBackground(Styles.MyColor.ButtonColor.getValue());
            button.setForeground(Styles.MyColor.HeaderColor.getValue());
            add(button);

            Cursor c = getToolkit().createCustomCursor(new ImageIcon("res/cursor/turtle.png").getImage(), new Point(10, 10), "Cursor");
            setCursor(c);
        }
    }

    public static Footer getInstance() {
        if (footer == null) {
            footer = new Footer();
        }
        return footer;
    }

}
