package I_H_U;

import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MANAGEMENT.Sqlconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Pharmacy_Stock extends JFrame {

	private JPanel contentPane;
	private JTextField drugID;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pharmacy_Stock frame = new Pharmacy_Stock();
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
	private JTextField ab;
	private JTextField q;
	
	public Pharmacy_Stock() {
		
		connection = Sqlconnection.dbConnector();	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pharmacy Stock");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(406, 40, 310, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Drug ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(176, 163, 78, 31);
		contentPane.add(lblNewLabel_1);
		
		drugID = new JTextField();
		drugID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		drugID.setBounds(279, 169, 265, 25);
		contentPane.add(drugID);
		drugID.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 312, 777, 74);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					
					
					String query = "SELECT * FROM pharmacy WHERE drug_id = '"+drugID.getText()+"'  ";
					
					PreparedStatement pst = connection.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery(); 
					 
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					pst.close();
					}catch(Exception e2){
						JOptionPane.showMessageDialog(null, e2.getMessage());
						
					}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(682, 164, 104, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pharmacy_Reciept prs1 = new Pharmacy_Reciept();
				prs1.setVisible(true);
				prs1.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(125, 544, 104, 31);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
		
					String query = "UPDATE pharmacy SET availability = '"+ab.getText()+"' ,amount = '"+q.getText()+"' WHERE drug_id = '"+drugID.getText()+"' ;" ;
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated");
				
					ps.close();
				
				}catch(Exception e1){
					
					e1.printStackTrace();
				}
			}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(769, 544, 133, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Availability");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(631, 437, 85, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(631, 479, 78, 31);
		contentPane.add(lblNewLabel_3);
		
		ab = new JTextField();
		ab.setBounds(758, 444, 144, 19);
		contentPane.add(ab);
		ab.setColumns(10);
		
		q = new JTextField();
		q.setBounds(758, 488, 144, 19);
		contentPane.add(q);
		q.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_4.setBounds(0, 0, 1100, 673);
		contentPane.add(lblNewLabel_4);
	}

}
