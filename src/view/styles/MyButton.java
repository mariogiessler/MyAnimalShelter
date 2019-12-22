package view.styles;

import controll.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// design all buttons for the programm in a custom way

public class MyButton extends JButton {

    public MyButton(String text) {
        super(text);
        setFocusPainted(false);
        addActionListener(Controller.getButtonListener());
        setBorder(BorderFactory.createRaisedBevelBorder());
        setPreferredSize(new Dimension(150, 50));
        setFont(Styles.MyFont.ButtonText.getValue());
        setBackground(Styles.MyColor.ButtonColor.getValue());
        setForeground(Styles.MyColor.HeaderColor.getValue());
    }
}
