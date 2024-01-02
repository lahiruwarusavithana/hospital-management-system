package MANAGEMENT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import I_H_U.DPM;
import I_H_U.Dental;
import I_H_U.Add_Dental;
import I_H_U.ECG_EEG;
import I_H_U.Lab_Test_Results;
import I_H_U.Pharmacy_Reciept;
import I_H_U.X_ray;
import O_P_D.Indoor;
import O_P_D.Outdoor;
import STAFF.Clerk;
import STAFF.Directory_Board;
import STAFF.Doctor;
import STAFF.Internal_Help_Unit;
import STAFF.Midwhife;
import STAFF.Nurse;
import STAFF.Overseer;
import STAFF.Staff_login;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSlider;
import javax.swing.ImageIcon;

public class Welcome_e_Medix extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome_e_Medix frame = new Welcome_e_Medix();
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
	public Welcome_e_Medix() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 727);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Accounts");
		btnNewButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent arg0) {
				
				Accounts acc = new Accounts();
				acc.setVisible(true);
				acc.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(582, 115, 153, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Administrative");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Administrative admin = new Administrative();
				admin.setVisible(true);
				admin.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(582, 167, 155, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Outdoor");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Outdoor out = new Outdoor();
				out.setVisible(true);
				out.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setBounds(332, 167, 133, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Pharmacy");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pharmacy_Reciept pr = new Pharmacy_Reciept();
				pr.setVisible(true);
				pr.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_4.setBounds(88, 115, 126, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("ECG / EEG");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ECG_EEG eg = new ECG_EEG();
				eg.setVisible(true);
				eg.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_5.setBounds(87, 170, 126, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("X-Ray");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				X_ray xr = new X_ray();
				xr.setVisible(true);
				xr.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_7.setBounds(88, 223, 126, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("DPM");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DPM dpm = new DPM();
				dpm.setVisible(true);
				dpm.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_8.setBounds(88, 279, 126, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Dental");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Dental den = new Dental();
				den.setVisible(true);
				den.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_9.setBounds(88, 332, 126, 23);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_6 = new JButton("Director");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Directory_Board db = new Directory_Board();
				db.setVisible(true);
				db.setLocationRelativeTo(null);
				dispose();
				
				
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_6.setBounds(864, 112, 126, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_10 = new JButton("Doctor");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Doctor dc = new Doctor();
			dc.setVisible(true);
			dc.setLocationRelativeTo(null);
			dispose();
			}
		});
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_10.setBounds(864, 167, 126, 23);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Nurse");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Nurse nur = new Nurse();
				nur.setVisible(true);
				nur.setLocationRelativeTo(null);
				dispose();
	
				
			}
		});
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_11.setBounds(865, 219, 126, 23);
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Midwife");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Midwhife mid = new Midwhife();
				mid.setVisible(true);
				mid.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_12.setBounds(866, 269, 126, 23);
		contentPane.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Oversser");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Overseer ov = new Overseer();
				ov.setVisible(true);
				ov.setLocationRelativeTo(null);
				dispose();
								
			}
		});
		btnNewButton_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_13.setBounds(866, 319, 126, 23);
		contentPane.add(btnNewButton_13);
		
		JButton btnNewButton_2 = new JButton("Indoor ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Indoor in = new Indoor();
				in.setVisible(true);
				in.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(332, 115, 133, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_14 = new JButton("Internal ");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Internal_Help_Unit ihu = new Internal_Help_Unit();
				ihu.setVisible(true);
				ihu.setLocationRelativeTo(null);
				dispose();
				
				
						
			}
		});
		btnNewButton_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_14.setBounds(864, 371, 129, 23);
		contentPane.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Clark");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Clerk cl = new Clerk();
				cl.setVisible(true);
				cl.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_15.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_15.setBounds(864, 424, 130, 23);
		contentPane.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("Back");
		btnNewButton_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Main_Login ml = new Main_Login();
				ml.setVisible(true);
				ml.setLocationRelativeTo(null);
				dispose();
				
				
			}
		});
		btnNewButton_16.setBounds(472, 613, 120, 28);
		contentPane.add(btnNewButton_16);
		
		JButton btnNewButton_9_1 = new JButton("Lab Tests");
		btnNewButton_9_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Lab_Test_Results cl = new Lab_Test_Results();
				cl.setVisible(true);
				cl.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_9_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_9_1.setBounds(88, 385, 126, 23);
		contentPane.add(btnNewButton_9_1);
		
		JButton btnNewButton_15_1 = new JButton("Profile");
		btnNewButton_15_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Staff_login staff_log = new Staff_login();
				staff_log.setVisible(true);
				staff_log.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_15_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_15_1.setBounds(864, 475, 130, 23);
		contentPane.add(btnNewButton_15_1);
		
		JButton btnNewButton_17 = new JButton("PHI");
		btnNewButton_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_17.setBounds(88, 434, 126, 26);
		contentPane.add(btnNewButton_17);
		
		JLabel lblNewLabel = new JLabel("new label");
		lblNewLabel.setIcon(new ImageIcon("Images\\thamma.jpg"));
		lblNewLabel.setBounds(0, -16, 1070, 743);
		contentPane.add(lblNewLabel);
		
		
	}
}
