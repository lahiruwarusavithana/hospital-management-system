package I_H_U;

import java.awt.BorderLayout;

import java.sql.PreparedStatement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MANAGEMENT.Sqlconnection;
import MANAGEMENT.Welcome_e_Medix;

import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class Add_Dental extends JFrame {

	private JPanel contentPane;
	private JTextField pname;
	private JTextField pid;
	private JTextField psex;
	private JTextField page;
	private JTextField pnic;
	private JTextField pnum;
	private JTextField padd;
	private JTextField pdate;
	private JTextField pdiag;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Dental frame = new Add_Dental();
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
	
	public Add_Dental() {

		connection = Sqlconnection.dbConnector();	
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DENTAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(470, 10, 250, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Patient ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(103, 102, 113, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Patient Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(103, 166, 144, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Sex");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(103, 222, 113, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile Number ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(103, 365, 167, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NIC");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(103, 318, 107, 22);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(103, 412, 113, 22);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Next Dental Date");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setBounds(103, 460, 167, 22);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Diagnosis Details");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_8.setBounds(103, 525, 186, 29);
		contentPane.add(lblNewLabel_8);
		
		pname = new JTextField();
		pname.setBounds(369, 154, 392, 23);
		contentPane.add(pname);
		pname.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Age");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_9.setBounds(103, 268, 73, 23);
		contentPane.add(lblNewLabel_9);
		
		pid = new JTextField();
		pid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pid.setColumns(10);
		pid.setBounds(369, 101, 392, 23);
		contentPane.add(pid);
		
		psex = new JTextField();
		psex.setColumns(10);
		psex.setBounds(369, 211, 392, 23);
		contentPane.add(psex);
		
		page = new JTextField();
		page.setColumns(10);
		page.setBounds(369, 268, 392, 23);
		contentPane.add(page);
		
		pnic = new JTextField();
		pnic.setColumns(10);
		pnic.setBounds(369, 321, 392, 23);
		contentPane.add(pnic);
		
		pnum = new JTextField();
		pnum.setColumns(10);
		pnum.setBounds(369, 368, 392, 23);
		contentPane.add(pnum);
		
		padd = new JTextField();
		padd.setColumns(10);
		padd.setBounds(369, 415, 392, 23);
		contentPane.add(padd);
		
		pdate = new JTextField();
		pdate.setColumns(10);
		pdate.setBounds(369, 463, 392, 23);
		contentPane.add(pdate);
		
		pdiag = new JTextField();
		pdiag.setColumns(10);
		pdiag.setBounds(369, 526, 392, 63);
		contentPane.add(pdiag);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Dental welcome = new Dental();
				welcome.setVisible(true);
				welcome.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(103, 582, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query = "INSERT INTO dental (patient_id,name,sex,age,mobile_no,nic,address,next_dental_date,diagnosis_details) VALUES (?,?,?,?,?,?,?,?,?)";
									
					PreparedStatement ps = connection.prepareStatement(query);
					
					
					ps.setString(1,pid.getText());
					ps.setString(2,pname.getText());
					ps.setString(3,psex.getText());
					ps.setString(4,page.getText());
					ps.setString(5,pnum.getText());
					ps.setString(6,pnic.getText());
					ps.setString(7,padd.getText());
					ps.setString(8,pdate.getText());
					ps.setString(9,pdiag.getText());
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					ps.close();

				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, "Invalid data Entered");
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(900, 582, 127, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_10.setBounds(0, 0, 1105, 665);
		contentPane.add(lblNewLabel_10);
	}
}
