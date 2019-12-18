package view;

import model.Database;
import view.Styles.MyColor;
import view.Styles.MyFont;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Table extends JTable {
	private static final long serialVersionUID = 1L;
	private static JScrollPane instance;

	public Table() {
		super(Database.getAnimals(), Form.getFormLabels());
		instance = new JScrollPane(this);
		Border line = BorderFactory.createLineBorder(Color.DARK_GRAY);
		Border title = BorderFactory.createTitledBorder(line, "Alle Tiere in der Übersicht", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION, MyFont.SubText.getValue());
		Border invisible = BorderFactory.createEmptyBorder(50, 50, 50, 50);
		Border border = BorderFactory.createCompoundBorder(invisible, title);
		instance.setBackground(MyColor.CenterColor.getValue());
		instance.setBorder(border);
	}

	public static JScrollPane getInstance() {
		return instance;
	}
}
