package lec19.v05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CalculatorController implements ActionListener {

	CalculatorModel model;
	CalculatorView view;

	boolean start_of_number;
	boolean point_pressed;
	
	public CalculatorController(CalculatorModel model, CalculatorView view) {
		this.model = model;
		this.view = view;

		view.addActionListener(this);

		start_of_number = true;
		point_pressed = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		char button_char = button.getText().charAt(0);
		switch (button_char) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			if (start_of_number) {
				if (button_char != '0') {
					view.setDisplay(Character.toString(button_char));
					start_of_number = false;
				}
			} else {
				view.appendToDisplay(Character.toString(button_char));
			}
			break;
			
		case '.':
			if (start_of_number) {
				view.setDisplay("0.");
				start_of_number = false;
			} else if (!point_pressed) {
				view.appendToDisplay(".");
			}
			point_pressed = true;
			break;
		}
	}
}
