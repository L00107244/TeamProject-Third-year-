package Work_Block2_Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import Work_Block1.Patient;
public class BedsideNotes extends Patient
{
	private int id;
    private int patient_id;
    private bloodType blood_type; 
    private String blood_pressure;
    public String blood_results;
    private String comments;
    private String investigations;
    private String pstatus;
    private String notes_date;
    private String notes;
    
    
    //Database variables
    private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
    private String driver = "com.mysql.jdbc.Driver";
    private static String userName = "root";
    private static String password = "password"; 
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    
    public BedsideNotes(int pid, bloodType bt, String bp,String br, String comm, String invest, String stat, String nd, String n)
    {
        patient_id = pid;
        blood_type = bt;
        blood_pressure = bp;
        blood_results = br;
        comments = comm;
        investigations = invest;
        pstatus = stat;
        notes_date = nd;
        notes = n;
    }
    public BedsideNotes(int idin,int pid, bloodType bt, String bp, String br, String comm, String invest, String stat, String nd, String n)
    {
    	id=idin; 
    	patient_id = pid;
         blood_type = bt;
         blood_pressure = bp;
         blood_results = br;
         comments = comm;
         investigations = invest;
         pstatus = stat;
         notes_date = nd;
         notes = n;
    }
    public BedsideNotes()
    {
 	   
    }
    public int getID()
    {
    	return id;
    }
    public int getPatientId()
    {
    	return patient_id;
    }
    public bloodType getbloodType()
    {
    	return blood_type;
    }
    public String getBloodPressure()
    {
    	return blood_pressure;
    }
    public String getBloodResults()
    {
    	return blood_results;
    }
    public String getComments()
    {
    	return comments;
    }
    public String getinvestigations()
    {
    	return investigations;
    }
    public String getStatus()
    {
    	return pstatus;
    }
    public String getNoteDate()
    {
    	return notes_date;
    }
    public String getNotes()
    {
    	return notes;
    }
    public static int add(BedsideNotes BNin)
    {
    	
 	   int status = 0;
 	   
 	   String sqlString= "insert into hospital.Bedside_Notes(patient_id, blood_type, blood_pressure,blood_results, comments, investigations, pstatus, notes_date, notes) values(\'" +BNin.getPatientId()+ 
 	 	 	  "\', \'"+BNin.getbloodType().getID()+ 
 	 	   "\', \'"+BNin.getBloodPressure() + 
 	 	   "\', \'"+BNin.getBloodResults() +
 			"\', \'"+ BNin.getComments()+ "\', \'"  + BNin.getinvestigations()+ 
             "\', \'" + BNin.getStatus() +  
 	   		"\', \'" + BNin.getNoteDate()+
 	   	    "\', \'" + BNin.getNotes()+"\')";
 	   status = databaseUpdate(sqlString);
            System.out.print(sqlString);  
 	   return status;
    }
    public static BedsideNotes getNotes(int searchNo)
    {
       BedsideNotes foundNote= new BedsideNotes();
       try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection(url,userName,password);
          statement=conn.createStatement();
          resultSet=statement.executeQuery("select * from hospital.Bedside_Notes where hospital.Bedside_Notes.id=" + searchNo);
                  
          while ( resultSet.next() )      {
             foundNote = new BedsideNotes( resultSet.getInt("id"),
            		            resultSet.getInt("patient_id"),
            		            bloodType.getTypeByID(resultSet.getInt("blood_type")),
            		    	    resultSet.getString("blood_pressure"),
            		    	    resultSet.getString("blood_results"),
            		    	    resultSet.getString("comments"),
            		    	    resultSet.getString("investigations"),
            		    	    resultSet.getString("pstatus"),
            		    	    resultSet.getString("notes_date"),
            		    	    resultSet.getString("notes").toString() );                 
          }   
          conn.close();
       } 
       catch (Exception e) {
          e.printStackTrace();
       }  
       return foundNote;
    }
    public static int updateNote(int IDNoIn, String BloodPressureIn, String comments, String invest, String pstat, String noteDate, String note )   
    {
        int status = 0;
        String sqlString="update hospital.Bedside_Notes set blood_pressure=\'"+BloodPressureIn+"',comments = '"+comments+"',investigations = '"+invest+
        		        "',Pstatus = '"+pstat+"',notes_date = '"+noteDate+  "',notes = '"+note   + "\' where id="+IDNoIn;
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
