package view.sites;

import controll.Controller;
import view.styles.MyButton;
import view.styles.MyLabel;
import view.styles.MyTextField;
import view.styles.Styles;
import view.styles.Styles.MyBorder;
import view.styles.Styles.MyColor;
import view.styles.Styles.MyFont;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private static Login login;

    private Login() {
        setUndecorated(true);
        setSize(600, 300);
        setBackground(MyColor.PopUpColor.getValue());

        JPanel main = new JPanel();
        main.setLayout(new GridLayout(4, 1));
        main.setBackground(MyColor.PopUpColor.getValue());

        JPanel header =new JPanel();
        JPanel rowOne=new JPanel();
        JPanel rowTwo=new JPanel();
        JPanel rowThree=new JPanel();

        JLabel headLine = new JLabel("Bitte geben Sie Ihre Benutzerdaten ein:");
        headLine.setFont(MyFont.PopUpText.getValue());
        headLine.setPreferredSize(new Dimension(540, 30));
        headLine.setHorizontalAlignment(SwingConstants.CENTER);
        header.setOpaque(false);
        header.add(headLine);

        MyLabel nameLabel = new MyLabel("Benutzername :");
        nameLabel.setPreferredSize(new Dimension(200, 30));
        MyTextField name = new MyTextField();
        rowOne.add(nameLabel);
        rowOne.setOpaque(false);
        rowOne.add(name);

        MyLabel passLabel = new MyLabel("Passwort :");
        passLabel.setPreferredSize(new Dimension(200, 30));
        JPasswordField pass = new JPasswordField();
        pass.setPreferredSize(new Dimension(300, 30));
        pass.setFont(Styles.MyFont.MainText.getValue());
        pass.addFocusListener(Controller.getFieldListener());
        pass.setBackground(Styles.MyColor.ValueFieldColor.getValue());
        rowTwo.add(passLabel);
        rowTwo.setOpaque(false);
        rowTwo.add(pass);

        MyButton exitButton = new MyButton("Abbr.");
        MyButton confirmButton = new MyButton("OK");
        rowThree.add(confirmButton);
        rowThree.setOpaque(false);
        rowThree.add(exitButton);

        main.setBorder(MyBorder.PopUpBorder.getValue());

        main.add(header);
        main.add(rowOne);
        main.add(rowTwo);
        main.add(rowThree);

        add(main);

        setVisible(true);
        setLocationRelativeTo(null);

        Cursor c = getToolkit().createCustomCursor(new ImageIcon("res/cursor/turtle.png").getImage(), new Point(0, 0), "Cursor");
        setCursor(c);
    }

    public static Login getInstance() {
        if (login == null) {
            login = new Login();
        } else if (!login.isValid()) {
            login = new Login();
        }
        return login;
    }
}
