package MANAGEMENT;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import O_P_D.Medicine;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Acc_Oversser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acc_Oversser frame = new Acc_Oversser();
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
	private JTextField d_id;
	private JTextField d_name;
	private JTextField d_nic;
	private JTextField d_phone;
	private JTextField d_mail;
	private JTextField d_add;
	private JTextField d_pos;
	private JTextField d_position;
	private JTextField sex;
	private JTextField password;
	
	public Acc_Oversser() {
		
		connection = Sqlconnection.dbConnector();	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1109, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Oversser Accounts");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(409, 10, 285, 77);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Oversser ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(199, 97, 151, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Oversser Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(199, 153, 165, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Position");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(199, 210, 114, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NIC");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(199, 283, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile No");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(199, 333, 114, 27);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("E-Mail");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(199, 394, 83, 27);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(199, 454, 133, 27);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
				
			try {
					
					String query = "INSERT INTO staff (e_id,name,position,nic,mobile_phone,e_mail,Address,sex,u_pswd) VALUES (?,?,?,?,?,?,?,?,?)";
									
					PreparedStatement ps = connection.prepareStatement(query);
					
					
					ps.setString(1,d_id.getText());
					ps.setString(2,d_name.getText());
					ps.setString(3,d_position.getText());
					ps.setString(4,d_nic.getText());
					ps.setString(5,d_phone.getText());
					ps.setString(6,d_mail.getText());
					ps.setString(7,d_add.getText());
					ps.setString(8,sex.getText());	
					ps.setString(9,password.getText());
					
				
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					ps.close();

				}catch(Exception e1){
					
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(692, 623, 114, 27);
		contentPane.add(btnNewButton);
		
		d_id = new JTextField();
		d_id.setBounds(416, 103, 387, 19);
		contentPane.add(d_id);
		d_id.setColumns(10);
		
		d_name = new JTextField();
		d_name.setBounds(416, 162, 387, 19);
		contentPane.add(d_name);
		d_name.setColumns(10);
		
		d_nic = new JTextField();
		d_nic.setBounds(416, 282, 387, 19);
		contentPane.add(d_nic);
		d_nic.setColumns(10);
		
		d_phone = new JTextField();
		d_phone.setBounds(416, 339, 387, 19);
		contentPane.add(d_phone);
		d_phone.setColumns(10);
		
		d_mail = new JTextField();
		d_mail.setBounds(416, 400, 387, 19);
		contentPane.add(d_mail);
		d_mail.setColumns(10);
		
		d_add = new JTextField();
		d_add.setBounds(416, 460, 387, 19);
		contentPane.add(d_add);
		d_add.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Accounts acc = new Accounts();
				acc.setVisible(true);
				acc.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setBounds(199, 620, 114, 32);
		contentPane.add(btnNewButton_1);
		
		d_position = new JTextField();
		d_position.setBounds(416, 219, 387, 19);
		contentPane.add(d_position);
		d_position.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Sex");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_9.setBounds(199, 506, 83, 31);
		contentPane.add(lblNewLabel_9);
		
		sex = new JTextField();
		sex.setBounds(419, 516, 384, 19);
		contentPane.add(sex);
		sex.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Password");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setBounds(199, 559, 114, 38);
		contentPane.add(lblNewLabel_8);
		
		password = new JTextField();
		password.setBounds(419, 569, 387, 19);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_10.setBounds(0, 0, 1109, 680);
		contentPane.add(lblNewLabel_10);
	}
}
