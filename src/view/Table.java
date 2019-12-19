package view;

import model.Database;
import view.Styles.MyColor;
import view.Styles.MyFont;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class Table extends JTable {
    private static final long serialVersionUID = 1L;
    private static JScrollPane instance;
    private static Table table;

    public Table() {
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

        instance.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.scrollBarWidth = 25;

                this.trackColor = MyColor.ButtonColor.getValue();

                this.maximumThumbSize = new Dimension(0, 50);
                this.thumbColor = MyColor.HeaderColor.getValue();
                this.thumbLightShadowColor = Color.LIGHT_GRAY;
                this.thumbDarkShadowColor = Color.DARK_GRAY;
                this.thumbHighlightColor = Color.YELLOW;
            }
        });

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

    public static JScrollPane getInstance() {
        return instance;
    }
}
