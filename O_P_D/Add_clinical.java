package O_P_D;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import MANAGEMENT.Sqlconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

public class Add_clinical extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField address;
	private JTextField room_no;
	private JTextField sex;
	private JTextField weight;
	private JTextField ctype;
	private JTextField e_date;
	private JTextField mobile;
	private JTextField diag;
	private JTextField nc;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_clinical frame = new Add_clinical();
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
	private JTable table;
	
	

	
	public Add_clinical() {
		
		connection = Sqlconnection.dbConnector();		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1111, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLINICAL PATIENT");
		lblNewLabel.setFont(new Font("RomanT", Font.BOLD, 35));
		lblNewLabel.setBounds(383, 10, 434, 77);
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(153, 111, 571, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		age = new JTextField();
		age.setBounds(153, 170, 178, 31);
		contentPane.add(age);
		age.setColumns(10);
		
		address = new JTextField();
		address.setBounds(153, 396, 445, 30);
		contentPane.add(address);
		address.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String query = "INSERT INTO clinical_patient(clinic_type,name,entry_date,sex,age,weight,mobile_no,address,diagnosis_det,room_no,nic) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
									
					PreparedStatement ps = connection.prepareStatement(query);
					
					
					ps.setString(1,ctype.getText());
					ps.setString(2,name.getText());
					ps.setString(3,e_date.getText());
					ps.setString(4,sex.getText());
					ps.setString(5,age.getText());
					ps.setString(6,weight.getText());
					ps.setString(7,mobile.getText());
					ps.setString(8,address.getText());
					ps.setString(9,diag.getText());
					ps.setString(10,room_no.getText());
					ps.setString(11,nc.getText());
				
			
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Added");
					
					ps.close();

				}catch(Exception e1){
					
					e1.printStackTrace();
				}
					
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(904, 619, 85, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(43, 102, 169, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(43, 164, 96, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(43, 383, 75, 48);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(176, 423, 46, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Room No.");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(732, 526, 118, 36);
		contentPane.add(lblNewLabel_5);
		
		room_no = new JTextField();
		room_no.setBounds(892, 530, 120, 36);
		contentPane.add(room_no);
		room_no.setColumns(10);
		
		sex = new JTextField();
		sex.setBounds(470, 170, 128, 31);
		contentPane.add(sex);
		sex.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Sex");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(376, 164, 66, 36);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Weight");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(376, 235, 66, 34);
		contentPane.add(lblNewLabel_7);
		
		weight = new JTextField();
		weight.setBounds(471, 241, 128, 31);
		contentPane.add(weight);
		weight.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Clinical_patient cp = new Clinical_patient();
				cp.setVisible(true);
				cp.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(31, 619, 85, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("Clinic Type");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(732, 392, 102, 31);
		contentPane.add(lblNewLabel_9);
		
		ctype = new JTextField();
		ctype.setBounds(892, 395, 124, 31);
		contentPane.add(ctype);
		ctype.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Entry Date");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(732, 465, 102, 31);
		contentPane.add(lblNewLabel_10);
		
		e_date = new JTextField();
		e_date.setBounds(894, 466, 118, 36);
		contentPane.add(e_date);
		e_date.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Mobile No.");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_11.setBounds(43, 305, 123, 31);
		contentPane.add(lblNewLabel_11);
		
		mobile = new JTextField();
		mobile.setBounds(153, 305, 178, 34);
		contentPane.add(mobile);
		mobile.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Diagnosis Details");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_12.setBounds(43, 441, 154, 54);
		contentPane.add(lblNewLabel_12);
		
		diag = new JTextField();
		diag.setBounds(43, 494, 555, 77);
		contentPane.add(diag);
		diag.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("NIC");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_13.setBounds(43, 238, 72, 29);
		contentPane.add(lblNewLabel_13);
		
		nc = new JTextField();
		nc.setBounds(153, 240, 178, 31);
		contentPane.add(nc);
		nc.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Schedule");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from clinical_schedule";
					
					java.sql.PreparedStatement pts1 = connection.prepareStatement(query);
					java.sql.ResultSet db = pts1.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(db));
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(756, 134, 154, 30);
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(757, 178, 284, 145);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 284, 145);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_14.setBounds(0, 0, 1097, 684);
		contentPane.add(lblNewLabel_14);
	}
}
