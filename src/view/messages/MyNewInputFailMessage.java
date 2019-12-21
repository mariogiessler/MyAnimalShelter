package view.messages;

import view.styles.MyButton;
import view.styles.MyLabel;
import view.styles.Styles.MyFont;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyNewInputFailMessage extends MyMessage {

    private static MyNewInputFailMessage failMessage;

    private MyNewInputFailMessage() {
        super("Es ist ein Fehler aufgetreten !");

        MyLabel message1 = new MyLabel("Das Tier konnte nicht zur Datenbank");
        message1.setPreferredSize(new Dimension(430, 30));
        message1.setFont(MyFont.PopUpText.getValue());
        getRowOne().add(message1);

        MyLabel message2 = new MyLabel("hinzugefügt gefügt werden!");
        message2.setPreferredSize(new Dimension(430, 30));
        message2.setFont(MyFont.PopUpText.getValue());
        getRowTwo().add(message2);

        Image img = null;
        try {
            img = ImageIO.read(new File("res/pics/cat.png"));
        } catch (IOException e) {

        }
        img = img.getScaledInstance(94, 110, Image.SCALE_SMOOTH);

        getImage().add(new JLabel(new ImageIcon(img)));

        MyButton confirm = new MyButton("OK");
        confirm.setName("failOK");
        getButton().add(confirm);
    }

    public static MyNewInputFailMessage getInstance() {
        if (failMessage == null) {
            failMessage = new MyNewInputFailMessage();
        }
        return failMessage;
    }

    public static void removeMessage() {
        failMessage = null;
    }

}
