package Control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    public static ButtonListener instance = new ButtonListener();

    @Override
    public void actionPerformed(ActionEvent event) {
        String title = ((JButton) event.getSource()).getText();

        switch (title) {
            case "Beenden":
                System.exit(0);
                break;
            case "Übersicht":
                // TODO
                break;
            case "Neues Tierchen":
                Controller.changeView();
                break;
        }

    }
}
