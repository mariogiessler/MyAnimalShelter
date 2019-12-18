package view;

import model.Database;
import view.Styles.MyColor;
import view.Styles.MyFont;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class Table extends JTable {
    private static final long serialVersionUID = 1L;
    private static JScrollPane instance;
    private static Table table;

    private Table() {
        super(Database.getAnimals(), Form.getFormLabels());
        setForeground(MyColor.TextColor.getValue());
        getTableHeader().setFont(MyFont.TableHeadText.getValue());
        getTableHeader().setBackground(MyColor.HeaderColor.getValue());

        setRowHeight(30);

        setShowVerticalLines(false);
        setShowHorizontalLines(false);

        setFont(MyFont.TableMainText.getValue());

        setDefaultEditor(Object.class, null);
        setRowSelectionAllowed(false);
        setFocusable(false);

        instance = new JScrollPane(this);

        setBackground(MyColor.CenterColor.getValue());
        instance.getViewport().setOpaque(false);

        Border invisible = BorderFactory.createEmptyBorder(0, 50, 50, 50);
        instance.setOpaque(false);
        instance.setBorder(invisible);
    }

    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (c instanceof JComponent) {
            ((JComponent) c).setOpaque(false);
        }
        if (c instanceof JLabel) {
            ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
        }
        return c;
    }

    public static JScrollPane getScrollPane() {
        return instance;
    }

    public static Table getInstance() {
        if (table == null) {
            table = new Table();
        }
        return table;
    }
}
