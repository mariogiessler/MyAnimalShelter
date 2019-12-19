package view.sites;

import view.styles.AnimalPic;
import view.styles.MyLabel;
import view.styles.Styles.MyFont;

import javax.swing.*;
import java.awt.*;

public class Welcome extends JPanel {
    public static Welcome welcome;

    private Welcome() {
        centerImages();
        centerContent();
    }

    private static void centerImages() {
        JPanel centerImages = new JPanel();
        centerImages.setLayout(new GridLayout(1, 4));
        centerImages.setOpaque(false);
        centerImages.add(new JLabel(AnimalPic.getCat()));
        centerImages.add(new JLabel(AnimalPic.getMouse()));
        centerImages.add(new JLabel(AnimalPic.getGiraffe()));
        centerImages.add(new JLabel(AnimalPic.getChamaeleon()));
        centerImages.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        Center.getInstance().add(centerImages, BorderLayout.PAGE_START);
    }

    private static void centerContent() {
        JPanel centerContent = new JPanel();
        centerContent.setLayout(new GridLayout(10, 1));
        centerContent.setOpaque(false);

        JLabel text = new JLabel("Hallo! Wir bieten eine große Auswahl an liebenswerten Tierchen,");
        JLabel text1 = new JLabel("die alle ein neues Zuhause suchen.");
        JLabel text2 = new JLabel("Für alle adoptierten Lieblinge gibt es Tierarztbesuche gratis auf Lebenszeit.");

        text.setFont(MyFont.MainText.getValue());
        text1.setFont(MyFont.MainText.getValue());
        text2.setFont(MyFont.MainText.getValue());
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text1.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setHorizontalAlignment(SwingConstants.CENTER);

        centerContent.add(new MyLabel());
        centerContent.add(text);
        centerContent.add(text1);
        centerContent.add(text2);

        Center.getInstance().add(centerContent, BorderLayout.PAGE_END);
    }

    public static Welcome getInstance() {
        if (welcome == null) {
            welcome = new Welcome();
        }
        return welcome;
    }
}

