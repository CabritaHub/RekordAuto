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

	private String PiezaID, Izena, Deskribapena, Kantitatea, DataEntrega, Hornitzailea;

	private Statement st;
	private ResultSet rs;
	private Connection konexioa;
	private JLabel IDLbl, Izenalbl, Deskribapenalbl, Kantitatealbl, Datalbl, Hornitzailealbl, Prezioalbl;
	private JTextField TF_ID,TF_Izena, TF_Kantitatea, TF_Deskribapena, TF_Data, TF_Hornoitzaile, TF_Prezioa;
	private JButton Atzerabtn, Sartubtn;
	private JComboBox HornitzaileBox;

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

		IDLbl = new JLabel("Piezak ID");
		IDLbl.setBounds(21, 51, 71, 13);
		contentPane.add(IDLbl);

		Izenalbl = new JLabel("Izena");
		Izenalbl.setBounds(252, 51, 62, 13);
		contentPane.add(Izenalbl);

		Deskribapenalbl = new JLabel("Deskribapena");
		Deskribapenalbl.setBounds(466, 51, 88, 13);
		contentPane.add(Deskribapenalbl);

		Kantitatealbl = new JLabel("Kantitatea");
		Kantitatealbl.setBounds(21, 130, 71, 13);
		contentPane.add(Kantitatealbl);

		Datalbl = new JLabel("Data Entrega");
		Datalbl.setBounds(252, 130, 88, 13);
		contentPane.add(Datalbl);

		Hornitzailealbl = new JLabel("Hornitzailea");
		Hornitzailealbl.setBounds(21, 213, 71, 13);
		contentPane.add(Hornitzailealbl);

		Prezioalbl = new JLabel("Prezioa");
		Prezioalbl.setBounds(466, 130, 71, 13);
		contentPane.add(Prezioalbl);

		TF_ID = new JTextField();
		TF_ID.setBounds(103, 48, 96, 19);
		contentPane.add(TF_ID);
		TF_ID.setColumns(10);

		TF_Kantitatea = new JTextField();
		TF_Kantitatea.setColumns(10);
		TF_Kantitatea.setBounds(103, 127, 96, 19);
		contentPane.add(TF_Kantitatea);

		TF_Data = new JTextField();
		TF_Data.setColumns(10);
		TF_Data.setBounds(350, 127, 96, 19);
		contentPane.add(TF_Data);

		TF_Izena = new JTextField();
		TF_Izena.setColumns(10);
		TF_Izena.setBounds(350, 48, 96, 19);
		contentPane.add(TF_Izena);

		TF_Deskribapena = new JTextField();
		TF_Deskribapena.setColumns(10);
		TF_Deskribapena.setBounds(577, 48, 96, 19);
		contentPane.add(TF_Deskribapena);

		TF_Prezioa = new JTextField();
		TF_Prezioa.setColumns(10);
		TF_Prezioa.setBounds(577, 127, 96, 19);
		contentPane.add(TF_Prezioa);

		Atzerabtn = new JButton("Atzera");
		Atzerabtn.addActionListener(this);
		Atzerabtn.setBounds(482, 209, 85, 21);
		contentPane.add(Atzerabtn);

		Sartubtn = new JButton("Sartu");
		Sartubtn.addActionListener(this);
		Sartubtn.setBounds(618, 210, 85, 21);
		contentPane.add(Sartubtn);

		HornitzaileBox = new JComboBox();
		HornitzaileBox.setBounds(116, 209, 108, 21);
		contentPane.add(HornitzaileBox);

//		CONECTA A LA BASE DE DATOS	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			konexioa = DriverManager.getConnection("jdbc:mysql://localhost/rekordauto", "root", "");
			// Statement instantzi berri bat ireki
			st = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ((java.sql.Statement) st).executeQuery("SELECT * FROM piezak");

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

		if (source == Atzerabtn) {

			Menua MenuaP;
			MenuaP = new Menua();
			MenuaP.setVisible(true);
			setVisible(false);

		}

		if (source == Sartubtn) {

			
			
		}
	}
}
