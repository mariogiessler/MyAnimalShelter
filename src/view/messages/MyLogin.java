package view.messages;

import controll.Controller;
import view.styles.MyButton;
import view.styles.MyLabel;
import view.styles.MyTextField;
import view.styles.Styles;
import view.styles.Styles.MyFont;

import javax.swing.*;
import java.awt.*;

public class MyLogin extends MyDialog {
    private static MyLogin login;

    private MyLogin() {
        super("login");
        JLabel headLine = new JLabel("Bitte geben Sie Ihre Benutzerdaten ein:");

        MyLabel nameLabel = new MyLabel("Benutzername :");
        nameLabel.setPreferredSize(new Dimension(200, 30));
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        MyTextField name = new MyTextField();
        getRowOne().add(nameLabel);
        getRowOne().add(name);

        MyLabel passLabel = new MyLabel("Passwort :");
        passLabel.setPreferredSize(new Dimension(200, 30));
        passLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JPasswordField pass = new JPasswordField();
        pass.setPreferredSize(new Dimension(300, 30));
        pass.setFont(Styles.MyFont.MainText.getValue());
        pass.addFocusListener(Controller.getFieldListener());
        pass.setBackground(Styles.MyColor.ValueFieldColor.getValue());
        getRowTwo().add(passLabel);
        getRowTwo().add(pass);

        MyButton exitButton = new MyButton("Abbr.");
        MyButton confirmButton = new MyButton("OK");
        getButton().add(confirmButton);
        getButton().add(exitButton);
        revalidate();
        repaint();
    }

    public static MyLogin getInstance() {
        if (login == null) {
            login = new MyLogin();
        } else if (!login.isValid()) {
            login = new MyLogin();
        }
        return login;
    }
}
