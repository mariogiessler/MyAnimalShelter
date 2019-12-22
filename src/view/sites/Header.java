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

// showing the header for the whole programm
// The reffered Object is designed in a singleton way

public class Header extends JPanel {

    private static Header header;
    private static String dateString;

    private Header() {
        setLayout(new BorderLayout());
        setBackground(MyColor.HeaderColor.getValue());
        setPreferredSize(new Dimension(0, 120));

        dateString = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT));
        JLabel date = new JLabel(dateString);

        JLabel welcome = new JLabel("Willkommen im Tierheim \"Animal Shelter\"");
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

        // setting a custom Cursor
        setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));

        // actualize the timefield in the header
        new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateString = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT));
                date.setText(dateString);
                revalidate();
            }

        }).start();

        // adding the frameMoveListener for dragging this frame
        addMouseMotionListener(FrameMoveListener.getInstance());
        addMouseListener(FrameMoveListener.getInstance());
    }

    // singleton: to make only one instance of this object possible
    public static Header getInstance() {
        if (header == null) {
            header = new Header();
        }
        return header;
    }
}
