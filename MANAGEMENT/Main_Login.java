package MANAGEMENT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import STAFF.Staff_profile;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Main_Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwd;
	private JTextField unm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Login frame = new Main_Login();
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
	
	public Main_Login() {
		
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1068, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(672, 442, 108, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(672, 485, 108, 52);
		contentPane.add(lblPassword);
		
		pwd = new JPasswordField();
		pwd.setBounds(813, 503, 135, 21);
		contentPane.add(pwd);
		
		unm = new JTextField();
		unm.setBounds(813, 451, 135, 21);
		contentPane.add(unm);
		unm.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					String query = "SELECT * FROM staff WHERE e_id = ? and u_pswd = ?";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					
					pst.setString(1,unm.getText() );
					pst.setString(2,pwd.getText() );
					
					ResultSet rs = pst.executeQuery();
					
					int count = 0 ;
					
					String userIdPublic = null;
				
					while(rs.next() ) {
						userIdPublic = rs.getString("e_id");
				        String userNamePublic = rs.getString("u_pswd");
						count++;
					}
					
					rs.close();
					pst.close();
					
					if(count ==1)
					{
						
						JOptionPane.showMessageDialog(null, "Welcome  " +userIdPublic);
						
						dispose();
						Welcome_e_Medix hm = new Welcome_e_Medix();
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
		btnNewButton.setBounds(839, 550, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Images\\ljiji.jpg"));
		lblNewLabel.setBounds(0, -45, 1057, 694);
		contentPane.add(lblNewLabel);
	}
}
