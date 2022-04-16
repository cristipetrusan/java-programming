package javaGt;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("serial")
public class Main extends JFrame {
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	private JPanel contentPane;
	private JLabel lblOra;
	private Timer timer;
	private JFileChooser fileChooser;
	private File fisierSelectat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.setIconImage(new ImageIcon("Icon\\xml.png").getImage());
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Procesare XML");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// CEAS
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblOra.setText(simpleDateFormat.format(new Date()));
			}
		});
		timer.setInitialDelay(0);
		timer.start();
		FileNameExtensionFilter extension = new FileNameExtensionFilter("XML Documents (*.xml)", "xml");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 416, 185);
		contentPane.add(scrollPane);

		JTree tree = new JTree();
		tree.setModel(null);
		scrollPane.setViewportView(tree);

		// BUTON 'OPEN XML'
		JButton btnNewButton = new JButton("Open XML");
		btnNewButton.setBounds(10, 20, 85, 25);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser("c:\\users\\georg\\eclipse-workspace\\Lab9_Petrusan\\src\\javaGt\\XML");
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.addChoosableFileFilter(extension);
				int optiune = fileChooser.showOpenDialog(null);
				if (optiune == JFileChooser.APPROVE_OPTION) {
					fisierSelectat = fileChooser.getSelectedFile();
					try {
						DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
						DocumentBuilder builder = factory.newDocumentBuilder();
						Document document = builder.parse(fisierSelectat);
						Element radacinaArboreDom = document.getDocumentElement();
						DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode(
								radacinaArboreDom.getNodeName());
						DefaultTreeModel defaultTreeModel = new DefaultTreeModel(defaultMutableTreeNode);
						tree.setModel(defaultTreeModel);
						functieRecursiva(radacinaArboreDom, defaultMutableTreeNode);
					} catch (Exception ex) {
						System.out.println("Nu s-a selectat niciun fisier");
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 10));

		// Label-ul pentru ceas
		lblOra = new JLabel();
		lblOra.setBounds(370, 23, 56, 13);
		contentPane.add(lblOra);
		lblOra.setText(simpleDateFormat.format(new Date()));

	}

	public static void functieRecursiva(Node radacina, DefaultMutableTreeNode radacinaTree) {
		NodeList nodeList;
		DefaultMutableTreeNode defaultMutableTreeNode = null;
		if (radacina.hasChildNodes()) {
			nodeList = radacina.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				radacina = nodeList.item(i);
				if (radacina.getNodeType() == Node.ELEMENT_NODE) {
					defaultMutableTreeNode = new DefaultMutableTreeNode(radacina.getNodeName());
					radacinaTree.add(defaultMutableTreeNode); // legatura cu parintele
				} else if (radacina.getNodeType() == Node.TEXT_NODE && !radacina.getNodeValue().isBlank()) {
					defaultMutableTreeNode = new DefaultMutableTreeNode(radacina.getNodeValue());
					radacinaTree.add(defaultMutableTreeNode); // legatura cu parintele
				}
				functieRecursiva(nodeList.item(i), defaultMutableTreeNode);
			}
		}
	}
}
