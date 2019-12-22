package view.messages;

import view.styles.MyButton;
import view.styles.MyLabel;
import view.styles.Styles.MyFont;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// this message is vissible, if a database insert was succesfull
// The reffered Object is designed in a singleton way


public class MyConfirmMessage extends MyMessage {

    private static MyConfirmMessage confirmMessage;

    private MyConfirmMessage() {
        super("Das war Erfolgreich !");

        MyLabel message1 = new MyLabel("Das Tier wurde zur");
        message1.setPreferredSize(new Dimension(430, 30));
        message1.setFont(MyFont.PopUpText.getValue());
        getRowOne().add(message1);

        MyLabel message2 = new MyLabel("Datenbank hinzugefügt!");
        message2.setPreferredSize(new Dimension(430, 30));
        message2.setFont(MyFont.PopUpText.getValue());
        getRowTwo().add(message2);

        // image for this message
        Image img = null;
        try {
            img = ImageIO.read(new File("res/pics/giraffe.png"));
        } catch (IOException e) {

        }
        img = img.getScaledInstance(80, 110, Image.SCALE_SMOOTH);

        getImage().add(new JLabel(new ImageIcon(img)));

        MyButton confirm = new MyButton("OK");
        confirm.setName("confirmOK");
        getButton().add(confirm);
    }

    // singleton: to make only one instance of this object possible
    public static MyConfirmMessage getInstance() {
        if (confirmMessage == null) {
            confirmMessage = new MyConfirmMessage();
        }
        return confirmMessage;
    }

    // remove this messageframe to be ready for the garbage
    // to show message in a further way
    public static void removeMessage() {
        confirmMessage = null;
    }
}
