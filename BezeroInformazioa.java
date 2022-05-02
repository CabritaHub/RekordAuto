package ERRONKA;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class BezeroInformazioa extends JFrame implements ActionListener, FocusListener {

	private JPanel contentPane;
	private JTextField TF_Dni, TF_Izena, TF_Abizena, TF_Jaiotzedata, TF_Mugikor, TF_Mail, TF_Postakode, TF_Herrialdea,
			TF_Alta, TF_Autonomo;
	private JLabel DNILB, IZENALB, AbizenaLB, Jaiotzedatalbl, Mugikorlbl, Correolbl, Postalbl, Herrialdelbl,
			Autonomolbl, Altalbl;
	private String StrIzena, StrAbizena, StrJaiotzedata, StrMugikor, StrHerrialdea, StrMail, StrPostakode, StrDni,
	StrAlta, StrAutonomo;
	private JButton Ezabatubtn, Eguneratubtn, Atzerabtn;
	private Statement st;
	private ResultSet rs;
	private Connection konexioa;
	private Vector<String> Titulo;
	private Vector<Vector<String>> Datuak  = new Vector<Vector<String>>();
	Vector<String> lerroa = new Vector<String>();
    private Vector<String[]> data = new Vector<String[]>();
	private static final long serialVersionUID = 1L;
	private DefaultTableModel dlmTabla;
	private int filas;
	private JTable TablaV2 = new JTable(dlmTabla);
	private JScrollPane scrollPane;
	private BezeroClass bezeroak;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroInformazioa frame = new BezeroInformazioa();
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
	public BezeroInformazioa() throws SQLException, ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		DNILB = new JLabel("DNI");
		DNILB.setBounds(33, 56, 49, 38);
		contentPane.add(DNILB);

		IZENALB = new JLabel("IZENA");
		IZENALB.setBounds(33, 95, 49, 38);
		contentPane.add(IZENALB);

		AbizenaLB = new JLabel("ABIZENA");
		AbizenaLB.setBounds(33, 134, 66, 38);
		contentPane.add(AbizenaLB);

		Jaiotzedatalbl = new JLabel("Jaiotze Data");
		Jaiotzedatalbl.setBounds(33, 172, 74, 38);
		contentPane.add(Jaiotzedatalbl);

		TF_Dni = new JTextField();
		TF_Dni.addFocusListener(this);
		TF_Dni.setBounds(117, 66, 116, 19);
		contentPane.add(TF_Dni);
		TF_Dni.setColumns(10);

		TF_Izena = new JTextField();
		TF_Izena.setColumns(10);
		TF_Izena.setBounds(117, 105, 116, 19);
		contentPane.add(TF_Izena);

		TF_Abizena = new JTextField();
		TF_Abizena.setColumns(10);
		TF_Abizena.setBounds(117, 144, 116, 19);
		contentPane.add(TF_Abizena);

		TF_Jaiotzedata = new JTextField();
		TF_Jaiotzedata.setColumns(10);
		TF_Jaiotzedata.setBounds(117, 182, 116, 19);
		contentPane.add(TF_Jaiotzedata);

		Mugikorlbl = new JLabel("Mugikorra");
		Mugikorlbl.setBounds(261, 172, 66, 38);
		contentPane.add(Mugikorlbl);

		TF_Mugikor = new JTextField();
		TF_Mugikor.setText((String) null);
		TF_Mugikor.setColumns(10);
		TF_Mugikor.setBounds(343, 182, 116, 19);
		contentPane.add(TF_Mugikor);

		Correolbl = new JLabel("Mail");
		Correolbl.setBounds(261, 134, 66, 38);
		contentPane.add(Correolbl);

		TF_Mail = new JTextField();
		TF_Mail.setText((String) null);
		TF_Mail.setColumns(10);
		TF_Mail.setBounds(343, 144, 116, 19);
		contentPane.add(TF_Mail);

		Postalbl = new JLabel("Posta Kodea");
		Postalbl.setBounds(261, 95, 74, 38);
		contentPane.add(Postalbl);

		TF_Postakode = new JTextField();
		TF_Postakode.setText((String) null);
		TF_Postakode.setColumns(10);
		TF_Postakode.setBounds(343, 105, 116, 19);
		contentPane.add(TF_Postakode);

		Herrialdelbl = new JLabel("Herrialdea");
		Herrialdelbl.setBounds(261, 56, 66, 38);
		contentPane.add(Herrialdelbl);

		TF_Herrialdea = new JTextField();
		TF_Herrialdea.setText((String) null);
		TF_Herrialdea.setColumns(10);
		TF_Herrialdea.setBounds(343, 66, 116, 19);
		contentPane.add(TF_Herrialdea);

		Altalbl = new JLabel("Alta data");
		Altalbl.setBounds(500, 56, 66, 38);
		contentPane.add(Altalbl);

		TF_Alta = new JTextField();
		TF_Alta.setText((String) null);
		TF_Alta.setColumns(10);
		TF_Alta.setBounds(569, 66, 116, 19);
		contentPane.add(TF_Alta);

		TF_Autonomo = new JTextField();
		TF_Autonomo.setText((String) null);
		TF_Autonomo.setColumns(10);
		TF_Autonomo.setBounds(569, 105, 116, 19);
		contentPane.add(TF_Autonomo);

		Autonomolbl = new JLabel("Autonomo");
		Autonomolbl.setBounds(500, 95, 74, 38);
		contentPane.add(Autonomolbl);

		Ezabatubtn = new JButton("Ezabatu");
		Ezabatubtn.addActionListener(this);
		Ezabatubtn.setBounds(590, 166, 85, 21);
		contentPane.add(Ezabatubtn);

		Eguneratubtn = new JButton("Eguneratu");
		Eguneratubtn.addActionListener(this);
		Eguneratubtn.setBounds(683, 166, 102, 21);
		contentPane.add(Eguneratubtn);

		Atzerabtn = new JButton("Atzera");
		Atzerabtn.addActionListener(this);
		Atzerabtn.setBounds(495, 166, 85, 21);
		contentPane.add(Atzerabtn);

//		DatuBasera konektatzeko kontsulta	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			konexioa = DriverManager.getConnection("jdbc:mysql://localhost/rekordauto", "root", "");
			// Statement instantzi berri bat ireki
			st = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ((java.sql.Statement) st).executeQuery("SELECT * FROM bezeroa");

		} catch (SQLException e) {
			// e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(null, "No se puede Conectar", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

		try {
			Taulasortu();
		} catch (SQLException e) {
			// e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(null, "Error en la tabla", "", JOptionPane.ERROR_MESSAGE);
		}

	}

//	Taulan agertzen diren goiko informazioa
	public void Taulasortu() throws SQLException {
		Titulo = new Vector<String>();

		Titulo.add("Nan");
		Titulo.add("Izena");
		Titulo.add("Abizena");
		Titulo.add("Jaiotze Data");
		Titulo.add("Mugikorra");
		Titulo.add("Posta Kodea");
		Titulo.add("Herrialdea");
		Titulo.add("Posta Elektronikoa");
		Titulo.add("Alta Data");
		Titulo.add("Autonomoa");

		dlmTabla = new DefaultTableModel(Datuak, Titulo);
		TablaV2 = new JTable(dlmTabla);

		TablaV2.setEnabled(false);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 289, 728, 170);
		scrollPane.setViewportView(TablaV2);
		contentPane.add(scrollPane);

		ST1();

	}

//	DatuBaseen zutabe informazioak taulan agertzeko
	public void ST1() throws SQLException {

//		Kontsulta hau erabiltzen da delete edo eguneratzerakoan taulan datu berriak agertzeko 
		rs = (ResultSet) st.executeQuery("SELECT * FROM bezeroa");
		rs.first();
			
		dlmTabla.setRowCount(0);
		
		rs.absolute(0);

		while (rs.next()) {
			Vector<String> lerroa = new Vector<String>();
			
			lerroa.add((String) rs.getObject("Nan"));
			lerroa.add((String) rs.getObject("Izena"));
			lerroa.add((String) rs.getObject("Abizena"));
			// Aldatu Jaiotzedata datetik Stringra
			Date JaiotzeAux = (Date) rs.getObject("JaiotzeDatak");
			lerroa.add((JaiotzeAux.toString()));

			lerroa.add((String) rs.getObject("Telefonoa"));
			lerroa.add((String) rs.getObject("PostaKodea"));
			lerroa.add((String) rs.getObject("Herrialdea"));
			lerroa.add((String) rs.getObject("Mail"));

//			Aldatu AltdaData datetik Stringra
			Date AltaAux = (Date) rs.getObject("AltaData");
			lerroa.add((AltaAux.toString()));

			lerroa.add((String) rs.getObject("Autonomoa"));

			lerroa.add("\n\n\n\n\n\n\n");
			
			dlmTabla.addRow(lerroa);
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == Ezabatubtn) {

			try {
				st.executeUpdate("DELETE FROM bezeroa WHERE Nan='" + TF_Dni.getText() + "'");
				TablaV2.removeAll();
				ST1();
			} catch (SQLException i) {
				i.printStackTrace();
			}

		}

		if (source == Eguneratubtn) {

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

			bezeroak = new BezeroClass(StrDni, StrIzena, StrAbizena, StrJaiotzedata, StrMugikor, StrMail, StrPostakode, StrHerrialdea, 
					 StrAlta, StrAutonomo);
			
			
			try {

				rs = ((java.sql.Statement) st).executeQuery("SELECT * FROM bezeroa");

				st.executeUpdate("call EguneratuBezero ('" + bezeroak.getNan().toString() + "','"
						+ bezeroak.getIzena().toString() + "', '" + bezeroak.getAbizena().toString() + "', '"
						+ bezeroak.getJaiotzeData().toString() + "', '" + bezeroak.getMugikor().toString() + "', '"
						+ bezeroak.getMail().toString() + "', '" + bezeroak.getPostaKode().toString() + "', '"
						+ bezeroak.getHerrialde().toString() + "', '" + bezeroak.getAlta().toString() + "', '"
						+ bezeroak.getAutonomo().toString() + "') ");
				ST1();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
		

		}

		if (source == Atzerabtn) {

			Menua clasec;
			clasec = new Menua();
			clasec.setVisible(true);
			setVisible(false);
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		
		for (int i = 0; Datuak.size() > i; i++) {

			if(TF_Dni.getText().equals(Datuak.elementAt(i).elementAt(0))) {
				TF_Izena.setText(Datuak.elementAt(i).elementAt(1));
				TF_Abizena.setText(Datuak.elementAt(i).elementAt(2));
				TF_Jaiotzedata.setText(Datuak.elementAt(i).elementAt(3));
				TF_Herrialdea.setText(Datuak.elementAt(i).elementAt(6));
				TF_Mugikor.setText(Datuak.elementAt(i).elementAt(4));
				TF_Mail.setText(Datuak.elementAt(i).elementAt(7));
				TF_Postakode.setText(Datuak.elementAt(i).elementAt(5));
				TF_Alta.setText(Datuak.elementAt(i).elementAt(8));
				TF_Autonomo.setText(Datuak.elementAt(i).elementAt(9));

			}
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
	}
	


}
