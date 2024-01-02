package O_P_D;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MANAGEMENT.Welcome_e_Medix;

import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Indoor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Indoor frame = new Indoor();
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
	public Indoor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1027, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INDOOR PATIENT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(336, 44, 377, 72);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("MEDICINE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Medicine med = new Medicine();
				med.setVisible(true);
				med.setLocationRelativeTo(null);
				dispose();
	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(54, 176, 230, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SURGERY");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Surgery sg = new Surgery();
				sg.setVisible(true);
				sg.setLocationRelativeTo(null);
				dispose();

			}
		});
		
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(54, 343, 230, 47);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("GYN & OBS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Gyn_obs go = new Gyn_obs();
				go.setVisible(true);
				go.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(54, 504, 230, 47);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PEDIATRIC");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pediatric pd = new Pediatric();
				pd.setVisible(true);
				pd.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.setBounds(725, 176, 230, 47);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("PSYCHIATRIC");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Psychiatric psy = new Psychiatric();
				psy.setVisible(true);
				psy.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_4.setBounds(725, 343, 230, 47);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("CORONA");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Corona co = new Corona();
				co.setVisible(true);
				co.setLocationRelativeTo(null);
				dispose();
	
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_5.setBounds(725, 504, 230, 47);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Welcome_e_Medix welcome = new Welcome_e_Medix();
				welcome.setVisible(true);
				welcome.setLocationRelativeTo(null);
				dispose();
			
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_6.setBounds(426, 581, 138, 40);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("Images\\inddor.jfif"));
		lblNewLabel_1.setBounds(0, -19, 1033, 743);
		contentPane.add(lblNewLabel_1);
	}
}
