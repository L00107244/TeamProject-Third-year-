/**
 * Author: Anthony Appiah, Shaun Boyle
 * Date: 22-04-2106
 * Add staff Menu
 */
package Work_Block1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DeleteStaff extends JFrame {

	//variables for deleting patient
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStaff frame = new DeleteStaff();
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
	public DeleteStaff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 760, 406);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Staff id to delete Staff");
		lblNewLabel.setBounds(10, 11, 193, 25);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter Staff ID number");
		lblNewLabel_1.setBounds(29, 301, 131, 25);
		panel.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(193, 303, 147, 20);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 76, 680, 199);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);

		table = new JTable(){public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			return false;
		};
		};
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);

		//String[] columnsName = {"ID", "first name", "last name", "date of birth"};


		DefaultTableModel model= (DefaultTableModel) table.getModel(); 
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



		model.addColumn("ID");
		model.addColumn("First name");
		model.addColumn("Last name");
		model.addColumn("Speciality");


		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.setBounds(479, 345, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StaffMenu().setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.setBounds(620, 345, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff.isConnected=false;
				new LoginToSystem().setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.setBounds(193, 345, 147, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int delStaffNo=0;
				delStaffNo = Integer.parseInt(textField.getText());
				int delStatus = Staff.delete(delStaffNo);
				if (delStatus==1)

					JOptionPane.showMessageDialog(null, "Staff Member successfully deleted from database");

				new StaffMenu().setVisible(true);
				dispose();
			}
		});
		panel.add(btnNewButton_2);

		//Button for viewing all staff
		JButton btnNewButton_3 = new JButton("View All Staff");
		btnNewButton_3.setBackground(new Color(128, 128, 0));
		btnNewButton_3.setBounds(261, 12, 131, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				ArrayList arr= new ArrayList();
				arr=Staff.viewAllStaff();
				Iterator<Staff> staffIterator = arr.iterator();
				while(staffIterator.hasNext()){
					Staff s=staffIterator.next();

					model.addRow(new Object[]{s.getID(),s.getFirstName(),s.getLastName(),s.getGender(),s.getEmail(),s.getSpeciality()});
				}
			}


		});
		panel.add(btnNewButton_3);


	}
}
