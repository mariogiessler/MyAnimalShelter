package View;

import Control.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {
    private static final long serialVersionUID = 1L;

    private JButton[] buttons = {new JButton("Übersicht"), new JButton("Neues Tierchen"), new JButton("Beenden")};

    public Footer() {
        setLayout(new GridLayout(1, 3));
        for (JButton button : buttons) {
            button.setFocusPainted(false);
            button.addActionListener(ButtonListener.instance);
            button.setBorder(BorderFactory.createRaisedBevelBorder());
            button.setPreferredSize(new Dimension(0, 50));
            button.setFont(Styles.MyFont.ButtonText.getValue());
            button.setBackground(Styles.MyColor.ButtonColor.getValue());
            button.setForeground(Styles.MyColor.HeaderColor.getValue());
            add(button);
        }
    }

}
