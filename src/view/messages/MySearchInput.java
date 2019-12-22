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
        JPanel row = new JPanel();

        row.setOpaque(false);

        MyLabel searchLabel = new MyLabel("Suchbegriff :");
        searchLabel.setPreferredSize(new Dimension(200, 30));
        searchLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        searchString = new MyTextField();
        row.add(searchLabel);
        row.add(searchString);

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(3, 1));
        content.add(headLine);
        content.add(row);

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
