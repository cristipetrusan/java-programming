package tema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class Filme extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFilm;
	private JTextField textFieldActori;
	private JTable table;
	private JSpinner spinnerAnLansare;
	private JCheckBox chckbxComedie;
	private JCheckBox chckbxDrama;
	private JCheckBox chckbxIstoric;
	private JCheckBox chckbxRomantic;
	private JCheckBox chckbxActiune;
	private TableModel myTableModel;
	private JButton btnSterge;

	private boolean validFields()
	{
		if (textFieldActori.getText().isEmpty() || textFieldFilm.getText().isEmpty())
			return false;
		return true;
	}

	private class AdaugaButtonPress implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if (validFields())
			{
				Vector <String>row = new Vector<String>(3);
				row.add(textFieldFilm.getText());
				row.add(textFieldActori.getText());
				row.add(spinnerAnLansare.getValue().toString());
				String genuri = "";
				if (chckbxComedie.isSelected())
					genuri = genuri + "comedie, ";
				if (chckbxDrama.isSelected())
					genuri = genuri + "drama, ";
				if (chckbxIstoric.isSelected())
					genuri = genuri + "istoric, ";
				if (chckbxRomantic.isSelected())
					genuri = genuri + "romantic, ";
				if (chckbxActiune.isSelected())
					genuri = genuri + "actiune, ";
				if (genuri.endsWith(", "))
					genuri = genuri.substring(0, genuri.length() - 2);
				row.add(genuri);
				((DefaultTableModel) myTableModel).addRow(row);

				btnSterge.setEnabled(true);
				
				textFieldFilm.setText("");
				textFieldActori.setText("");
				spinnerAnLansare.setValue(2015);
				chckbxComedie.setSelected(false);
				chckbxDrama.setSelected(false);
				chckbxIstoric.setSelected(false);
				chckbxRomantic.setSelected(false);
				chckbxActiune.setSelected(false);
			}
		}
	}

	private class StergeButtonPress implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			while (table.getSelectedRow() != -1)
				((DefaultTableModel) myTableModel).removeRow(table.getSelectedRow());

			if (((DefaultTableModel) myTableModel).getRowCount() == 0)
				btnSterge.setEnabled(false);
		}
	}

	public Filme(String nume) 
	{
		super(nume);
		setTitle("Filme");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFilm = new JLabel("Film");
		lblFilm.setBounds(10, 40, 46, 14);
		contentPane.add(lblFilm);

		textFieldFilm = new JTextField();
		textFieldFilm.setBounds(78, 37, 194, 20);
		contentPane.add(textFieldFilm);
		textFieldFilm.setColumns(10);

		JLabel lblActori = new JLabel("Actori");
		lblActori.setBounds(10, 68, 46, 14);
		contentPane.add(lblActori);

		textFieldActori = new JTextField();
		textFieldActori.setColumns(10);
		textFieldActori.setBounds(78, 65, 194, 20);
		contentPane.add(textFieldActori);

		JLabel lblAnLansare = new JLabel("An lansare");
		lblAnLansare.setBounds(10, 96, 80, 14);
		contentPane.add(lblAnLansare);

		spinnerAnLansare = new JSpinner();
		spinnerAnLansare.setModel(new SpinnerNumberModel(2015, 2015, 2020, 1));
		spinnerAnLansare.setBounds(78, 93, 80, 20);
		((JSpinner.DefaultEditor) spinnerAnLansare.getEditor()).getTextField().setEditable(false);;
		contentPane.add(spinnerAnLansare);

		JPanel panelGenuri = new JPanel();
		panelGenuri.setBorder(new TitledBorder(null, "Genuri", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGenuri.setBounds(10, 135, 262, 85);
		contentPane.add(panelGenuri);

		chckbxComedie = new JCheckBox("Comedie");
		panelGenuri.add(chckbxComedie);

		chckbxDrama = new JCheckBox("Drama");
		panelGenuri.add(chckbxDrama);

		chckbxIstoric = new JCheckBox("Istoric");
		panelGenuri.add(chckbxIstoric);

		chckbxRomantic = new JCheckBox("Romantic");
		panelGenuri.add(chckbxRomantic);

		chckbxActiune = new JCheckBox("Actiune");
		panelGenuri.add(chckbxActiune);

		myTableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Film", "Actori", "An", "Genuri"})
		{
			boolean[] columnEditables = new boolean[] {false, false, false, false};
			public boolean isCellEditable(int row, int column) 
			{
				return columnEditables[column];
			}
		};

		table = new JTable();
		JScrollPane myScroll = new JScrollPane(table);

		table.setModel(myTableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(600);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		myScroll.setBounds(10, 277, 262, 158);
		contentPane.add(myScroll);

		JButton btnAdauga = new JButton("Adauga");
		btnAdauga.addActionListener(new AdaugaButtonPress());
		btnAdauga.setBounds(10, 231, 89, 23);
		contentPane.add(btnAdauga);

		btnSterge = new JButton("Sterge");
		btnSterge.setEnabled(false);
		btnSterge.addActionListener(new StergeButtonPress());
		btnSterge.setBounds(183, 231, 89, 23);
		contentPane.add(btnSterge);
	}

	public static void main(String[] args) 
	{
		JFrame frame = new Filme("Film");
		frame.setVisible(true);
	}	
}