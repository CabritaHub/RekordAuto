package ERRONKA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextPane;
import javax.swing.SortOrder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Eskaerak extends JFrame implements ActionListener {
	private Statement st, st2;
	private ResultSet rs, rs2;
	private Connection konexioa;
	private Vector<String> Titulo;
	private Vector<Vector<String>> Datuak;
	private static final long serialVersionUID = 1L;
	private DefaultTableModel dlmTabla = new DefaultTableModel();
	private JTable TablaV2 = new JTable(dlmTabla);
	int rowCount = dlmTabla.getRowCount();

	private JScrollPane scrollPane;
	private int filas;
	private JPanel contentPane;
	private JButton Ezabatubtn, Eguneratubtn, Sartubtn, Atzerabtn, Ordenatubtn;
	private JTextPane TxtEskaera;
	private JComboBox<String> MatrikulaCombo;
	private JLabel Eskaeralbl, Langilelbl, Orduaklbl, Piezakllbl, Idlbl, Preziolbl;
	private JTextField TF_Prezioa, TF_Orduak, TF_Langilea, TF_Piezak, TF_LanaId;
	private JSpinner KantitateSpinner;
	private Date DataAux;
	private EskaeraClass Eskaerak;

	
	private String StrLanaId, StrLangilea, STRMatrikula, StrDeskribapena, StrOrduak, StrPrezioa, StrPiezak, StrData,
			StrKantitatea;
	private JLabel Datalbl;
	private JTextField TF_Data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eskaerak frame = new Eskaerak();
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
	public Eskaerak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1098, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		TxtEskaera = new JTextPane();
		TxtEskaera.setBounds(573, 27, 426, 124);
		contentPane.add(TxtEskaera);

		MatrikulaCombo = new JComboBox<String>();
		MatrikulaCombo.addActionListener(this);
		MatrikulaCombo.setBounds(388, 85, 151, 21);
		contentPane.add(MatrikulaCombo);

		Eskaeralbl = new JLabel("ESKAERA: ");
		Eskaeralbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Eskaeralbl.setBounds(425, 27, 83, 35);
		contentPane.add(Eskaeralbl);

		Ezabatubtn = new JButton("Ezabatu");
		Ezabatubtn.addActionListener(this);
		Ezabatubtn.setBounds(418, 171, 104, 21);
		contentPane.add(Ezabatubtn);

		Eguneratubtn = new JButton("Eguneratu");
		Eguneratubtn.addActionListener(this);
		Eguneratubtn.setBounds(573, 171, 104, 21);
		contentPane.add(Eguneratubtn);

		Sartubtn = new JButton("Sartu");
		Sartubtn.addActionListener(this);
		Sartubtn.setBounds(719, 171, 104, 21);
		contentPane.add(Sartubtn);

		Atzerabtn = new JButton("Atzera");
		Atzerabtn.addActionListener(this);
		Atzerabtn.setBounds(860, 171, 104, 21);
		contentPane.add(Atzerabtn);
		
		Ordenatubtn = new JButton("Ordenatu");
		Ordenatubtn.addActionListener(this);
		Ordenatubtn.setBounds(29, 217, 85, 21);
		contentPane.add(Ordenatubtn);

		Langilelbl = new JLabel("Langilea");
		Langilelbl.setBounds(192, 40, 83, 22);
		contentPane.add(Langilelbl);

		TF_Langilea = new JTextField();
		TF_Langilea.setText("Pepe");
		TF_Langilea.setBounds(253, 43, 96, 19);
		contentPane.add(TF_Langilea);
		TF_Langilea.setColumns(10);

		Orduaklbl = new JLabel("Orduak");
		Orduaklbl.setBounds(192, 85, 45, 21);
		contentPane.add(Orduaklbl);

		TF_Orduak = new JTextField();
		TF_Orduak.setText("72");
		TF_Orduak.setBounds(253, 85, 96, 19);
		contentPane.add(TF_Orduak);
		TF_Orduak.setColumns(10);

		Piezakllbl = new JLabel("Piezak");
		Piezakllbl.setBounds(10, 130, 45, 21);
		contentPane.add(Piezakllbl);

		TF_Piezak = new JTextField();
		TF_Piezak.setText("Tornillo Volador");
		TF_Piezak.setBounds(65, 131, 96, 19);
		contentPane.add(TF_Piezak);
		TF_Piezak.setColumns(10);

		Idlbl = new JLabel("Lana ID");
		Idlbl.setBounds(10, 40, 83, 22);
		contentPane.add(Idlbl);

		TF_LanaId = new JTextField();
		TF_LanaId.setText("3");
		TF_LanaId.setColumns(10);
		TF_LanaId.setBounds(67, 43, 96, 19);
		contentPane.add(TF_LanaId);

		KantitateSpinner = new JSpinner();
		KantitateSpinner.setBounds(192, 131, 36, 20);
		contentPane.add(KantitateSpinner);

		Preziolbl = new JLabel("Prezioa");
		Preziolbl.setBounds(10, 175, 68, 13);
		contentPane.add(Preziolbl);

		TF_Prezioa = new JTextField();
		TF_Prezioa.setText("45");
		TF_Prezioa.setColumns(10);
		TF_Prezioa.setBounds(65, 172, 96, 19);
		contentPane.add(TF_Prezioa);

		Datalbl = new JLabel("Data");
		Datalbl.setBounds(10, 84, 83, 22);
		contentPane.add(Datalbl);

		TF_Data = new JTextField();
		TF_Data.setText("2022-04-06");
		TF_Data.setColumns(10);
		TF_Data.setBounds(67, 86, 96, 19);
		contentPane.add(TF_Data);

//		CONECTA A LA BASE DE DATOS	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			konexioa = DriverManager.getConnection("jdbc:mysql://localhost/rekordauto", "root", "");
			// Statement instantzi berri bat ireki
			st = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ((java.sql.Statement) st).executeQuery("SELECT * FROM lana");
			st2 = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			MatrikulaComboKargatu();

			System.out.println("Se puede acceder a la base de datos");

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("No se puede acceder a la BD");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Taulasortu();
		} catch (SQLException e) {
			// e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(null, "Ezin da taula egin", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void Taulasortu() throws SQLException {
		Titulo = new Vector<String>();

		Titulo.add("Lana ID");
		Titulo.add("Langilea");
		Titulo.add("Matrikula");
		Titulo.add("Deskribapena");
		Titulo.add("Piezak");
		Titulo.add("Kant");
		Titulo.add("Prezioa");
		Titulo.add("Orduak");
		Titulo.add("Data");

		dlmTabla = new DefaultTableModel(Datuak, Titulo);
		TablaV2 = new JTable(dlmTabla);

		TablaV2.setEnabled(false);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 260, 972, 170);
		scrollPane.setViewportView(TablaV2);
		contentPane.add(scrollPane);
		
		
	

		TaulaKargatu();
	}

	public void TaulaKargatu() throws SQLException {
		
		
		rs.first();

		rs.absolute(0);

		dlmTabla.setRowCount(0);

		while (rs.next()) {
			Vector<String> lerroa = new Vector<String>();

			lerroa.add((String) rs.getObject("Lana_id"));
			lerroa.add((String) rs.getObject("Langilea"));
			lerroa.add((String) rs.getObject("Matrikula"));
			lerroa.add((String) rs.getObject("Deskribapena"));
			lerroa.add((String) rs.getObject("Piezak"));
			lerroa.add("" + rs.getObject("Kantitatea"));
			lerroa.add("" + rs.getObject("Prezioa"));
			lerroa.add("" + rs.getObject("Orduak"));
			// Aldatu Data datetik Stringra
			DataAux = (Date) rs.getObject("LanData");
			lerroa.add((DataAux.toString()));

			dlmTabla.addRow(lerroa);
		}
	}

	public void MatrikulaComboKargatu() throws SQLException {
		st2 = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs2 = (ResultSet) st2.executeQuery("SELECT Matrikula FROM autoa");

		while (rs2.next()) {
			MatrikulaCombo.addItem("" + rs2.getObject("Matrikula"));
		}
	}

	public void MatrikulazKargatu() throws SQLException {

		rs = ((java.sql.Statement) st).executeQuery("SELECT * FROM lana WHERE Matrikula='" + MatrikulaCombo.getSelectedItem() + "'");

		rs.first();

		rs.absolute(0);

		TaulaKargatu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == Atzerabtn) {

			Menua MenuaP;
			MenuaP = new Menua();
			MenuaP.setVisible(true);
			setVisible(false);

		}

		
		if (source == Eguneratubtn) {

			StrLanaId = TF_LanaId.getText();
			StrLangilea = TF_Langilea.getText();
			STRMatrikula = (String) MatrikulaCombo.getSelectedItem();
			StrDeskribapena = TxtEskaera.getText();
			StrPiezak = TF_Piezak.getText();
			StrPrezioa = TF_Prezioa.getText();
			StrKantitatea = "" + KantitateSpinner.getValue();
			StrOrduak = TF_Orduak.getText();
			StrData = TF_Data.getText();

			Eskaerak = new EskaeraClass(StrLanaId, StrLangilea, STRMatrikula, StrDeskribapena, StrPiezak, StrPrezioa,
					StrKantitatea, StrOrduak, StrData);

			try {

				rs = ((java.sql.Statement) st).executeQuery("SELECT * FROM lana");

				st.executeUpdate("call EguneratuLana ('" + Eskaerak.getLana_id().toString() + "','"
						+ Eskaerak.getLangilea().toString() + "', '" + Eskaerak.getMatrikula().toString() + "', '"
						+ Eskaerak.getDeskribapena().toString() + "', '" + Eskaerak.getPiezak().toString() + "', '"
						+ Eskaerak.getPrezioa().toString() + "', '" + Eskaerak.getKantitatea().toString() + "', '"
						+ Eskaerak.getOrduak().toString() + "', '" + Eskaerak.getData().toString() + "') ");
				MatrikulazKargatu();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		
		if (source == Sartubtn) {

			StrLanaId = TF_LanaId.getText();
			StrLangilea = TF_Langilea.getText();
			STRMatrikula = (String) MatrikulaCombo.getSelectedItem();
			StrDeskribapena = TxtEskaera.getText();
			StrPiezak = TF_Piezak.getText();
			StrPrezioa = TF_Prezioa.getText();
			StrKantitatea = "" + KantitateSpinner.getValue();
			StrOrduak = TF_Orduak.getText();
			StrData = TF_Data.getText();

			Eskaerak = new EskaeraClass(StrLanaId, StrLangilea, STRMatrikula, StrDeskribapena, StrPiezak, StrPrezioa,
					StrKantitatea, StrOrduak, StrData);

			try {

				rs = ((java.sql.Statement) st).executeQuery("SELECT * FROM lana");

				st.executeUpdate("call SartuEskaera ('" + Eskaerak.getLana_id().toString() + "','"
						+ Eskaerak.getLangilea().toString() + "', '" + Eskaerak.getMatrikula().toString() + "', '"
						+ Eskaerak.getDeskribapena().toString() + "', '" + Eskaerak.getPiezak().toString() + "', '"
						+ Eskaerak.getPrezioa().toString() + "', '" + Eskaerak.getKantitatea().toString() + "', '"
						+ Eskaerak.getOrduak().toString() + "', '" + Eskaerak.getData().toString() + "') ");
				MatrikulazKargatu();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		
		if (source == Ezabatubtn) {
			try {
				st.executeUpdate("DELETE FROM lana WHERE Lana_id='" + TF_LanaId.getText() + "'");
				MatrikulazKargatu();

			} catch (SQLException i) {
				i.printStackTrace();
			}
		}

		
		if (source == MatrikulaCombo) {
			try {
				MatrikulazKargatu();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		if (source == Ordenatubtn) {
			
		
            
     
			
		}
		
	
	}
}
