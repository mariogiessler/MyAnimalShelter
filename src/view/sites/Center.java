package view.sites;

import view.styles.Styles.MyBorder;
import view.styles.Styles.MyColor;

import javax.swing.*;
import java.awt.*;

// initialize the centerview
// The reffered Object is designed in a singleton way

public class Center extends JPanel {

    private static Center center;

    private Center() {
        setLayout(new BorderLayout());
        setBackground(MyColor.CenterColor.getValue());
        setBorder(MyBorder.DoubleCompountBorder.getValue());

        // setting a custom Cursor
        Cursor c = getToolkit().createCustomCursor(new ImageIcon("res/cursor/turtle.png").getImage(), new Point(0, 0), "Cursor");
        setCursor(c);
    }

    // singleton: to make only one instance of this object possible
    public static Center getInstance() {
        if (center == null) {
            center = new Center();
        }
        return center;
    }
}

