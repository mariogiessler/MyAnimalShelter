package view.messages;

import view.styles.MyButton;
import view.styles.MyLabel;
import view.styles.Styles.MyFont;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// custom failmessage for loginmessage
// The reffered Object is designed in a singleton way


public class MyLoginFailMessage extends MyMessage {

    private static MyLoginFailMessage loginFailMessage;

    private MyLoginFailMessage() {
        super("Es ist ein Fehler aufgetreten !");

        MyLabel message1 = new MyLabel("Sie haben die falschen");
        message1.setPreferredSize(new Dimension(430, 30));
        message1.setFont(MyFont.PopUpText.getValue());
        getRowOne().add(message1);

        MyLabel message2 = new MyLabel("Login Daten angegeben!");
        message2.setPreferredSize(new Dimension(430, 30));
        message2.setFont(MyFont.PopUpText.getValue());
        getRowTwo().add(message2);

        // image for this message
        Image img = null;
        try {
            img = ImageIO.read(new File("res/pics/cat.png"));
        } catch (IOException e) {

        }
        img = img.getScaledInstance(94, 110, Image.SCALE_SMOOTH);

        getImage().add(new JLabel(new ImageIcon(img)));

        MyButton confirm = new MyButton("OK");
        confirm.setName("loginFailOK");
        getButton().add(confirm);
    }

    // singleton: to make only one instance of this object possible
    public static MyLoginFailMessage getInstance() {
        if (loginFailMessage == null) {
            loginFailMessage = new MyLoginFailMessage();
        }
        return loginFailMessage;
    }

    // remove this messageframe to be ready for the garbage
    // to show message in a further way
    public static void removeMessage() {
        loginFailMessage = null;
    }
}
