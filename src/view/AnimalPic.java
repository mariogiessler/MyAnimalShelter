package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AnimalPic {
    public static ImageIcon getCat() {
        Image img = null;
        try {
            img = ImageIO.read(new File("res/pics/cat.png"));
        } catch (IOException e) {

        }
        img = img.getScaledInstance(170, 200, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public static ImageIcon getGiraffe() {
        Image img = null;
        try {
            img = ImageIO.read(new File("res/pics/giraffe.png"));
        } catch (IOException e) {

        }
        img = img.getScaledInstance(145, 200, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public static ImageIcon getChamaeleon() {
        Image img = null;
        try {
            img = ImageIO.read(new File("res/pics/chamaeleon.png"));
        } catch (IOException e) {

        }
        img = img.getScaledInstance(282, 200, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public static ImageIcon getMouse() {
        Image img = null;
        try {
            img = ImageIO.read(new File("res/pics/mouse.png"));
        } catch (IOException e) {

        }
        img = img.getScaledInstance(197, 200, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}
