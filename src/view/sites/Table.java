package view.sites;

import model.Database;
import view.styles.Styles.MyBorder;
import view.styles.Styles.MyColor;
import view.styles.Styles.MyFont;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

// showing the result table (all entries in database)
// The reffered Object is designed in a singleton way

public class Table extends JTable {

    private static JScrollPane scrollPane;

    private Table() {
        super(Database.getAnimals(), Form.getFormLabels());

        JLabel label = new JLabel("Alle Tierchen in der Übersicht:");
        label.setPreferredSize(new Dimension(600, 70));
        label.setBackground(MyColor.CenterColor.getValue());
        label.setFont(MyFont.LabelText.getValue());
        label.setHorizontalAlignment(SwingConstants.CENTER);

        Center.getInstance().add(label, BorderLayout.PAGE_START);

        getTableHeader().setForeground(MyColor.TextColor.getValue());
        getTableHeader().setFont(MyFont.TableHeadText.getValue());
        getTableHeader().setBackground(MyColor.TableHeaderColor.getValue());

        scrollPane = new JScrollPane(this);

        // initalize Layout for the table
        setDefaultEditor(Object.class, null);
        setDefaultRenderer(Object.class, new TableRendering());

        // some designs for the table
        setRowSelectionAllowed(false);
        setFocusable(false);
        setRowHeight(30);
        setFont(MyFont.TableMainText.getValue());
        setShowVerticalLines(false);
        setShowHorizontalLines(false);

        // some designs for the scrollbar
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.scrollBarWidth = 25;
                this.trackColor = MyColor.ScrollbarBackColor.getValue();
                this.thumbColor = MyColor.ScrollbarColor.getValue();
                this.thumbLightShadowColor = Color.LIGHT_GRAY;
                this.thumbDarkShadowColor = Color.DARK_GRAY;
                this.thumbHighlightColor = Color.YELLOW;
            }
        });
        scrollPane.setBackground(MyColor.CenterColor.getValue());
        scrollPane.setBorder(MyBorder.InvisibleBorder.getValue());

        setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
    }

    // setting alternating row colors
    private static class TableRendering implements TableCellRenderer {
        private static final DefaultTableCellRenderer defRender = new DefaultTableCellRenderer();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = defRender.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (row % 2 == 0) {
                ((JComponent) c).setOpaque(true);
                c.setBackground(MyColor.TableRowColor.getValue());
            } else {
                ((JComponent) c).setOpaque(false);
            }
            if (c instanceof JLabel) {
                ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
            }
            return c;
        }
    }

    // singleton: to make only one instance of this object possible
    public static JScrollPane getInstance() {
        if (scrollPane == null) {
            new Table();
        } else if (!scrollPane.isValid()) {
            new Table();
        }
        return scrollPane;
    }
}
