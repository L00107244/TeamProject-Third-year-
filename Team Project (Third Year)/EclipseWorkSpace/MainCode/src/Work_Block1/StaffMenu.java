/**
 * Author: Anthony Appiah, Shaun Boyle
 * Date: 22-04-2106
 * Staff Menu
 */
package Work_Block1;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StaffMenu extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffMenu frame = new StaffMenu();
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
	public StaffMenu() {
		setFont(new Font("Lucida Bright", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 759, 406);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//images for the menu
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\resources\\images\\doc.png"));
		lblNewLabel.setBounds(30, 64, 161, 141);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(".\\resources\\images\\staf2.jpg"));
		lblNewLabel_1.setBounds(270, 64, 161, 141);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\resources\\images\\deletest.jpg"));
		lblNewLabel_2.setBounds(527, 64, 161, 141);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add New Staff");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addStaff2().setVisible(true);
                dispose();
				
			}
		});
		btnNewButton.setBounds(30, 263, 161, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View All Staff");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewAllStaff().setVisible(true);
                dispose();
			}
		});
		btnNewButton_1.setBounds(270, 263, 161, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete a Staff Member");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteStaff().setVisible(true);
                dispose();
			}
		});
		btnNewButton_2.setBounds(527, 263, 161, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBackground(new Color(128, 128, 0));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminMenu().setVisible(true);
		        dispose();
			}
		});
		btnNewButton_3.setBounds(527, 372, 89, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.setBackground(new Color(128, 128, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff.isConnected=false;
				new LoginToSystem().setVisible(true);
		        dispose();
			}
		});
		btnNewButton_4.setBounds(626, 372, 89, 23);
		panel.add(btnNewButton_4);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome to Staff Menu");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 11, 150, 23);
		panel.add(lblNewLabel_3);
	}
}
