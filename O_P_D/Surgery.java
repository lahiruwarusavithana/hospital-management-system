package O_P_D;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MANAGEMENT.Sqlconnection;

import java.sql.Connection;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;

public class Surgery extends JFrame {

	private JPanel contentPane;
	private JTextField av;
	private JTextField np;
	private JTable table;
	
	String beds = "";
	String patients = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Surgery frame = new Surgery();
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
	
	public Surgery() {
		connection = Sqlconnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Patient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				S_admission ad = new S_admission();
				ad.setVisible(true);
				ad.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(447, 577, 179, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Patient");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Surgery_Profile pf = new Surgery_Profile();
				pf.setVisible(true);
				pf.setLocationRelativeTo(null);
				dispose();	
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(827, 577, 174, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("SURGERY");
		lblNewLabel_1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 40));
		lblNewLabel_1.setBounds(401, 22, 233, 103);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("03");
		lblNewLabel_2.setFont(new Font("Perpetua Titling MT", Font.BOLD, 33));
		lblNewLabel_2.setBounds(497, 117, 67, 59);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("Available Beds");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(668, 283, 143, 27);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("No.Of Patients");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setBounds(668, 350, 143, 27);
		contentPane.add(lblNewLabel_7);
		
		av = new JTextField();
		av.setBounds(849, 283, 131, 27);
		contentPane.add(av);
		av.setColumns(10);
		
		np = new JTextField();
		np.setBounds(849, 350, 131, 27);
		contentPane.add(np);
		np.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Indoor in = new Indoor();
				in.setVisible(true);
				in.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(71, 577, 114, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ward Details");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM ward WHERE w_no = 3;";
					java.sql.PreparedStatement pst = connection.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery(); 
					 
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					pst.close();
					}catch(Exception e2){
						JOptionPane.showMessageDialog(null, e2.getMessage());
						
					}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setBounds(240, 264, 138, 53);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Dailly Update");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String updateQuery = "UPDATE ward SET available_beds = '"+av.getText()+"', no_of_patients = '"+np.getText()+"' WHERE w_no = 3;";
					java.sql.PreparedStatement ps = connection.prepareStatement(updateQuery);
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
				
					ps.close();
				
				}catch(Exception e2){
					
					e2.printStackTrace();
				}
			}
			
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_4.setBounds(754, 416, 161, 34);
		contentPane.add(btnNewButton_4);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 357, 493, 73);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Images\\zzzzzzz.jpg"));
		lblNewLabel.setBounds(0, -28, 1090, 723);
		contentPane.add(lblNewLabel);

	}
}
