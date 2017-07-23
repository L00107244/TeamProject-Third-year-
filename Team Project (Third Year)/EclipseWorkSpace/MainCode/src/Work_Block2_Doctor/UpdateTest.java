/**
 * Author: Anthony Appiah
 * Date: 22-04-2106
 * Update Test menu 
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

public class UpdateTest extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idField;
	private JTextField SeenField_1;
	private JTextField typeField_5;
	private JTextField ResField_6;
	private JTextField dateField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateTest frame = new UpdateTest();
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
	public UpdateTest() {
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

		JLabel lblNewLabel_5 = new JLabel("Enter New Test type");
		lblNewLabel_5.setBounds(370, 206, 127, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Enter New Results");
		lblNewLabel_6.setBounds(370, 307, 127, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Date Issued");
		lblNewLabel_7.setBounds(370, 251, 127, 14);
		contentPane.add(lblNewLabel_7);

		idField = new JTextField();
		idField.setBounds(167, 203, 180, 20);
		contentPane.add(idField);
		idField.setColumns(10);

		SeenField_1 = new JTextField();
		SeenField_1.setBounds(167, 248, 180, 20);
		contentPane.add(SeenField_1);
		SeenField_1.setColumns(10);

		typeField_5 = new JTextField();
		typeField_5.setBounds(520, 203, 179, 20);
		contentPane.add(typeField_5);
		typeField_5.setColumns(10);

		ResField_6 = new JTextField();
		ResField_6.setBounds(519, 295, 180, 39);
		contentPane.add(ResField_6);
		ResField_6.setColumns(10);

		dateField_7 = new JTextField();
		dateField_7.setBounds(519, 248, 180, 20);
		contentPane.add(dateField_7);
		dateField_7.setColumns(10);




		JButton btnNewButton = new JButton("Update Test");
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int changeIdNo=0;
				int changeStatus=0;
				Boolean patientExist=false;
				
				String  newtesttype=null;
				String  newresults=null;
				String  newdate=null;
				String  newseenby=null;

				changeIdNo = Integer.parseInt(idField.getText());
				//String int searchHostpital = idField.getText()
				newseenby = SeenField_1.getText();


				newtesttype = typeField_5.getText();
				newresults = ResField_6.getText();
				newdate = dateField_7.getText();

				ArrayList<Patient> arp = Patient.viewAllPatients();
				for(Patient p: arp){
					if(changeIdNo==p.getID())
					{
				changeStatus=Tests.updateTest(changeIdNo,newtesttype,newresults , newdate, newseenby);
				if(changeStatus==1) 
				{
					patientExist = true;
					JOptionPane.showMessageDialog(null, "Tests added to datbase");
					new DiagnosisMenu().setVisible(true);
					dispose();
				}

				else{

					JOptionPane.showMessageDialog(null, "ERROR in Details");
				}}
				else{
					patientExist = false;
				}
			}
			if(!patientExist)
				JOptionPane.showMessageDialog(null, "Patient does not exit");

		}

			
		});
		btnNewButton.setBounds(520, 363, 179, 23);
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
		btnNewButton_1.setBounds(167, 303, 180, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DiagnosisMenu().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(520, 434, 74, 23);
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
		btnNewButton_3.setBounds(625, 434, 74, 23);
		contentPane.add(btnNewButton_3);


	}
}
