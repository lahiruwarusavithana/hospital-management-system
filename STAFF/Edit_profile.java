package STAFF;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import MANAGEMENT.Sqlconnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;


public class Edit_profile extends JFrame {

	private JPanel contentPane;
	private JTextField mobile;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit_profile frame = new Edit_profile();
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
	
	private JTextField textField;
	private JTextField pw;
		
	public Edit_profile() {
		
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1104, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Profile");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(444, 34, 221, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile Number");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(209, 215, 133, 39);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(209, 295, 89, 27);
		contentPane.add(lblNewLabel_3);
		
		
		
		Staff_login log1 = new Staff_login();	
		String empID = log1.userIdPublic ;
		
		JLabel emp = new JLabel("");
		emp.setBounds(352, 146, 107, 24);
		contentPane.add(emp);
		emp.setText(empID);
		
		
		//	eid1.setText(log.userIdPublic);
		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Staff_profile s_profile= new Staff_profile();
				s_profile.setVisible(true);
				s_profile.setLocationRelativeTo(null);
				dispose();
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(169, 580, 89, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String updateQuery = "UPDATE staff SET  mobile_phone = '"+mobile.getText()+"', e_mail = '"+email.getText()+"',u_pswd = '"+pw.getText()+"' WHERE e_id = '"+empID+"';";
					java.sql.PreparedStatement ps = connection.prepareStatement(updateQuery);
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
				
					ps.close();
				
				}catch(Exception e2){
					
					e2.printStackTrace();
				}
			}
			
		});
		
		
		
		
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnNewButton_1.setBounds(713, 580, 89, 30);
		contentPane.add(btnNewButton_1);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(352, 223, 450, 30);
		contentPane.add(mobile);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(352, 292, 450, 30);
		contentPane.add(email);
		
		JLabel lblNewLabel_5 = new JLabel("Employee ID");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(209, 146, 121, 24);
		contentPane.add(lblNewLabel_5);
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Dialog", Font.PLAIN, 18));
		Password.setBounds(209, 363, 107, 24);
		contentPane.add(Password);
		
		pw = new JTextField();
		pw.setBounds(352, 363, 450, 30);
		contentPane.add(pw);
		pw.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_6.setBounds(0, 0, 1103, 691);
		contentPane.add(lblNewLabel_6);
	
		
				


	}
}
	

