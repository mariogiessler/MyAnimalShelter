package view.styles;

import view.styles.Styles;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {

    public MyLabel(){
       setPreferredSize(new Dimension(50, 30));
    }

    public MyLabel(String text) {
        super(text);
        setPreferredSize(new Dimension(150, 30));
        setFont(Styles.MyFont.MainText.getValue());
        setHorizontalAlignment(SwingConstants.RIGHT);
    }
}
