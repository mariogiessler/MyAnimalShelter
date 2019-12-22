package view.messages;

import view.styles.MyButton;
import view.styles.MyLabel;
import view.styles.MyTextField;
import view.styles.Styles.MyBorder;

import javax.swing.*;
import java.awt.*;

// custom searchfield message
// The reffered Object is designed in a singleton way

public class MySearchInput extends MyDialog {

    private static MySearchInput searchInput;
    private static MyTextField searchString;
    private static JPasswordField pass;

    private MySearchInput() {
        super("Datenbank durchsuchen !");

        MyLabel headLine = new MyLabel("Wonach wollen Sie in der Datenbank suchen?");

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(5, 1));
        content.add(new JLabel()); // blank space
        content.add(headLine);
        content.add(new JLabel()); // blank space
        searchString = new MyTextField();
        content.add(searchString);
        content.add(new JLabel()); // blank space

        content.setOpaque(false);
        content.setBorder(MyBorder.PopUpInvisibleBorder.getValue());

        getContent().add(content);

        MyButton cancelButton = new MyButton("Abbr.");
        cancelButton.setName("searchCancel");
        MyButton confirmButton = new MyButton("OK");
        confirmButton.setName("searchOK");
        getButton().add(confirmButton);
        getButton().add(cancelButton);
    }

    public static String getInput() {
        return searchString.getText();
    }

    // singleton: to make only one instance of this object possible
    public static MySearchInput getInstance() {
        if (searchInput == null) {
            searchInput = new MySearchInput();
        }
        return searchInput;
    }

    // remove this messageframe to be ready for the garbage
    // to show message in a further way
    public static void removeSearch() {
        searchInput = null;
    }
}
