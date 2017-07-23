package Work_Block2_Nurse;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Work_Block1.LoginToSystem;
import Work_Block1.Patient;
import Work_Block1.PatientMenu;
import Work_Block1.Staff;
import Work_Block1.addStaff2;
import Work_Block2_Doctor.ViewNotes;


public class ViewPatientNurse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPatientNurse frame = new ViewPatientNurse();
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
	public ViewPatientNurse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1120, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Patient's ID");
		lblNewLabel.setBounds(10, 64, 125, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(145, 61, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 1084, 208);
		contentPane.add(scrollPane);

		table_1 = new JTable(){public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			return false;
		};
		};
		scrollPane.setViewportView(table_1);
		table_1.setBackground(Color.WHITE);
		table_1.setFillsViewportHeight(true);

		//String[] columnsName = {"ID", "first name", "last name", "date of birth"};


		DefaultTableModel model= (DefaultTableModel) table_1.getModel(); 
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



		model.addColumn("ID");
		model.addColumn("First name");
		model.addColumn("Last name");
		model.addColumn("Date of birth");
		model.addColumn("Address");
		model.addColumn("PPSN");
		model.addColumn("Next of Kin");
		model.addColumn("Next of Kin's Number");
		model.addColumn("Allergy");
		model.addColumn("History");
		model.addColumn("Referral");
		model.addColumn("Referral Class");
		model.addColumn("Ward");

		JButton btnNewButton = new JButton("Search ID");
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int searchPNo=0;
				searchPNo = Integer.parseInt(textField.getText());
				Patient SearchP = Patient.getPatient(searchPNo);
				if(searchPNo != SearchP.getID())
				{
					JOptionPane.showMessageDialog(null, "Record not in database. search again: ");


				}	
				else{
					model.setRowCount(0);
					model.addRow(new Object[]{SearchP.getID(),SearchP.getfirst_name(),SearchP.getlastName(),SearchP.getDOB(),
							SearchP.getAddress(),SearchP.getPPS(),SearchP.getkin(),SearchP.getkin_pn(),SearchP.Getallergy(),SearchP.GetHistory(),SearchP.GetRefferal(),SearchP.GetRefferalClass(),SearchP.WardID()});
				}

			}
		});
		btnNewButton.setBounds(259, 60, 89, 23);
		contentPane.add(btnNewButton);

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
					//Object data[]={p.getID(),p.getfirst_name(),p.getlastName(),p.getDOB()}
					model.addRow(new Object[]{p.getID(),p.getfirst_name(),p.getlastName(),p.getDOB(),
							p.getAddress(),p.getPPS(),p.getkin(),p.getkin_pn(),p.Getallergy(),p.GetHistory(),p.GetRefferal(),p.GetRefferalClass(),p.WardID()});
				}

			}
		});
		btnNewButton_1.setBounds(355, 60, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NurseMenu().setVisible(true);
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

		JButton btnNewButton_4 = new JButton("Bedside Notes");
		btnNewButton_4.setBackground(new Color(128, 128, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ViewNotesNurse().setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(10, 372, 125, 23);
		contentPane.add(btnNewButton_4);
	}
}
