package ERRONKA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class loginMain extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//UI
	private JPanel contentPane;
	private JTextField tfErabiltzailea;
	private JPasswordField tfPasahitza;
	private JLabel lbLogin;

	//Login-ean behar diren aldagaiak
    public String langileId;
    public String pasahitza;
    public String departamentua;
    public String izena;
    
    //Konstruktoreak erabiltzeko aldagaiak
	private LoginClass datuak;
	
	//SQL konponenteak
	private ResultSet rs;
	private Statement st;
	
	private TextPrompt placeholderErab, placeholderPas;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginMain frame = new loginMain();
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
	public loginMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 343, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbImage = new JLabel("");
		lbImage.setIcon(new ImageIcon("C:\\Users\\ik_1dw3d\\Desktop\\3EB\\ERRONKAT3\\FOTOS\\loginIcon.png"));
		lbImage.setBounds(93, 31, 144, 144);
		contentPane.add(lbImage);
		
		lbLogin = new JLabel("Login");
		lbLogin.setForeground(new Color(0, 0, 0));
		lbLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
		lbLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbLogin.setBounds(133, 175, 63, 30);
		contentPane.add(lbLogin);
		
		textField = new JTextField();
		textField.setBounds(-43, 27, -4, 2);
		contentPane.add(textField);
		textField.setColumns(10);
		
		tfErabiltzailea = new JTextField();
	    placeholderErab = new TextPrompt("Erabiltzaile", tfErabiltzailea);
		tfErabiltzailea.setText("");
		tfErabiltzailea.setBackground(new Color(173, 216, 230));
		tfErabiltzailea.setBounds(74, 239, 177, 36);
		contentPane.add(tfErabiltzailea);
		tfErabiltzailea.setColumns(10);
		
		tfPasahitza = new JPasswordField();
	    placeholderPas = new TextPrompt("Pasahitza", tfPasahitza);
		tfPasahitza.setBackground(new Color(173, 216, 230));
		tfPasahitza.setColumns(10);
		tfPasahitza.setBounds(74, 309, 177, 36);
		contentPane.add(tfPasahitza);
				
		//Sartu botoia
		JButton btnSartu = new JButton("Sartu");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatuakHartu();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSartu.setBackground(new Color(176, 196, 222));
		btnSartu.setBounds(206, 377, 85, 30);
		contentPane.add(btnSartu);
		
		
		
	}
	
	private void DatuakHartu() throws SQLException 
	{
				try {
					
					//Driver-a hasierazteko
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					//SQL-rekin konexioa hasteko
					Connection konexioa;
					konexioa= DriverManager.getConnection("jdbc:mysql://localhost/rekordauto", "root", "");

					//Statement-a sortzeko
					st = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					
					//Resultset-a sortzeko eta select kontsulta exekutatzeko 
					rs = st.executeQuery("SELECT LangileID, Pasahitza, Departamentua, izena FROM langilea");
					
					//Lehenengo pozizioa aukeratzeko
					rs.first();
								
					//SQL-n dauden datuak hartzeko eta objetu batean eraikitzeko
					DatuakHartuSQL();

					
					//Objetuan dauden datuak erabiltzaileak sartu dituenak konparatzeko
					if (datuak.getLangileId().equals(tfErabiltzailea.getText()) && datuak.getPasahitza().equals(new String (tfPasahitza.getPassword())) )
					{
						JOptionPane.showInternalMessageDialog(null, "Ongi etorri, "+izena, "RekordAuto", JOptionPane.INFORMATION_MESSAGE);
						
						

						//Sartu menu-ra
					}
					else 
					{
						//System.out.println("Error login egiten "+rs.getObject("LangileID").toString()+" erabiltzailearekin");

						while(rs.next())
						{								    
							DatuakHartuSQL();
							
									if (datuak.getLangileId().equals(tfErabiltzailea.getText()) && datuak.getPasahitza().equals(new String (tfPasahitza.getPassword())) )
									{
										
										
										//Sartu menu-ra
									}
									else
									{
										//System.out.println("Error login egiten "+rs.getObject("LangileID").toString()+" erabiltzailearekin");
									}
							}
					}

					//Konexioak ixteko
					rs.close();
					st.close();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
    private void DatuakHartuSQL() throws SQLException
    {
    	//Nahi ditugun zutabearen datuak autatzeko
    	langileId = rs.getObject("LangileID").toString();
		pasahitza = rs.getObject("Pasahitza").toString();
		departamentua = rs.getObject("Departamentua").toString();
		izena = rs.getObject("izena").toString();

		//Aurreko datuen informazioa objetua eraikitzeko 
		datuak = new LoginClass(langileId, pasahitza, departamentua);
		

		
		Menua Login;
		Login = new Menua();
		Login.setVisible(true);
		setVisible(false);
	
    }
}
