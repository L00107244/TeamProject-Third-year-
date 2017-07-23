package Work_Block1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class WardMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WardMenu frame = new WardMenu();
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
	public WardMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 760, 406);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton AssignButton = new JButton("Assign Ward");
		AssignButton.setForeground(Color.BLACK);
		AssignButton.setBackground(new Color(128, 128, 0));
		AssignButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		AssignButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		new GuiWard().setVisible(true);
                dispose();
			}
		});
		AssignButton.setBounds(90, 282, 204, 23);
		panel.add(AssignButton);
		
		JButton disPatient = new JButton("Discharge a Patient");
		disPatient.setForeground(Color.BLACK);
		disPatient.setFont(new Font("Tahoma", Font.BOLD, 11));
		disPatient.setBackground(new Color(128, 128, 0));
		disPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DischargePatient().setVisible(true);
                dispose();
			}
		});
		disPatient.setBounds(472, 282, 204, 23);
		panel.add(disPatient);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(".\\resources\\images\\wardicon.png"));
		lblNewLabel.setBounds(90, 66, 204, 205);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(".\\resources\\images\\discharge.png"));
		lblNewLabel_1.setBounds(472, 66, 204, 205);
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
	}

}
