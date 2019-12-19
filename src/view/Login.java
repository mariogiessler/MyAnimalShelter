package view;

import controll.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Login extends JFrame {
    private static Login login;

    private Login() {
        super("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 200);

        JPanel main = new JPanel();
        main.setLayout(new GridLayout(3, 2));
        main.setOpaque(false);

        Border bevelBorder = BorderFactory.createLoweredBevelBorder();
        Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        Border compount = BorderFactory.createCompoundBorder(emptyBorder, bevelBorder);
        JLabel nameLabel = new JLabel("Benutzername :");
        nameLabel.setPreferredSize(new Dimension(150, 30));
        nameLabel.setFont(Styles.MyFont.MainText.getValue());
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        nameLabel.setBorder(emptyBorder);
        main.add(nameLabel);

        JTextField name = new JTextField();
        name.setPreferredSize(new Dimension(300, 20));
        name.setFont(Styles.MyFont.MainText.getValue());
        name.addFocusListener(Controller.getFieldListener());
        name.setBackground(Styles.MyColor.ValueFieldColor.getValue());
        main.add(name);

        JLabel passLabel = new JLabel("Passwort :");
        passLabel.setPreferredSize(new Dimension(150, 20));
        passLabel.setFont(Styles.MyFont.MainText.getValue());
        passLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passLabel.setBorder(emptyBorder);
        main.add(passLabel);

        JPasswordField pass = new JPasswordField(10);
        pass.setPreferredSize(new Dimension(300, 20));
        pass.setFont(Styles.MyFont.MainText.getValue());
        pass.addFocusListener(Controller.getFieldListener());
        pass.setBackground(Styles.MyColor.ValueFieldColor.getValue());
        main.add(pass);

        JButton exit = new JButton("Abbr.");
        exit.setFocusPainted(false);
        exit.addActionListener(Controller.getButtonListener());
        exit.setBorder(BorderFactory.createRaisedBevelBorder());
        exit.setPreferredSize(new Dimension(0, 20));
        exit.setFont(Styles.MyFont.ButtonText.getValue());
        exit.setBackground(Styles.MyColor.ButtonColor.getValue());
        exit.setForeground(Styles.MyColor.HeaderColor.getValue());
        main.add(exit);

        JButton confirm = new JButton("OK");
        confirm.setFocusPainted(false);
        confirm.addActionListener(Controller.getButtonListener());
        confirm.setBorder(BorderFactory.createRaisedBevelBorder());
        confirm.setPreferredSize(new Dimension(0, 20));
        confirm.setFont(Styles.MyFont.ButtonText.getValue());
        confirm.setBackground(Styles.MyColor.ButtonColor.getValue());
        confirm.setForeground(Styles.MyColor.HeaderColor.getValue());
        main.add(confirm);

        main.setBorder(compount);
        add(main);

        setVisible(true);
        setLocationRelativeTo(null);
    }


    public static Login getInstance() {
        if (login == null) {
            login = new Login();
        } else if (!login.isValid()) {
            login = new Login();
        }
        return login;
    }
}
