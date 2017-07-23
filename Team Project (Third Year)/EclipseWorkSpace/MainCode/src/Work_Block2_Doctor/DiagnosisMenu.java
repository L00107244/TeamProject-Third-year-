/**
 * Author: Anthony Appiah
 * Date: 22-04-2106
 * Diagnosis menu 
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

public class DiagnosisMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiagnosisMenu frame = new DiagnosisMenu();
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
	public DiagnosisMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 760, 611);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton ManagePatient = new JButton("Add Diagnosis");
		ManagePatient.setFont(new Font("Tahoma", Font.BOLD, 11));
		ManagePatient.setBackground(new Color(128, 128, 0));
		ManagePatient.setForeground(Color.BLACK);
		ManagePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddDiagnosis ().setVisible(true);
				dispose();

			}
		});
		ManagePatient.setBounds(10, 268, 146, 23);
		panel.add(ManagePatient);

		JButton ManageStaff = new JButton("View Diagnosis");
		ManageStaff.setFont(new Font("Tahoma", Font.BOLD, 11));
		ManageStaff.setBackground(new Color(128, 128, 0));
		ManageStaff.setForeground(Color.BLACK);
		ManageStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewDiagnosis().setVisible(true);
				dispose();
			}
		});
		ManageStaff.setBounds(205, 268, 146, 23);
		panel.add(ManageStaff);

		JButton WardButton = new JButton("Update Diagnosis");
		WardButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		WardButton.setBackground(new Color(128, 128, 0));
		WardButton.setForeground(Color.BLACK);
		WardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new UpdateDiagnosis().setVisible(true);
				dispose();
			}
		});
		WardButton.setBounds(404, 268, 146, 23);
		panel.add(WardButton);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\resources\\images\\diag2.png"));
		lblNewLabel.setBounds(10, 90, 121, 131);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(".\\resources\\images\\diag1.png"));
		lblNewLabel_1.setBounds(205, 90, 121, 131);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\resources\\images\\diaup.png"));
		lblNewLabel_2.setBounds(404, 90, 121, 131);
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
		LogoutButton.setBounds(637, 577, 89, 23);
		panel.add(LogoutButton);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(".\\resources\\images\\test1.png"));
		lblNewLabel_6.setBounds(10, 348, 121, 131);
		panel.add(lblNewLabel_6);

		JButton btnNewButton = new JButton("Add a Test");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddTest ().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 527, 146, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DoctorMenu ().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(537, 577, 89, 23);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(".\\resources\\images\\view2.png"));
		lblNewLabel_3.setBounds(205, 348, 121, 131);
		panel.add(lblNewLabel_3);

		JButton btnNewButton_2 = new JButton("View a Test");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ViewTest ().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(205, 527, 146, 23);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Update a Test");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateTest ().setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBackground(new Color(128, 128, 0));
		btnNewButton_3.setBounds(404, 527, 146, 23);
		panel.add(btnNewButton_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(".\\resources\\diaup.png"));
		lblNewLabel_4.setBounds(404, 348, 121, 131);
		panel.add(lblNewLabel_4);
	}
}
