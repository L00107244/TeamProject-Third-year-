/**
 * Author: Anthony Appiah
 * Date: 22-04-2106
 * Add existing patient Menu
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
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class AddExisting extends JFrame {

	//Variables for adding existing patients
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddExisting frame = new AddExisting();
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
	public AddExisting() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Search for existing Patient's ID");
		lblNewLabel.setBounds(10, 64, 187, 14);
		contentPane.add(lblNewLabel);

		//
		textField = new JTextField();
		textField.setBounds(207, 61, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 715, 177);
		contentPane.add(scrollPane);

		//Creating the table to display records
		table_1 = new JTable(){public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			return false;
		};
		};
		scrollPane.setViewportView(table_1);
		table_1.setBackground(Color.WHITE);
		table_1.setFillsViewportHeight(true);

		


		DefaultTableModel model= (DefaultTableModel) table_1.getModel(); 
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



		model.addColumn("ID");
		model.addColumn("First name");
		model.addColumn("Last name");
		model.addColumn("Date of birth");
		model.addColumn("History");

		JButton btnNewButton = new JButton("Search ");
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int searchPNo=0;
				searchPNo = Integer.parseInt(textField.getText());
				Patient SearchP = Patient.getPatient(searchPNo);
				while(searchPNo != SearchP.getID())
				{
					JOptionPane.showMessageDialog(null, "Record not in database. search again: ");


				}	

				model.setRowCount(0);
				model.addRow(new Object[]{SearchP.getID(),SearchP.getfirst_name(),SearchP.getlastName(),SearchP.getDOB(),SearchP.GetHistory()});

			}
		});
		btnNewButton.setBounds(316, 60, 89, 23);
		contentPane.add(btnNewButton);

		//button to view all patients
		JButton btnNewButton_1 = new JButton("View All");
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				ArrayList arr= new ArrayList();
				arr=Patient.viewAllPatients();
				Iterator<Patient> patientIterator = arr.iterator();
				while(patientIterator.hasNext()){
					Patient p=patientIterator.next();
					
					model.addRow(new Object[]{p.getID(),p.getfirst_name(),p.getlastName(),p.getDOB(),p.GetHistory()});
				}

			}
		});
		btnNewButton_1.setBounds(415, 60, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PatientMenu().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(522, 372, 89, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setBackground(new Color(128, 128, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff.isConnected=false;
				new LoginToSystem().setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(636, 372, 89, 23);
		contentPane.add(btnNewButton_3);

		textField_1 = new JTextField();
		textField_1.setBounds(222, 306, 103, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(222, 337, 209, 41);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Enter ID to update Patient");
		lblNewLabel_1.setBounds(10, 309, 154, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Update Patient's History");
		lblNewLabel_2.setBounds(10, 364, 154, 14);
		contentPane.add(lblNewLabel_2);

		//Buttons to update systems.
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.setBackground(new Color(128, 128, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int changeIdNo=0;
				String newhistory=null;
				int changeStatus=0;
				changeIdNo = Integer.parseInt(textField_1.getText());
				newhistory = textField_2.getText();

				changeStatus=Patient.updatePatient(changeIdNo, newhistory);
				if (changeStatus==1)
				{
					JOptionPane.showMessageDialog(null, "Record successfully upddated from database");
					new GuiWard().setVisible(true);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Record failed to Update, Invalid ID");
				}

			}


		});
		btnNewButton_4.setBounds(342, 305, 89, 23);
		contentPane.add(btnNewButton_4);
	}
}
