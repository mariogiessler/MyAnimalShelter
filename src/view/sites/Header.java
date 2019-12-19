package view.sites;

import controll.FrameMoveListener;
import view.styles.Styles.MyBorder;
import view.styles.Styles.MyColor;
import view.styles.Styles.MyFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Header extends JPanel {
    private static final long serialVersionUID = 1L;
    private static Header header;
    private static String dateString;

    private Header() {
        setLayout(new BorderLayout());
        setBackground(MyColor.HeaderColor.getValue());
        setPreferredSize(new Dimension(0, 120));

        dateString = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT));
        JLabel date = new JLabel(dateString);

        JLabel welcome = new JLabel("Willkommen im Tierheim Moabit");
        welcome.setFont(MyFont.HeadText.getValue());
        welcome.setForeground(MyColor.TextColor.getValue());
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setBorder(MyBorder.HeadBorder.getValue());

        add(welcome, BorderLayout.PAGE_START);

        date.setFont(MyFont.SubText.getValue());
        date.setForeground(MyColor.TextColor.getValue());
        date.setHorizontalAlignment(SwingConstants.CENTER);
        date.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        add(date, BorderLayout.PAGE_END);

        setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));

        new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateString = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT));
                date.setText(dateString);
                revalidate();
            }

        }).start();


        addMouseMotionListener(FrameMoveListener.instance);
        addMouseListener(FrameMoveListener.instance);
    }


    public static Header getInstance() {
        if (header == null) {
            header = new Header();
        }
        return header;
    }
}
