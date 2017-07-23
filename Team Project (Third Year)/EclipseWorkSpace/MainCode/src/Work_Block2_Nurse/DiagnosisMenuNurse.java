package Work_Block2_Nurse;

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

public class DiagnosisMenuNurse extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiagnosisMenuNurse frame = new DiagnosisMenuNurse();
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
	public DiagnosisMenuNurse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 760, 611);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton ManageStaff = new JButton("View Diagnosis");
		ManageStaff.setFont(new Font("Tahoma", Font.BOLD, 11));
		ManageStaff.setBackground(new Color(128, 128, 0));
		ManageStaff.setForeground(Color.BLACK);
		ManageStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewDiagnosisNurse().setVisible(true);
				dispose();
			}
		});
		ManageStaff.setBounds(139, 226, 146, 23);
		panel.add(ManageStaff);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(".\\resources\\images\\diag1.png"));
		lblNewLabel_1.setBounds(139, 84, 121, 131);
		panel.add(lblNewLabel_1);

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
		LogoutButton.setBounds(635, 374, 89, 23);
		panel.add(LogoutButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NurseMenu ().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(515, 374, 89, 23);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(".\\resources\\images\\view2.png"));
		lblNewLabel_3.setBounds(461, 84, 121, 131);
		panel.add(lblNewLabel_3);

		JButton btnNewButton_2 = new JButton("View a Test");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ViewTestNurse ().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(436, 226, 146, 23);
		panel.add(btnNewButton_2);
	}
}
