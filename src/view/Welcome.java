package view;

import javax.swing.*;
import java.awt.*;

public abstract class Welcome extends JPanel {
    private static JPanel centerContent = new JPanel();
    private static JPanel centerImages = new JPanel();

    public static JPanel getCenterContent() {
        centerContent.setLayout(new GridLayout(10, 1));
        centerContent.setOpaque(false);

        JLabel text = new JLabel("Hallo! Wir bieten eine große Auswahl an liebenswerten Tierchen,");
        JLabel text1 = new JLabel("die alle ein neues Zuhause suchen.");
        JLabel text2 = new JLabel("Für alle adoptierten Lieblinge gibt es Tierarztbesuche gratis auf Lebenszeit.");

        text.setFont(Styles.MyFont.MainText.getValue());
        text1.setFont(Styles.MyFont.MainText.getValue());
        text2.setFont(Styles.MyFont.MainText.getValue());
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setHorizontalAlignment(SwingConstants.CENTER);

        centerContent.add(new JLabel());
        centerContent.add(new JLabel());
        centerContent.add(new JLabel());
        centerContent.add(text);
        centerContent.add(text1);
        centerContent.add(text2);

        return centerContent;
    }

    public static JPanel getCenterImages() {
        centerImages.setLayout(new GridLayout(1, 4));
        centerImages.setOpaque(false);
        centerImages.add(new JLabel(AnimalPic.getCat()));
        centerImages.add(new JLabel(AnimalPic.getMouse()));
        centerImages.add(new JLabel(AnimalPic.getGiraffe()));
        centerImages.add(new JLabel(AnimalPic.getChamaeleon()));

        return centerImages;
    }
}

