package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import view.Styles.MyColor;

public class Center extends JPanel {
    private static final long serialVersionUID = 1L;
    private static Center center;

    private Center() {
        setLayout(new BorderLayout());
        setBackground(MyColor.CenterColor.getValue());
        Border raised = BorderFactory.createRaisedBevelBorder();
        Border lowered = BorderFactory.createLoweredBevelBorder();
        Border compound = BorderFactory.createCompoundBorder(raised, lowered);
        Border invisible = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        Border border = BorderFactory.createCompoundBorder(invisible, compound);
        setBorder(border);

        Cursor c = getToolkit().createCustomCursor(new ImageIcon("res/cursor/turtle.png").getImage(), new Point(10, 10), "Cursor");
        setCursor(c);
    }

    public static Center getInstance() {
        if (center == null) {
            center = new Center();
        }
        return center;
    }
}

