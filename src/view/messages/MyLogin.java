package view.messages;

import view.styles.MyButton;
import view.styles.MyLabel;
import view.styles.MyTextField;
import view.styles.Styles;
import view.styles.Styles.MyBorder;

import javax.swing.*;
import java.awt.*;

// custom loginmessage
// The reffered Object is designed in a singleton way

public class MyLogin extends MyDialog {

    private static MyLogin login;
    private static MyTextField name;
    private static JPasswordField pass;

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
        name = new MyTextField();
        rowOne.add(nameLabel);
        rowOne.add(name);

        MyLabel passLabel = new MyLabel("Passwort :");
        passLabel.setPreferredSize(new Dimension(200, 30));
        passLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        pass = new JPasswordField();
        pass.setPreferredSize(new Dimension(300, 30));
        pass.setFont(Styles.MyFont.MainText.getValue());
        pass.setBackground(Styles.MyColor.ValueFieldColor.getValue());
        rowTwo.add(passLabel);
        rowTwo.add(pass);

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(3, 1));
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
    }

    public static String[] returnLoginData() {
        return new String[]{name.getText(), String.valueOf(pass.getPassword())};
    }

    // singleton: to make only one instance of this object possible
    public static MyLogin getInstance() {
        if (login == null) {
            login = new MyLogin();
        }
        return login;
    }

    // remove this messageframe to be ready for the garbage
    // to show message in a further way
    public static void removeLogin() {
        login = null;
    }
}
