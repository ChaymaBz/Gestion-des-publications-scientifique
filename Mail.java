package Pub;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class Mail extends JFrame {

	private JPanel contentPane;
	private JLabel lblConfirmerVotreEmail;
	private JTextField adr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mail frame = new Mail();
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
	public Mail() {
		setBackground(new Color(255, 255, 255));
		setTitle("Confirmation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setForeground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblConfirmerVotreEmail = new JLabel("Confirmer votre Email!");
		lblConfirmerVotreEmail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		lblConfirmerVotreEmail.setForeground(new Color(199, 21, 133));
		GridBagConstraints gbc_lblConfirmerVotreEmail = new GridBagConstraints();
		gbc_lblConfirmerVotreEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblConfirmerVotreEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmerVotreEmail.gridx = 2;
		gbc_lblConfirmerVotreEmail.gridy = 0;
		contentPane.add(lblConfirmerVotreEmail, gbc_lblConfirmerVotreEmail);
		
		JLabel lblAdresseEmail = new JLabel("Adresse E-mail:");
		lblAdresseEmail.setForeground(new Color(0, 0, 139));
		lblAdresseEmail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GridBagConstraints gbc_lblAdresseEmail = new GridBagConstraints();
		gbc_lblAdresseEmail.anchor = GridBagConstraints.WEST;
		gbc_lblAdresseEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresseEmail.gridx = 2;
		gbc_lblAdresseEmail.gridy = 2;
		contentPane.add(lblAdresseEmail, gbc_lblAdresseEmail);
		
		adr = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridwidth = 7;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 2;
		contentPane.add(adr, gbc_textField);
		adr.setColumns(10);
		
		JButton btnEnvoyer = new JButton("Télécharger");
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				exit(e);
				
						
						
				
			}
		});
		btnEnvoyer.setBackground(new Color(175, 238, 238));
		btnEnvoyer.setForeground(new Color(0, 0, 0));
		btnEnvoyer.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_btnEnvoyer = new GridBagConstraints();
		gbc_btnEnvoyer.insets = new Insets(0, 0, 0, 5);
		gbc_btnEnvoyer.gridx = 3;
		gbc_btnEnvoyer.gridy = 7;
		contentPane.add(btnEnvoyer, gbc_btnEnvoyer);
	}
	JOptionPane opt=new JOptionPane();
	public void exit(ActionEvent evt)
	{try 
	{
		Class.forName("org.postgresql.Driver");//test du driver
		System.out.println("Driver ok!!!");
		String url="jdbc:postgresql://localhost:5432/publication_scientifique";
		String user="postgres";
		String pw="postgre";
		Connection con=DriverManager.getConnection(url,user,pw);
		System.out.println("Connecté !!! ");
		Statement str=con.createStatement();
		String strpro="SELECT adr_mail FROM visiteur";
		ResultSet rs=str.executeQuery(strpro);
		int i=0;
		while(rs.next()) 
		{
			String adr_visiteur=rs.getString("adr_mail").toString();
			 if (adr.getText().equals(adr_visiteur)) 
				 opt.showMessageDialog(null, "Vous pouvez maintenant télécharger l'article !!"
							+ "","Bienvenue",JOptionPane.INFORMATION_MESSAGE);
			 
		
			 else
			 {
				 opt.showMessageDialog(null, "Attention!! vous n'etes pas autorisé"
							+ "","Bienvenue",JOptionPane.WARNING_MESSAGE);
				 
			}
		}
		
		con.close();
}catch(Exception e1)
{
e1.printStackTrace();
}
		
	}

}
