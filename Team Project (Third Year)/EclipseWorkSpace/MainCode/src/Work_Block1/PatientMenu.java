/**
 * Author: Anthony Appiah
 * Date: 22-04-2106
 * Patient Option menu 
 */
package Work_Block1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PatientMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientMenu frame = new PatientMenu();
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
	public PatientMenu() {
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

		//Button for different menus
		JButton AdmitButton = new JButton("Admit Patient");
		AdmitButton.setBackground(new Color(128, 128, 0));
		AdmitButton.setForeground(new Color(0, 0, 0));
		AdmitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		AdmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdmitPatient().setVisible(true);
				dispose();
			}
		});
		AdmitButton.setBounds(10, 282, 204, 23);
		panel.add(AdmitButton);

		//Button for different menus
		JButton ViewPatient = new JButton("View a Patient");
		ViewPatient.setBackground(new Color(128, 128, 0));
		ViewPatient.setForeground(new Color(0, 0, 0));
		ViewPatient.setFont(new Font("Tahoma", Font.BOLD, 11));
		ViewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Search4Patient().setVisible(true);
				dispose();
			}
		});
		ViewPatient.setBounds(276, 282, 204, 23);
		panel.add(ViewPatient);

		//Adding images to the gui and positioning them 
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(".\\resources\\images\\patient2.png"));
		lblNewLabel.setBounds(10, 66, 204, 205);
		panel.add(lblNewLabel);

		//Adding images to the gui and positioning them 
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(".\\resources\\images\\user_search.png"));
		lblNewLabel_1.setBounds(276, 66, 204, 205);
		panel.add(lblNewLabel_1);

		JButton BackButton = new JButton("Back");
		BackButton.setForeground(Color.BLACK);
		BackButton.setBackground(new Color(128, 128, 0));
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminMenu().setVisible(true);
				dispose();
			}
		});
		BackButton.setBounds(517, 372, 89, 23);
		panel.add(BackButton);

		JButton logoutButton = new JButton("Log Out");
		logoutButton.setForeground(Color.BLACK);
		logoutButton.setBackground(new Color(128, 128, 0));
		logoutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff.isConnected=false;
				new LoginToSystem().setVisible(true);
				dispose();
			}
		});
		logoutButton.setBounds(616, 372, 89, 23);
		panel.add(logoutButton);

		JButton ExistButton = new JButton("Admit Existing Patient");
		ExistButton.setForeground(Color.BLACK);
		ExistButton.setBackground(new Color(128, 128, 0));
		ExistButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		ExistButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddExisting().setVisible(true);
				dispose();

			}
		});
		ExistButton.setBounds(527, 282, 223, 23);
		panel.add(ExistButton);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(".\\resources\\images\\exitPatients.jpg"));
		lblNewLabel_2.setBounds(517, 66, 233, 205);
		panel.add(lblNewLabel_2);
	}

}
