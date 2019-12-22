package view.messages;

import view.sites.UserWindow;
import view.styles.MyLabel;
import view.styles.Styles;
import view.styles.Styles.MyBorder;
import view.styles.Styles.MyColor;
import view.styles.Styles.MyFont;

import javax.swing.*;
import java.awt.*;

// parent for all messages (whit and witout input)
// i chose a package visibility, because i wont refer this class to any others, except childrens


class MyDialog extends JFrame {

    private JPanel button, main, content;

    MyDialog() {
        super("Message");
    }

    MyDialog(String title) {
        setUndecorated(true);
        setSize(600, 300);
        setLayout(new BorderLayout());
        setBackground(Styles.MyColor.PopUpColor.getValue());

        main = new JPanel();
        main.setLayout(new BorderLayout());
        main.setBackground(MyColor.PopUpColor.getValue());

        JPanel header = new JPanel();
        header.setOpaque(false);

        MyLabel headLabel = new MyLabel(title);
        headLabel.setFont(MyFont.SubText.getValue());
        headLabel.setPreferredSize(new Dimension(580, 40));
        headLabel.setBackground(MyColor.ButtonColor.getValue());
        headLabel.setForeground(MyColor.HeaderColor.getValue());
        headLabel.setHorizontalAlignment(SwingConstants.LEFT);
        headLabel.setBorder(MyBorder.PopUpInvisibleBorder.getValue());
        headLabel.setOpaque(true);

        header.add(headLabel);
        main.add(header, BorderLayout.PAGE_START);

        content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setOpaque(false);

        button = new JPanel();
        button.setOpaque(false);

        main.setBorder(MyBorder.MessageBorder.getValue());
        main.add(content, BorderLayout.CENTER);
        main.add(button, BorderLayout.PAGE_END);

        add(main);
        setVisible(true);
        setLocationRelativeTo(UserWindow.getInstance());

        // setting a custom Cursor
        Cursor c = getToolkit().createCustomCursor(new ImageIcon("res/cursor/turtle.png").getImage(), new Point(0, 0), "Cursor");
        setCursor(c);
    }

    // getter for all Mesages
    JPanel getContent() {
        return content;
    }

    JPanel getButton() {
        return button;
    }
}
