package STAFF;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MANAGEMENT.Sqlconnection;
import MANAGEMENT.Welcome_e_Medix;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Internal_Help_Unit extends JFrame {

	private JPanel contentPane;
	private JLabel lblInternalHelpUnit;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable table;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Internal_Help_Unit frame = new Internal_Help_Unit();
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
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	
	public Internal_Help_Unit() {
		
		connection = Sqlconnection.dbConnector();	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1106, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Welcome_e_Medix ed = new Welcome_e_Medix();
				ed.setVisible(true);
				ed.setLocationRelativeTo(null);
				dispose();
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(83, 597, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnNewButton = new JButton("Login");
		btnNewButton.setBounds(839, 597, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Staff_login staff_log = new Staff_login();
				staff_log.setVisible(true);
				staff_log.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblInternalHelpUnit = new JLabel("Internal Help Unit");
		lblInternalHelpUnit.setBounds(368, 40, 347, 40);
		contentPane.add(lblInternalHelpUnit);
		lblInternalHelpUnit.setFont(new Font("Times New Roman", Font.BOLD, 40));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 139, 859, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton_2 = new JButton("View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					String query = "SELECT e_id,name,position,sex,e_mail FROM staff WHERE e_id LIKE 'I%' ";
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
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(453, 598, 85, 21);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel.setBounds(0, 0, 1092, 671);
		contentPane.add(lblNewLabel);
	}

}
