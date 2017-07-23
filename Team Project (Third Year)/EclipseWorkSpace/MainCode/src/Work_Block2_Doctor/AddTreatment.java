/**
 * Author: Anthony Appiah
 * Date: 22-04-2106
 * Add Treatment menu 
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

public class AddTreatment extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idField;
	private JTextField nameField_2;
	private JTextField lengthField_3;
	private JTextField docField_5;
	private JTextField notesField_6;
	private JTextField dateField_7;
	private JLabel lblNewLabel_8;
	private JTextField textField_8;
	private JTextField datField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTreatment frame = new AddTreatment();
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
	public AddTreatment() {
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


		JLabel lblNewLabel = new JLabel("Enter Patient ID:");
		lblNewLabel.setBounds(20, 171, 127, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Treatment Type");
		lblNewLabel_1.setBounds(20, 206, 127, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Treatment Name");
		lblNewLabel_2.setBounds(20, 251, 107, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Treatment Length");
		lblNewLabel_3.setBounds(20, 299, 107, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Select Dosage");
		lblNewLabel_4.setBounds(389, 171, 127, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Doctor Name");
		lblNewLabel_5.setBounds(389, 206, 127, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Notes");
		lblNewLabel_6.setBounds(389, 251, 127, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Begin Date");
		lblNewLabel_7.setBounds(389, 299, 127, 14);
		contentPane.add(lblNewLabel_7);

		idField = new JTextField();
		idField.setBounds(167, 168, 180, 20);
		contentPane.add(idField);
		idField.setColumns(10);

		nameField_2 = new JTextField();
		nameField_2.setBounds(167, 239, 180, 39);
		contentPane.add(nameField_2);
		nameField_2.setColumns(10);

		lengthField_3 = new JTextField();
		lengthField_3.setBounds(167, 296, 180, 20);
		contentPane.add(lengthField_3);
		lengthField_3.setColumns(10);

		docField_5 = new JTextField();
		docField_5.setBounds(544, 203, 179, 20);
		contentPane.add(docField_5);
		docField_5.setColumns(10);

		notesField_6 = new JTextField();
		notesField_6.setBounds(544, 239, 180, 39);
		contentPane.add(notesField_6);
		notesField_6.setColumns(10);

		dateField_7 = new JTextField();
		dateField_7.setBounds(544, 296, 180, 20);
		contentPane.add(dateField_7);
		dateField_7.setColumns(10);

		lblNewLabel_8 = new JLabel("Effects");
		lblNewLabel_8.setBounds(20, 343, 127, 14);
		contentPane.add(lblNewLabel_8);

		textField_8 = new JTextField();
		textField_8.setBounds(167, 337, 180, 69);
		contentPane.add(textField_8);
		textField_8.setColumns(10);

		String[] type = {"50mg ", "60mg", "100mg","150mg", "200mg", "250mg", "300mg"};
		JComboBox comboBox = new JComboBox(type);
		comboBox.setBounds(545, 168, 179, 20);
		contentPane.add(comboBox);

		
		String[] type1 = {"Medication ", "Therapy", "Surgery"};
		JComboBox comboBox_1 = new JComboBox(type1);
		comboBox_1.setBounds(167, 203, 180, 20);
		contentPane.add(comboBox_1);
		

		JButton btnNewButton = new JButton("Add Treatment");
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int searchHostpital=0;
				Boolean patientExist=false;

				searchHostpital = Integer.parseInt(idField.getText());
				//String int searchHostpital = idField.getText()
				TreatmentType treatT = TreatmentType.getTypeByID(comboBox_1.getSelectedIndex()+1);
				String treatN = nameField_2.getText();
				String treatL = lengthField_3.getText();
				String DoctorF = docField_5.getText();
				String NoteF = notesField_6.getText();
				String dateF = dateField_7.getText();
				String dateF1 = datField.getText();
				String effects = textField_8.getText();
				Dosage dosage= Dosage.getDosageByID(comboBox.getSelectedIndex()+1);
				
				
				ArrayList<Patient> arp = Patient.viewAllPatients();
				for(Patient p: arp){
					if(searchHostpital==p.getID())
					{

				Treatment newTreat = new Treatment(searchHostpital, treatT, dosage ,treatN ,treatL ,effects ,dateF ,dateF1 ,NoteF,DoctorF);
				int addStatus = Treatment.add(newTreat);
				if(addStatus==1)
				{
					patientExist = true;
					JOptionPane.showMessageDialog(null, "Treatment ADDED to datbase");

					new TreatMenu().setVisible(true);
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
		btnNewButton.setBounds(544, 381, 180, 23);
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
		btnNewButton_1.setBounds(167, 477, 180, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TreatMenu().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(544, 477, 80, 23);
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
		btnNewButton_3.setBounds(643, 477, 80, 23);
		contentPane.add(btnNewButton_3);

		JLabel lblNewLabel_9 = new JLabel("End Date");
		lblNewLabel_9.setBounds(389, 343, 118, 14);
		contentPane.add(lblNewLabel_9);

		datField = new JTextField();
		datField.setBounds(544, 340, 179, 20);
		contentPane.add(datField);
		datField.setColumns(10);




	}
}
