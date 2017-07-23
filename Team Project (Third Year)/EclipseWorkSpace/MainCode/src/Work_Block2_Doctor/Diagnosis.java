
package Work_Block2_Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import Work_Block1.Patient;
public class Diagnosis extends Patient
{
	private int id;
	private int patient_id;
	private String presenting_complaint; 
	private String symptoms;
	private String diagnosis;
	private String date_issued;	
	private String seen_by;

	//Database variables
	private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
	private String driver = "com.mysql.jdbc.Driver";
	private static String userName = "root";
	private static String password = "password"; 
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	public Diagnosis(int pid, String pc, String sym, String diag, String di, String sb)
	{
		patient_id = pid;
		presenting_complaint = pc;
		symptoms = sym;
		diagnosis = diag;
		date_issued = di;
		seen_by =sb;
	}
	public Diagnosis( int idin, int pid, String pc, String sym, String diag, String di, String sb)
	{
		id=idin;
		patient_id = pid;
		presenting_complaint = pc;
		symptoms = sym;
		diagnosis = diag;
		date_issued = di;
		seen_by = sb;
	}
	public Diagnosis()
	{

	}
	public int getID()
	{
		return id;
	}
	public int getPatientID()
	{
		return patient_id;
	}
	public String getpresentingcomplaint()
	{
		return presenting_complaint;
	}
	public String getsymptoms()
	{
		return symptoms;
	}
	public String getDiagnosis()
	{
		return diagnosis;
	}
	public String getDateIssued()
	{
		return date_issued;
	}
	public String getDoc()
	{
		return seen_by;
	}
	public static int add(Diagnosis diagnosisIn)
	{ 
		int status = 0;
		String sqlString= "insert into hospital.Diagnosis(patient_id, presenting_complaint, symptoms, diagnosis, date_issued, seen_by) values(\'" +diagnosisIn.getPatientID()+ 
				"\', \'"+diagnosisIn.getpresentingcomplaint()+
				"\', \'"+diagnosisIn.getsymptoms() + 
				"\', \'"+ diagnosisIn.getDiagnosis()+ 
				"\', \'" + diagnosisIn.getDateIssued()+
				"\', \'" + diagnosisIn.getDoc()+"\')";
		status = databaseUpdate(sqlString);
		System.out.print(sqlString);              
		return status;
	}
	public static Diagnosis getDiagnosis(int searchNo)
	{
		Diagnosis foundDiagnosis= new Diagnosis();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,userName,password);
			statement=conn.createStatement();
			resultSet=statement.executeQuery("select * from hospital.Diagnosis where hospital.Diagnosis.id=" + searchNo);

			while ( resultSet.next() )      {
				foundDiagnosis = new Diagnosis( resultSet.getInt("id"),
						resultSet.getInt("patient_id"),
						resultSet.getString("presenting_complaint"),
						resultSet.getString("symptoms"),
						resultSet.getString("diagnosis"),
						resultSet.getString("date_issued"),
						resultSet.getString("seen_by").toString() );                 
			}   
			conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}  
		return foundDiagnosis;
	}
	public static int updateDiagnosis(int IDNoIn, String complaint, String symptoms, String diagnosis, String dateIssued, String sb )   
	{
		int status = 0;
		String sqlString="update hospital.Diagnosis set presenting_complaint=\'"+complaint+"',symptoms = '"+symptoms+"',diagnosis = '"+diagnosis+
				"',date_issued = '"+dateIssued+ "',seen_by = '"+sb+"\' where id="+IDNoIn;
		status = databaseUpdate(sqlString);                                           

		return status;

	}
	private  static int databaseUpdate(String sqlUpdate)
	{
		int status = 0;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, userName, password);
			statement=conn.createStatement();
			status=statement.executeUpdate(sqlUpdate);
			conn.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

}
