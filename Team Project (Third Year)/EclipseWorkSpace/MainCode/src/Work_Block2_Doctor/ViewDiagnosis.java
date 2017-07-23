/**
 * Author: Anthony Appiah
 * Date: 22-04-2106
 * View Diagnosis menu 
 */
package Work_Block2_Doctor;


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


public class ViewDiagnosis extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTable table_2_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDiagnosis frame = new ViewDiagnosis();
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
	public ViewDiagnosis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1120, 560);
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
		scrollPane.setBounds(10, 105, 1084, 156);
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

		


		DefaultTableModel model= (DefaultTableModel) table_1.getModel(); 
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



		model.addColumn("ID");
		model.addColumn("Present Complaint");
		model.addColumn("Symptons");
		model.addColumn("Diagnosis");
		model.addColumn("Date");
		model.addColumn("Seen by");



		JButton btnNewButton = new JButton("Search ID");
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int searchNoteNo=0;
				searchNoteNo = Integer.parseInt(textField.getText());
				Diagnosis SearchDiag = Diagnosis.getDiagnosis(searchNoteNo);
				if(searchNoteNo != SearchDiag.getPatientID())
				{
					JOptionPane.showMessageDialog(null, "Record not in database. search again: ");


				}	
				else
				{
					model.setRowCount(0);
					model.addRow(new Object[]{SearchDiag.getID(),SearchDiag.getpresentingcomplaint(),
							SearchDiag.getsymptoms(), SearchDiag.getDiagnosis(), SearchDiag.getDateIssued(), SearchDiag.getDoc()
					});
				}


			}

		});
		btnNewButton.setBounds(259, 60, 105, 23);
		contentPane.add(btnNewButton);


		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DiagnosisMenu().setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(546, 482, 89, 23);
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
		btnNewButton_3.setBounds(644, 482, 89, 23);
		contentPane.add(btnNewButton_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 315, 1084, 156);
		contentPane.add(scrollPane_1);

		table_2_1 = new JTable(){public boolean isCellEditable(int row, int col) {
			//Note that the data/cell address is constant,
			//no matter where the cell appears onscreen.
			return false;
		};
		};
		scrollPane_1.setViewportView(table_2_1);
		table_2_1.setBackground(Color.WHITE);
		table_2_1.setFillsViewportHeight(true);

		//String[] columnsName = {"ID", "first name", "last name", "date of birth"};


		DefaultTableModel model1= (DefaultTableModel) table_2_1.getModel(); 
		table_2_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



		model1.addColumn("ID");
		model1.addColumn("First name");
		model1.addColumn("Last name");
		model1.addColumn("Date of birth");

		JButton btnNewButton_1 = new JButton("View All Patient");
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model1.setRowCount(0);
				ArrayList arr= new ArrayList();
				arr=Patient.viewAllPatients();
				Iterator<Patient> patientIterator = arr.iterator();
				while(patientIterator.hasNext()){
					Patient p=patientIterator.next();
					//Object data[]={p.getID(),p.getfirst_name(),p.getlastName(),p.getDOB()}
					model1.addRow(new Object[]{p.getID(),p.getfirst_name(),p.getlastName(),p.getDOB(),
					});
				}

			}
		});
		btnNewButton_1.setBounds(385, 60, 125, 23);
		contentPane.add(btnNewButton_1);

	}

}
