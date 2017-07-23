/**
 * Author: Anthony Appiah, Shaun Boyle
 * Date: 22-04-2106
 * Add staff Menu
 */
package Work_Block1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class addStaff2 extends JFrame {

	//variables for adding staff
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		int menu_option;
		Scanner keyIn = new Scanner(System.in);
		Patient patient = new Patient();
		Ward ward = new Ward();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addStaff2 frame = new addStaff2();
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
	public addStaff2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 0, 760, 395);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setBounds(38, 32, 92, 35);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Gender");
		lblNewLabel_1.setBounds(38, 78, 92, 35);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setBounds(38, 124, 92, 35);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setBounds(38, 170, 92, 35);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(38, 216, 92, 35);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Phone Number");
		lblNewLabel_5.setBounds(38, 262, 92, 35);
		panel.add(lblNewLabel_5);

		textField_2 = new JTextField();
		textField_2.setBounds(188, 131, 184, 25);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(188, 177, 184, 25);
		panel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(188, 216, 184, 40);
		panel.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(188, 267, 184, 25);
		panel.add(textField_5);
		textField_5.setColumns(10);

		//combo box to hold different options
		String[] TitleStrings = {"Mr", "Dr", "Mrs", "Miss"};
		JComboBox comboBox = new JComboBox(TitleStrings);
		comboBox.setBounds(188, 39, 184, 25);
		panel.add(comboBox);

		JLabel lblNewLabel_6 = new JLabel("Speciality");
		lblNewLabel_6.setBounds(38, 308, 92, 14);
		panel.add(lblNewLabel_6);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StaffMenu().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(530, 348, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff.isConnected=false;
				new LoginToSystem().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(646, 348, 89, 23);
		panel.add(btnNewButton_1);


		String[] GenderString = {"Male ", "Female"};
		JComboBox comboBox_1 = new JComboBox(GenderString);
		comboBox_1.setBounds(188, 85, 184, 20);
		panel.add(comboBox_1);


		String[] specialityStaff = {"Doctor ", "Nurse", "Admin"};
		JComboBox comboBox_2 = new JComboBox(specialityStaff);
		comboBox_2.setBounds(188, 303, 184, 25);
		panel.add(comboBox_2);

		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setBounds(462, 42, 89, 25);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Username");
		lblNewLabel_8.setBounds(462, 88, 89, 25);
		panel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Password");
		lblNewLabel_9.setBounds(462, 134, 89, 25);
		panel.add(lblNewLabel_9);

		//action button to add new staff
		JButton btnNewButton_2 = new JButton("Add New Staff Member");
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Title title= Title.getTitleByID(comboBox.getSelectedIndex()+1);
				Gender staffgender= Gender.getgenderByID(comboBox_1.getSelectedIndex()+1);
				String staffFirstName=textField_2.getText();
				String staffLastName=textField_3.getText();
				String address=textField_4.getText();
				String phone_nb=textField_5.getText();
				String email=textField_6.getText();
				Speciality staffspecilaity= Speciality.getSpecialityByID(comboBox_2.getSelectedIndex()+1);
				String staff_username=textField_7.getText();
				String staff_password=passwordField.getText();
				String staff_password2=passwordField_1.getText();
				if( !staff_password.equals(staff_password2) || staff_password.isEmpty() )
			      {
					JOptionPane.showMessageDialog(null, "Check Password");
			      }
				else{
				
				Staff addstaff = new Staff(title, staffgender, staffFirstName, staffLastName, address, phone_nb, email ,staffspecilaity, staff_username, staff_password);
				
				int addStatus = Staff.add(addstaff);
				
				if(addStatus==1)
				{
					JOptionPane.showMessageDialog(null, "Staff ADDED to datbase");

					new StaffMenu().setVisible(true);
					dispose();
				}
				
				else{

					JOptionPane.showMessageDialog(null, "ERROR in Details");
				}
				
			
				}}
			
		});

		btnNewButton_2.setBounds(188, 348, 184, 23);
		panel.add(btnNewButton_2);


		textField_6 = new JTextField();
		textField_6.setBounds(569, 37, 166, 25);
		panel.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(569, 83, 166, 25);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(569, 131, 166, 24);
		panel.add(passwordField);
		
		JLabel lblNewLabel_10 = new JLabel("Retype Password");
		lblNewLabel_10.setBounds(462, 180, 108, 14);
		panel.add(lblNewLabel_10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(569, 172, 166, 25);
		panel.add(passwordField_1);





	}
}
