package MANAGEMENT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Equipment extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Equipment frame = new Equipment();
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
	private JTextField equip_id;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	public Equipment() {
			
			connection = Sqlconnection.dbConnector();	
			
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1116, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Equipments");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(447, 22, 188, 39);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 152, 919, 331);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Add Equipment");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Equip eq = new Add_Equip();
				eq.setVisible(true);
				eq.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setBounds(291, 554, 181, 29);
		contentPane.add(btnNewButton);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
		
				   try {
						
						String query = "DELETE FROM equipment where equip_id = '" + equip_id.getText() + " ' ";
						
						java.sql.PreparedStatement pst = connection.prepareStatement(query);
						
						pst.execute();
						
						JOptionPane.showMessageDialog(null,"" + equip_id.getText() +" "+ "Deleted");
						
						query = "SELECT * FROM equipment" ;
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
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(895, 554, 105, 26);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("View ");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					String query = "select * from equipment";
					
					java.sql.PreparedStatement pts1 = connection.prepareStatement(query);
					java.sql.ResultSet db = pts1.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(db));
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				

				
			}
		});
		btnNewButton_3.setBounds(467, 94, 140, 23);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Back");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Administrative admin = new Administrative();
				admin.setVisible(true);
				admin.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_4.setBounds(81, 555, 105, 26);
		contentPane.add(btnNewButton_4);
		
		equip_id = new JTextField();
		equip_id.setBounds(758, 557, 105, 26);
		contentPane.add(equip_id);
		equip_id.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Equipment ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(612, 555, 151, 23);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1102, 688);
		contentPane.add(lblNewLabel_2);
	}

}
