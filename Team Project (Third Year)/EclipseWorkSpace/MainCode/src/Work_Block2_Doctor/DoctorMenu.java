/**
 * Author: Anthony Appiah
 * Date: 22-04-2106
 * Doctor menu 
 */
package Work_Block2_Doctor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Work_Block1.LoginToSystem;
import Work_Block1.PatientMenu;
import Work_Block1.Staff;
import Work_Block1.StaffMenu;
import Work_Block1.WardMenu;

public class DoctorMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorMenu frame = new DoctorMenu();
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
	public DoctorMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 760, 406);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton ManagePatient = new JButton("Patients");
		ManagePatient.setFont(new Font("Tahoma", Font.BOLD, 11));
		ManagePatient.setBackground(new Color(128, 128, 0));
		ManagePatient.setForeground(Color.BLACK);
		ManagePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewPatient ().setVisible(true);
				dispose();

			}
		});
		ManagePatient.setBounds(10, 268, 121, 23);
		panel.add(ManagePatient);

		JButton ManageStaff = new JButton("Notes");
		ManageStaff.setFont(new Font("Tahoma", Font.BOLD, 11));
		ManageStaff.setBackground(new Color(128, 128, 0));
		ManageStaff.setForeground(Color.BLACK);
		ManageStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BedsideMenu().setVisible(true);
				dispose();
			}
		});
		ManageStaff.setBounds(205, 268, 121, 23);
		panel.add(ManageStaff);

		JButton WardButton = new JButton("Diagnosis");
		WardButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		WardButton.setBackground(new Color(128, 128, 0));
		WardButton.setForeground(Color.BLACK);
		WardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DiagnosisMenu().setVisible(true);
				dispose();
			}
		});
		WardButton.setBounds(397, 268, 121, 23);
		panel.add(WardButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\resources\\images\\pat.png"));
		lblNewLabel.setBounds(10, 90, 121, 131);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(".\\resources\\images\\diag.png"));
		lblNewLabel_1.setBounds(205, 90, 121, 131);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\resources\\images\\bedside.png"));
		lblNewLabel_2.setBounds(397, 90, 121, 131);
		panel.add(lblNewLabel_2);

		JButton LogoutButton = new JButton("Logout");
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Staff.isConnected=false;
				new LoginToSystem().setVisible(true);
				dispose();
			}
		});
		LogoutButton.setForeground(Color.BLACK);
		LogoutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		LogoutButton.setBackground(new Color(128, 128, 0));
		LogoutButton.setBounds(634, 372, 89, 23);
		panel.add(LogoutButton);

		JLabel lblNewLabel_3 = new JLabel("Logged in As ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 372, 100, 18);
		panel.add(lblNewLabel_3);

		try{
			JLabel userButton = new JLabel(LoginToSystem.UserField.getText());
		userButton.setForeground(new Color(128, 128, 0));
		userButton.setBounds(99, 372, 71, 18);
		panel.add(userButton);

		}
		catch (Exception e)
		{
			
		}
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(".\\resources\\images\\lyit.jpg"));
		lblNewLabel_4.setBounds(180, 357, 444, 33);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Welcome to the Doctor Menu");
		lblNewLabel_5.setForeground(new Color(128, 128, 0));
		lblNewLabel_5.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblNewLabel_5.setBounds(164, 11, 400, 36);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(".\\resources\\images\\treat.png"));
		lblNewLabel_6.setBounds(585, 90, 121, 131);
		panel.add(lblNewLabel_6);

		JButton btnNewButton = new JButton("Treatment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TreatMenu().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(585, 268, 121, 23);
		panel.add(btnNewButton);
	}
}
