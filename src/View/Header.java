package View;

import Control.FrameMoveListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import View.Styles.MyFont;
import View.Styles.MyColor;

public class Header extends JPanel {
    private static final long serialVersionUID = 1L;

    private JLabel welcome = new JLabel("Willkommen im Tierheim Moabit");
    private String dateString = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT));
    private JLabel date = new JLabel(dateString);

    public Header() {
        setLayout(new BorderLayout());
        setBackground(MyColor.HeaderColor.getValue());
        setPreferredSize(new Dimension(0, 70));
        welcome.setFont(MyFont.HeadText.getValue());
        welcome.setForeground(MyColor.TextColor.getValue());
        welcome.setHorizontalAlignment(SwingConstants.CENTER);

        date.setFont(MyFont.SubText.getValue());
        date.setForeground(MyColor.TextColor.getValue());
        date.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcome, BorderLayout.PAGE_START);
        add(date, BorderLayout.PAGE_END);

        addMouseMotionListener(FrameMoveListener.instance);
        addMouseListener(FrameMoveListener.instance);
    }
}
