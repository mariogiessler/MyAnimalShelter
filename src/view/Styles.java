package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Styles {

    enum MyColor {
        HeaderColor(255, 215, 0),
        CenterColor(240, 240, 200),
        ButtonColor(0, 50, 0),
        TextColor(0, 50, 0),
        BackColor(113, 113, 98);

        private Color value;

        MyColor(int r, int g, int b) {
            value = new Color(r, g, b);
        }

        Color getValue() {
            return value;
        }
    }

    enum MyFont {
        HeadText("Vanilla", Font.ITALIC, 40),
        SubText("Quicksand-Bold", Font.BOLD, 20),
        ButtonText("Quicksand-Bold", Font.BOLD, 20),
        MainText("Quicksand-Regular", Font.PLAIN, 24);

        private Font value;

        MyFont(String name, int style, int size) {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            try {
                Font head = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/Vanilla.ttf"));
                Font bold = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/Quicksand-Bold.otf"));
                Font main = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/Quicksand-Regular.otf"));

                ge.registerFont(head);
                ge.registerFont(main);
                ge.registerFont(bold);
            } catch (FontFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            value = new Font(name, style, size);
        }

        Font getValue() {
            return value;
        }
    }


}
