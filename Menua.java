package ERRONKA;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Font;

public class Menua extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblIzenAbizenak;
	private JButton btnLaguntza, btnBezero, btnAuto, btnPiezak, btnHornitzaile, btnEskaerak, btnFakturak, btnLog;
	private Desktop enlace;
	private JButton ComboBoxbtn;
	private JComboBox TaulaBox;
	private String s;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menua frame = new Menua();
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
	public Menua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		btnLaguntza = new JButton("Laguntza");
		btnLaguntza.addActionListener(this);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLaguntza, 15, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLaguntza, 32, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnLaguntza, 59, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnLaguntza, -598, SpringLayout.EAST, contentPane);
		contentPane.add(btnLaguntza);

		lblIzenAbizenak = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblIzenAbizenak, 16, SpringLayout.NORTH, btnLaguntza);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblIzenAbizenak, -113, SpringLayout.EAST, contentPane);
		contentPane.add(lblIzenAbizenak);

		btnBezero = new JButton("Bezero");
		btnBezero.addActionListener(this);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBezero, 49, SpringLayout.SOUTH, btnLaguntza);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnBezero, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBezero, -483, SpringLayout.EAST, contentPane);
		contentPane.add(btnBezero);

		btnAuto = new JButton("Auto");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAuto, 206, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBezero, -29, SpringLayout.NORTH, btnAuto);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAuto, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAuto, -175, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAuto, 0, SpringLayout.EAST, btnBezero);
		contentPane.add(btnAuto);

		btnPiezak = new JButton("Piezak");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnPiezak, 28, SpringLayout.SOUTH, btnAuto);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnPiezak, 0, SpringLayout.WEST, btnBezero);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnPiezak, -78, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnPiezak, -483, SpringLayout.EAST, contentPane);
		contentPane.add(btnPiezak);

		btnHornitzaile = new JButton("Hornitzaile");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnHornitzaile, 108, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnHornitzaile, 27, SpringLayout.EAST, btnBezero);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnHornitzaile, 240, SpringLayout.EAST, btnBezero);
		contentPane.add(btnHornitzaile);

		btnEskaerak = new JButton("Eskaerak");
		btnEskaerak.addActionListener(this);

		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnHornitzaile, -30, SpringLayout.NORTH, btnEskaerak);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEskaerak, -176, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEskaerak, 1, SpringLayout.NORTH, btnAuto);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEskaerak, 0, SpringLayout.WEST, btnHornitzaile);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEskaerak, 240, SpringLayout.EAST, btnAuto);
		contentPane.add(btnEskaerak);

		btnFakturak = new JButton("Fakturak");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnFakturak, 0, SpringLayout.NORTH, btnPiezak);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnFakturak, 0, SpringLayout.WEST, btnHornitzaile);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnFakturak, 98, SpringLayout.SOUTH, btnEskaerak);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnFakturak, 240, SpringLayout.EAST, btnPiezak);
		contentPane.add(btnFakturak);

		btnLog = new JButton("Log");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLog, 0, SpringLayout.NORTH, btnLaguntza);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLog, 25, SpringLayout.EAST, btnLaguntza);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnLog, 59, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnLog, 132, SpringLayout.EAST, btnLaguntza);
		contentPane.add(btnLog);
		
		ComboBoxbtn = new JButton("Sartu");
		sl_contentPane.putConstraint(SpringLayout.NORTH, ComboBoxbtn, 12, SpringLayout.NORTH, btnLaguntza);
		sl_contentPane.putConstraint(SpringLayout.WEST, ComboBoxbtn, 428, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, ComboBoxbtn, 0, SpringLayout.EAST, btnHornitzaile);
		ComboBoxbtn.addActionListener(this);
		contentPane.add(ComboBoxbtn);
		
		TaulaBox = new JComboBox();
		TaulaBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_contentPane.putConstraint(SpringLayout.NORTH, TaulaBox, 0, SpringLayout.NORTH, btnLaguntza);
		sl_contentPane.putConstraint(SpringLayout.WEST, TaulaBox, 24, SpringLayout.EAST, btnLog);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, TaulaBox, 0, SpringLayout.SOUTH, btnLaguntza);
		sl_contentPane.putConstraint(SpringLayout.EAST, TaulaBox, -6, SpringLayout.WEST, ComboBoxbtn);
		TaulaBox.addActionListener(this);
		contentPane.add(TaulaBox);
		TaulaBox.addItem("Auto Taula");
		TaulaBox.addItem("Bezero Taula");
		TaulaBox.addItem("Hornitzaile Taula");
		TaulaBox.addItem("Piezak Taula");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == btnBezero) {

			BezeroSortu BezSortu;
			BezSortu = new BezeroSortu();
			BezSortu.setVisible(true);
			setVisible(false);

		}

		if (source == btnEskaerak) {

			Eskaerak Eskaera;
			Eskaera = new Eskaerak();
			Eskaera.setVisible(true);
			setVisible(false);

		}

		if (source == btnLaguntza) {

			enlace = Desktop.getDesktop();
			try {
				enlace.browse(new URI("https:www.discoduroderoer.es/abrir-un-enlace-desde-nuestra-aplicacion-en-java/"));
			} catch (IOException | URISyntaxException a) {
				((Throwable) a).getMessage();
			}

		}
		
		if (source == TaulaBox) {

			s = (String)TaulaBox.getSelectedItem();
			System.out.println(s);

		}
		
		if (source == ComboBoxbtn) {
			
			
			
			
//			if(Selekzioa.equals("Auto Taula")) {
//				
//				kotxeakTaulaMain Kotxeak;
//				Kotxeak = new kotxeakTaulaMain();
//				Kotxeak.setVisible(true);
//				setVisible(false);
//				
//			}
//			
			if(s.equals("Bezero Taula")) {
				
				
				try {
					BezeroInformazioa bezero;
					bezero = new BezeroInformazioa();
					bezero.setVisible(true);
					setVisible(false);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
				
				
			}
//			
//			if(Selekzioa.equals("Hornitzaile Taula")) {
//				
//				HornitzaileInformazioa hornitzaile;
//				hornitzaile = new HornitzaileInformazioa();
//				hornitzaile.setVisible(true);
//				setVisible(false);
//				
//			}
//			
//			if(Selekzioa.equals("Piezak Taula")) {
//				
//				PiezakTaula piezak;
//				piezak = new PiezakTaula();
//				piezak.setVisible(true);
//				setVisible(false);
//				
//			}
//
					
		}
	}

