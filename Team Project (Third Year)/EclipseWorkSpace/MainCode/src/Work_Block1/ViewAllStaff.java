/**
 * Author: Anthony Appiah, Shaun Boyle
 * Date: 22-04-2106
 * Assign patient to ward Menu
 */
package Work_Block1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Work_Block2_Doctor.BedsideNotes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ViewAllStaff extends JFrame {

	//variables for viewing staff
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAllStaff frame = new ViewAllStaff();
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
	public ViewAllStaff() {
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
		
		JLabel lblNewLabel = new JLabel("View Current Staff");
		lblNewLabel.setBounds(23, 11, 139, 21);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 121, 682, 207);
		panel.add(scrollPane);
		
		table = new JTable(){public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
return false;
};
};
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		table.setFillsViewportHeight(true);
		
		 
		DefaultTableModel model= (DefaultTableModel) table.getModel(); 
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
 
 
model.addColumn("ID");
model.addColumn("First name");
model.addColumn("Last name");
model.addColumn("Gender");
model.addColumn("Email");
model.addColumn("Speciality");
		
		
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(128, 128, 0));
		btnNewButton_1.setBounds(521, 357, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StaffMenu().setVisible(true);
                dispose();
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LogOut");
		btnNewButton_2.setBackground(new Color(128, 128, 0));
		btnNewButton_2.setBounds(636, 357, 89, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff.isConnected=false;
				new LoginToSystem().setVisible(true);
                dispose();
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("View All");
		btnNewButton.setBackground(new Color(128, 128, 0));
		btnNewButton.setBounds(44, 87, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(255, 90, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.setBackground(new Color(128, 128, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int searchSNo=0;
				searchSNo = Integer.parseInt(textField.getText());
				Staff SearchS = Staff.getStaff(searchSNo);
				if(searchSNo != SearchS.getID())
				{
					JOptionPane.showMessageDialog(null, "Record not in database. search again: ");
				}	
				else{
				model.setRowCount(0);
				 model.addRow(new Object[]{SearchS.getID(),SearchS.getFirstName(),SearchS.getLastName(),SearchS.getAddress(),SearchS.getPhoneNumber()
					,SearchS.getEmail(),SearchS.getSpeciality()	 });
				} 
			}
			
		});
		btnNewButton_3.setBounds(143, 87, 89, 23);
		panel.add(btnNewButton_3);
		
		
	}
}
