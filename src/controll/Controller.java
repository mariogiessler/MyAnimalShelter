package controll;

import model.Database;
import view.ViewManager;
import view.messages.MyConfirmMessage;
import view.messages.MyLogin;
import view.messages.MyLoginFailMessage;
import view.messages.MyNewInputFailMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

// This class is doing all the controlling for the programm
// The reffered Object is designed in a singleton way

public class Controller {

    private static FrameMoveListener moveListener;
    private static Controller controller;

    // calling the display
    private Controller() {
        ViewManager.init();
    }

    // watching for all buttons of the programm
    private static ActionListener buttonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            String name = ((JButton) e.getSource()).getName();

            switch (name) {
                case "home":
                case "logout":
                    ViewManager.setHome();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "tableView":
                    ViewManager.setCenterTable();
                    break;
                case "newInput":
                    ViewManager.displayLogin();
                    break;
                case "failOK":
                    MyNewInputFailMessage.getInstance().dispose();
                    MyNewInputFailMessage.removeMessage();
                    break;
                case "confirmOK":
                    MyConfirmMessage.getInstance().dispose();
                    MyConfirmMessage.removeMessage();
                    break;

                case "loginOK":
                    if (Database.authorize()) {
                        MyLogin.getInstance().dispose();
                        MyLogin.removeLogin();
                        ViewManager.setCenterForm();
                    } else {
                        ViewManager.displayLoginFail();
                    }
                    break;
                case "loginFailOK":
                    MyLoginFailMessage.getInstance().dispose();
                    MyLoginFailMessage.removeMessage();
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

    // watching for formfield-changing.
    // If some inputfield has lost focus, write it in a Hashtable(from Database)
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

    // all getter-methods for this class
    public static ActionListener getButtonListener() {
        return buttonListener;
    }

    public static FocusListener getFieldListener() {
        return fieldListener;
    }

    public static FrameMoveListener getMoveListener() {
        return moveListener;
    }

    // singleton: to make only one instance of this object possible
    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }
}