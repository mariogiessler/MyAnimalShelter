package view.messages;

import view.styles.MyLabel;
import view.styles.Styles;
import view.styles.Styles.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyDialog extends JFrame {

    private JPanel rowOne,rowTwo, button,icon, main;

    protected MyDialog(){
        super("Message");
    }

    protected MyDialog(String title){

        setUndecorated(true);
        setSize(600, 300);
        setLayout(new BorderLayout());
        setBackground(Styles.MyColor.PopUpColor.getValue());

        main = new JPanel();
        main.setLayout(new BorderLayout());
        main.setBackground(MyColor.PopUpColor.getValue());


        JPanel header = new JPanel();
        header.setPreferredSize(new Dimension(600,70));
        header.setOpaque(false);

        MyLabel headLabel =new MyLabel(title);
        headLabel.setFont(MyFont.SubText.getValue());
        headLabel.setPreferredSize(new Dimension(550,40));
        headLabel.setBackground(MyColor.ButtonColor.getValue());
        headLabel.setForeground(MyColor.HeaderColor.getValue());
        headLabel.setHorizontalAlignment(SwingConstants.LEFT);
        headLabel.setOpaque(true);

        header.add(headLabel);
        main.add(header,BorderLayout.PAGE_START);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setOpaque(false);

        icon = new JPanel();
        icon.setPreferredSize(new Dimension(150,150));
        icon.setOpaque(false);

        content.add(icon,BorderLayout.LINE_START);

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(2, 1));
        grid.setOpaque(false);

        rowOne=new JPanel();
        rowTwo=new JPanel();

        rowOne.setOpaque(false);
        rowTwo.setOpaque(false);

        grid.add(rowOne);
        grid.add(rowTwo);

        content.add(grid,BorderLayout.CENTER);

        button =new JPanel();
        button.setOpaque(false);

        main.setBorder(Styles.MyBorder.MessageBorder.getValue());
main.add(content,BorderLayout.CENTER);
        main.add(button,BorderLayout.PAGE_END);

        add(main);
        setVisible(true);
        setLocationRelativeTo(null);

        Cursor c = getToolkit().createCustomCursor(new ImageIcon("res/cursor/turtle.png").getImage(), new Point(0, 0), "Cursor");
        setCursor(c);
    }

    protected MyDialog(String title,String icon){
        this(title);
         Image img = null;
        try {
         img = ImageIO.read(new File("res/pics/cat.png"));
        } catch (IOException e) {

        }
        img = img.getScaledInstance(75, 90, Image.SCALE_SMOOTH);

        main.add(new JLabel(new ImageIcon(img)));
    }

    protected JPanel getIcon(){
        return icon;
    }

    protected JPanel getRowOne(){
        return rowOne;
    }

     protected JPanel getRowTwo(){
        return rowTwo;
    }
     protected JPanel getButton(){
        return button;
    }
}
