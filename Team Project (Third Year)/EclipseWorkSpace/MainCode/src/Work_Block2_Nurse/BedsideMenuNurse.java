package Work_Block2_Nurse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Work_Block1.LoginToSystem;
import Work_Block1.Staff;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class BedsideMenuNurse extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BedsideMenuNurse frame = new BedsideMenuNurse();
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
	public BedsideMenuNurse() {
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

		JButton AdmitButton = new JButton("Add Bedside Notes");
		AdmitButton.setBackground(new Color(128, 128, 0));
		AdmitButton.setForeground(Color.BLACK);
		AdmitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		AdmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddNoteNurse().setVisible(true);
				dispose();
			}
		});
		AdmitButton.setBounds(10, 282, 204, 23);
		panel.add(AdmitButton);

		JButton ViewPatient = new JButton("View Bedside Notes");
		ViewPatient.setBackground(new Color(128, 128, 0));
		ViewPatient.setForeground(Color.BLACK);
		ViewPatient.setFont(new Font("Tahoma", Font.BOLD, 11));
		ViewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewNotesNurse().setVisible(true);
				dispose();
			}
		});
		ViewPatient.setBounds(276, 282, 204, 23);
		panel.add(ViewPatient);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\resources\\images\\addbed.png"));
		lblNewLabel.setBounds(10, 66, 204, 205);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(".\\resources\\images\\view.png"));
		lblNewLabel_1.setBounds(276, 66, 204, 205);
		panel.add(lblNewLabel_1);

		JButton BackButton = new JButton("Back");
		BackButton.setForeground(Color.BLACK);
		BackButton.setBackground(new Color(128, 128, 0));
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NurseMenu().setVisible(true);
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

		JButton ExistButton = new JButton("Update Notes");
		ExistButton.setForeground(Color.BLACK);
		ExistButton.setBackground(new Color(128, 128, 0));
		ExistButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		ExistButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateNoteNurse().setVisible(true);
				dispose();

			}
		});
		ExistButton.setBounds(527, 282, 223, 23);
		panel.add(ExistButton);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\resources\\images\\update.png"));
		lblNewLabel_2.setBounds(517, 66, 233, 205);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Bedside Note Menu");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 11, 176, 23);
		panel.add(lblNewLabel_3);
	}
}
