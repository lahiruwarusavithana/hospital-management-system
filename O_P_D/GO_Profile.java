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

public class GO_Profile extends JFrame {

	private JPanel contentPane;
	private JTextField mobi;
	private JTextField add;
	private JTextField age;
	private JTextField diagnosis;
	private JTextField pid;
	private JTextField wei;
	private JTextField nm;
	private JTextField nc;
	private JTextField ed;
	private JTextField tr;
	
	String name = "";
	String sex = "";
	String nic = ""; 
	String address = "";
	String mobile = "";
	String date = "";
	String diag = "";
	String age1 = "";
	String weight = "";
	String trust = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GO_Profile frame = new GO_Profile();
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
	
	public GO_Profile() {
		
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1107, 719);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(73, 225, 107, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(73, 330, 107, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NIC");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(676, 216, 65, 38);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(73, 400, 107, 38);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Entry Date");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(676, 164, 86, 28);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Mobile no");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(676, 336, 103, 28);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Diagnosis Details");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(73, 458, 143, 53);
		contentPane.add(lblNewLabel_8);
		
	
		mobi = new JTextField(mobile);
		mobi.setBounds(834, 338, 149, 28);
		contentPane.add(mobi);
		mobi.setColumns(10);
		
		add = new JTextField(address);
		add.setBounds(204, 410, 354, 26);
		contentPane.add(add);
		add.setColumns(10);
		
		age = new JTextField(age1);
		age.setBounds(204, 339, 118, 28);
		contentPane.add(age);
		age.setColumns(10);
		
		diagnosis = new JTextField(diag);
		diagnosis.setBounds(73, 508, 910, 87);
		contentPane.add(diagnosis);
		diagnosis.setColumns(10);
		
		wei = new JTextField(weight);
		wei.setBounds(204, 280, 118, 28);
		contentPane.add(wei);
		wei.setColumns(10);
	
		JLabel patient_id = new JLabel("Patient ID");
		patient_id.setFont(new Font("Tahoma", Font.PLAIN, 18));
		patient_id.setBounds(73, 174, 107, 26);
		contentPane.add(patient_id);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try { 
						
					String findDetails = "SELECT name,nic,mobile_no,address,weight, entry_date,age,diagnosis_details,trustee FROM go WHERE p_id = '"+pid.getText()+"';";
					
					PreparedStatement psDetails = connection.prepareStatement(findDetails);
					ResultSet rsDetails = psDetails.executeQuery();
					
					while(rsDetails.next()) {
				
						nm.setText(rsDetails.getString("name"));
						nc.setText(rsDetails.getString("nic"));
						mobi.setText(rsDetails.getString("mobile_no"));
						add.setText(rsDetails.getString("address"));
						wei.setText(rsDetails.getString("weight"));
						ed.setText(rsDetails.getString("entry_date"));
						age.setText(rsDetails.getString("age"));
						diagnosis.setText(rsDetails.getString("diagnosis_details"));
						tr.setText(rsDetails.getString("trustee"));		
							
					}
				
				}
				
				catch(Exception e1) {
					e1.printStackTrace();
				}
						
			}
		});
		btnNewButton.setBounds(375, 172, 118, 33);
		contentPane.add(btnNewButton);
		
		pid = new JTextField();
		pid.setBounds(204, 173, 118, 32);
		contentPane.add(pid);
		pid.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Weight");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(73, 281, 107, 19);
		contentPane.add(lblNewLabel_11);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gyn_obs md = new Gyn_obs();
				md.setVisible(true);
				md.setLocationRelativeTo(null);
				dispose();
			}
			
		});
		btnNewButton_1.setBounds(73, 632, 118, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
					
					String updateQuery = "UPDATE go SET age = '"+age.getText()+"', address = '"+add.getText()+"', mobile_no = '"+mobi.getText()+"',diagnosis_details = '"+diagnosis.getText()+"' WHERE p_id = '"+pid.getText()+"';";
					java.sql.PreparedStatement ps = connection.prepareStatement(updateQuery);
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
				
					ps.close();
				
				}catch(Exception e2){
					
					e2.printStackTrace();
				}
			}
			
		});
			
		btnNewButton_2.setBounds(853, 632, 130, 28);
		contentPane.add(btnNewButton_2);
		
		nm = new JTextField(name);
		nm.setBounds(204, 227, 354, 26);
		contentPane.add(nm);
		nm.setColumns(10);
		
		nc = new JTextField(nic);
		nc.setBounds(834, 223, 149, 28);
		contentPane.add(nc);
		nc.setColumns(10);
		
		ed = new JTextField(date);
		ed.setBounds(834, 164, 149, 27);
		contentPane.add(ed);
		ed.setColumns(10);
		
		JLabel label = new JLabel("PATIENT PROFILE");
		label.setFont(new Font("Tahoma", Font.BOLD, 40));
		label.setBounds(351, 10, 398, 63);
		contentPane.add(label);
		
		JLabel lblMedicine = new JLabel("GYN & OBS");
		lblMedicine.setFont(new Font("Dialog", Font.PLAIN, 35));
		lblMedicine.setBounds(429, 83, 242, 38);
		contentPane.add(lblMedicine);
		
		JLabel lblNewLabel = new JLabel("Trustee");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(676, 278, 103, 26);
		contentPane.add(lblNewLabel);
		
		tr = new JTextField("");
		tr.setColumns(10);
		tr.setBounds(834, 279, 149, 28);
		contentPane.add(tr);	
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_9.setBounds(0, -27, 1124, 736);
		contentPane.add(lblNewLabel_9);
		
	}
}
