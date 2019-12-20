package view.styles;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Styles {

    public enum MyColor {
        HeaderColor(255, 215, 0),
        CenterColor(240, 240, 200),
        PopUpColor(240, 240, 200,150),
        ValueFieldColor(250, 250, 195),
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

        public Color getValue() {
            return value;
        }
    }

    public enum MyFont {
        HeadText("Vanilla", Font.ITALIC, 40),
        PopUpText("Vanilla", Font.PLAIN, 20),
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

        public Font getValue() {
            return value;
        }
    }

    public enum MyBorder {
        LoweredBorder(BorderFactory.createLoweredBevelBorder()),
        CompountBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder())),
        InvisibleBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25)),
        DoubleCompountBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25), BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()))),
        HeadBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)),
        MessageBorder( BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        private Border value;

        MyBorder(Border BorderName) {
            value = BorderName;
        }

        public Border getValue() {
            return value;
        }

    }
}
