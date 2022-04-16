package tema;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Calculator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnAdunare;
	private JButton btnScadere;
	private JButton btnInmultire;
	private JButton btnImpartire;
	private JTextField textField_2;
	private JLabel lblNewLabel;
	private JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 227, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel1 = new JLabel("Numar 1");
		lblNewLabel1.setBounds(32, 14, 67, 14);
		contentPane.add(lblNewLabel1);

		JLabel lblNewLabel2 = new JLabel("Numar 2");
		lblNewLabel2.setBounds(32, 43, 67, 14);
		contentPane.add(lblNewLabel2);

		textField = new JTextField();
		textField.setBounds(109, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(109, 40, 86, 20);
		contentPane.add(textField_1);

		btnAdunare = new JButton("Adunare");
		btnAdunare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double rezultat = Double.parseDouble(textField.getText())
							+ Double.parseDouble(textField_1.getText());
					textField_2.setText(Double.toString(rezultat));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Adaugati 2 numere");
				}
			}
		});
		btnAdunare.setBounds(10, 99, 89, 23);
		contentPane.add(btnAdunare);

		btnScadere = new JButton("Scadere");
		btnScadere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double rezultat = Double.parseDouble(textField.getText())
							- Double.parseDouble(textField_1.getText());
					textField_2.setText(Double.toString(rezultat));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Adaugati 2 numere");
				}

			}
		});
		btnScadere.setBounds(109, 99, 89, 23);
		contentPane.add(btnScadere);

		btnInmultire = new JButton("Inmultire");
		btnInmultire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double rezultat = Double.parseDouble(textField.getText())
							* Double.parseDouble(textField_1.getText());
					textField_2.setText(Double.toString(rezultat));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Adaugati 2 numere");
				}
			}
		});
		btnInmultire.setBounds(10, 130, 89, 23);
		contentPane.add(btnInmultire);

		btnImpartire = new JButton("Impartire");
		btnImpartire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double rezultat = Double.parseDouble(textField.getText())
							/ Double.parseDouble(textField_1.getText());
					if (Double.parseDouble(textField_1.getText()) == 0) {
						JOptionPane.showMessageDialog(null, "Impartire la 0, reintroduceti!");
						return;
					}
					textField_2.setText(Double.toString(rezultat));

				} catch (NumberFormatException | ArithmeticException e1) {
					JOptionPane.showMessageDialog(null, "Adaugati 2 numere");
				}
			}
		});
		btnImpartire.setBounds(109, 130, 89, 23);
		contentPane.add(btnImpartire);

		textField_2 = new JTextField();
		textField_2.setBounds(109, 166, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		lblNewLabel = new JLabel("Rezultat");
		lblNewLabel.setBounds(53, 169, 46, 14);
		contentPane.add(lblNewLabel);

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});

		btnClear.setBounds(109, 197, 89, 23);
		contentPane.add(btnClear);
	}
}
