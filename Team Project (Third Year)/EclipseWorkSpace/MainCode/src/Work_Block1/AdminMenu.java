/**
 * Author: Anthony Appiah
 * Date: 22-04-2106
 * Administrator menu 
 */
package Work_Block1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class AdminMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
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

		JButton ManagePatient = new JButton("Manage Patients");
		ManagePatient.setFont(new Font("Tahoma", Font.BOLD, 11));
		ManagePatient.setBackground(new Color(128, 128, 0));
		ManagePatient.setForeground(new Color(0, 0, 0));
		ManagePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PatientMenu ().setVisible(true);
				dispose();

			}
		});
		ManagePatient.setBounds(10, 268, 200, 23);
		panel.add(ManagePatient);

		//Button for different menus
		JButton ManageStaff = new JButton("Manage Staff");
		ManageStaff.setFont(new Font("Tahoma", Font.BOLD, 11));
		ManageStaff.setBackground(new Color(128, 128, 0));
		ManageStaff.setForeground(new Color(0, 0, 0));
		ManageStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StaffMenu().setVisible(true);
				dispose();
			}
		});
		ManageStaff.setBounds(271, 268, 210, 23);
		panel.add(ManageStaff);

		JButton WardButton = new JButton("Ward ");
		WardButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		WardButton.setBackground(new Color(128, 128, 0));
		WardButton.setForeground(new Color(0, 0, 0));
		WardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new WardMenu().setVisible(true);
				dispose();
			}
		});
		WardButton.setBounds(526, 268, 210, 23);
		panel.add(WardButton);

		//Adding images to the gui and positioning them 
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\resources\\images\\patientPic.jpg"));
		lblNewLabel.setBounds(10, 58, 200, 199);
		panel.add(lblNewLabel);

		//Adding images to the gui and positioning them 
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(".\\resources\\images\\stafficon.png"));
		lblNewLabel_1.setBounds(271, 58, 200, 199);
		panel.add(lblNewLabel_1);

		//Adding images to the gui and positioning them 
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\resources\\images\\wards.jpg.png"));
		lblNewLabel_2.setBounds(526, 58, 210, 199);
		panel.add(lblNewLabel_2);

		JButton LogoutButton = new JButton("Logout");
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Staff.isConnected=false;
				new LoginToSystem().setVisible(true);
				dispose();
			}
		});
		LogoutButton.setForeground(new Color(0, 0, 0));
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
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Anthony\\Desktop\\images\\lyit.jpg"));
		lblNewLabel_4.setBounds(180, 357, 444, 33);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Welcome to the Administrator Menu");
		lblNewLabel_5.setForeground(new Color(128, 128, 0));
		lblNewLabel_5.setFont(new Font("Lucida Bright", Font.BOLD, 18));
		lblNewLabel_5.setBounds(164, 11, 400, 36);
		panel.add(lblNewLabel_5);
	}
}
