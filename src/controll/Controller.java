package controll;

import model.Database;
import view.ViewManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Controller {
    private static FrameMoveListener moveListener = new FrameMoveListener();
    private static ActionListener buttonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = ((JButton) e.getSource()).getText();
            switch (title) {
                case "Beenden":
                    System.exit(0);
                    break;
                case "Übersicht":
                    ViewManager.setCenterTable();
                    break;
                case "Neues Tierchen":
                    ViewManager.login();
                    break;
                case "einfügen":
                    if (Database.addAnimal()) {
                        Database.clearFormValues();
                        ViewManager.clearForm();
                        ViewManager.displayConfirm();
                    } else {
                        ViewManager.displayFail();
                    }
                    break;
            }
        }
    };
    private static FocusListener fieldListener = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            JTextField field = (JTextField) e.getComponent();
            Database.getFormValues().put(field.getName(), field.getText());
        }
    };

    public static void main(String[] args) {
        ViewManager.init();
    }

    public static ActionListener getButtonListener() {
        return buttonListener;
    }

    public static FocusListener getFieldListener() {
        return fieldListener;
    }

    public static FrameMoveListener getMoveListener() {
        return moveListener;
    }
}