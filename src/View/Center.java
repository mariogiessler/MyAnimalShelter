package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

import Control.Controller;
import View.Styles.*;
import Control.ButtonListener;

public class Center extends JPanel {
    private static final long serialVersionUID = 1L;

    private static JPanel centerContent = new JPanel();
    private static JPanel centerImages = new JPanel();

    public Center() {
        setLayout(new BorderLayout());
        Border raised = BorderFactory.createRaisedBevelBorder();
        Border lowered = BorderFactory.createLoweredBevelBorder();
        Border compound = BorderFactory.createCompoundBorder(raised, lowered);
        Border invisible = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        Border border = BorderFactory.createCompoundBorder(invisible, compound);
        setBorder(border);
        setCenterGreeting();
    }

    private void setCenterGreeting() {
        centerContent.setLayout(new GridLayout(10, 1));
        centerImages.setLayout(new GridLayout(1, 4));
        centerContent.setBackground(MyColor.CenterColor.getValue());
        centerImages.setBackground(MyColor.CenterColor.getValue());
        JLabel text = new JLabel("Hallo! Wir bieten eine große Auswahl an liebenswerten Tierchen,");
          JLabel text1 = new JLabel("die alle ein neues Zuhause suchen.");
        JLabel text2 = new JLabel("Für alle adoptierten Lieblinge gibt es Tierarztbesuche gratis auf Lebenszeit.");

        text.setFont(MyFont.MainText.getValue());
        text1.setFont(MyFont.MainText.getValue());
        text2.setFont(MyFont.MainText.getValue());
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setHorizontalAlignment(SwingConstants.CENTER);
        centerImages.add(new JLabel(AnimalPic.getCat()));
        centerImages.add(new JLabel(AnimalPic.getMouse()));
        centerImages.add(new JLabel(AnimalPic.getGiraffe()));
        centerImages.add(new JLabel(AnimalPic.getChamaeleon()));
        centerContent.add(new JLabel());
        centerContent.add(new JLabel());
        centerContent.add(new JLabel());
        centerContent.add(text);
        centerContent.add(text1);
        centerContent.add(text2);
        add(centerImages, BorderLayout.PAGE_START);
        add(centerContent, BorderLayout.CENTER);
    }

    public static void setCenterForm() {
        centerContent.removeAll();
        centerImages.removeAll();
        centerContent.setLayout(null);

        JPanel formContent = new JPanel();

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(6, 2));
        form.setSize(300, 200);
        form.setOpaque(false);

        form.add(new JLabel("Tiername:")).setFont(MyFont.MainText.getValue());
        JTextField name = new JTextField();
        name.setFont(MyFont.MainText.getValue());
        name.setLocation(400, 100);
        form.add(name);

        form.add(new JLabel("Tierart:")).setFont(MyFont.MainText.getValue());
        JTextField species = new JTextField();
        species.setFont(MyFont.MainText.getValue());
        form.add(species);

        form.add(new JLabel("Rasse:")).setFont(MyFont.MainText.getValue());
        JTextField breed = new JTextField();
        breed.setFont(MyFont.MainText.getValue());
        form.add(breed);

        form.add(new JLabel("Alter:")).setFont(MyFont.MainText.getValue());
        JTextField age = new JTextField();
        age.setFont(MyFont.MainText.getValue());
        form.add(age);

        form.add(new JLabel("Geschlecht:")).setFont(MyFont.MainText.getValue());
        JTextField gender = new JTextField();
        gender.setFont(MyFont.MainText.getValue());
        form.add(gender);

        form.add(new JLabel("Farbe:")).setFont(MyFont.MainText.getValue());
        JTextField color = new JTextField();
        color.setFont(MyFont.MainText.getValue());
        form.add(color);

        form.setLocation(400, 150);

        JButton insertButton = new JButton("einfügen");
        insertButton.addActionListener(ButtonListener.instance);
        insertButton.setSize(150, 50);
        insertButton.setLocation(550, 380);

        centerContent.add(form);
        centerContent.add(insertButton);

    }


}

