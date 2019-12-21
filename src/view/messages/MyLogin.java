package view.messages;

import controll.Controller;
import view.styles.MyButton;
import view.styles.MyLabel;
import view.styles.MyTextField;
import view.styles.Styles;
import view.styles.Styles.MyBorder;

import javax.swing.*;
import java.awt.*;

public class MyLogin extends MyDialog {
    private static MyLogin login;

    private MyLogin() {
        super("Ameldung zur Datenbank !");

        MyLabel headLine = new MyLabel("Bitte geben Sie Ihre Benutzerdaten ein:");
        JPanel rowOne = new JPanel();
        JPanel rowTwo = new JPanel();

        rowOne.setOpaque(false);
        rowTwo.setOpaque(false);

        MyLabel nameLabel = new MyLabel("Benutzername :");
        nameLabel.setPreferredSize(new Dimension(200, 30));
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        MyTextField name = new MyTextField();
        rowOne.add(nameLabel);
        rowOne.add(name);

        MyLabel passLabel = new MyLabel("Passwort :");
        passLabel.setPreferredSize(new Dimension(200, 30));
        passLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JPasswordField pass = new JPasswordField();
        pass.setPreferredSize(new Dimension(300, 30));
        pass.setFont(Styles.MyFont.MainText.getValue());
        pass.addFocusListener(Controller.getFieldListener());
        pass.setBackground(Styles.MyColor.ValueFieldColor.getValue());
        rowTwo.add(passLabel);
        rowTwo.add(pass);

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(3,1));
        content.add(headLine);
        content.add(rowOne);
        content.add(rowTwo);

        content.setOpaque(false);
        content.setBorder(MyBorder.PopUpInvisibleBorder.getValue());

        getContent().add(content);

        MyButton cancelButton = new MyButton("Abbr.");
        cancelButton.setName("loginCancel");
        MyButton confirmButton = new MyButton("OK");
        confirmButton.setName("loginOK");
        getButton().add(confirmButton);
        getButton().add(cancelButton);
        revalidate();
        repaint();
    }

    public static MyLogin getInstance() {
        if (login == null) {
            login = new MyLogin();
        }
        return login;
    }

    public static void removeLogin() {
        login = null;
    }
}
