package Work_Block2_Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
public class Tests
{
	private int id;
	private int patient_id;
	private String test_type;
    private String  results; 
    private String test_date;
    private String seen_by;
    
	   //Database variables
 private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
// private static String dbName = "hospital";
 private String driver = "com.mysql.jdbc.Driver";
 private static String userName = "root";
 private static String password = "password"; 
 private static Statement statement = null;
 private static ResultSet resultSet = null;
    
    public Tests(int Pid,String tt, String result, String td, String sb)
    {
    	patient_id=Pid;
    	test_type = tt;
    	results = result;
    	test_date = td;
    	seen_by = sb;
    }
    public Tests(int idin, int Pid, String tt, String result, String td, String sb)
    {
    	id=idin;
    	patient_id=Pid;
    	test_type = tt;
    	results = result;
    	test_date = td;
    	seen_by = sb;
    }
    public Tests()
    {
    	
    }
    public int getID()
    {
    	return id;
    }
    public int getpatientID()
    {
    	return id;
    }
    public String getTestType()
    {
    	return test_type;
    }
    public String getResults()
    {
    	return results;
    }
    public String getTestDate()
    {
    	return test_date;
    }
    public String getDoc()
    {
    	return seen_by;
    }
    public static int add(Tests testIn)
    { 
 	   int status = 0;
 	   String sqlString= "insert into hospital.Tests(patient_id,test_type, results, test_date, seen_by) values(\'"+ testIn.getpatientID()+
  	 	 	  "\', \'" +testIn.getTestType()+ 
 	 	 	  "\', \'"+testIn.getResults()+
 	 	   "\', \'"+testIn.getTestDate() + 
 			"\', \'"+ testIn.getDoc()+ "\')";
 	   status = databaseUpdate(sqlString);
            System.out.print(sqlString);              
 	   return status;
    }
    public static Tests getTest(int searchNo)
    {
       Tests foundTest= new Tests();
       try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection(url,userName,password);
          statement=conn.createStatement();
          resultSet=statement.executeQuery("select * from hospital.Tests where hospital.Tests.id=" + searchNo);
       	        
          while ( resultSet.next() )      {
             foundTest = new Tests( resultSet.getInt("id"),
            		            resultSet.getInt("patient_id"),
            		            resultSet.getString("test_type"),
            		    	    resultSet.getString("results"),
            		    	    resultSet.getString("test_date"),
            		    	    resultSet.getString("seen_by").toString() );                 
          }   
          conn.close();
       } 
       catch (Exception e) {
           e.printStackTrace();
        }  
        return foundTest;
     }
    public static int updateTest(int IDNoIn, String tt, String result, String td, String sb )   
    {
        int status = 0;
        String sqlString="update hospital.Tests set test_type=\'"+tt+"',results = '"+result+"',test_date = '"+td+
        		        "',seen_by = '"+sb+"\' where id="+IDNoIn;
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
