package view.styles;

import controll.Controller;
import view.styles.Styles;

import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField {
    public MyTextField(){
        setPreferredSize(new Dimension(300, 30));
        setFont(Styles.MyFont.MainText.getValue());
        setBackground(Styles.MyColor.ValueFieldColor.getValue());
    }
}
