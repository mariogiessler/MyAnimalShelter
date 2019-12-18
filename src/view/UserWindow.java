package view;

import javax.swing.*;
import java.awt.*;

public class UserWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private static UserWindow window;

    private JPanel centerContent=new JPanel();

    private UserWindow() {
        setTitle("Tierheim Moabit");
        setLayout(new BorderLayout());
        setSize(1200, 800);

        setUndecorated(true);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static UserWindow getInstance() {
        if (window == null) {
            window = new UserWindow();
        }
        return window;
    }
}
