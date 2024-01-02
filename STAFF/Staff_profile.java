package STAFF;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MANAGEMENT.Sqlconnection;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Staff_profile extends JFrame {

	private JPanel contentPane;

	String name = "";
	String position = "";
	String sex = "";
	String nic = "";
	String address = "";
	String mobile = "";
	String email = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_profile frame = new Staff_profile();
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
	
	public Staff_profile() {
		
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1101, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Your Profile");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(390, 28, 385, 24);
		contentPane.add(lblNewLabel);
		
		Staff_login log = new Staff_login();
		JLabel eid = new JLabel("");
		String eid1 = log.userIdPublic ;
		
		String name = "";
		String position = "";
		String sex = "";
		String nic = "";
		String address = "";
		String mobile = "";
		String email = "";
		
		try { 
			
			String findDetails = "SELECT name,position,sex,nic,mobile_phone,e_mail,Address FROM staff WHERE e_id = '"+eid1+"';";
			
			PreparedStatement psDetails = connection.prepareStatement(findDetails);
			ResultSet rsDetails = psDetails.executeQuery();
			
			while(rsDetails.next()) {
		
				name    = rsDetails.getString("name");
				position = rsDetails.getString("position");
				sex      = rsDetails.getString("sex");
				nic      = rsDetails.getString("nic");
				mobile   = rsDetails.getString("mobile_phone");
				email    = rsDetails.getString("e_mail");
				address  = rsDetails.getString("Address");				
				
			}	
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		
		eid.setBounds(550, 111, 424, 24);
		contentPane.add(eid);

		eid.setText(log.userIdPublic);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(363, 167, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Position");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(363, 213, 70, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(363, 464, 70, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile Number");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(363, 368, 163, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff_login c_login= new Staff_login();
				c_login.setVisible(true);
				c_login.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(146, 556, 89, 24);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Edit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Edit_profile edit= new Edit_profile();
				edit.setVisible(true);
				edit.setLocationRelativeTo(null);
				dispose();				
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setBounds(897, 557, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(363, 411, 70, 24);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sex");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(363, 260, 45, 24);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("NIC");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(363, 315, 36, 24);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Employee ID");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(363, 111, 127, 24);
		contentPane.add(lblNewLabel_8);		
		
		JLabel name1 = new JLabel(name);
		name1.setBounds(550, 157, 424, 24);
		contentPane.add(name1);
		
		JLabel position1 = new JLabel(position);
		position1.setBounds(550, 213, 424, 24);
		contentPane.add(position1);
		
		JLabel sex1 = new JLabel(sex);
		sex1.setBounds(550, 260, 424, 24);
		contentPane.add(sex1);
		
		JLabel nic1 = new JLabel(nic);
		nic1.setBounds(550, 315, 424, 24);
		contentPane.add(nic1);
		
		JLabel mobile1 = new JLabel(mobile);
		mobile1.setBounds(550, 368, 424, 24);
		contentPane.add(mobile1);
		
		JLabel email1 = new JLabel(email);
		email1.setBounds(550, 411, 424, 24);
		contentPane.add(email1);
		
		JLabel address1 = new JLabel(address);
		address1.setBounds(550, 464, 424, 24);
		contentPane.add(address1);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_9.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_9.setBounds(0, 0, 1087, 657);
		contentPane.add(lblNewLabel_9);
	}
}
