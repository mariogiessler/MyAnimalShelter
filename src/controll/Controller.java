package controll;

import model.Database;
import view.ViewManager;
import view.messages.MyConfirmMessage;
import view.messages.MyFailMessage;
import view.messages.MyLogin;
import view.sites.UserWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Controller {
    private static FrameMoveListener moveListener = new FrameMoveListener();
    private static Controller controller;

    private Controller() {
        ViewManager.init();
    }

    private static ActionListener buttonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = ((JButton) e.getSource()).getText();
            String name = ((JButton) e.getSource()).getName();
            System.out.println(name);
            switch (name) {
                case "home":
                    ViewManager.home();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "tableView":
                    ViewManager.setCenterTable();
                    break;
                case "newInput":
                    ViewManager.login();
                    break;
                case "failOK":
                    MyFailMessage.getInstance().dispose();
                    MyFailMessage.removeMessage();
                    break;
                case "confirmOK":
                    MyConfirmMessage.getInstance().dispose();
                    MyConfirmMessage.removeMessage();
                    break;

                case "loginCancel":
                    MyLogin.getInstance().dispose();
                    MyLogin.removeLogin();
                    break;
                case "formAdd":
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

    public static ActionListener getButtonListener() {
        return buttonListener;
    }

    public static FocusListener getFieldListener() {
        return fieldListener;
    }

    public static FrameMoveListener getMoveListener() {
        return moveListener;
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }
}