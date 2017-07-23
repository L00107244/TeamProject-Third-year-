/**
 * Author: Anthony Appiah
 * Date: 22-04-2106
 * Assign patient to ward Menu
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

public class GuiWard extends JFrame {

	//ward variables
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
					GuiWard frame = new GuiWard();
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
	public GuiWard() {
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
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 103, 696, 144);
		panel.add(scrollPane);

		//set up new table to hold records
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
		model.addColumn("History");




		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		textField = new JTextField();
		textField.setBounds(305, 258, 120, 23);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("ID of Patient to Assign");
		lblNewLabel.setBounds(59, 258, 151, 32);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Select Ward");
		lblNewLabel_1.setBounds(59, 301, 151, 32);
		panel.add(lblNewLabel_1);


		//combo box to give you a list of options
		String[] TitleStrings = {"Cardiology", "Surgical", "Surgical2", "ICU", "Pediatrics"};
		JComboBox comboBox = new JComboBox(TitleStrings);
		comboBox.setBounds(305, 307, 120, 20);
		panel.add(comboBox);

		//action button to assign patient
		JButton btnNewButton_2 = new JButton("Assign Patient");
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String patientid = String.valueOf(textField.getText());
				Ward  patientward = Ward.getWardByID(comboBox.getSelectedIndex()+1);
				//Assign patient to ward


				if (patientward.getbed_free()==0){
					
					JOptionPane.showMessageDialog(null, "The "+patientward.getward_name()+" ward has no bed available at the moment!");
				}
				else{
					int addStatus1 = Ward.assignWard(patientward,patientid);
					Ward.updateBedNb(patientward,true);
					if(addStatus1 == 1)
					{
						JOptionPane.showMessageDialog(null, "record added to database");
						new WardMenu().setVisible(true);
						dispose();
					}


				}
			}
		});
		btnNewButton_2.setBounds(305, 361, 120, 23);
		panel.add(btnNewButton_2);


		//action button to view all
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
					
					model.addRow(new Object[]{p.getID(),p.getfirst_name(),p.getlastName(),p.getDOB(),p.WardID().getward_name(),p.GetHistory()});
				}

			}

		});
		btnNewButton_3.setBounds(30, 36, 151, 23);
		panel.add(btnNewButton_3);

		JLabel lblNewLabel_2 = new JLabel("Assign Patient to Ward");
		lblNewLabel_2.setBounds(30, 11, 151, 14);
		panel.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(191, 70, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);


		//button to search for patient
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
				model.addRow(new Object[]{SearchP.getID(),SearchP.getfirst_name(),SearchP.getlastName(),SearchP.getDOB(),SearchP.WardID(),SearchP.GetHistory()});
				}
				}
		});
		btnNewButton_4.setBounds(30, 69, 151, 23);
		panel.add(btnNewButton_4);




	}
}
