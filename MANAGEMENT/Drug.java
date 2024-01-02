package MANAGEMENT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class Drug extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drug frame = new Drug();
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
	
	public Drug() {
		
		connection = Sqlconnection.dbConnector();	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1112, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Drugs Stocks");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(444, 24, 227, 33);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 156, 924, 356);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Add Drug");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Add_Drug add = new Add_Drug();
				add.setVisible(true);
				add.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBounds(366, 541, 115, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Drug");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				   try {
						
						String query = "DELETE FROM drug where drug_id = '" + delete.getText() + " ' ";
						
						java.sql.PreparedStatement pst = connection.prepareStatement(query);
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null,"" + delete.getText() +" "+ "Deleted");
						
						query = "SELECT * FROM drug" ;
						java.sql.PreparedStatement pst1 = connection.prepareStatement(query);
						
						ResultSet rs = pst1.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						rs.close();
						pst.close();
						pst1.close();
						
					}catch(Exception e1){
						
						JOptionPane.showMessageDialog(null, e1.getMessage());

					}
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(868, 541, 140, 23);
		contentPane.add(btnNewButton_1);
		
		delete = new JTextField();
		delete.setBounds(682, 545, 134, 20);
		contentPane.add(delete);
		delete.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Administrative admin = new Administrative();
				admin.setVisible(true);
				admin.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(84, 541, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select * from drug";
					
					java.sql.PreparedStatement pts1 = connection.prepareStatement(query);
					java.sql.ResultSet db = pts1.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(db));
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(490, 105, 103, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1104, 681);
		contentPane.add(lblNewLabel_1);
	}
}
