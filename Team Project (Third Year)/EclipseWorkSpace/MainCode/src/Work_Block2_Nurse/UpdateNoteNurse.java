package Work_Block2_Nurse;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import Work_Block2_Doctor.BedsideMenu;
import Work_Block2_Doctor.BedsideNotes;

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

public class UpdateNoteNurse extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idField;
	private JTextField presField_1;
	private JTextField ComField_2;
	private JTextField StatField_3;
	private JTextField invField_6;
	private JTextField dateField_7;
	private JLabel lblNewLabel_8;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateNoteNurse frame = new UpdateNoteNurse();
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
	public UpdateNoteNurse() {
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
		lblNewLabel.setBounds(20, 206, 127, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter New Blood Pressure:");
		lblNewLabel_1.setBounds(20, 251, 164, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Enter New Comments:");
		lblNewLabel_2.setBounds(20, 290, 127, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Enter New Status:");
		lblNewLabel_3.setBounds(20, 343, 107, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_6 = new JLabel("Enter New  Investigations:");
		lblNewLabel_6.setBounds(382, 206, 153, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Enter Date:");
		lblNewLabel_7.setBounds(382, 290, 127, 14);
		contentPane.add(lblNewLabel_7);

		idField = new JTextField();
		idField.setBounds(194, 203, 153, 20);
		contentPane.add(idField);
		idField.setColumns(10);

		presField_1 = new JTextField();
		presField_1.setBounds(194, 248, 153, 20);
		contentPane.add(presField_1);
		presField_1.setColumns(10);

		ComField_2 = new JTextField();
		ComField_2.setBounds(194, 287, 153, 39);
		contentPane.add(ComField_2);
		ComField_2.setColumns(10);

		StatField_3 = new JTextField();
		StatField_3.setBounds(194, 340, 153, 20);
		contentPane.add(StatField_3);
		StatField_3.setColumns(10);

		invField_6 = new JTextField();
		invField_6.setBounds(580, 206, 144, 39);
		contentPane.add(invField_6);
		invField_6.setColumns(10);

		dateField_7 = new JTextField();
		dateField_7.setBounds(580, 284, 144, 20);
		contentPane.add(dateField_7);
		dateField_7.setColumns(10);

		lblNewLabel_8 = new JLabel("Enter New  Patient Notes:");
		lblNewLabel_8.setBounds(20, 374, 153, 14);
		contentPane.add(lblNewLabel_8);

		textField_8 = new JTextField();
		textField_8.setBounds(194, 371, 268, 69);
		contentPane.add(textField_8);
		textField_8.setColumns(10);

		String[] bloodtype = {"A+ ", "A-", "B+","B- ", "AB+", "AB-", "O+ " , "O- "};


		JButton btnNewButton = new JButton("Update Notes");
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int searchHostpital=0;
				Boolean patientExist=false;

				String newBloodPressure=null;
				String newComment=null;
				String newinvestigation=null;
				String newStat=null;

				String newNoteDate=null;
				String newNote=null;
				int changeStatus=0;


				searchHostpital = Integer.parseInt(idField.getText());
				//String int searchHostpital = idField.getText()
				newBloodPressure = presField_1.getText();
				newComment = ComField_2.getText();
				newStat = StatField_3.getText();
				//String resultsP = ResField_5.getText();
				newinvestigation = invField_6.getText();
				newNoteDate = dateField_7.getText();
				newNote = textField_8.getText();
				//bloodType bloodt= bloodType.getTypeByID(comboBox.getSelectedIndex()+1);



				ArrayList<Patient> arp = Patient.viewAllPatients();
				for(Patient p: arp){
					if(searchHostpital==p.getID())
					{
				changeStatus = BedsideNotes.updateNote(searchHostpital,newBloodPressure, newComment, newinvestigation, newStat, newNoteDate, newNote);

				if(changeStatus==1)
				{
					
					patientExist = true;
					JOptionPane.showMessageDialog(null, "Notes ADDED to datbase");

					new BedsideMenu().setVisible(true);
					dispose();
				}

				else{

					JOptionPane.showMessageDialog(null, "ERROR in Details");
				}}

				else{
					patientExist = false;
				
					}
			if(!patientExist)
				JOptionPane.showMessageDialog(null, "Patient does not exit");

				}
			
				}
		});
		btnNewButton.setBounds(580, 334, 144, 23);
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
		btnNewButton_1.setBounds(519, 149, 180, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BedsideMenuNurse().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(504, 477, 89, 23);
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
		btnNewButton_3.setBounds(635, 477, 89, 23);
		contentPane.add(btnNewButton_3);


	}
}
