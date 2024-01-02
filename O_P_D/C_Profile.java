package O_P_D;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MANAGEMENT.Sqlconnection;
import STAFF.Staff_login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class C_Profile extends JFrame {

	private JPanel contentPane;
	private JTextField mobi;
	private JTextField add;
	private JTextField age;
	private JTextField diagnosis;
	private JTextField pid;
	private JTextField wei;
	
	String name = "";
	String sex = "";
	String nic = "";
	String type = "" ;
	String address = "";
	String mobile = "";
	String date = "";
	String diag = "";
	String room_no = "";
	String age1 = "";
	String weight = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					C_Profile frame = new C_Profile();
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
	private JTextField rm_no;
	private JTextField nm;
	private JTextField sx;
	private JTextField nc;
	private JTextField ct;
	private JTextField ed;

	public C_Profile() {
		
		
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1117, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLINICAL PATIENT PROFILE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(251, 10, 680, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(43, 145, 86, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(43, 328, 78, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NIC");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(43, 388, 65, 44);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sex");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(43, 215, 65, 28);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(43, 519, 103, 38);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Entry Date");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(623, 81, 86, 28);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Mobile no");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(43, 460, 103, 28);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Diagnosis Details");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(386, 283, 170, 53);
		contentPane.add(lblNewLabel_8);
		
	
		mobi = new JTextField(mobile);
		mobi.setBounds(175, 465, 184, 25);
		contentPane.add(mobi);
		mobi.setColumns(10);
		
		add = new JTextField(address);
		add.setBounds(175, 529, 184, 25);
		contentPane.add(add);
		add.setColumns(10);
		
		age = new JTextField(age1);
		age.setBounds(175, 338, 180, 25);
		contentPane.add(age);
		age.setColumns(10);
		
		diagnosis = new JTextField(diag);
		diagnosis.setBounds(386, 346, 523, 211);
		contentPane.add(diagnosis);
		diagnosis.setColumns(10);
		
		wei = new JTextField(weight);
		wei.setBounds(175, 273, 184, 25);
		contentPane.add(wei);
		wei.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Clinic Type");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(623, 215, 103, 28);
		contentPane.add(lblNewLabel_9);
	
		JLabel patient_id = new JLabel("Patient ID");
		patient_id.setFont(new Font("Tahoma", Font.PLAIN, 18));
		patient_id.setBounds(43, 94, 103, 26);
		contentPane.add(patient_id);
		
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try { 
					
					
					String findDetails = "SELECT name,sex,nic,mobile_no,address,weight, entry_date,clinic_type,age,diagnosis_det,room_no FROM clinical_patient WHERE patient_id = '"+pid.getText()+"';";
					
					PreparedStatement psDetails = connection.prepareStatement(findDetails);
					ResultSet rsDetails = psDetails.executeQuery();
					
					while(rsDetails.next()) {
				
						nm.setText(rsDetails.getString("name"));
						sx.setText(rsDetails.getString("sex"));
						nc.setText(rsDetails.getString("nic"));
						mobi.setText(rsDetails.getString("mobile_no"));
						add.setText(rsDetails.getString("address"));
						wei.setText(rsDetails.getString("weight"));
						ed.setText(rsDetails.getString("entry_date"));
						ct.setText(rsDetails.getString("clinic_type"));
						age.setText(rsDetails.getString("age"));
						diagnosis.setText(rsDetails.getString("diagnosis_det"));
						rm_no.setText(rsDetails.getString("room_no"));
								
							
					}
		
				}
				
				catch(Exception e1) {
					e1.printStackTrace();
				}
						
			}
		});
		btnNewButton.setBounds(294, 99, 96, 25);
		contentPane.add(btnNewButton);
		
		pid = new JTextField();
		pid.setBounds(175, 100, 96, 25);
		contentPane.add(pid);
		pid.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Room No.");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(623, 145, 96, 38);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Weight");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(43, 270, 78, 25);
		contentPane.add(lblNewLabel_11);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clinical_patient cp = new Clinical_patient();
				cp.setVisible(true);
				cp.setLocationRelativeTo(null);
				dispose();
			}
			
		});
		btnNewButton_1.setBounds(43, 623, 103, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
					
					String updateQuery = "UPDATE clinical_patient SET age = '"+age.getText()+"', address = '"+add.getText()+"', mobile_no = '"+mobi.getText()+"',diagnosis_det = '"+diagnosis.getText()+"' WHERE patient_id = '"+pid.getText()+"';";
					java.sql.PreparedStatement ps = connection.prepareStatement(updateQuery);
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
				
					ps.close();
				
				}catch(Exception e2){
					
					e2.printStackTrace();
				}
			}
			
		});
			
		btnNewButton_2.setBounds(896, 623, 112, 28);
		contentPane.add(btnNewButton_2);
		
		rm_no = new JTextField(room_no);
		rm_no.setBounds(757, 155, 152, 26);
		contentPane.add(rm_no);
		rm_no.setColumns(10);
		
		nm = new JTextField(name);
		nm.setBounds(175, 155, 345, 25);
		contentPane.add(nm);
		nm.setColumns(10);
		
		sx = new JTextField(sex);
		sx.setBounds(175, 220, 96, 25);
		contentPane.add(sx);
		sx.setColumns(10);
		
		nc = new JTextField(nic);
		nc.setBounds(175, 401, 180, 25);
		contentPane.add(nc);
		nc.setColumns(10);
		
		ct = new JTextField(type);
		ct.setBounds(757, 219, 152, 28);
		contentPane.add(ct);
		ct.setColumns(10);
		
		ed = new JTextField(date);
		ed.setBounds(757, 85, 152, 28);
		contentPane.add(ed);
		ed.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_12.setBounds(0, -29, 1114, 738);
		contentPane.add(lblNewLabel_12);
		
		
		
		
		
	}
}
