package MANAGEMENT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Add_Drug extends JFrame {

	private JPanel contentPane;
	private JTextField Quan;
	private JTextField uPrice;
	private JTextField tot;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField mDate;
	private JTextField eDate;
	private JTextField drugID;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField dName;
	private JTextField bDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Drug frame = new Add_Drug();
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
	private JTextField supplier;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	
	public Add_Drug() {
		
		connection = Sqlconnection.dbConnector();	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1106, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Quan = new JTextField();
		Quan.setBounds(232, 300, 187, 20);
		contentPane.add(Quan);
		Quan.setColumns(10);
		
		uPrice = new JTextField();
		uPrice.setBounds(756, 300, 187, 20);
		contentPane.add(uPrice);
		uPrice.setColumns(10);
		
		tot = new JTextField();
		tot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int one = Integer.parseInt(Quan.getText());
				int two = Integer.parseInt(uPrice.getText());
				int f = one + two ;
				tot.setText(f+ " ");
			}
		});
		tot.setBounds(491, 404, 187, 20);
		contentPane.add(tot);
		tot.setColumns(10);
		
		JButton btnNewButton = new JButton("Total");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int one = Integer.parseInt(Quan.getText());
				int two = Integer.parseInt(uPrice.getText());
				int f = one * two ;
				tot.setText(f+ " ");
				
			}
		});
		btnNewButton.setBounds(324, 399, 106, 25);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Add Drug Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(411, 10, 267, 40);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Drug ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(86, 84, 106, 40);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Unit Price");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(534, 297, 144, 20);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(92, 288, 100, 35);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Manufacture Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(534, 146, 200, 23);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Expire Date");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(534, 196, 151, 23);
		contentPane.add(lblNewLabel_5);
		
		mDate = new JTextField();
		mDate.setBounds(759, 150, 184, 20);
		contentPane.add(mDate);
		mDate.setColumns(10);
		
		eDate = new JTextField();
		eDate.setBounds(759, 200, 184, 20);
		contentPane.add(eDate);
		eDate.setColumns(10);
		
		drugID = new JTextField();
		drugID.setBounds(232, 99, 187, 20);
		contentPane.add(drugID);
		drugID.setColumns(10);
		
		btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
	try {
					
					String query = "INSERT INTO drug(drug_id,drug_name,Supplier,buy_date,manu_date,exp_date,amount,unit_price,total) VALUES (?,?,?,?,?,?,?,?,?)";
									
					PreparedStatement ps = connection.prepareStatement(query);
					
					
					ps.setString(1,drugID.getText());
					ps.setString(2,dName.getText());
					ps.setString(3,supplier.getText());
					ps.setString(4,bDate.getText());
					ps.setString(5,mDate.getText());
					ps.setString(6,eDate.getText());
					ps.setString(7,Quan.getText());
					ps.setString(8,uPrice.getText());
					ps.setString(9,tot.getText());
			
					
					ps.execute();
					
					JOptionPane.showMessageDialog(null, "Data added");
					
					ps.close();

				}catch(Exception e1){
					
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(821, 510, 122, 35);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Drug drug = new Drug();
				drug.setVisible(true);
				drug.setLocationRelativeTo(null);
				dispose();
				
				
			}
		});
		btnNewButton_2.setBounds(86, 510, 122, 35);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_6 = new JLabel("Drug Name");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(86, 140, 122, 35);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Buy Date");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(534, 95, 158, 23);
		contentPane.add(lblNewLabel_7);
		
		dName = new JTextField();
		dName.setBounds(232, 150, 184, 19);
		contentPane.add(dName);
		dName.setColumns(10);
		
		bDate = new JTextField();
		bDate.setBounds(759, 99, 184, 19);
		contentPane.add(bDate);
		bDate.setColumns(10);
		
		supplier = new JTextField();
		supplier.setBounds(232, 200, 187, 19);
		contentPane.add(supplier);
		supplier.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Supplier");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(86, 197, 106, 23);
		contentPane.add(lblNewLabel_8);
		
		
		JLabel lblNewLabel_10 = new JLabel("YYYY-MM-DD");
		lblNewLabel_10.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(760, 115, 112, 25);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("YYYY-MM-DD");
		lblNewLabel_11.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(760, 165, 112, 25);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("YYYY-MM-DD");
		lblNewLabel_12.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(760, 219, 112, 25);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_13.setBounds(0, 0, 1132, 663);
		contentPane.add(lblNewLabel_13);
		
		
	}
}
