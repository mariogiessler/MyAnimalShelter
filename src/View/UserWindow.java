package View;

import Control.ButtonListener;
import Control.FrameMoveListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import View.Styles.*;

public class UserWindow extends JFrame {

    private static final long serialVersionUID = 1L;

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
