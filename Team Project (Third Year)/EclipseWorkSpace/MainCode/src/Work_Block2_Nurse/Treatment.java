package Work_Block2_Nurse;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import Work_Block1.Patient;
public class Treatment extends Patient
{
	    private int id;
	    private int patient_id;
		private TreatmentType treatment_type;
	    private Dosage dosage;
	    private String treatment_name;
	    private String treatment_length;
	    private String effects;
	    private String begin_date;
	    private String end_date;
	    private String notes;
	    private String given_by;
	
	   //Database variables
    private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
   // private static String dbName = "hospital";
    private String driver = "com.mysql.jdbc.Driver";
    private static String userName = "root";
    private static String password = "password"; 
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    
    public Treatment(int pid, TreatmentType ttype, Dosage dos, String tn, String tl, String eff, String bd, String ed, String note, String gb)
    {
    
    	patient_id = pid;
		treatment_type= ttype;
	    dosage = dos;
	    treatment_name = tn;
	    treatment_length = tl;
	    effects = eff;
	    begin_date = bd;
	    end_date = ed;
	    notes = note;
	    given_by = gb;
    }
    public Treatment(int pid, TreatmentType ttype,String tn, String tl,String bd, String ed, String gb)
    {
    	
    	patient_id = pid;
		treatment_type= ttype;
	    treatment_name = tn;
	    treatment_length = tl;
	    begin_date = bd;
	    end_date = ed;
	    given_by = gb;
	  
    	
    }
    
    public Treatment()
    {
    	
    }
    public int getID()
    {
    	return id;
    }
    public int getpatientID()
    {
    	return patient_id;
    }
    public TreatmentType gettreatmenttype()
    {
    	return treatment_type;
    }
    public Dosage getdosage()
    {
    	return dosage;
    }
    public String gettreatmentname()
    {
    	return treatment_name;
    }
    public String gettreatmentLength()
    {
    	return treatment_length;
    }
    public String geteffects()
    {
    	return effects;
    }
    public String getbeginDate()
    {
    	return begin_date;
    }
    public String getEndDate()
    {
    	return end_date;
    }
    public String getNotes()
    {
    	return notes;
    }
    public String getDoc()
    {
    	return given_by;
    }
    public static int add(Treatment tin)
    {
 	   int status = 0;
 	   String sqlString= "insert into hospital.Treatment(patient_id, treatment_type, dosage, treatment_name, treatment_length, effects, begin_date, end_date, notes, given_by) values(\'" +tin.getpatientID()+ 
 	 	 	  "\', \'"+tin.gettreatmenttype().getID()+ 
 	 	   "\', \'"+tin.getdosage().getID() + 
 			"\', \'"+ tin.gettreatmentname()+ "\', \'"  + tin.gettreatmentLength()+ 
             "\', \'" + tin.geteffects() +  
 	   		"\', \'" + tin.getbeginDate()+
 	   	    "\', \'" + tin.getEndDate()+
 	     	 "\', \'"+tin.getNotes()+
 	     	"\', \'" + tin.getDoc()+"\')";
 	   status = databaseUpdate(sqlString);
            System.out.print(sqlString);              
 	   return status;
    }
    public static int add1(Treatment tin)
    {
 	   int status = 0;
 	   String sqlString= "insert into hospital.Treatment(patient_id, treatment_type, treatment_name, treatment_length, begin_date, end_date, notes) values(\'" +tin.getpatientID()+ 
 	 	 	  "\', \'"+tin.gettreatmenttype().getID()+ 
 			"\', \'"+ tin.gettreatmentname()+ "\', \'"  + tin.gettreatmentLength()+ 
 	   		"\', \'" + tin.getbeginDate()+
 	   	    "\', \'" + tin.getEndDate()+
 	     	 "\', \'"+tin.getNotes()+
 	     	"\', \'" + tin.getDoc()+"\')";
 	   status = databaseUpdate(sqlString);
            System.out.print(sqlString);              
 	   return status;
    }
    
    public static Treatment getTreatment(int searchNo)
    {
       Treatment foundTreatment= new Treatment();
       try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection(url,userName,password);
          statement=conn.createStatement();
          resultSet=statement.executeQuery("select * from hospital.Treatment where hospital.Treatment.id=" + searchNo);
                  
          while ( resultSet.next() )      {
        	  
             foundTreatment = new Treatment( 
            		            resultSet.getInt("patient_id"),
            		            TreatmentType.getTypeByID(resultSet.getInt("id")),
            		    	    Dosage.getDosageByID(resultSet.getInt("id")),
            		    	    resultSet.getString("treatment_name"),
            		    	    resultSet.getString("treatment_length"),
            		    	    resultSet.getString("effects"),
            		    	    resultSet.getString("begin_date"),
            		    	    resultSet.getString("end_date"),
            		    	    resultSet.getString("notes"),
            		    	    resultSet.getString("given_by").toString() );                 
          }   
          conn.close();
       } 
       catch (Exception e) {
          e.printStackTrace();
       }  
       return foundTreatment;
    }
    public static int updateTreatment(int IDNoIn, String treatName,String treatLength, String beginDate, String EndDate, String Doctor)   {
        int status = 0;
        String sqlString="update hospital.Treatment set treatment_name=\'"+treatName+"',treatment_length = '"+treatLength+"',begin_date = '"+beginDate+
		        "',end_date = '"+EndDate + "',given_by = '"+Doctor +"\' where id="+IDNoIn;
        System.out.println("-"+sqlString+"-");
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
