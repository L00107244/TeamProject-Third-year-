/**
 * Author: Anthony Appiah
 * Date: 22-04-2106
 * discharge patient Menu
 */
package Work_Block1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;

public class DischargePatient extends JFrame {

	//variables for discharge patients
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DischargePatient frame = new DischargePatient();
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
	public DischargePatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 0, 760, 406);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WardMenu().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(522, 361, 89, 23);
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
		btnNewButton_1.setBounds(636, 361, 89, 23);
		panel.add(btnNewButton_1);

		textField = new JTextField();
		textField.setBounds(202, 309, 141, 23);
		panel.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 125, 695, 168);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);

		table = new JTable(){public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			return false;
		};
		};
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.setBounds(40, 21, 483, 117);



		DefaultTableModel model= (DefaultTableModel) table.getModel(); 



		model.addColumn("ID");
		model.addColumn("First name");
		model.addColumn("Last name");
		model.addColumn("Date of birth");
		model.addColumn("Ward");




		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JLabel lblNewLabel = new JLabel("ID of Patient to Discharge");
		lblNewLabel.setBounds(30, 304, 151, 32);
		panel.add(lblNewLabel);




		//action button to discharge patient
		JButton btnNewButton_2 = new JButton("Discharge Patient");
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				int delStatus = Ward.removeFromWard(textField.getText());
				
				
				if(delStatus == 1)
				{
					JOptionPane.showMessageDialog(null, "Patient has been successfully discharged");
					new AdminMenu().setVisible(true);
					dispose();
				}
				else
				{

					JOptionPane.showMessageDialog(null, "Invalid ID or Patient has already been discharge");
				}


			}
		});
		btnNewButton_2.setBounds(202, 361, 141, 23);
		panel.add(btnNewButton_2);


		//button for a list all patients
		JButton btnNewButton_3 = new JButton("List all Patients");
		btnNewButton_3.setBackground(new Color(128, 128, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
				ArrayList arr= new ArrayList();
				arr=Patient.viewAllPatients();
				Iterator<Patient> patientIterator = arr.iterator();
				while(patientIterator.hasNext()){
					Patient p=patientIterator.next();
					
					model.addRow(new Object[]{p.getID(),p.getfirst_name(),p.getlastName(),p.getDOB(),p.WardID()});
				}


			}
		});
		btnNewButton_3.setBounds(30, 49, 151, 23);
		panel.add(btnNewButton_3);

		JLabel lblNewLabel_2 = new JLabel("Discharge a Patient");
		lblNewLabel_2.setBounds(30, 11, 151, 14);
		panel.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(202, 92, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		//button to search for a patient
		JButton btnNewButton_4 = new JButton("Search for Patient");
		btnNewButton_4.setBackground(new Color(128, 128, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int searchPNo=0;
				searchPNo = Integer.parseInt(textField_1.getText());
				Patient SearchP = Patient.getPatient(searchPNo);
				if(searchPNo != SearchP.getID())
				{
					JOptionPane.showMessageDialog(null, "Record not in database. search again: ");


				}	
				else{
				model.setRowCount(0);
				model.addRow(new Object[]{SearchP.getID(),SearchP.getfirst_name(),SearchP.getlastName(),SearchP.getDOB(),SearchP.WardID()});
				}
				}
		});
		btnNewButton_4.setBounds(30, 91, 151, 23);
		panel.add(btnNewButton_4);




	}
}
