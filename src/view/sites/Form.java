package view.sites;

import controll.Controller;
import view.styles.MyButton;
import view.styles.MyLabel;
import view.styles.MyTextField;
import view.styles.Styles.MyBorder;
import view.styles.Styles.MyFont;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// showing the inputform
// The reffered Object is designed in a singleton way

public class Form extends JPanel {
    public static Form form;
    private static ArrayList<JTextField> formFields = new ArrayList<>();
    private static Object[] formLabels = {"Tiername", "Tierart", "Rasse", "Alter", "Geschlecht", "Farbe"};

    private Form() {
        setLayout(null);
        setOpaque(false);

        setSize(400, 400);
        setLocation(50, 50);

        JTextArea formHeader = new JTextArea();
        formHeader.setText("Hier können Sie ein neues Tierchen zur Datenbank\nhinzufügen:");
        formHeader.setFont(MyFont.SubText.getValue());
        formHeader.setOpaque(false);
        formHeader.setSize(500, 50);
        formHeader.setLocation(320, 80);

        JPanel formCenter = new JPanel();
        formCenter.setLayout(new GridLayout(6, 1));
        formCenter.setOpaque(false);
        formCenter.setSize(520, 300);
        formCenter.setLocation(300, 150);

        for (Object position : formLabels) {
            JPanel rowPanel = new JPanel();
            rowPanel.setOpaque(false);

            MyLabel rowLabel = new MyLabel((String) position + " :");
            rowLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            MyLabel blankLabel = new MyLabel();
            MyTextField rowField = new MyTextField();
            rowField.setName(((String) position).trim().toLowerCase());
            rowField.addFocusListener(Controller.getFieldListener());
            rowField.setBorder(MyBorder.LoweredBorder.getValue());

            rowPanel.add(rowLabel);
            rowPanel.add(blankLabel);
            rowPanel.add(rowField);
            formFields.add(rowField);

            formCenter.add(rowPanel);
        }

        MyButton formButton = new MyButton("einfügen");
        formButton.setName("formAdd");
        formButton.setSize(new Dimension(150, 50));
        formButton.setLocation(665, 470);

        MyButton logoutButton = new MyButton("abmelden");
        logoutButton.setName("logout");
        logoutButton.setSize(new Dimension(150, 50));
        logoutButton.setLocation(980, 510);


        add(formHeader);
        add(formCenter);
        add(formButton);
        add(logoutButton);
    }

    // getter for the form
    public static ArrayList<JTextField> getFormFields() {
        return formFields;
    }

    public static ArrayList<JTextField> getFields() {
        return formFields;
    }

    public static Object[] getFormLabels() {
        return formLabels;
    }

    // singleton: to make only one instance of this object possible
    public static Form getInstance() {
        if (form == null) {
            form = new Form();
        } else if (!form.isValid()) {
            new Form();
        }
        return form;
    }
}
