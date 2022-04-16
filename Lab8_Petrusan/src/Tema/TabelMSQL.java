package Tema;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

@SuppressWarnings("serial")
public class TabelMSQL extends JFrame {

	private JPanel contentPane;
	private JTextField txtCursor;
	private JTextField txtId;
	private JTextField txtNume;
	private JTextField txtVarsta;
	private JButton btnMoveFirst, btnMoveBack, btnMoveNext, btnMoveLast;
	private JButton btnAdd, btnFind, btnDelete, btnSave, btnUndo, btnEdit;
	public int stare;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					TabelMSQL frame = new TabelMSQL();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public TabelMSQL() throws SQLException {
		/////
		String url = "jdbc:mysql://localhost:3306/test";
		Statement sql;
		ResultSet rs;
		Connection con;
		con = DriverManager.getConnection(url, "root", "admin");
		sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = sql.executeQuery("select * from persoane");
		while (rs.next())
			System.out.println("id=" + rs.getInt("Id") + ", nume= " + rs.getString("nume") + ",varsta=" + rs.getInt(3));

		///////////////////////////////////////////////////////////////////////////////////////////

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 424, 37);
		contentPane.add(toolBar);

		btnMoveFirst = new JButton(new ImageIcon(TabelMSQL.class.getResource("/Imagini/MoveFirst.png")));
		btnMoveFirst.setToolTipText("Move First");
		btnMoveBack = new JButton(new ImageIcon(TabelMSQL.class.getResource("/Imagini/MovePrevious.png")));
		btnMoveBack.setToolTipText("Previous");
		btnMoveNext = new JButton(new ImageIcon(TabelMSQL.class.getResource("/Imagini/MoveNext.png")));
		btnMoveNext.setToolTipText("Next");
		btnMoveLast = new JButton(new ImageIcon(TabelMSQL.class.getResource("/Imagini/MoveLast.png")));
		btnMoveLast.setToolTipText("Move Last");
		btnAdd = new JButton(new ImageIcon(TabelMSQL.class.getResource("/Imagini/Add.png")));
		btnAdd.setToolTipText("Add");
		btnEdit = new JButton(new ImageIcon(TabelMSQL.class.getResource("/Imagini/Edit.png")));
		btnEdit.setToolTipText("Edit");
		btnDelete = new JButton(new ImageIcon(TabelMSQL.class.getResource("/Imagini/Delete.png")));
		btnDelete.setToolTipText("Delete");
		btnFind = new JButton(new ImageIcon(TabelMSQL.class.getResource("/Imagini/find.JPG")));
		btnFind.setToolTipText("Find");
		btnSave = new JButton(new ImageIcon(TabelMSQL.class.getResource("/Imagini/save.JPG")));
		btnSave.setToolTipText("Save");
		btnUndo = new JButton(new ImageIcon(TabelMSQL.class.getResource("/Imagini/undo.JPG")));
		btnUndo.setToolTipText("Undo");
		txtCursor = new JTextField();

		toolBar.add(btnMoveFirst);
		toolBar.add(btnMoveBack);
		toolBar.add(txtCursor);
		txtCursor.setColumns(10);
		toolBar.add(btnMoveNext);
		toolBar.add(btnMoveLast);
		toolBar.add(btnAdd);
		toolBar.add(btnEdit);
		toolBar.add(btnDelete);
		toolBar.add(btnFind);
		toolBar.add(btnSave);
		toolBar.add(btnUndo);

		txtId = new JTextField();
		txtId.setBounds(115, 74, 128, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		txtNume = new JTextField();
		txtNume.setColumns(10);
		txtNume.setBounds(115, 105, 128, 20);
		contentPane.add(txtNume);

		txtVarsta = new JTextField();
		txtVarsta.setColumns(10);
		txtVarsta.setBounds(115, 139, 128, 20);
		contentPane.add(txtVarsta);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(74, 77, 46, 14);
		contentPane.add(lblId);

		JLabel lblNume = new JLabel("Nume");
		lblNume.setBounds(74, 111, 46, 14);
		contentPane.add(lblNume);

		JLabel lblVarsta = new JLabel("Varsta");
		lblVarsta.setBounds(74, 142, 46, 14);
		contentPane.add(lblVarsta);

		// Modul 1 -- Initializare
		Starea1(rs);
		int nrLinii = ActualizareNrLinii(rs);
		IncarcaDate(rs);

		btnMoveFirst.addActionListener(new ActionListener() { // INCEPUT
			public void actionPerformed(ActionEvent e) {
				try {
					rs.first();
					IncarcaDate(rs);
					btnMoveBack.setEnabled(false);
					btnMoveFirst.setEnabled(false);
					btnMoveNext.setEnabled(true);
					btnMoveLast.setEnabled(true);
					txtCursor.setText(String.valueOf(rs.getRow()) + "/" + String.valueOf(nrLinii));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnMoveBack.addActionListener(new ActionListener() { // INAPOI
			public void actionPerformed(ActionEvent e) {
				try {
					rs.previous();
					IncarcaDate(rs);
					btnMoveNext.setEnabled(true);
					btnMoveLast.setEnabled(true);
					txtCursor.setText(String.valueOf(rs.getRow()) + "/" + String.valueOf(nrLinii));
					if (rs.isFirst()) {
						btnMoveBack.setEnabled(false);
						btnMoveFirst.setEnabled(false);
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnMoveNext.addActionListener(new ActionListener() { // INAINTE
			public void actionPerformed(ActionEvent e) {
				try {
					rs.next();
					IncarcaDate(rs);
					btnMoveBack.setEnabled(true);
					btnMoveFirst.setEnabled(true);
					txtCursor.setText(String.valueOf(rs.getRow()) + "/" + String.valueOf(nrLinii));
					if (rs.isLast()) {
						btnMoveNext.setEnabled(false);
						btnMoveLast.setEnabled(false);
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		btnMoveLast.addActionListener(new ActionListener() { // SFARSIT
			public void actionPerformed(ActionEvent e) {
				try {
					rs.last();
					IncarcaDate(rs);
					btnMoveNext.setEnabled(false);
					btnMoveLast.setEnabled(false);
					btnMoveBack.setEnabled(true);
					btnMoveFirst.setEnabled(true);
					txtCursor.setText(String.valueOf(rs.getRow()) + "/" + String.valueOf(nrLinii));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnAdd.addActionListener(new ActionListener() { // ADAUGA
			public void actionPerformed(ActionEvent e) {
				Starea2(rs);
				txtId.setText("");
				txtNume.setText("");
				txtVarsta.setText("");
				stare = 1;
			}
		});

		btnEdit.addActionListener(new ActionListener() { // EDIT
			public void actionPerformed(ActionEvent e) {
				Starea2(rs);
				stare = 2;
			}
		});

		btnDelete.addActionListener(new ActionListener() { // STERGE ------ PROBLEM
			public void actionPerformed(ActionEvent e) {
				try {
					int r = JOptionPane.showConfirmDialog(null,
							"Sunteti sigur ca doriti sa stergeti aceasta persoana?");
					if (r == 0) {
						rs.deleteRow();
						Starea1(rs);
						ActualizareNrLinii(rs);
						IncarcaDate(rs);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnSave.addActionListener(new ActionListener() { // SAVE
			public void actionPerformed(ActionEvent e) {
				try {
					int r = JOptionPane.showConfirmDialog(null, "Salvati modificarile?");
					if (r == 0 && stare == 2) {
						rs.absolute(rs.getRow());
						rs.updateInt(1, Integer.valueOf(txtId.getText()));
						rs.updateString(2, txtNume.getText());
						rs.updateInt(3, Integer.valueOf(txtVarsta.getText()));
						rs.updateRow();
						Starea1(rs);
						stare = 0;
					}
					if (r == 0 && stare == 1) {
						rs.absolute(rs.getRow());
						rs.moveToInsertRow();
						rs.updateInt(1, Integer.valueOf(txtId.getText()));
						rs.updateString("nume", txtNume.getText());
						rs.updateInt("varsta", Integer.valueOf(txtVarsta.getText()));
						rs.insertRow();
						ActualizareNrLinii(rs);
						Starea1(rs);
						stare = 0;
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Modificare nereusita");
					try {
						Starea1(rs);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					e1.printStackTrace();
				}
			}
		});

		btnFind.addActionListener(new ActionListener() { // CAUTA
			public void actionPerformed(ActionEvent e) {
				String cautare;
				cautare = JOptionPane.showInputDialog(null, "Numele:");

				try {
					String url = "jdbc:mysql://localhost:3306/test";
					Statement sql;
					ResultSet rs;
					Connection con;
					con = DriverManager.getConnection(url, "root", "admin");
					sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					rs = sql.executeQuery("select * from persoane");
					PreparedStatement pr = con.prepareStatement("select * from persoane where nume=?");
					pr.setString(1, cautare);
					rs = pr.executeQuery();
					
					while (rs.next()) {
						txtId.setText(String.valueOf(rs.getInt("Id")));
						txtNume.setText(rs.getString("nume"));
						txtVarsta.setText(String.valueOf(rs.getInt(3)));
						System.out.println(rs.getRow());
					}
					txtCursor.setText(String.valueOf(rs.getRow()) + "/" + String.valueOf(nrLinii));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnUndo.addActionListener(new ActionListener() { // UNDO
			public void actionPerformed(ActionEvent e) {
				try {
					
					Starea1(rs);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		// con.close();
		// sql.close();
		// rs.close();

	}

	public int ActualizareNrLinii(ResultSet rs) throws SQLException {
		rs.last();
		int nrLinii = rs.getRow();
		rs.first();
		txtCursor.setText(String.valueOf(rs.getRow()) + "/" + String.valueOf(nrLinii));
		return nrLinii;
	}

	public void Starea1(ResultSet rs) throws SQLException {
		btnSave.setEnabled(false);
		btnUndo.setEnabled(false);
		btnMoveBack.setEnabled(false);
		btnMoveFirst.setEnabled(false);// TO DO de pus toate butoanele true/false
		btnMoveNext.setEnabled(true);
		btnMoveLast.setEnabled(true);
		btnAdd.setEnabled(true);
		btnEdit.setEnabled(true);
		btnFind.setEnabled(true);
		btnDelete.setEnabled(true);

		txtNume.setEnabled(false);
		txtNume.setBackground(ColorUIResource.gray);
		txtId.setEnabled(false);
		txtId.setBackground(ColorUIResource.gray);
		txtVarsta.setEnabled(false);
		txtVarsta.setBackground(ColorUIResource.gray);
		txtCursor.setEditable(false);
		rs.beforeFirst();
	}

	public void Starea2(ResultSet rs) {
		btnSave.setEnabled(true);
		btnUndo.setEnabled(true);
		btnMoveBack.setEnabled(false);
		btnMoveFirst.setEnabled(false);
		btnMoveNext.setEnabled(false);
		btnMoveLast.setEnabled(false);
		btnAdd.setEnabled(false);
		btnEdit.setEnabled(false);
		btnFind.setEnabled(false);
		btnDelete.setEnabled(false);

		txtNume.setEnabled(true);
		txtNume.setBackground(ColorUIResource.white);
		txtId.setEnabled(true);
		txtId.setBackground(ColorUIResource.white);
		txtVarsta.setEnabled(true);
		txtVarsta.setBackground(ColorUIResource.white);

	}

	public void IncarcaDate(ResultSet rs) {
		try {
			txtId.setText(rs.getString("id"));
			txtNume.setText(rs.getString("nume"));
			txtVarsta.setText(rs.getString("varsta"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
