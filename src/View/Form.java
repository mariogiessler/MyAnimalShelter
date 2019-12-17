package View;

import Control.ButtonListener;
import Control.TextFieldListener;
import View.Styles.MyFont;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Form extends JPanel {
    public static Form instance = new Form();
    private static ArrayList<JTextField> formFields = new ArrayList<>();

    private Form() {
        setLayout(null);
        setSize(400, 400);
        setLocation(50, 50);

        setOpaque(false);
    }

    public static ArrayList<JTextField> getFormFields() {
        return formFields;
    }

    public void setForm() {
        String[] formPositions = {"Tiername:", "Tierart:", "Rasse:", "Alter:", "Geschlecht:", "Farbe:"};

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

        for (String position : formPositions) {
            JPanel rowPanel = new JPanel();
            rowPanel.setOpaque(false);

            JLabel rowLabel = new JLabel(position);
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
            rowField.setName(position.replace(":", "").trim());
            rowField.addFocusListener(TextFieldListener.instance);

            rowPanel.add(rowField);
            formFields.add(rowField);

            formCenter.add(rowPanel);
        }

        JButton formButton = new JButton("einfügen");
        formButton.addActionListener(ButtonListener.instance);
        formButton.setSize(150, 50);
        formButton.setLocation(660, 500);

        add(formHeader);
        add(formCenter);
        add(formButton);
    }
}
