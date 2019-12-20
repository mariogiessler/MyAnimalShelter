package view.styles;

import view.styles.Styles;

import javax.swing.*;
import java.awt.*;
import view.styles.Styles.MyColor;

public class MyLabel extends JLabel {

    public MyLabel(){
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
