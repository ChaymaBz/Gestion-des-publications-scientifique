package Pub;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Visite extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField adr;
	private JTextField id;
	JComboBox comboBox;
	Mail m = new Mail();
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visite frame = new Visite();
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
	public Visite() {
		setTitle("Inetrafce Visiteur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEspaceVisisteur = new JLabel("Espace Visiteur");
		lblEspaceVisisteur.setForeground(new Color(255, 0, 0));
		lblEspaceVisisteur.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_lblEspaceVisisteur = new GridBagConstraints();
		gbc_lblEspaceVisisteur.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspaceVisisteur.gridx = 5;
		gbc_lblEspaceVisisteur.gridy = 1;
		contentPane.add(lblEspaceVisisteur, gbc_lblEspaceVisisteur);
		
		JLabel lblNom = new JLabel("Nom:");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.WEST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 2;
		gbc_lblNom.gridy = 2;
		contentPane.add(lblNom, gbc_lblNom);
		
		nom = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 2;
		contentPane.add(nom, gbc_textField);
		nom.setColumns(10);
		
		JLabel lblPrnm = new JLabel("Pr\u00E9nom:");
		GridBagConstraints gbc_lblPrnm = new GridBagConstraints();
		gbc_lblPrnm.anchor = GridBagConstraints.WEST;
		gbc_lblPrnm.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrnm.gridx = 2;
		gbc_lblPrnm.gridy = 3;
		contentPane.add(lblPrnm, gbc_lblPrnm);
		
		prenom = new JTextField();
		prenom.setText("");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 3;
		contentPane.add(prenom, gbc_textField_1);
		prenom.setColumns(10);
		
		JLabel lblAdresseMail = new JLabel("Adresse Mail:");
		GridBagConstraints gbc_lblAdresseMail = new GridBagConstraints();
		gbc_lblAdresseMail.anchor = GridBagConstraints.WEST;
		gbc_lblAdresseMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresseMail.gridx = 2;
		gbc_lblAdresseMail.gridy = 4;
		contentPane.add(lblAdresseMail, gbc_lblAdresseMail);
		
		adr = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 4;
		contentPane.add(adr, gbc_textField_2);
		adr.setColumns(10);
		
		JLabel lblIdentifiant = new JLabel("Identifiant:");
		GridBagConstraints gbc_lblIdentifiant = new GridBagConstraints();
		gbc_lblIdentifiant.anchor = GridBagConstraints.WEST;
		gbc_lblIdentifiant.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdentifiant.gridx = 2;
		gbc_lblIdentifiant.gridy = 5;
		contentPane.add(lblIdentifiant, gbc_lblIdentifiant);
		
		id = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 5;
		gbc_textField_3.gridy = 5;
		contentPane.add(id, gbc_textField_3);
		id.setColumns(10);
		
		JLabel lblListeDesPublictaions = new JLabel("Liste des publictaions");
		GridBagConstraints gbc_lblListeDesPublictaions = new GridBagConstraints();
		gbc_lblListeDesPublictaions.insets = new Insets(0, 0, 5, 5);
		gbc_lblListeDesPublictaions.gridx = 7;
		gbc_lblListeDesPublictaions.gridy = 5;
		contentPane.add(lblListeDesPublictaions, gbc_lblListeDesPublictaions);
		
		 comboBox = new JComboBox();
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 7;
		gbc_comboBox.gridy = 6;
		contentPane.add(comboBox, gbc_comboBox);
		remplirCombo();

		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter(e);
			}
		});
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouter.gridx = 2;
		gbc_btnAjouter.gridy = 7;
		contentPane.add(btnAjouter, gbc_btnAjouter);
		
		JButton btnTlcharger = new JButton("T\u00E9l\u00E9charger");
		btnTlcharger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				relation(evt);
			}
			
		});
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annuler(e); 
			}
		});
		JButton btnNewButton = new JButton("Modifier");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 7;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				modifier(e);
				
			}	
		});
		contentPane.add(btnNewButton, gbc_btnNewButton);
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnuler.gridx = 6;
		gbc_btnAnnuler.gridy = 7;
		contentPane.add(btnAnnuler, gbc_btnAnnuler);
		GridBagConstraints gbc_btnTlcharger = new GridBagConstraints();
		gbc_btnTlcharger.insets = new Insets(0, 0, 5, 5);
		gbc_btnTlcharger.gridx = 7;
		gbc_btnTlcharger.gridy = 8;
		contentPane.add(btnTlcharger, gbc_btnTlcharger);
	}
	public void ajouter(java.awt.event.ActionEvent evt) {
		try {
			Class.forName("org.postgresql.Driver");// test du driver
			// System.out.println("Driver ok!!!");
			String url = "jdbc:postgresql://localhost:5432/publication_scientifique";
			String user = "postgres";
			String pw = "postgre";
			Connection con = DriverManager.getConnection(url, user, pw);
			// System.out.println("Connecté !!! ");
			Statement str = con.createStatement();

			String n = nom.getText();

			String pre = prenom.getText();

			String ad = adr.getText();

			String ide = id.getText();

			str.executeUpdate(
					"INSERT INTO visiteur values('" + n + "','" + pre + "','" + ad + "','" + ide + "')");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
}
	public void remplirCombo() {
		try {
			Class.forName("org.postgresql.Driver");// test du driver
			System.out.println("Driver ok!!!");
			String url = "jdbc:postgresql://localhost:5432/publication_scientifique";
			String user = "postgres";
			String pw = "postgre";
			Connection con = DriverManager.getConnection(url, user, pw);
			System.out.println("Connecté !!! ");
			Statement str = con.createStatement();
			String strpro = "SELECT nom_publication  FROM publication";
			ResultSet rs = str.executeQuery(strpro);
			while (rs.next()) {
				String nom = rs.getString("nom_publication").toString();
				comboBox.addItem(nom);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void relation(java.awt.event.ActionEvent evt) {
		m.setVisible(true);
		m.pack();
		m.setLocationRelativeTo(m);
		m.setDefaultCloseOperation(m.EXIT_ON_CLOSE);
	}
	public void annuler(ActionEvent e) {
		System.exit(0);
	}
	public void modifier(ActionEvent e) {
		try {
			Class.forName("org.postgresql.Driver");// test du driver
			System.out.println("Driver ok!!!");
			String url = "jdbc:postgresql://localhost:5432/publication_scientifique";
			String user = "postgres";
			String pw = "postgre";
			Connection con = DriverManager.getConnection(url, user, pw);
			System.out.println("Connecté !!! ");
			Statement str = con.createStatement();
			String SQL = "update visiteur set nom_visiteur ="+nom.getText()+" , "+ "prenom_visiteur = "+prenom.getText()+", adr_mail = "+adr.getText()
					+" where id_visiteur = "+id.getText()+"";
					
			str.executeUpdate(SQL);
			 JOptionPane.showMessageDialog(null, "modification réussite !!"+"","Bienvenue",JOptionPane.INFORMATION_MESSAGE);
			 nom.setText(" ");
			 prenom.setText("");
			 adr.setText("");
			 id.setText("");
			
			con.close();
		}catch (Exception ex) {
				ex.printStackTrace();
			}
	      
	      
	}	
}
