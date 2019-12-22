package view.styles;

import view.styles.Styles.MyColor;

import javax.swing.*;
import java.awt.*;

// design all labels for the programm in a custom way

public class MyLabel extends JLabel {

    public MyLabel() {
        setPreferredSize(new Dimension(50, 30));
    }

    public MyLabel(String text) {
        super(text);
        setPreferredSize(new Dimension(150, 30));
        setFont(Styles.MyFont.MainText.getValue());
        setForeground(MyColor.TextColor.getValue());
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
