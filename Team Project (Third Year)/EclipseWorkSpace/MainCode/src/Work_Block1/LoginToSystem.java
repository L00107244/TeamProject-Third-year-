/**
 * Author: Anthony Appiah
 * Date: 22-04-2106
 * Password Gui
	 */
package Work_Block1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Work_Block2_Doctor.DoctorMenu;
import Work_Block2_Nurse.NurseMenu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginToSystem extends JFrame {

	//Password Variables
	private JPanel contentPane;
	public static JTextField UserField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginToSystem frame = new LoginToSystem();
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
	public LoginToSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 684, 321);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(128, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(423, 87, 86, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(128, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(423, 132, 86, 14);
		panel.add(lblNewLabel_1);

		setUserField(new JTextField());
		getUserField().setBounds(548, 84, 113, 20);
		panel.add(getUserField());
		getUserField().setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(548, 129, 113, 20);
		panel.add(passwordField);

		//Adding images to the gui and positioning them 
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(".\\resources\\images\\lyit4.png"));
		lblNewLabel_2.setBounds(10, 84, 409, 137);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(".\\resources\\images\\lyit.jpg"));
		lblNewLabel_3.setBounds(10, 261, 450, 49);
		panel.add(lblNewLabel_3);

		
		
		//Action Button to log in to the system
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				ArrayList<Staff> ars= new ArrayList<Staff>();
				ars=Staff.viewAllStaff();
				for(Staff s:ars){
					if(getUserField().getText().equals(s.getUsername())&& passwordField.getText().equals(s.getPassword()))
					{
						Staff.connectedStaff=s;
						Staff.isConnected=true;
						JOptionPane.showMessageDialog(null,"Connected");
					}
				}

				if(Staff.isConnected){

					if(Staff.connectedStaff.speciality.getID()==1)
					{
						//doctor gui??
						new DoctorMenu().setVisible(true);
						dispose();
					}
					else if(Staff.connectedStaff.speciality.getID()==2)
					{
						new NurseMenu().setVisible(true);
						dispose();
					}
					else if(Staff.connectedStaff.speciality.getID()==3)
					{
						//admin gui.
						new AdminMenu().setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Data");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Wrong Password / Username");
				}

			}
		});
		btnNewButton.setBounds(581, 273, 80, 23);
		panel.add(btnNewButton);

		JRootPane rootPane = SwingUtilities.getRootPane(btnNewButton);
		rootPane.setDefaultButton(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(491, 273, 80, 23);
		panel.add(btnNewButton_1);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(".\\resources\\images\\lock.png"));
		lblNewLabel_4.setBounds(548, 177, 113, 85);
		panel.add(lblNewLabel_4);
	}

	public JTextField getUserField() {
		return UserField;
	}

	public void setUserField(JTextField userField) {
		UserField = userField;
	}
}
	 