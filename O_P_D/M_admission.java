package O_P_D;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import MANAGEMENT.Sqlconnection;
import javax.swing.ImageIcon;

public class M_admission extends JFrame {
	
	private JPanel diagnosis_det;
	private JTextField f_name;
	private JTextField age;
	private JTextField address;
	private JTextField trustee;
	private JTextField sex;
	private JTextField bed_No;
	private JTextField pid;
	private JTextField nic;
	private JTextField entry_date;
	private JTextField mobile;
	private JTextField diagnosis;
	private JTextField diagnos;
	private JTextField weight;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					M_admission frame = new M_admission();
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
	
	public M_admission() {
		
		
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 711);
		diagnosis_det = new JPanel();
		diagnosis_det.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(diagnosis_det);
		diagnosis_det.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMISSION");
		lblNewLabel.setFont(new Font("RomanT", Font.BOLD, 35));
		lblNewLabel.setBounds(459, 21, 280, 81);
		diagnosis_det.add(lblNewLabel);
		
		f_name = new JTextField();
		f_name.setBounds(282, 165, 658, 31);
		diagnosis_det.add(f_name);
		f_name.setColumns(10);
		
		age = new JTextField();
		age.setBounds(282, 229, 178, 31);
		diagnosis_det.add(age);
		age.setColumns(10);
		
		address = new JTextField();
		address.setBounds(282, 503, 715, 30);
		diagnosis_det.add(address);
		address.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
	try {
					
					String query = "INSERT INTO medicine (p_id,name,sex,age,entry_date,bed_no,nic,trustee,mobile_no,address,diagnosis_details,weight) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
									
					PreparedStatement ps = connection.prepareStatement(query);
					
					
					ps.setString(1,pid.getText());
					ps.setString(2,f_name.getText());
					ps.setString(3,sex.getText());
					ps.setString(4,age.getText());
					ps.setString(5,entry_date.getText());
					ps.setString(6,bed_No.getText());
					ps.setString(7,nic.getText());
					ps.setString(8,trustee.getText());
					ps.setString(9,mobile.getText());
					ps.setString(10,address.getText());
					ps.setString(11,diagnos.getText());
					ps.setString(12,weight.getText());
				
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					ps.close();

				}catch(Exception e1){
					
					e1.printStackTrace();
				}		
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(912, 633, 85, 21);
		diagnosis_det.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(103, 159, 169, 36);
		diagnosis_det.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(103, 223, 96, 36);
		diagnosis_det.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(103, 490, 75, 48);
		diagnosis_det.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Weight");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(103, 341, 75, 31);
		diagnosis_det.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Trustee");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(674, 403, 118, 36);
		diagnosis_det.add(lblNewLabel_5);
		
		trustee = new JTextField();
		trustee.setBounds(820, 407, 120, 36);
		diagnosis_det.add(trustee);
		trustee.setColumns(10);
		
		sex = new JTextField();
		sex.setBounds(282, 387, 160, 31);
		diagnosis_det.add(sex);
		sex.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Sex");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(103, 381, 66, 36);
		diagnosis_det.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Bed No.");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(103, 278, 66, 34);
		diagnosis_det.add(lblNewLabel_7);
		
		bed_No = new JTextField();
		bed_No.setBounds(282, 283, 118, 31);
		diagnosis_det.add(bed_No);
		bed_No.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Medicine  ot = new Medicine();
				ot.setVisible(true);
				ot.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(103, 633, 100, 25);
		diagnosis_det.add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("Patient_ID");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(674, 285, 118, 21);
		diagnosis_det.add(lblNewLabel_8);
		
		pid = new JTextField();
		pid.setBounds(820, 283, 120, 31);
		diagnosis_det.add(pid);
		pid.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("NIC");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(674, 226, 102, 31);
		diagnosis_det.add(lblNewLabel_9);
		
		nic = new JTextField();
		nic.setBounds(820, 229, 124, 31);
		diagnosis_det.add(nic);
		nic.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Entry Date");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(674, 341, 102, 31);
		diagnosis_det.add(lblNewLabel_10);
		
		entry_date = new JTextField();
		entry_date.setBounds(820, 342, 118, 36);
		diagnosis_det.add(entry_date);
		entry_date.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Mobile No.");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(102, 438, 123, 31);
		diagnosis_det.add(lblNewLabel_11);
		
		mobile = new JTextField();
		mobile.setBounds(282, 440, 160, 34);
		diagnosis_det.add(mobile);
		mobile.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("MEDICIINE");
		lblNewLabel_12.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblNewLabel_12.setBounds(506, 94, 124, 31);
		diagnosis_det.add(lblNewLabel_12);
		
		diagnos = new JTextField();
		diagnos.setColumns(10);
		diagnos.setBounds(282, 557, 715, 30);
		diagnosis_det.add(diagnos);
		
		JLabel lblNewLabel_3_1 = new JLabel("Diagnosis Details");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(103, 548, 169, 40);
		diagnosis_det.add(lblNewLabel_3_1);
		
		weight = new JTextField();
		weight.setColumns(10);
		weight.setBounds(282, 336, 118, 31);
		diagnosis_det.add(weight);
		
		JLabel weight = new JLabel("New label");
		weight.setIcon(new ImageIcon("Images"+ "\\allfor.jpg"));
		weight.setBounds(0, -28, 1154, 746);
		diagnosis_det.add(weight);
		
		
	}
}
