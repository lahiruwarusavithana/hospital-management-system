 package O_P_D;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MANAGEMENT.Sqlconnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class General_patient extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField address;
	private JTextField diagnosis;
	private JTextField sex;
	private JTextField weight;
	private JTextField pres_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					General_patient frame = new General_patient();
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
	
	public General_patient() {
	
		connection = Sqlconnection.dbConnector();	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GENERAL PATIENT");
		lblNewLabel.setFont(new Font("RomanT", Font.BOLD, 35));
		lblNewLabel.setBounds(385, 10, 407, 113);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(282, 204, 715, 31);
		contentPane.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setBounds(282, 271, 178, 31);
		contentPane.add(age);
		age.setColumns(10);
		
		address = new JTextField();
		address.setBounds(282, 337, 715, 30);
		contentPane.add(address);
		address.setColumns(10);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		try {
					
					String query = "INSERT INTO general_patient(pres_id,full_name,age,weight,sex,address) VALUES (?,?,?,?,?,?)";
									
					PreparedStatement ps = connection.prepareStatement(query);
					
					
					ps.setString(1,pres_id.getText());
					ps.setString(2,name.getText());
					ps.setString(3,age.getText());
					ps.setString(4,weight.getText());
					ps.setString(5,sex.getText());
					ps.setString(6,address.getText());
		
					
			
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					ps.close();

				}catch(Exception e1){
					
					e1.printStackTrace();
				}
					
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(912, 639, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(103, 198, 169, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(103, 265, 96, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(103, 324, 75, 48);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(176, 423, 46, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Diagnosis Details");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(103, 400, 168, 36);
		contentPane.add(lblNewLabel_5);
		
		diagnosis = new JTextField();
		diagnosis.setBounds(104, 446, 893, 148);
		contentPane.add(diagnosis);
		diagnosis.setColumns(10);
		
		sex = new JTextField();
		sex.setBounds(837, 271, 160, 31);
		contentPane.add(sex);
		sex.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Sex");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(722, 265, 66, 36);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Weight");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(493, 266, 66, 34);
		contentPane.add(lblNewLabel_7);
		
		weight = new JTextField();
		weight.setBounds(590, 274, 110, 25);
		contentPane.add(weight);
		weight.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Outdoor ot = new Outdoor();
				ot.setVisible(true);
				ot.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(103, 639, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("PRESCRIPTION");
		lblNewLabel_8.setFont(new Font("Proxy 3", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(493, 89, 131, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prescription Number");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(103, 140, 169, 36);
		contentPane.add(lblNewLabel_1_1);
		
		pres_id = new JTextField();
		pres_id.setColumns(10);
		pres_id.setBounds(282, 145, 178, 31);
		contentPane.add(pres_id);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_9.setBounds(0, -28, 1154, 738);
		contentPane.add(lblNewLabel_9);
	}

}
