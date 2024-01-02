
package O_P_D;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Clinical_patient extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clinical_patient frame = new Clinical_patient();
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
	public Clinical_patient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1097, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("EYE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Eye ey = new Eye();
				ey.setVisible(true);
				ey.setLocationRelativeTo(null);
				dispose();

			}
		});
		btnNewButton.setFont(new Font("Perpetua", Font.BOLD, 30));
		btnNewButton.setBounds(59, 98, 324, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ANTENATAL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Antenatal ant = new Antenatal();
				ant.setVisible(true);
				ant.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Perpetua", Font.BOLD, 30));
		btnNewButton_1.setBounds(59, 209, 324, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DIABETES");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Diabetes dbt = new Diabetes();
				dbt.setVisible(true);
				dbt.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Perpetua", Font.BOLD, 30));
		btnNewButton_2.setBounds(59, 325, 324, 46);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("CLINICAL PATIENT");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("RomanT", Font.BOLD, 35));
		lblNewLabel_1.setBounds(401, 0, 401, 79);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("CARDIOLOGY");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cardiology cdl = new Cardiology();
				cdl.setVisible(true);
				cdl.setLocationRelativeTo(null);
				dispose();

			}
		});
		btnNewButton_3.setFont(new Font("Perpetua", Font.BOLD, 30));
		btnNewButton_3.setBounds(59, 427, 324, 46);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("ORTHOPEDIC");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Orthopedic orp = new Orthopedic();
				orp.setVisible(true);
				orp.setLocationRelativeTo(null);
				dispose();

			}
		});
		btnNewButton_4.setFont(new Font("Perpetua", Font.BOLD, 30));
		btnNewButton_4.setBounds(59, 523, 324, 46);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("ENT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Ent en = new Ent();
				en.setVisible(true);
				en.setLocationRelativeTo(null);
				dispose();

			}
		});
		btnNewButton_5.setFont(new Font("Perpetua", Font.BOLD, 30));
		btnNewButton_5.setBounds(707, 98, 324, 46);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("DERMOTOLOGY");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Dermotology dmt = new Dermotology();
				dmt.setVisible(true);
				dmt.setLocationRelativeTo(null);
				dispose();

			}
		});
		btnNewButton_6.setFont(new Font("Perpetua", Font.BOLD, 30));
		btnNewButton_6.setBounds(707, 209, 324, 46);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("DPM");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Dpm bp = new Dpm();
				bp.setVisible(true);
				bp.setLocationRelativeTo(null);
				dispose();

			}
		});
		btnNewButton_7.setFont(new Font("Perpetua", Font.BOLD, 30));
		btnNewButton_7.setBounds(707, 325, 324, 46);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("SKIN");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Skin sn = new Skin();
				sn.setVisible(true);
				sn.setLocationRelativeTo(null);
				dispose();

			}
		});
		btnNewButton_8.setFont(new Font("Perpetua", Font.BOLD, 30));
		btnNewButton_8.setBounds(707, 427, 324, 46);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("PSYCHOLOGY");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Psycology ps = new Psycology();
				ps.setVisible(true);
				ps.setLocationRelativeTo(null);
				dispose();

			}
		});
		btnNewButton_9.setFont(new Font("Perpetua", Font.BOLD, 30));
		btnNewButton_9.setBounds(707, 523, 324, 46);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Back");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Outdoor ot = new Outdoor();
				ot.setVisible(true);
				ot.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_10.setBounds(518, 538, 85, 21);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Add Patient");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_clinical ac= new Add_clinical();
				ac.setVisible(true);
				ac.setLocationRelativeTo(null);
				dispose();

			}
		});
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_11.setBounds(480, 103, 155, 28);
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Find Patient");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    C_Profile ac= new C_Profile();
				ac.setVisible(true);
				ac.setLocationRelativeTo(null);
				dispose();
				
				
			}
		});
		btnNewButton_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_12.setBounds(480, 160, 155, 28);
		contentPane.add(btnNewButton_12);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Images\\plplplp.jpg"));
		lblNewLabel.setBounds(0, -36, 1105, 719);
		contentPane.add(lblNewLabel);
		
	}
}
