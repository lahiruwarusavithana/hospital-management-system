package I_H_U;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MANAGEMENT.Sqlconnection;
import MANAGEMENT.Welcome_e_Medix;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class Lab_Test_Results extends JFrame {

	private JPanel contentPane;
	private JTextField p_id;
	private JTextField sample_id;
	private JTextField name;
	private JTextField t_type;
	private JTextField date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab_Test_Results frame = new Lab_Test_Results();
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
	private JTextField result;
	
	public Lab_Test_Results() {
		
		connection = Sqlconnection.dbConnector();	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1096, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lab Test Results");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(406, 31, 348, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Patient ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(66, 145, 157, 20);
		contentPane.add(lblNewLabel_2);
		
		p_id = new JTextField();
		p_id.setBounds(233, 149, 430, 19);
		contentPane.add(p_id);
		p_id.setColumns(10);
		
		sample_id = new JTextField();
		sample_id.setBounds(233, 209, 430, 19);
		contentPane.add(sample_id);
		sample_id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(233, 268, 430, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Sample ID");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(66, 200, 116, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(66, 265, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Test Type");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(66, 321, 96, 19);
		contentPane.add(lblNewLabel_5);
		
		t_type = new JTextField();
		t_type.setBounds(233, 324, 430, 19);
		contentPane.add(t_type);
		t_type.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Date of Testing");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(61, 371, 143, 30);
		contentPane.add(lblNewLabel_7);
		
		date = new JTextField();
		date.setBounds(233, 380, 430, 19);
		contentPane.add(date);
		date.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Results");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(66, 434, 72, 17);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query = "INSERT INTO lab_test (patient_id,sample_id,name,test_type,date_of_testing,result) VALUES (?,?,?,?,?,?)";
									
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.setString(1,p_id.getText());
					ps.setString(2,sample_id.getText());
					ps.setString(3,name.getText());
					ps.setString(4,t_type.getText());
					ps.setString(5,date.getText());
					ps.setString(6,result.getText());
				
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					ps.close();

				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, "You Have Entered Invalid Input");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(910, 629, 116, 29);
		contentPane.add(btnNewButton);
		
		result = new JTextField();
		result.setBounds(66, 461, 960, 146);
		contentPane.add(result);
		result.setColumns(10);
		
		
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome_e_Medix welcome = new Welcome_e_Medix();
				welcome.setVisible(true);
				welcome.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setBounds(66, 628, 116, 30);
		contentPane.add(btnNewButton_2);
		
		
		
		JButton btnNewButton_2_1 = new JButton("Find");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Lab_Test welcome = new View_Lab_Test();
				welcome.setVisible(true);
				welcome.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1.setBounds(495, 629, 116, 29);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1096, 691);
		contentPane.add(lblNewLabel_1);
	}
}
