package view.styles;

import controll.Controller;
import view.styles.Styles.MyColor;
import view.styles.Styles.MyFont;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

// design all buttons for the programm in a custom way

public class MyButton extends JButton {

    public MyButton(String text) {
        super(text);
        setFocusPainted(false);
        addActionListener(Controller.getButtonListener());
        setBorder(BorderFactory.createRaisedBevelBorder());
        setPreferredSize(new Dimension(150, 50));
        setFont(MyFont.ButtonText.getValue());
        setBackground(MyColor.ButtonColor.getValue());
        setForeground(MyColor.HeaderColor.getValue());
        addFocusListener(focusListener);

        // listen ENTER-key on Button
        getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "DoClick");
        getActionMap().put("DoClick", action);

        // change Hover-Color for Button
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent evt) {
                if (getModel().isRollover()) {
                    setBackground(MyColor.ButtonColor.getValue().brighter());
                } else {
                    setBackground(MyColor.ButtonColor.getValue());
                }
            }
        });

        // set Background for pressed Button
        UIManager.put("Button.select", MyColor.ButtonClickedColor.getValue());
    }

    Color oldFColor, oldBColor;

    // chance Hover-Color and focus of Button on entering the TAB-key
    private FocusListener focusListener = new FocusListener() {

        @Override
        public void focusGained(FocusEvent e) {
            setBackground(Styles.MyColor.ButtonColor.getValue().brighter());
        }

        @Override
        public void focusLost(FocusEvent e) {
            setBackground(Styles.MyColor.ButtonColor.getValue());
        }
    };

    // click Button on ENTER-key
    AbstractAction action = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                JButton button = (JButton) e.getSource();
                button.doClick();
            }
        }
    };
}
