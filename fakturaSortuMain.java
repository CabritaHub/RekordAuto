package ERRONKA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class fakturaSortuMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField tfTelefonoa;
	private JTextField tfPostaKodea;
	private JTextField tfIzena;
	private JTextField tfHerrialdea;
	private JTextField tfAbizena;
	private JTextField tfDekorazioa1;
	private JTextField tfDekorazioa2;
	private JTextField tfEmail;
	private JTextField tfAltaData;
	private JTextField tfDekorazioa3;
	private JTextField tfModeloa;
	private JTextField tfUrtea;
	private JTextField tfBaztidorea;
	private JTextField tfMarka;
	private JTextField tfDekorazioa4;
	private JTextField tfArazoa;
	
	private JScrollPane sp;
	
	private JLabel lbData;
	
	private JTable taula;
	private DefaultTableModel piezaTaula;
	
	private JComboBox<String> cbKotxea;
	private JComboBox<String> cbBezeroa;
	private JComboBox<String> cbLanAgindua;
	
	private String indx;
	private int cont;

	//Aldagaiak
	private String matrikula;
	private String urtea;
	private String marka;
	private String modeloa;
	private String baztidorea;
	private String nanKotxea;
	
	private String nanPertsona;
	private String izena;
	private String abizena;
	private String email;
	private String herrialdea;
	private String altaData;
	
	private String postaKodea;
	private String telefonoa;

	//SQL konponenteak
	private ResultSet rs1;
	private Statement st1;
	
	private ResultSet rs2;
	private Statement st2;
	
	//Objetuak
	private KotxeakTaulaClass datuakKotxea;
	private BezeroClass datuakPertsona;
	private FakturaSortuClass datuakLanAgindua;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fakturaSortuMain frame = new fakturaSortuMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public fakturaSortuMain() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 807);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfTelefonoa = new JTextField();
		tfTelefonoa.setText("Telefonoa");
		tfTelefonoa.setColumns(10);
		tfTelefonoa.setBounds(20, 208, 161, 37);
		contentPane.add(tfTelefonoa);
		
		tfPostaKodea = new JTextField();
		tfPostaKodea.setText("Posta kodea");
		tfPostaKodea.setColumns(10);
		tfPostaKodea.setBounds(228, 208, 161, 37);
		contentPane.add(tfPostaKodea);
		
		
		tfIzena = new JTextField();
		tfIzena.setText("Izena");
		tfIzena.setColumns(10);
		tfIzena.setBounds(228, 149, 161, 37);
		contentPane.add(tfIzena);
		
		tfHerrialdea = new JTextField();
		tfHerrialdea.setText("Herrialdea");
		tfHerrialdea.setColumns(10);
		tfHerrialdea.setBounds(437, 208, 161, 37);
		contentPane.add(tfHerrialdea);
		
		tfAbizena = new JTextField();
		tfAbizena.setText("Abizena");
		tfAbizena.setColumns(10);
		tfAbizena.setBounds(437, 149, 161, 37);
		contentPane.add(tfAbizena);
		
		tfDekorazioa1 = new JTextField();
		tfDekorazioa1.setBackground(Color.BLACK);
		tfDekorazioa1.setEnabled(false);
		tfDekorazioa1.setEditable(false);
		tfDekorazioa1.setBounds(20, 57, 369, 8);
		contentPane.add(tfDekorazioa1);
		tfDekorazioa1.setColumns(10);
		
		tfDekorazioa2 = new JTextField();
		tfDekorazioa2.setEnabled(false);
		tfDekorazioa2.setEditable(false);
		tfDekorazioa2.setColumns(10);
		tfDekorazioa2.setBackground(Color.BLACK);
		tfDekorazioa2.setBounds(20, 121, 77, 8);
		contentPane.add(tfDekorazioa2);
		
		tfEmail = new JTextField();
		tfEmail.setText("Email");
		tfEmail.setColumns(10);
		tfEmail.setBounds(20, 269, 369, 37);
		contentPane.add(tfEmail);
		
		tfAltaData = new JTextField();
		tfAltaData.setText("Alta data");
		tfAltaData.setColumns(10);
		tfAltaData.setBounds(437, 269, 161, 37);
		contentPane.add(tfAltaData);
		
		tfDekorazioa3 = new JTextField();
		tfDekorazioa3.setEnabled(false);
		tfDekorazioa3.setEditable(false);
		tfDekorazioa3.setColumns(10);
		tfDekorazioa3.setBackground(Color.BLACK);
		tfDekorazioa3.setBounds(20, 348, 77, 8);
		contentPane.add(tfDekorazioa3);
		
		tfModeloa = new JTextField();
		tfModeloa.setText("Modeloa");
		tfModeloa.setColumns(10);
		tfModeloa.setBounds(228, 435, 161, 37);
		contentPane.add(tfModeloa);
		
		tfUrtea = new JTextField();
		tfUrtea.setText("Urtea");
		tfUrtea.setColumns(10);
		tfUrtea.setBounds(437, 376, 161, 37);
		contentPane.add(tfUrtea);
		
		tfBaztidorea = new JTextField();
		tfBaztidorea.setText("Baztidorea");
		tfBaztidorea.setColumns(10);
		tfBaztidorea.setBounds(437, 435, 161, 37);
		contentPane.add(tfBaztidorea);
		
		tfMarka = new JTextField();
		tfMarka.setText("Marka");
		tfMarka.setColumns(10);
		tfMarka.setBounds(20, 435, 161, 37);
		contentPane.add(tfMarka);
		
		tfDekorazioa4 = new JTextField();
		tfDekorazioa4.setEnabled(false);
		tfDekorazioa4.setEditable(false);
		tfDekorazioa4.setColumns(10);
		tfDekorazioa4.setBackground(Color.BLACK);
		tfDekorazioa4.setBounds(20, 514, 77, 8);
		contentPane.add(tfDekorazioa4);
		
		tfArazoa = new JTextField();
		tfArazoa.setText("Arazoa");
		tfArazoa.setColumns(10);
		tfArazoa.setBounds(20, 543, 473, 37);
		contentPane.add(tfArazoa);	
		
		JLabel lbLangileIzena = new JLabel("LANGILEA: Emanuel Hernandez");
		lbLangileIzena.setBounds(20, 25, 243, 28);
		contentPane.add(lbLangileIzena);
		
		lbData = new JLabel("2022-04-21   14:34");
		lbData.setHorizontalAlignment(SwingConstants.RIGHT);
		lbData.setBounds(267, 25, 122, 28);
		contentPane.add(lbData);
		
		JLabel lbImage = new JLabel("");
		lbImage.setIcon(new ImageIcon(fakturaSortuMain.class.getResource("/ERRONKA/loginIcon.png")));
		lbImage.setBounds(443, 25, 161, 81);
		contentPane.add(lbImage);
		
		JLabel lbBezeroDatuak = new JLabel("BEZERO DATUAK");
		lbBezeroDatuak.setBounds(20, 89, 102, 28);
		contentPane.add(lbBezeroDatuak);
		
		JLabel lbKotxeDatuak = new JLabel("KOTXEAREN DATUAK");
		lbKotxeDatuak.setBounds(20, 316, 174, 28);
		contentPane.add(lbKotxeDatuak);
		
		JLabel lbLanAgindua = new JLabel("LAN AGINDUA");
		lbLanAgindua.setBounds(20, 482, 174, 28);
		contentPane.add(lbLanAgindua);
		
		JLabel lbPrezioa = new JLabel("PREZIOA: 2056\u20AC");
		lbPrezioa.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbPrezioa.setBounds(20, 720, 174, 29);
		contentPane.add(lbPrezioa);
		
		JLabel lbBez = new JLabel("BEZ: 218\u20AC");
		lbBez.setHorizontalAlignment(SwingConstants.CENTER);
		lbBez.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbBez.setBounds(228, 720, 174, 29);
		contentPane.add(lbBez);
		
		JLabel lbTotala = new JLabel("TOTALA: 5642\u20AC");
		lbTotala.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTotala.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTotala.setBounds(430, 720, 174, 29);
		contentPane.add(lbTotala);
		
		sp = new JScrollPane();
		sp.setBounds(20, 600, 473, 99);
		contentPane.add(sp);
		
		//taula = new JTable();
		//scrollPane.setViewportView(taula);
		
		cbBezeroa = new JComboBox<String>();
		cbBezeroa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					tfUrtea.setText("");
					tfModeloa.setText("");
					tfBaztidorea.setText("");
					tfMarka.setText("");
					
					KotxeaAukeratu();
					DatuakEraikituPertsona();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}	
		});
		cbBezeroa.setToolTipText("");
		cbBezeroa.setBounds(20, 149, 161, 37);
		contentPane.add(cbBezeroa);
		
		cbKotxea = new JComboBox<String>();

		cbKotxea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfUrtea.setText("");
				tfModeloa.setText("");
				tfBaztidorea.setText("");
				tfMarka.setText("");
		}
		});
		cbKotxea.setToolTipText("");
		cbKotxea.setBounds(20, 376, 161, 37);
		contentPane.add(cbKotxea);
		
		cbLanAgindua = new JComboBox<String>();
		cbLanAgindua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cbLanAgindua.setToolTipText("");
		cbLanAgindua.setBounds(517, 543, 81, 37);
		contentPane.add(cbLanAgindua);
		
		JButton btnImprimatuPDF = new JButton("PDF");
		btnImprimatuPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImprimatuPDF.setBounds(517, 662, 85, 37);
		contentPane.add(btnImprimatuPDF);
		
		JButton btnAukeratu = new JButton("Aukeratu");
		btnAukeratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DatuakEraikituLanAgindua();
					 PiezaTaulaBete();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAukeratu.setBounds(517, 600, 85, 37);
		contentPane.add(btnAukeratu);
		
		JButton btnMatrikulaAukeratu = new JButton("Matrikula aukeratu");
		btnMatrikulaAukeratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatuakEraikituKotxea();
					LanaAukeratu();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnMatrikulaAukeratu.setBounds(228, 376, 161, 37);
		contentPane.add(btnMatrikulaAukeratu);
		
		
		try {
			BezeroaAukeratu();
			

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		   LocalDateTime now = LocalDateTime.now();  

		   lbData.setText(dtf.format(now));
		   
			taula = new JTable();
			taula.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Artikulua", "Kantitatea", "Prezioa", "BEZ/a", "Totala"
				}
			) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
			
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			taula.getColumnModel().getColumn(0).setResizable(false);
			taula.getColumnModel().getColumn(1).setResizable(false);
			taula.getColumnModel().getColumn(2).setResizable(false);
			taula.getColumnModel().getColumn(3).setResizable(false);
			taula.getColumnModel().getColumn(4).setResizable(false);
			taula.getColumnModel().getColumn(5).setResizable(false);

			sp.setViewportView(taula);
	}
	
	public void BezeroaAukeratu() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//SQL-rekin konexioa hasteko
			Connection konexioa;
			konexioa= DriverManager.getConnection("jdbc:mysql://localhost/recordauto", "root", "");

			//Statement-a sortzeko
			st1 = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Resultset-a sortzeko eta select kontsulta exekutatzeko 
			rs1 = st1.executeQuery("SELECT Nan FROM bezeroa");
			
			cbBezeroa.removeAllItems();
			
			rs1.first();
		    DatuakEraikituBezeroa();
		    
			while(rs1.next())
			{					
				DatuakEraikituBezeroa();
			}
			
			
			cbBezeroa.setSelectedItem(indx);
						
									
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void DatuakEraikituBezeroa() throws SQLException
	{

		nanPertsona = rs1.getObject("Nan").toString();
		cbBezeroa.addItem(nanPertsona);

	}
	
	private void KotxeaAukeratu() throws SQLException
	{
		cbKotxea.removeAllItems();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//SQL-rekin konexioa hasteko
			Connection konexioa;
			konexioa= DriverManager.getConnection("jdbc:mysql://localhost/recordauto", "root", "");

			//Statement-a sortzeko
			st2 = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Resultset-a sortzeko eta select kontsulta exekutatzeko 
			rs2 = st2.executeQuery("SELECT * FROM autoa WHERE Nan = '"+cbBezeroa.getSelectedItem().toString()+"'");
			
			//Lehenengo pozizioa aukeratzeko
			rs2.first();

			cbKotxea.addItem(rs2.getObject("Matrikula").toString());			
			while(rs2.next())
			{					
				cbKotxea.addItem(rs2.getObject("Matrikula").toString());
			}
									
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//Datuak objetu batean eraikitzeko
	private void DatuakEraikituPertsona() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//SQL-rekin konexioa hasteko
			Connection konexioa;
			konexioa= DriverManager.getConnection("jdbc:mysql://localhost/recordauto", "root", "");

			//Statement-a sortzeko
			st1 = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Resultset-a sortzeko eta select kontsulta exekutatzeko 
			rs1 = st1.executeQuery("SELECT * FROM bezeroa WHERE Nan = '"+cbBezeroa.getSelectedItem().toString()+"'");

 
			indx = cbBezeroa.getSelectedItem().toString();
			rs1.first();
		
		nanPertsona = rs1.getObject("Nan").toString();
		izena = rs1.getObject("Izena").toString();
		abizena = rs1.getObject("Abizena").toString();
		email = rs1.getObject("PostaElektronikoa").toString();
		herrialdea = rs1.getObject("Herrialdea").toString();
		altaData = rs1.getObject("AltaData").toString();
		postaKodea = rs1.getObject("PostaKodea").toString();
		telefonoa = rs1.getObject("Telefonoa").toString();
		
		datuakPertsona = new BezeroClass(nanPertsona, izena, abizena, email, herrialdea, altaData, postaKodea, telefonoa);	

		tfIzena.setText(datuakPertsona.getIzena());
		tfAbizena.setText(datuakPertsona.getAbizena());
		tfEmail.setText(datuakPertsona.getPostaKode());
		tfHerrialdea.setText(datuakPertsona.getHerrialde());
		tfAltaData.setText(datuakPertsona.getAlta());
		tfPostaKodea.setText(datuakPertsona.getPostaKode());
		tfTelefonoa.setText(datuakPertsona.getMugikor());
		

		BezeroaAukeratu();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private void DatuakEraikituKotxea() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//SQL-rekin konexioa hasteko
			Connection konexioa;
			konexioa= DriverManager.getConnection("jdbc:mysql://localhost/recordauto", "root", "");

			//Statement-a sortzeko
			st2 = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Resultset-a sortzeko eta select kontsulta exekutatzeko 
			rs2 = st2.executeQuery("SELECT * FROM autoa WHERE Matrikula = '"+cbKotxea.getSelectedItem().toString()+"'");

 
			rs2.first();
			
			
    	//Nahi ditugun zutabearen datuak autatzeko
		urtea = rs2.getObject("Urtea").toString();
		marka = rs2.getObject("Marka").toString();
    	modeloa = rs2.getObject("Modeloa").toString();
		baztidorea = rs2.getObject("Baztidora").toString();
		nanKotxea = rs2.getObject("NAN").toString();
		
		//Aurreko datuen informazioa objetua eraikitzeko 
		datuakKotxea = new KotxeakTaulaClass(matrikula, urtea, marka, modeloa, baztidorea, nanPertsona);
		
		tfUrtea.setText(datuakKotxea.getUrtea());
		tfModeloa.setText(datuakKotxea.getModeloa());
		tfBaztidorea.setText(datuakKotxea.getBaztidorea());
		tfMarka.setText(datuakKotxea.getMarka());

				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rs2.close();
		st2.close();
	}
	
	private void LanaAukeratu() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//SQL-rekin konexioa hasteko
			Connection konexioa;
			konexioa= DriverManager.getConnection("jdbc:mysql://localhost/recordauto", "root", "");

			//Statement-a sortzeko
			st2 = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Resultset-a sortzeko eta select kontsulta exekutatzeko 
			rs2 = st2.executeQuery("SELECT LanaID FROM lana WHERE Matrikula = '"+cbKotxea.getSelectedItem().toString()+"'");
			
			//Lehenengo pozizioa aukeratzeko
			rs2.first();
			
			cbLanAgindua.addItem(rs2.getObject("LanaID").toString());			
			while(rs2.next())
			{					
				cbLanAgindua.addItem(rs2.getObject("LanaID").toString());
			}
									
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rs2.close();
		st2.close();
		
	}
	
	private void DatuakEraikituLanAgindua() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//SQL-rekin konexioa hasteko
			Connection konexioa;
			konexioa= DriverManager.getConnection("jdbc:mysql://localhost/recordauto", "root", "");

			//Statement-a sortzeko
			st2 = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Resultset-a sortzeko eta select kontsulta exekutatzeko 
			rs2 = st2.executeQuery("SELECT * FROM lana WHERE LanaID = '"+cbLanAgindua.getSelectedItem().toString()+"'");

 
			rs2.first();
			
		tfArazoa.setText(rs2.getObject("Deskribapena").toString());

				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rs2.close();
		st2.close();
		
	}
	
	private void PiezaTaulaBete() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//SQL-rekin konexioa hasteko
			Connection konexioa;
			konexioa= DriverManager.getConnection("jdbc:mysql://localhost/recordauto", "root", "");

			//Statement-a sortzeko
			st1 = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Resultset-a sortzeko eta select kontsulta exekutatzeko 
			rs1 = st1.executeQuery("SELECT * FROM piezaagindua WHERE LanaID = '"+cbLanAgindua.getSelectedItem().toString()+"'");

 
			rs1.first();
			
			
		    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rs1.close();
		st1.close();
	}
	
	private void DatuakTaula()
	{
		piezaTaula = (DefaultTableModel)taula.getModel();
		piezaTaula.addRow(new Object [] {});
	}

}
