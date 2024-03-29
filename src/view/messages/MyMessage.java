package view.messages;

import view.styles.Styles.MyBorder;

import javax.swing.*;
import java.awt.*;

// parent for all messages without input
// i chose a package visibility, because i wont refer this class to any others, except childrens

class MyMessage extends MyDialog {

    private JPanel rowOne, rowTwo, image;

    MyMessage(String title) {
        super(title);
        image = new JPanel();
        image.setPreferredSize(new Dimension(150, 150));
        image.setOpaque(false);

        getContent().add(image, BorderLayout.LINE_START);

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(2, 1));
        grid.setBorder(MyBorder.PopUpInvisibleBorder.getValue());
        grid.setOpaque(false);

        rowOne = new JPanel();
        rowTwo = new JPanel();

        rowOne.setOpaque(false);
        rowTwo.setOpaque(false);

        grid.add(rowOne);
        grid.add(rowTwo);

        getContent().add(grid);
    }

    // getter for all messages without input
    JPanel getImage() {
        return image;
    }

    JPanel getRowOne() {
        return rowOne;
    }

    JPanel getRowTwo() {
        return rowTwo;
    }
}
