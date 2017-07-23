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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class AdmitPatient extends JFrame {

	//Set up variables for admitting patients
	private JPanel contentPane;
	private JTextField textFieldN;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_14;
	private JTextField textField_15;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdmitPatient frame = new AdmitPatient();
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
	public AdmitPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 759, 430);
		contentPane.add(panel);
		panel.setLayout(null);

		textFieldN = new JTextField();
		textFieldN.setBounds(164, 25, 160, 20);
		panel.add(textFieldN);
		textFieldN.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(164, 66, 160, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(164, 110, 160, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(164, 158, 160, 54);
		panel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(164, 254, 160, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(164, 288, 160, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(164, 321, 160, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(164, 352, 160, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(10, 28, 79, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(10, 69, 79, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("D.O.B");
		lblNewLabel_2.setBounds(10, 113, 79, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(10, 161, 79, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(10, 260, 79, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Phone number");
		lblNewLabel_5.setBounds(10, 294, 79, 14);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("PPSN");
		lblNewLabel_6.setBounds(10, 330, 79, 14);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Religion");
		lblNewLabel_7.setBounds(10, 355, 79, 14);
		panel.add(lblNewLabel_7);

		textField_8 = new JTextField();
		textField_8.setBounds(576, 25, 150, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setBounds(576, 66, 150, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(576, 110, 150, 20);
		panel.add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setBounds(576, 158, 150, 20);
		panel.add(textField_11);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setBounds(576, 192, 150, 20);
		panel.add(textField_12);
		textField_12.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setBounds(576, 291, 150, 20);
		panel.add(textField_14);
		textField_14.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Next Of Kin");
		lblNewLabel_8.setBounds(428, 28, 95, 14);
		panel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Next of Kin Number");
		lblNewLabel_9.setBounds(428, 69, 95, 14);
		panel.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Allergy");
		lblNewLabel_10.setBounds(428, 113, 95, 14);
		panel.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("History");
		lblNewLabel_11.setBounds(428, 158, 95, 14);
		panel.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Referral");
		lblNewLabel_12.setBounds(428, 198, 95, 14);
		panel.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Referral Class");
		lblNewLabel_13.setBounds(428, 257, 95, 14);
		panel.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("Date of Admission");
		lblNewLabel_14.setBounds(428, 291, 95, 14);
		panel.add(lblNewLabel_14);

		textField_15 = new JTextField();
		textField_15.setBounds(576, 321, 150, 20);
		panel.add(textField_15);
		textField_15.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Length of Stay");
		lblNewLabel_15.setBounds(428, 327, 95, 14);
		panel.add(lblNewLabel_15);

		String[] TitleStrings = {"Accident and emergency", "GP"};
		JComboBox comboBox = new JComboBox(TitleStrings);
		comboBox.setBounds(576, 254, 150, 20);
		panel.add(comboBox);

		//Button for different menus
		JButton btnNewButton = new JButton("Admit Patient");
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fn=textFieldN.getText();
				String ln=textField_1.getText();
				String dob=textField_2.getText();
				String ad=textField_3.getText();
				String em=textField_4.getText();
				String pn=textField_5.getText();
				String patientPPS=textField_6.getText();
				String nokIn=textField_8.getText();
				String allerIN=textField_10.getText();
				String histin=textField_11.getText();
				String reffIn=textField_12.getText();
				ReferralClass referance_class = ReferralClass.getReferralClassByID(comboBox.getSelectedIndex()+1);
				//String refClass =RefferalClassextField.getText();
				String rel=textField_7.getText();
				String nokpn=textField_9.getText();
				String los=textField_15.getText();
				String doa=textField_14.getText();



				if(dob.matches("^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")/* && PPSN.matches("^\\d{7}[A-Z]{2}$") && PPSN.matches("^\\d{7}[A-Z]{1}\\s{1}$")*/)
				{

					Patient addpatient = new Patient(/*int iDin,*/ fn,  ln,  dob,  ad, em,   pn, patientPPS,  rel,
							nokIn,  nokpn,  allerIN,  histin,  reffIn, referance_class ,  doa,  los);
					int addStatus = addpatient.add(addpatient);
					if(addStatus==1)
					{
						JOptionPane.showMessageDialog(null, "patient added to datbase");
						//System.out.println("patient added to datbase");
						new GuiWard().setVisible(true);
						dispose();
					}
				}
				else{

					JOptionPane.showMessageDialog(null, "Error in Details");
				}
			}
		});
		btnNewButton.setBounds(428, 396, 120, 23);
		panel.add(btnNewButton);


		//Button for different menus
		JButton btnNewButton_1 = new JButton("Cancle");
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PatientMenu().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(576, 396, 120, 23);
		panel.add(btnNewButton_1);


	}

}
