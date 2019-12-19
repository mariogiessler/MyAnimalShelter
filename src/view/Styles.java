package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Styles {

    enum MyColor {
        HeaderColor(255, 215, 0),
        CenterColor(240, 240, 200),
        ValueFieldColor(230, 230, 150, 150),
        ButtonColor(0, 50, 0),
        TextColor(0, 50, 0),
        TableHeaderColor(255, 215, 0, 150),
        TableRowColor(230, 230, 150, 150),
        ScrollbarColor(255, 215, 0, 150),
        ScrollbarBackColor(0, 50, 0, 150);

        private Color value;

        MyColor(int r, int g, int b) {
            value = new Color(r, g, b);
        }

        MyColor(int r, int g, int b, int a) {
            value = new Color(r, g, b, a);
        }

        Color getValue() {
            return value;
        }
    }

    enum MyFont {
        HeadText("Vanilla", Font.ITALIC, 40),
        SubText("Quicksand-Bold", Font.BOLD, 20),
        LabelText("Quicksand-Bold", Font.BOLD, 24),
        ButtonText("Quicksand-Bold", Font.BOLD, 20),
        MainText("Quicksand-Regular", Font.PLAIN, 24),
        TableHeadText("Quicksand-Bold", Font.ITALIC, 20),
        TableMainText("Quicksand-Regular", Font.PLAIN, 20);

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
