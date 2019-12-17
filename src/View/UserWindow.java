package View;

import javax.swing.*;
import java.awt.*;

public class UserWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    public static Center center;

    private JPanel centerContent=new JPanel();
    public UserWindow() {
        setFrame();
        setHeader();
        setCenter();
        setFooter();

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void setFrame() {
        setLayout(new BorderLayout());
        setUndecorated(true);
        setTitle("Tierheim Moabit");
        setSize(1200, 800);
    }

    private void setHeader() {
        add(new Header(),BorderLayout.PAGE_START);
    }

    private void setCenter() {
        add(new Center(),BorderLayout.CENTER);
    }

    private void setFooter() {
        add(new Footer(),BorderLayout.PAGE_END);
    }
}
