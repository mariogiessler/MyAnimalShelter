package view.sites;

import javax.swing.*;
import java.awt.*;

// initalize the mainframe
// The reffered Object is designed in a singleton way

public class UserWindow extends JFrame {

    private static UserWindow window;

    private JPanel centerContent = new JPanel();

    private UserWindow() {
        setTitle("Tierheim Moabit");
        setLayout(new BorderLayout());
        setSize(1200, 800);

        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    // singleton: to make only one instance of this object possible
    public static UserWindow getInstance() {
        if (window == null) {
            window = new UserWindow();
        }
        return window;
    }
}
