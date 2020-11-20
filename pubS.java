package Pub;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pubS extends JFrame {
	private JTextField numero;
	private JTextField anneepub;
	private JTextField lieupub;
	private JTextField edit;
	JComboBox comboBox;
	Visite v=new Visite();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JComboBox comboBox = new JComboBox();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pubS frame = new pubS();
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
	public pubS() {
		setTitle("Publication_Scientifique");
		getContentPane().setBackground(new Color(255, 235, 205));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblPublicationScientifique = new JLabel("Publication Scientifique");
		lblPublicationScientifique.setForeground(new Color(199, 21, 133));
		lblPublicationScientifique.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		GridBagConstraints gbc_lblPublicationScientifique = new GridBagConstraints();
		gbc_lblPublicationScientifique.anchor = GridBagConstraints.WEST;
		gbc_lblPublicationScientifique.insets = new Insets(0, 0, 5, 5);
		gbc_lblPublicationScientifique.gridx = 1;
		gbc_lblPublicationScientifique.gridy = 0;
		getContentPane().add(lblPublicationScientifique, gbc_lblPublicationScientifique);
		
		
		comboBox = new JComboBox();
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"aaaaa", "b", "ccc", "ggg"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBox, gbc_comboBox);
		remplirCombo();
		
		
		JLabel lblNumpublication = new JLabel("Num_publication:");
		lblNumpublication.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNumpublication.setForeground(new Color(0, 0, 128));
		GridBagConstraints gbc_lblNumpublication = new GridBagConstraints();
		gbc_lblNumpublication.anchor = GridBagConstraints.WEST;
		gbc_lblNumpublication.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumpublication.gridx = 0;
		gbc_lblNumpublication.gridy = 2;
		getContentPane().add(lblNumpublication, gbc_lblNumpublication);
		
		numero = new JTextField();
		GridBagConstraints gbc_numero = new GridBagConstraints();
		gbc_numero.insets = new Insets(0, 0, 5, 5);
		gbc_numero.anchor = GridBagConstraints.WEST;
		gbc_numero.gridx = 1;
		gbc_numero.gridy = 2;
		getContentPane().add(numero, gbc_numero);
		numero.setColumns(10);
		
		JLabel lblAnnepublication = new JLabel("Anne\u00E8_publication:");
		lblAnnepublication.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAnnepublication.setForeground(new Color(0, 0, 128));
		GridBagConstraints gbc_lblAnnepublication = new GridBagConstraints();
		gbc_lblAnnepublication.anchor = GridBagConstraints.EAST;
		gbc_lblAnnepublication.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnnepublication.gridx = 0;
		gbc_lblAnnepublication.gridy = 3;
		getContentPane().add(lblAnnepublication, gbc_lblAnnepublication);
		
		anneepub = new JTextField();
		GridBagConstraints gbc_anneepub = new GridBagConstraints();
		gbc_anneepub.insets = new Insets(0, 0, 5, 5);
		gbc_anneepub.anchor = GridBagConstraints.WEST;
		gbc_anneepub.gridx = 1;
		gbc_anneepub.gridy = 3;
		getContentPane().add(anneepub, gbc_anneepub);
		anneepub.setColumns(10);
		
		JLabel lblEditeur = new JLabel("Nom publication:");
		lblEditeur.setForeground(new Color(0, 0, 128));
		lblEditeur.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblEditeur = new GridBagConstraints();
		gbc_lblEditeur.anchor = GridBagConstraints.WEST;
		gbc_lblEditeur.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditeur.gridx = 0;
		gbc_lblEditeur.gridy = 5;
		getContentPane().add(lblEditeur, gbc_lblEditeur);
		
		edit = new JTextField();
		GridBagConstraints gbc_edit = new GridBagConstraints();
		gbc_edit.insets = new Insets(0, 0, 5, 5);
		gbc_edit.anchor = GridBagConstraints.WEST;
		gbc_edit.gridx = 1;
		gbc_edit.gridy = 5;
		getContentPane().add(edit, gbc_edit);
		edit.setColumns(10);
		
		JLabel lblLieupublication = new JLabel("editeur:");
		lblLieupublication.setForeground(new Color(0, 0, 128));
		lblLieupublication.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblLieupublication = new GridBagConstraints();
		gbc_lblLieupublication.anchor = GridBagConstraints.WEST;
		gbc_lblLieupublication.insets = new Insets(0, 0, 5, 5);
		gbc_lblLieupublication.gridx = 0;
		gbc_lblLieupublication.gridy = 4;
		getContentPane().add(lblLieupublication, gbc_lblLieupublication);
		
		lieupub = new JTextField();
		GridBagConstraints gbc_lieupub = new GridBagConstraints();
		gbc_lieupub.insets = new Insets(0, 0, 5, 5);
		gbc_lieupub.anchor = GridBagConstraints.WEST;
		gbc_lieupub.gridx = 1;
		gbc_lieupub.gridy = 4;
		getContentPane().add(lieupub, gbc_lieupub);
		lieupub.setColumns(10);
		
		
		
		JButton btntelecharger = new JButton("Espace visiteur");
		btntelecharger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btntelechargerActionPerformed(e);
				relation (e);
			}
		});
		btntelecharger.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_btnTlcharger = new GridBagConstraints();
		gbc_btnTlcharger.insets = new Insets(0, 0, 5, 5);
		gbc_btnTlcharger.anchor = GridBagConstraints.EAST;
		gbc_btnTlcharger.gridx = 1;
		gbc_btnTlcharger.gridy = 7;
		getContentPane().add(btntelecharger, gbc_btnTlcharger);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter(e);
			}
		});
		btnConfirmer.setBackground(new Color(175, 238, 238));
		GridBagConstraints gbc_btnConfirmer = new GridBagConstraints();
		gbc_btnConfirmer.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmer.anchor = GridBagConstraints.WEST;
		gbc_btnConfirmer.gridx = 1;
		gbc_btnConfirmer.gridy = 8;
		getContentPane().add(btnConfirmer, gbc_btnConfirmer);
	}
public void remplirCombo()
{
	try 
	{
		Class.forName("org.postgresql.Driver");//test du driver
		System.out.println("Driver ok!!!");
		String url="jdbc:postgresql://localhost:5432/publication_scientifique";
		String user="postgres";
		String pw="postgre";
		Connection con=DriverManager.getConnection(url,user,pw);
		System.out.println("Connecté !!! ");
		Statement str=con.createStatement();
		String strpro="SELECT nom_auteur FROM auteur";
		ResultSet rs=str.executeQuery(strpro);
		while(rs.next()) 
		{
			String nom=rs.getString("nom_auteur").toString();
			 comboBox.addItem(nom);
			}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}}
public void ajouter(java.awt.event.ActionEvent evt)
{
	try 
	{
		Class.forName("org.postgresql.Driver");//test du driver
		//System.out.println("Driver ok!!!");
		String url="jdbc:postgresql://localhost:5432/publication_scientifique";
		String user="postgres";
		String pw="postgre";
		Connection con=DriverManager.getConnection(url,user,pw);
		//System.out.println("Connecté !!! ");
		Statement str=con.createStatement();
		
		String num,annee,lieu,editeur;
		num=numero.getText();
		annee=anneepub.getText();
		lieu=lieupub.getText();
		editeur=edit.getText();
		
		str.executeUpdate("INSERT INTO publication values('"+num+"','"+annee+"','"+editeur+"','"+lieu+"')");
		con.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}}
public void relation (java.awt.event.ActionEvent evt)
{
	//pubS pub=new pubS();
	v.setVisible(true);
	v.pack();
	v.setLocationRelativeTo(v);
	v.setDefaultCloseOperation(v.EXIT_ON_CLOSE);
}


}


