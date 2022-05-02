package ERRONKA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class kotxeakSartuMain extends JFrame {

	private static final long serialVersionUID = 1L;

	//UI
	private JPanel contentPane;
	private JTextField tfMatrikula;
	private JTextField tfMarka;
	private JTextField tfUrtea;
	private JTextField tfModeloa;
	private JTextField tfNan;
	private JTextField tfBaztidorea;
	
	//Aldagaiak
	private  String matrikula;
	private String urtea;
	private String marka;
	private String modeloa;
	private String baztidorea;
	private String nan;

	// SQL konponenteak
	private Statement st;
	
    //Konstruktoreak erabiltzeko aldagaiak
	private KotxeakSartuClass datuak;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kotxeakSartuMain frame = new kotxeakSartuMain();
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
	public kotxeakSartuMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfMatrikula = new JTextField();
		tfMatrikula.setText("Matrikula");
		tfMatrikula.setBounds(29, 45, 174, 43);
		contentPane.add(tfMatrikula);
		tfMatrikula.setColumns(10);

		tfMarka = new JTextField();
		tfMarka.setText("Marka");
		tfMarka.setColumns(10);
		tfMarka.setBounds(217, 45, 174, 43);
		contentPane.add(tfMarka);

		tfUrtea = new JTextField();
		tfUrtea.setText("Urtea");
		tfUrtea.setColumns(10);
		tfUrtea.setBounds(217, 129, 174, 43);
		contentPane.add(tfUrtea);

		tfModeloa = new JTextField();
		tfModeloa.setText("Modeloa");
		tfModeloa.setColumns(10);
		tfModeloa.setBounds(29, 129, 174, 43);
		contentPane.add(tfModeloa);

		tfNan = new JTextField();
		tfNan.setText("NAN");
		tfNan.setColumns(10);
		tfNan.setBounds(217, 214, 174, 43);
		contentPane.add(tfNan);

		tfBaztidorea = new JTextField();
		tfBaztidorea.setText("Baztidorea");
		tfBaztidorea.setColumns(10);
		tfBaztidorea.setBounds(29, 214, 174, 43);
		contentPane.add(tfBaztidorea);

		JButton btnDatuakSartu = new JButton("Datuak sartu");
		btnDatuakSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					KotxeakSartuSQL();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDatuakSartu.setBounds(293, 309, 116, 43);
		contentPane.add(btnDatuakSartu);

		JButton btnAtzerantzJoan = new JButton("Atzerantz joan");
		btnAtzerantzJoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Menu-ra atera
			}
		});
		btnAtzerantzJoan.setBounds(10, 309, 116, 43);
		contentPane.add(btnAtzerantzJoan);
	}

	private void KotxeakSartuSQL() throws SQLException {
		// Driver-a hasierazteko
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// SQL-rekin konexioa hasteko
			Connection konexioa;
			konexioa = DriverManager.getConnection("jdbc:mysql://localhost/recordauto", "root", "");

			// Statement-a sortzeko
			st = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Texfield-etatik informazioa hartzeko
			matrikula = tfMatrikula.getText();
			urtea = tfUrtea.getText();
			marka = tfMarka.getText();
			modeloa = tfModeloa.getText();
			baztidorea = tfBaztidorea.getText();
			nan = tfNan.getText();
			
			//Urtea hutsik edo beteta badago
			if (urtea.isEmpty())
			{
				//Aurreko datuen informazioa objetua eraikitzeko 
				datuak = new KotxeakSartuClass(matrikula, marka, modeloa, baztidorea, nan);
			}
			else
			{				
				//Aurreko datuen informazioa objetua eraikitzeko 
				datuak = new KotxeakSartuClass(matrikula, urtea, marka, modeloa, baztidorea, nan);
			}


			// Resultset-a sortzeko eta select INSERT exekutatzeko
			st.executeUpdate("INSERT INTO autoa VALUES ('"+datuak.getMatrikula().toString().toUpperCase()+"','"+datuak.getUrtea().toString()+"', '"+datuak.getMarka().toString()+"', '"+datuak.getModeloa().toString()+"', '"+datuak.getBaztidorea().toString()+"', '"+datuak.getNan().toString().toUpperCase()+"') ");

			st.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
