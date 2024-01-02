package MANAGEMENT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class Add_Ambulence extends JFrame {

	private JPanel contentPane;
	private JTextField ambu_id;
	private JTextField driver_id;
	private JTextField driver_name;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Ambulence frame = new Add_Ambulence();
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
	private JTextField date;
	private JLabel lblNewLabel_5;
	private JTextField hospital;
	
	public Add_Ambulence() {
		
		connection = Sqlconnection.dbConnector();	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1107, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Controlling Ambulence ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(331, 23, 462, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ambulence  ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(322, 185, 147, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Driver ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(322, 234, 97, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Driver Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(322, 285, 147, 30);
		contentPane.add(lblNewLabel_3);
		
		ambu_id = new JTextField();
		ambu_id.setBounds(599, 190, 261, 20);
		contentPane.add(ambu_id);
		ambu_id.setColumns(10);
		
		driver_id = new JTextField();
		driver_id.setBounds(599, 242, 261, 20);
		contentPane.add(driver_id);
		driver_id.setColumns(10);
		
		driver_name = new JTextField();
		driver_name.setBounds(599, 293, 261, 20);
		contentPane.add(driver_name);
		driver_name.setColumns(10);
		
		btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ambulence ambu = new Ambulence();
				ambu.setVisible(true);
				ambu.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBounds(322, 530, 121, 38);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query = "INSERT INTO ambulance (ambulance_id,driver_id,driver_name,date,hospital) VALUES (?,?,?,?,?)";
									
					PreparedStatement ps = connection.prepareStatement(query);
					
					
					ps.setString(1,ambu_id.getText());
					ps.setString(2, driver_id.getText());
					ps.setString(3,driver_name.getText());
					ps.setString(4,date.getText());
					ps.setString(5,hospital.getText());
				
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					ps.close();

				}catch(Exception e1){
					
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(749, 530, 111, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Hospital");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(322, 403, 97, 24);
		contentPane.add(lblNewLabel_4);
		
		date = new JTextField();
		date.setBounds(599, 356, 261, 19);
		contentPane.add(date);
		date.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Date");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(322, 351, 111, 24);
		contentPane.add(lblNewLabel_5);
		
		hospital = new JTextField();
		hospital.setBounds(599, 408, 261, 19);
		contentPane.add(hospital);
		hospital.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_6.setBounds(0, 0, 1108, 671);
		contentPane.add(lblNewLabel_6);
	}
}
