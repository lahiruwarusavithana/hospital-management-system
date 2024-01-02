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

public class Add_Equip extends JFrame {

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
					Add_Equip frame = new Add_Equip();
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
	
	public Add_Equip() {
		
		connection = Sqlconnection.dbConnector();	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1121, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Quan = new JTextField();
		Quan.setBounds(276, 280, 187, 20);
		contentPane.add(Quan);
		Quan.setColumns(10);
		
		uPrice = new JTextField();
		uPrice.setBounds(779, 280, 187, 20);
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
		tot.setBounds(496, 412, 187, 20);
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
		btnNewButton.setBounds(329, 407, 106, 25);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Add Equipment Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(369, 27, 369, 54);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Equipment ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(86, 124, 159, 25);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Unit Price");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(567, 280, 131, 20);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(86, 280, 100, 25);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Manufacture Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(567, 175, 187, 23);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Expire Date");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(567, 225, 138, 23);
		contentPane.add(lblNewLabel_5);
		
		mDate = new JTextField();
		mDate.setBounds(779, 179, 184, 20);
		contentPane.add(mDate);
		mDate.setColumns(10);
		
		eDate = new JTextField();
		eDate.setBounds(779, 229, 184, 20);
		contentPane.add(eDate);
		eDate.setColumns(10);
		
		drugID = new JTextField();
		drugID.setBounds(276, 124, 187, 20);
		contentPane.add(drugID);
		drugID.setColumns(10);
		
		btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
	try {
					
					String query = "INSERT INTO equipment(equip_id,name,supplier,buy_date,manu_date,exp_date,amount,unit_price,total) VALUES (?,?,?,?,?,?,?,?,?)";
									
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
					
					JOptionPane.showMessageDialog(null, "Data Updated");
					
					ps.close();

				}catch(Exception e1){
					
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(847, 503, 122, 40);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Equipment drug = new Equipment();
				drug.setVisible(true);
				drug.setLocationRelativeTo(null);
				dispose();
				
				
			}
		});
		btnNewButton_2.setBounds(86, 503, 122, 40);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_6 = new JLabel("Equipment Name");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(86, 173, 159, 25);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Buy Date");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(567, 124, 145, 23);
		contentPane.add(lblNewLabel_7);
		
		dName = new JTextField();
		dName.setBounds(279, 175, 184, 19);
		contentPane.add(dName);
		dName.setColumns(10);
		
		bDate = new JTextField();
		bDate.setBounds(779, 128, 184, 19);
		contentPane.add(bDate);
		bDate.setColumns(10);
		
		supplier = new JTextField();
		supplier.setBounds(276, 225, 187, 19);
		contentPane.add(supplier);
		supplier.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Supplier");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(86, 223, 106, 22);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_9.setBounds(0, 0, 1107, 665);
		contentPane.add(lblNewLabel_9);
	}

}
