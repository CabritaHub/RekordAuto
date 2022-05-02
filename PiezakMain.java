package ERRONKA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class PiezakMain extends JFrame implements ActionListener {

	private JPanel contentPane;

	private String PiezaID, Izena, Deskribapena, Kantitatea , DataEntrega,  Hornitzailea;

	private Statement st;
	private ResultSet rs;
	private Connection konexioa;
	private JTextField TF_ID;
	private JTextField TF_Kantitatea;
	private JTextField TF_Data;
	private JTextField TF_Izena;
	private JTextField TF_Deskribapena;
	private JTextField TF_Prezioa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PiezakMain frame = new PiezakMain();
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
	public PiezakMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel IDLbl = new JLabel("Piezak ID");
		IDLbl.setBounds(21, 51, 45, 13);
		contentPane.add(IDLbl);
		
		JLabel Izenalbl = new JLabel("Izena");
		Izenalbl.setBounds(252, 51, 45, 13);
		contentPane.add(Izenalbl);
		
		JLabel Deskribapenalbl = new JLabel("Deskribapena");
		Deskribapenalbl.setBounds(456, 51, 45, 13);
		contentPane.add(Deskribapenalbl);
		
		JLabel Kantitatealbl = new JLabel("Kantitatea");
		Kantitatealbl.setBounds(21, 130, 45, 13);
		contentPane.add(Kantitatealbl);
		
		JLabel Datalbl = new JLabel("Data Entrega");
		Datalbl.setBounds(252, 130, 45, 13);
		contentPane.add(Datalbl);
		
		JLabel Hornitzailealbl = new JLabel("Hornitzailea");
		Hornitzailealbl.setBounds(21, 213, 71, 13);
		contentPane.add(Hornitzailealbl);
		
		TF_ID = new JTextField();
		TF_ID.setBounds(86, 48, 96, 19);
		contentPane.add(TF_ID);
		TF_ID.setColumns(10);
		
		TF_Kantitatea = new JTextField();
		TF_Kantitatea.setColumns(10);
		TF_Kantitatea.setBounds(86, 127, 96, 19);
		contentPane.add(TF_Kantitatea);
		
		TF_Data = new JTextField();
		TF_Data.setColumns(10);
		TF_Data.setBounds(307, 127, 96, 19);
		contentPane.add(TF_Data);
		
		TF_Izena = new JTextField();
		TF_Izena.setColumns(10);
		TF_Izena.setBounds(307, 48, 96, 19);
		contentPane.add(TF_Izena);
		
		TF_Deskribapena = new JTextField();
		TF_Deskribapena.setColumns(10);
		TF_Deskribapena.setBounds(511, 48, 96, 19);
		contentPane.add(TF_Deskribapena);
		
		TF_Prezioa = new JTextField();
		TF_Prezioa.setColumns(10);
		TF_Prezioa.setBounds(511, 127, 96, 19);
		contentPane.add(TF_Prezioa);
		
		JButton Atzerabtn = new JButton("Atzera");
		Atzerabtn.setBounds(482, 209, 85, 21);
		contentPane.add(Atzerabtn);
		
		JButton Sartubtn = new JButton("Sartu");
		Sartubtn.setBounds(618, 210, 85, 21);
		contentPane.add(Sartubtn);
		
		JComboBox HornitzaileBox = new JComboBox();
		HornitzaileBox.setBounds(116, 209, 108, 21);
		contentPane.add(HornitzaileBox);
		
		JLabel Prezioalbl = new JLabel("Prezioa");
		Prezioalbl.setBounds(456, 130, 45, 13);
		contentPane.add(Prezioalbl);

//		CONECTA A LA BASE DE DATOS	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			konexioa = DriverManager.getConnection("jdbc:mysql://localhost/rekordauto", "root", "");
			// Statement instantzi berri bat ireki
			st = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ((java.sql.Statement) st).executeQuery("SELECT * FROM bezeroa");

			System.out.println("Se puede acceder a la base de datos");

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("No se puede acceder a la BD");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

	}
}
