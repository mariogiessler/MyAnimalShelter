package view;

import controll.Controller;
import view.Styles.MyFont;
import view.Styles.MyColor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

            JLabel rowLabel = new JLabel((String) position + " :");
            rowLabel.setPreferredSize(new Dimension(150, 30));
            rowLabel.setFont(MyFont.MainText.getValue());
            rowLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            rowPanel.add(rowLabel);

            JLabel blankLabel = new JLabel();
            blankLabel.setPreferredSize(new Dimension(50, 30));
            rowPanel.add(blankLabel);

            JTextField rowField = new JTextField();
            rowField.setPreferredSize(new Dimension(300, 30));
            rowField.setFont(MyFont.MainText.getValue());
            rowField.setName(((String) position).trim().toLowerCase());
            rowField.addFocusListener(Controller.getFieldListener());
            rowField.setBackground(MyColor.ValueFieldColor.getValue());
            rowField.setBorder(BorderFactory.createLoweredBevelBorder());

            rowPanel.add(rowField);
            formFields.add(rowField);

            formCenter.add(rowPanel);
        }

        JButton formButton = new JButton("einfügen");
        formButton.addActionListener(Controller.getButtonListener());
        formButton.setBorder(BorderFactory.createRaisedBevelBorder());
        formButton.setSize(new Dimension(150, 50));
        formButton.setFont(Styles.MyFont.ButtonText.getValue());
        formButton.setBackground(Styles.MyColor.ButtonColor.getValue());
        formButton.setForeground(Styles.MyColor.HeaderColor.getValue());
        formButton.setLocation(660, 500);
        formButton.setFocusPainted(false);

        add(formHeader);
        add(formCenter);
        add(formButton);
    }

    public static ArrayList<JTextField> getFormFields() {
        return formFields;
    }

    public static ArrayList<JTextField> getFields() {
        return formFields;
    }

    public static Object[] getFormLabels() {
        return formLabels;
    }

    public static Form getInstance() {
        if (form == null) {
            form = new Form();
        }
        return form;
    }
}
