package view;

import view.Styles.MyColor;
import view.Styles.MyFont;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Center extends JPanel {
    private static final long serialVersionUID = 1L;
    private static Center center;

    private static JPanel centerContent = new JPanel();
    private static JPanel centerImages = new JPanel();

    private Center() {
        setLayout(new BorderLayout());
        Border raised = BorderFactory.createRaisedBevelBorder();
        Border lowered = BorderFactory.createLoweredBevelBorder();
        Border compound = BorderFactory.createCompoundBorder(raised, lowered);
        Border invisible = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        Border border = BorderFactory.createCompoundBorder(invisible, compound);
        setBorder(border);

        Cursor c = getToolkit().createCustomCursor(new ImageIcon("res/cursor/turtle.png").getImage(), new Point(10, 10), "Cursor");
        setCursor(c);

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

    public static Center getInstance() {
        if (center == null) {
            center = new Center();
        }
        return center;
    }
}

