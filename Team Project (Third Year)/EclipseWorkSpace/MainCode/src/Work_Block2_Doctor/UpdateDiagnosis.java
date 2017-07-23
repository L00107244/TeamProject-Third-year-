/**
 * Author: Anthony Appiah
 * Date: 22-04-2106
 * Update diagnosis menu 
 */
package Work_Block2_Doctor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import Work_Block1.Gender;
import Work_Block1.LoginToSystem;
import Work_Block1.Patient;
import Work_Block1.Speciality;
import Work_Block1.Staff;
import Work_Block1.StaffMenu;
import Work_Block1.Title;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class UpdateDiagnosis extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idField;
	private JTextField SeenField_1;
	private JTextField ComField_2;
	private JTextField DiaField_5;
	private JTextField sympField_6;
	private JTextField dateField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDiagnosis frame = new UpdateDiagnosis();
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
	public UpdateDiagnosis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 30, 704, 141);
		contentPane.add(scrollPane);

		table = new JTable(){public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			return false;
		};
		};

		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		table.setBounds(40, 21, 483, 117);

		//String[] columnsName = {"ID", "first name", "last name", "date of birth"};


		DefaultTableModel model= (DefaultTableModel) table.getModel(); 



		model.addColumn("ID");
		model.addColumn("First name");
		model.addColumn("Last name");
		model.addColumn("Date of birth");


		//JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 21, 659, 117);
		//frame.getContentPane().add(scrollPane);

		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


		JLabel lblNewLabel = new JLabel("Enter Patient ID");
		lblNewLabel.setBounds(20, 206, 127, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Seen By");
		lblNewLabel_1.setBounds(20, 251, 127, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Present Compliant");
		lblNewLabel_2.setBounds(20, 290, 107, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_5 = new JLabel("Diagnosis");
		lblNewLabel_5.setBounds(370, 206, 127, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Symptoms");
		lblNewLabel_6.setBounds(370, 251, 127, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Date Issued");
		lblNewLabel_7.setBounds(370, 312, 127, 14);
		contentPane.add(lblNewLabel_7);

		idField = new JTextField();
		idField.setBounds(167, 203, 180, 20);
		contentPane.add(idField);
		idField.setColumns(10);

		SeenField_1 = new JTextField();
		SeenField_1.setBounds(167, 248, 180, 20);
		contentPane.add(SeenField_1);
		SeenField_1.setColumns(10);

		ComField_2 = new JTextField();
		ComField_2.setBounds(167, 287, 180, 39);
		contentPane.add(ComField_2);
		ComField_2.setColumns(10);

		DiaField_5 = new JTextField();
		DiaField_5.setBounds(544, 203, 179, 20);
		contentPane.add(DiaField_5);
		DiaField_5.setColumns(10);

		sympField_6 = new JTextField();
		sympField_6.setBounds(544, 251, 180, 39);
		contentPane.add(sympField_6);
		sympField_6.setColumns(10);

		dateField_7 = new JTextField();
		dateField_7.setBounds(543, 309, 180, 20);
		contentPane.add(dateField_7);
		dateField_7.setColumns(10);




		JButton btnNewButton = new JButton("Update Diagnosis");
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int changeIdNo=0;
				int changeStatus=0;
				Boolean patientExist=false;

				String newcomplaint=null;
				String newsymtoms=null;
				String newdiagnosis=null;
				String newDateIssued=null;
				String ddoc = null;

				changeIdNo = Integer.parseInt(idField.getText());
				//String int searchHostpital = idField.getText()
				ddoc = SeenField_1.getText();
				newcomplaint = ComField_2.getText();

				newdiagnosis = DiaField_5.getText();
				newsymtoms = sympField_6.getText();
				newDateIssued = dateField_7.getText();

				ArrayList<Patient> arp = Patient.viewAllPatients();
				for(Patient p: arp){
					if(changeIdNo==p.getID())
					{

				changeStatus=Diagnosis.updateDiagnosis(changeIdNo, newcomplaint, newsymtoms, newdiagnosis, newDateIssued, ddoc); //(changeIdNo, newcomplaint, newsymtoms, newdiagnosis, newDateIssued, ddoc);
				if(changeStatus==1) 
				{
					
					patientExist = true;
					JOptionPane.showMessageDialog(null, "Diagnosis added to datbase");
					new DiagnosisMenu().setVisible(true);
					dispose();

				}

				else{

					JOptionPane.showMessageDialog(null, "ERROR in Details");
				}
					}

					else{
						patientExist = false;
					}
				}
				if(!patientExist)
					JOptionPane.showMessageDialog(null, "Patient does not exit");

			}
		});
		btnNewButton.setBounds(544, 371, 179, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("View All Patients");
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				model.setRowCount(0);
				ArrayList arr= new ArrayList();
				arr=Patient.viewAllPatients();
				Iterator<Patient> patientIterator = arr.iterator();
				while(patientIterator.hasNext()){
					Patient p=patientIterator.next();
					//Object data[]={p.getID(),p.getfirst_name(),p.getlastName(),p.getDOB()}
					model.addRow(new Object[]{p.getID(),p.getfirst_name(),p.getlastName(),p.getDOB()});
				}

			}
		});
		btnNewButton_1.setBounds(167, 371, 180, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DiagnosisMenu().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(544, 434, 74, 23);
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
		btnNewButton_3.setBounds(649, 434, 74, 23);
		contentPane.add(btnNewButton_3);


	}
}
