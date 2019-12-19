package view.sites;

import view.styles.Styles.MyBorder;
import view.styles.Styles.MyColor;

import javax.swing.*;
import java.awt.*;

public class Center extends JPanel {
    private static final long serialVersionUID = 1L;
    private static Center center;

    private Center() {
        setLayout(new BorderLayout());
        setBackground(MyColor.CenterColor.getValue());
        setBorder(MyBorder.DoubleCompountBorder.getValue());

        Cursor c = getToolkit().createCustomCursor(new ImageIcon("res/cursor/turtle.png").getImage(), new Point(0, 0), "Cursor");
        setCursor(c);
    }

    public static Center getInstance() {
        if (center == null) {
            center = new Center();
        }
        return center;
    }
}

