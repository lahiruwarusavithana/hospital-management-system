package STAFF;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import MANAGEMENT.Sqlconnection;
import MANAGEMENT.Welcome_e_Medix;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Staff_login extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwd;
	

	public static String userNamePublic;
	public static String userIdPublic;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_login frame = new Staff_login();
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
	Connection connection = null ;
	
	public Staff_login() {
		
		connection = Sqlconnection.dbConnector();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1079, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane uid = new JTextPane();
		uid.setBounds(464, 269, 361, 43);
		contentPane.add(uid);
		
		pwd = new JPasswordField();
		pwd.setBounds(464, 365, 361, 43);
		contentPane.add(pwd);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					
				try {
			
						String query = "SELECT * FROM staff WHERE e_id = ? and u_pswd = ?";
						java.sql.PreparedStatement pst = connection.prepareStatement(query);
						
						pst.setString(1,uid.getText() );
						pst.setString(2,pwd.getText() );
						
						ResultSet rs = pst.executeQuery();
						
						int count = 0 ;
						
						while(rs.next() ) {
							userIdPublic = rs.getString("e_id");
					        userNamePublic = rs.getString("u_pswd");
							count++;
						}
						
						rs.close();
						pst.close();
						
						if(count ==1)
						{
							
							JOptionPane.showMessageDialog(null, "Welcome  " +userIdPublic);
							
							dispose();
							Staff_profile hm = new Staff_profile();
							hm.setVisible(true);
							hm.setLocationRelativeTo(null);
							
				
				
						}
						else  {
							JOptionPane.showMessageDialog(null, "Username or password is incorrect");
							
						}
			
		
						}catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1);
						}
						
				  }
					
				
	
			});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(679, 495, 146, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Welcome_e_Medix clerk = new Welcome_e_Medix();
				clerk.setVisible(true);
				clerk.setLocationRelativeTo(null);
				dispose();
			}
		
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(178, 497, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(406, 61, 210, 71);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(174, 275, 188, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(174, 361, 112, 43);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("Images\\lastone.jpg"));
		lblNewLabel_3.setBounds(0, -29, 1092, 675);
		contentPane.add(lblNewLabel_3);
	}
}