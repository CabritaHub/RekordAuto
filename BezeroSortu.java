package ERRONKA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class BezeroSortu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField TF_Izena, TF_Abizena, TF_Jaiotzedata, TF_Mugikor, TF_Herrialdea, TF_Mail, TF_Postakode, TF_Dni,
			TF_Alta, TF_Autonomo;

	private String StrIzena, StrAbizena, StrJaiotzedata, StrMugikor, StrHerrialdea, StrMail, StrPostakode, StrDni,
			StrAlta, StrAutonomo;

	private JButton Gordebtn, Itxibtn;
	
	private JLabel Dnilbl, Izenalbl, Abizenalbl, Jaiotzelbl, Telefonolbl, Correolbl, Postalbl, Autonomolbl,
			Herrialdelbl, Altalb;

	private Statement st;
	private ResultSet rs;
	private Connection konexioa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroSortu frame = new BezeroSortu();
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
	public BezeroSortu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Gordebtn = new JButton("Gorde");
		Gordebtn.addActionListener(this);
		Gordebtn.setBounds(789, 197, 107, 41);
		contentPane.add(Gordebtn);

		Itxibtn = new JButton("Itxi");
		Itxibtn.addActionListener(this);
		Itxibtn.setBounds(628, 197, 113, 41);
		contentPane.add(Itxibtn);

		Izenalbl = new JLabel("Izena");
		Izenalbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Izenalbl.setBounds(353, 37, 52, 26);
		contentPane.add(Izenalbl);

		TF_Izena = new JTextField();
		TF_Izena.setText("Juana");
		TF_Izena.setBounds(428, 42, 107, 19);
		contentPane.add(TF_Izena);
		TF_Izena.setColumns(10);

		Abizenalbl = new JLabel("Abizena");
		Abizenalbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Abizenalbl.setBounds(675, 37, 52, 26);
		contentPane.add(Abizenalbl);

		Jaiotzelbl = new JLabel("Jaiotze Data");
		Jaiotzelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Jaiotzelbl.setBounds(10, 105, 85, 26);
		contentPane.add(Jaiotzelbl);

		Telefonolbl = new JLabel("Mugikorra");
		Telefonolbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Telefonolbl.setBounds(675, 105, 52, 26);
		contentPane.add(Telefonolbl);

		Correolbl = new JLabel("Mail");
		Correolbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Correolbl.setBounds(353, 105, 52, 26);
		contentPane.add(Correolbl);

		Postalbl = new JLabel("PostaKodea");
		Postalbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Postalbl.setBounds(353, 174, 85, 26);
		contentPane.add(Postalbl);

		Herrialdelbl = new JLabel("Herrialdea");
		Herrialdelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Herrialdelbl.setBounds(10, 174, 63, 26);
		contentPane.add(Herrialdelbl);

		TF_Abizena = new JTextField();
		TF_Abizena.setText("Apellido1");
		TF_Abizena.setColumns(10);
		TF_Abizena.setBounds(748, 42, 96, 19);
		contentPane.add(TF_Abizena);

		TF_Jaiotzedata = new JTextField();
		TF_Jaiotzedata.setText("2022-04-06");
		TF_Jaiotzedata.setColumns(10);
		TF_Jaiotzedata.setBounds(86, 110, 96, 19);
		contentPane.add(TF_Jaiotzedata);

		TF_Mugikor = new JTextField();
		TF_Mugikor.setText("67364553");
		TF_Mugikor.setColumns(10);
		TF_Mugikor.setBounds(748, 110, 96, 19);
		contentPane.add(TF_Mugikor);

		TF_Herrialdea = new JTextField();
		TF_Herrialdea.setText("Bilbao");
		TF_Herrialdea.setColumns(10);
		TF_Herrialdea.setBounds(86, 179, 96, 19);
		contentPane.add(TF_Herrialdea);

		TF_Postakode = new JTextField();
		TF_Postakode.setText("90004");
		TF_Postakode.setColumns(10);
		TF_Postakode.setBounds(428, 179, 96, 19);
		contentPane.add(TF_Postakode);

		TF_Mail = new JTextField();
		TF_Mail.setText("Prueba1@gmail.com");
		TF_Mail.setColumns(10);
		TF_Mail.setBounds(428, 110, 130, 19);
		contentPane.add(TF_Mail);

		Autonomolbl = new JLabel("Autonomo");
		Autonomolbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Autonomolbl.setBounds(353, 235, 70, 26);
		contentPane.add(Autonomolbl);

		TF_Autonomo = new JTextField();
		TF_Autonomo.setText("Ez");
		TF_Autonomo.setColumns(10);
		TF_Autonomo.setBounds(428, 240, 96, 19);
		contentPane.add(TF_Autonomo);

		Dnilbl = new JLabel("Nan");
		Dnilbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Dnilbl.setBounds(10, 37, 52, 26);
		contentPane.add(Dnilbl);

		TF_Dni = new JTextField();
		TF_Dni.setText("93746372A");
		TF_Dni.setColumns(10);
		TF_Dni.setBounds(86, 42, 96, 19);
		contentPane.add(TF_Dni);

		Altalb = new JLabel("Alta");
		Altalb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Altalb.setBounds(10, 235, 70, 26);
		contentPane.add(Altalb);

		TF_Alta = new JTextField();
		TF_Alta.setText("2022-04-08");
		TF_Alta.setColumns(10);
		TF_Alta.setBounds(86, 240, 96, 19);
		contentPane.add(TF_Alta);

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

		if (source == Gordebtn) {

			BezeroClass Bezeroak;
			
			StrIzena = TF_Izena.getText();
			StrAbizena = TF_Abizena.getText();
			StrJaiotzedata = TF_Jaiotzedata.getText();
			StrMugikor = TF_Mugikor.getText();
			StrHerrialdea = TF_Herrialdea.getText();
			StrMail = TF_Mail.getText();
			StrPostakode = TF_Postakode.getText();
			StrDni = TF_Dni.getText();
			StrAlta = TF_Alta.getText();
			StrAutonomo = TF_Autonomo.getText();

			Bezeroak = new BezeroClass(StrDni, StrIzena, StrAbizena, StrJaiotzedata, StrMugikor, StrMail, StrPostakode, StrHerrialdea, 
					 StrAlta, StrAutonomo);

			try {
				
				st.executeUpdate("call SartuBezero ('" + Bezeroak.getNan().toString().toUpperCase() + "','"
						+ Bezeroak.getIzena().toString() + "', '" + Bezeroak.getAbizena().toString() + "', '"
						+ Bezeroak.getJaiotzeData().toString() + "', '" + Bezeroak.getMugikor().toString() + "', '"
						+ Bezeroak.getMail().toString() + "', '" + Bezeroak.getPostaKode().toString() + "', '"
						+ Bezeroak.getHerrialde().toString() + "', '" + Bezeroak.getAlta().toString() + "', '"
						+ Bezeroak.getAutonomo().toString() + "') ");
				
			

			} catch (SQLException i) {
				i.printStackTrace();
			}
			
		}

		if (source == Itxibtn) {

			Menua clasec;
			clasec = new Menua();
			clasec.setVisible(true);
			setVisible(false);

		}

	}
}
