package curk.mr.delovnadobacalculatorGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import curk.mr.delovnadobacalculator.DelovnaDoba;

/**
 * 
 * @author mr.curk@gmail.com
 * 
 */

public class GuiCalc extends JFrame {

	private static final long serialVersionUID = 1L;
	private DelovnaDoba dd;
	private JTextField dniJTextField;
	private JTextField mesecJTextField;
	private JTextField letJTextField;
	private JTextField sumJTextField;

	public GuiCalc() {
		super("Delovna Doba Kalkulator");
		setLayout(new FlowLayout());

		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// three diferent panels
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		JPanel input = new JPanel();
		input.setLayout(new FlowLayout());
		JPanel output = new JPanel();
		output.setLayout(new FlowLayout());
		JPanel button = new JPanel();
		button.setLayout(new FlowLayout());

		// create Delovan Doba instance
		dd = new DelovnaDoba();

		// years
		JLabel letJLabel = new JLabel("let");
		input.add(letJLabel);
		letJTextField = new JTextField(9);
		letJTextField.setHorizontalAlignment(JTextField.RIGHT);
		input.add(letJTextField);

		// months
		JLabel mesecJLabel = new JLabel("mesec");
		input.add(mesecJLabel);
		mesecJTextField = new JTextField(9);
		mesecJTextField.setHorizontalAlignment(JTextField.RIGHT);
		input.add(mesecJTextField);

		// days
		JLabel dniJLabel = new JLabel("dni");
		input.add(dniJLabel);
		dniJTextField = new JTextField(9);
		dniJTextField.setHorizontalAlignment(JTextField.RIGHT);
		input.add(dniJTextField);

		// summary
		JLabel sumJLabel = new JLabel("Rezultat je:");
		output.add(sumJLabel);
		sumJTextField = new JTextField(dd.toString(), 20);
		sumJTextField.setEditable(false);
		sumJTextField.setFont(new Font("Serif", Font.BOLD, 16));
		output.add(sumJTextField);

		// reset butoon
		JButton resetJButton = new JButton("Reset");
		resetJButton.setActionCommand("Reset");

		button.add(resetJButton);

		// add panels to main
		main.add(input, BorderLayout.CENTER);
		main.add(output, BorderLayout.SOUTH);
		main.add(button, BorderLayout.NORTH);

		add(main);
		// focus on year textfield
		letJTextField.requestFocus();
		pack();

		// adding listener to textfields
		TheHandler h = new TheHandler();

		dniJTextField.addActionListener(h);
		mesecJTextField.addActionListener(h);
		letJTextField.addActionListener(h);
		resetJButton.addActionListener(h);

	}

	private void getInputData(ActionEvent e) {
		int dni, mesecev, let;

		// check for reset button press
		if (e.getActionCommand().equalsIgnoreCase("Reset")) {
			dd.resetDD();
		} else {
			// parse all three textfields
			try {
				dni = Integer.parseInt(dniJTextField.getText());
			} catch (Exception e2) {
				dni = 0;
			}

			try {
				mesecev = Integer.parseInt(mesecJTextField.getText());
			} catch (Exception e2) {
				mesecev = 0;
			}

			try {
				let = Integer.parseInt(letJTextField.getText());
			} catch (Exception e2) {
				let = 0;
			}

			// add years,months, days to summary
			dd.addDD(let, mesecev, dni);
			// fokus on years field
			letJTextField.requestFocus();
		}

		// output results
		sumJTextField.setText(dd.toString());

		// empty all text fields
		dniJTextField.setText(null);
		mesecJTextField.setText(null);
		letJTextField.setText(null);

	}

	private class TheHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			getInputData(e);

		}

	}

}
