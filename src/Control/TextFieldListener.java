package Control;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextFieldListener implements FocusListener {
	public static TextFieldListener instance = new TextFieldListener();

	private TextFieldListener() {

	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField field = (JTextField) e.getComponent();
		Controller.getFormValues().put(field.getName(), field.getText());
	}

}
