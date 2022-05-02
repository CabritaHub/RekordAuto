package ERRONKA;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class kotxeakTaulaMain extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//UI
	private JPanel contentPane;
	private JTextField tfMatrikula;
	private JTextField tfUrtea;
	private JTextField tfMarka;
	private JTextField tfModeloa;
	private JTextField tfBaztidorea;
	private JTextField tfNan;
	private JComboBox<String> cbJabea;
	
	//Aldagaiak
	private String matrikula;
	private String urtea;
	private String marka;
	private String modeloa;
	private String baztidorea;
	private String nan;
	
	//SQL konponenteak
	private ResultSet rs;
	private Statement st;
	
    //Konstruktoreak erabiltzeko aldagaiak
	private KotxeakTaulaClass datuak;
	private JTable table;
	
	//Taula
	private DefaultTableModel taula;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kotxeakTaulaMain frame = new kotxeakTaulaMain();
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
	public kotxeakTaulaMain() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		tfMatrikula = new JTextField();
		tfMatrikula.setText("Matrikula");
		tfMatrikula.setColumns(10);
		tfMatrikula.setBounds(27, 41, 174, 43);
		contentPane.add(tfMatrikula);
		
		tfUrtea = new JTextField();
		tfUrtea.setText("Urtea");
		tfUrtea.setColumns(10);
		tfUrtea.setBounds(27, 109, 174, 43);
		contentPane.add(tfUrtea);
		
		tfMarka = new JTextField();
		tfMarka.setText("Marka");
		tfMarka.setColumns(10);
		tfMarka.setBounds(27, 175, 174, 43);
		contentPane.add(tfMarka);
		
		tfModeloa = new JTextField();
		tfModeloa.setText("Modeloa");
		tfModeloa.setColumns(10);
		tfModeloa.setBounds(244, 41, 174, 43);
		contentPane.add(tfModeloa);
		
		tfBaztidorea = new JTextField();
		tfBaztidorea.setEditable(false);
		tfBaztidorea.setText("Baztidorea");
		tfBaztidorea.setColumns(10);
		tfBaztidorea.setBounds(244, 109, 174, 43);
		contentPane.add(tfBaztidorea);
		
		tfNan = new JTextField();
		tfNan.setText("NAN");
		tfNan.setColumns(10);
		tfNan.setBounds(244, 175, 174, 43);
		contentPane.add(tfNan);
				
		cbJabea = new JComboBox<String>();
		cbJabea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NanAukeratu();
			}
		});
		cbJabea.setBounds(467, 50, 129, 25);
		contentPane.add(cbJabea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 239, 721, 278);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
                int i = table.getSelectedRow();
                tfMatrikula.setText((String)taula.getValueAt(i, 0));
                tfModeloa.setText((String)taula.getValueAt(i, 1));
                tfUrtea.setText((String)taula.getValueAt(i, 2));
                tfBaztidorea.setText((String)taula.getValueAt(i, 3));
                tfMarka.setText((String)taula.getValueAt(i, 4));
                tfNan.setText((String)taula.getValueAt(i, 5));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matrikula", "Modeloa", "Urtea", "Baztidorea", "Marka", "NAN"
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
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table);
		
		//Eguneratu botoia
		JButton btnEguneratu = new JButton("Eguneratu");
		btnEguneratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatuakEguneratu();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEguneratu.setBounds(646, 47, 102, 30);
		contentPane.add(btnEguneratu);
		
		//Ezabatu botoia
		JButton btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatuakEzabatu();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEzabatu.setBounds(646, 115, 102, 30);
		contentPane.add(btnEzabatu);
		
		//Atzerantz botoia
		JButton btnAtzerantz = new JButton("Atzerantz");
		btnAtzerantz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtzerantz.setBounds(646, 181, 102, 30);
		contentPane.add(btnAtzerantz);
				
		//Taulan datuak ipintzeko
		DatuakHartu();
		
		//Nan Texfild-a NAN ipintzeko
		tfNan.setText("NAN");
	}
	
	//Taulan datuak ipintzeko
	private void DatuakTaula()
	{
		taula = (DefaultTableModel)table.getModel();
		taula.addRow(new Object [] {datuak.getMatrikula().toString(), datuak.getModeloa().toString(), datuak.getUrtea().toString(), datuak.getBaztidorea().toString(), datuak.getMarka().toString(), datuak.getNan().toString()});
	}
	
	//Datuak hartzeko
	private void DatuakHartu() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//SQL-rekin konexioa hasteko
			Connection konexioa;
			konexioa= DriverManager.getConnection("jdbc:mysql://localhost/recordauto", "root", "");

			//Statement-a sortzeko
			st = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Resultset-a sortzeko eta select kontsulta exekutatzeko 
			rs = st.executeQuery("SELECT * FROM autoa");
			
			//Lehenengo pozizioa aukeratzeko
			rs.first();
			DatuakEraikitu();
									
			while(rs.next())
			{								 
				//SQL-n dauden datuak hartzeko eta objetu batean eraikitzeko
				DatuakEraikitu();				
				}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Datuak objetu batean eraikitzeko
	private void DatuakEraikitu() throws SQLException
	{
		
    	//Nahi ditugun zutabearen datuak autatzeko
    	matrikula = rs.getObject("Matrikula").toString();
		urtea = rs.getObject("Urtea").toString();
		marka = rs.getObject("Marka").toString();
    	modeloa = rs.getObject("Modeloa").toString();
		baztidorea = rs.getObject("Baztidora").toString();
		nan = rs.getObject("NAN").toString();
		
		//Aurreko datuen informazioa objetua eraikitzeko 
		datuak = new KotxeakTaulaClass(matrikula, urtea, marka, modeloa, baztidorea, nan);
		
		DatuakTaula();
		
		cbJabea.addItem(datuak.getNan().toString());
	}
	
	//Nahi dugun zerrenda ezabetzeko
	private void DatuakEzabatu() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//SQL-rekin konexioa hasteko
			Connection konexioa;
			konexioa= DriverManager.getConnection("jdbc:mysql://localhost/recordauto", "root", "");

			//Statement-a sortzeko
			st = konexioa.createStatement();
						
			//Resultset-a sortzeko eta select kontsulta exekutatzeko 
			st.executeUpdate("DELETE FROM autoa WHERE Baztidora = '"+tfBaztidorea.getText()+"'");
			
			DatuakGarbitu();
			
			//Lehenengo pozizioa aukeratzeko
			rs.first();
			DatuakHartu();
									
			while(rs.next())
			{								 
				//SQL-n dauden datuak hartzeko eta objetu batean eraikitzeko
				DatuakHartu();				
				}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Taularen datuak garbitzeko
	private void DatuakGarbitu()
	{
		taula.setRowCount(0);
	}
	
	//Datuak eguneratzeko 
	private void DatuakEguneratu() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//SQL-rekin konexioa hasteko
			Connection konexioa;
			konexioa= DriverManager.getConnection("jdbc:mysql://localhost/recordauto", "root", "");

			//Statement-a sortzeko
			st = konexioa.createStatement();
						
			//Resultset-a sortzeko eta select kontsulta exekutatzeko 
			st.executeUpdate("UPDATE autoa SET Matrikula='"+tfMatrikula.getText()+"', Urtea='"+tfUrtea.getText()+"', Marka='"+tfMarka.getText()+"', Modeloa='"+tfModeloa.getText()+"', NAN ='"+tfNan.getText()+"' WHERE Baztidora = '"+tfBaztidorea.getText()+"'");
			
			
			DatuakGarbitu();
			
			//Lehenengo pozizioa aukeratzeko
			rs.first();
			DatuakHartu();
									
			while(rs.next())
			{								 
				//SQL-n dauden datuak hartzeko eta objetu batean eraikitzeko
				DatuakHartu();				
				}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//CheckBox-etik autatu dugun datuan texfilean ipintzeko
	private void NanAukeratu()
	{
		tfNan.setText(cbJabea.getSelectedItem().toString());
	}
}
