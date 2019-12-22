package view.styles;

import javax.swing.*;
import java.awt.*;

// design all textfields for the programm in a custom way

public class MyTextField extends JTextField {
    public MyTextField() {
        setPreferredSize(new Dimension(300, 30));
        setFont(Styles.MyFont.MainText.getValue());
        setBackground(Styles.MyColor.ValueFieldColor.getValue());
    }
}
