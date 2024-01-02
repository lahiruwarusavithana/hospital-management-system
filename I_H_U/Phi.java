package I_H_U;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MANAGEMENT.Sqlconnection;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

public class Phi extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phi frame = new Phi();
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
	private JTextField textField_3;
	private JTextField textField_4;
	
	public Phi() {
		connection = Sqlconnection.dbConnector();	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PHI");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(469, 10, 112, 69);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(79, 651, 130, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("PHI ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(111, 170, 85, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PHI Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(111, 123, 112, 21);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(282, 126, 370, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(282, 173, 370, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Division");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(111, 217, 85, 21);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(282, 220, 370, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Cheked Details");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(87, 285, 214, 29);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Area 1");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(87, 390, 99, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_8 = new JLabel("Checked");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_8.setBounds(258, 334, 91, 33);
		contentPane.add(lblNewLabel_8);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(222, 388, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(321, 386, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Yes");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_2.setBounds(426, 386, 103, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("No");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_3.setBounds(526, 388, 103, 21);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_8_1 = new JLabel("Doubt");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_8_1.setBounds(469, 334, 99, 33);
		contentPane.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Area 2");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_1.setBounds(87, 448, 99, 21);
		contentPane.add(lblNewLabel_5_1);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Yes");
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_4.setBounds(222, 446, 103, 21);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_1_1.setBounds(321, 444, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("Yes");
		rdbtnNewRadioButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_2_1.setBounds(426, 444, 103, 21);
		contentPane.add(rdbtnNewRadioButton_2_1);
		
		JRadioButton rdbtnNewRadioButton_3_1 = new JRadioButton("No");
		rdbtnNewRadioButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_3_1.setBounds(526, 446, 103, 21);
		contentPane.add(rdbtnNewRadioButton_3_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Area 3");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_1_1.setBounds(87, 504, 99, 21);
		contentPane.add(lblNewLabel_5_1_1);
		
		JRadioButton rdbtnNewRadioButton_4_1 = new JRadioButton("Yes");
		rdbtnNewRadioButton_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_4_1.setBounds(222, 502, 103, 21);
		contentPane.add(rdbtnNewRadioButton_4_1);
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_1_1_1.setBounds(321, 500, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_1_1 = new JRadioButton("Yes");
		rdbtnNewRadioButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_2_1_1.setBounds(426, 500, 103, 21);
		contentPane.add(rdbtnNewRadioButton_2_1_1);
		
		JRadioButton rdbtnNewRadioButton_3_1_1 = new JRadioButton("No");
		rdbtnNewRadioButton_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_3_1_1.setBounds(526, 502, 103, 21);
		contentPane.add(rdbtnNewRadioButton_3_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Area 4");
		lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_1_1_1.setBounds(87, 556, 99, 21);
		contentPane.add(lblNewLabel_5_1_1_1);
		
		JRadioButton rdbtnNewRadioButton_4_1_1 = new JRadioButton("Yes");
		rdbtnNewRadioButton_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_4_1_1.setBounds(222, 554, 103, 21);
		contentPane.add(rdbtnNewRadioButton_4_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_1_1_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_1_1_1_1.setBounds(321, 552, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1_1_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_1_1_1 = new JRadioButton("Yes");
		rdbtnNewRadioButton_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_2_1_1_1.setBounds(426, 552, 103, 21);
		contentPane.add(rdbtnNewRadioButton_2_1_1_1);
		
		JRadioButton rdbtnNewRadioButton_3_1_1_1 = new JRadioButton("No");
		rdbtnNewRadioButton_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_3_1_1_1.setBounds(526, 554, 103, 21);
		contentPane.add(rdbtnNewRadioButton_3_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1_1 = new JLabel("Area 5");
		lblNewLabel_5_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_1_1_1_1.setBounds(87, 608, 99, 21);
		contentPane.add(lblNewLabel_5_1_1_1_1);
		
		JRadioButton rdbtnNewRadioButton_4_1_1_1 = new JRadioButton("Yes");
		rdbtnNewRadioButton_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_4_1_1_1.setBounds(222, 606, 103, 21);
		contentPane.add(rdbtnNewRadioButton_4_1_1_1);
		
		JRadioButton rdbtnNewRadioButton_1_1_1_1_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_1_1_1_1_1.setBounds(321, 604, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1_1_1_1_1);
		
		JRadioButton rdbtnNewRadioButton_2_1_1_1_1 = new JRadioButton("Yes");
		rdbtnNewRadioButton_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_2_1_1_1_1.setBounds(426, 604, 103, 21);
		contentPane.add(rdbtnNewRadioButton_2_1_1_1_1);
		
		JRadioButton rdbtnNewRadioButton_3_1_1_1_1 = new JRadioButton("No");
		rdbtnNewRadioButton_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnNewRadioButton_3_1_1_1_1.setBounds(526, 606, 103, 21);
		contentPane.add(rdbtnNewRadioButton_3_1_1_1_1);
		
		JLabel lblNewLabel_6 = new JLabel("Year");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(785, 152, 73, 39);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Month");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(925, 152, 99, 39);
		contentPane.add(lblNewLabel_7);
		
		textField_3 = new JTextField();
		textField_3.setBounds(764, 203, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(908, 203, 96, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("----- OPD, Clinics, Labs,Vehicle park");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(669, 389, 309, 21);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblMedicineWdGynobs = new JLabel("----- Medicine wd, Gyn&obs wd");
		lblMedicineWdGynobs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMedicineWdGynobs.setBounds(669, 448, 309, 21);
		contentPane.add(lblMedicineWdGynobs);
		
		JLabel lblHeadOfficePediatric = new JLabel("----- Head office, Pediatric wd, Store");
		lblHeadOfficePediatric.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHeadOfficePediatric.setBounds(669, 504, 309, 21);
		contentPane.add(lblHeadOfficePediatric);
		
		JLabel lblSurgeryWd = new JLabel("----- Surgery wd,Psycatric wd, Ambulance");
		lblSurgeryWd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSurgeryWd.setBounds(669, 556, 399, 21);
		contentPane.add(lblSurgeryWd);
		
		JLabel lblCoronaWd = new JLabel("----- Corona wd");
		lblCoronaWd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCoronaWd.setBounds(669, 608, 309, 21);
		contentPane.add(lblCoronaWd);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("Images\\allfor.jpg"));
		lblNewLabel_9.setBounds(0, -18, 1089, 734);
		contentPane.add(lblNewLabel_9);
	}
}
