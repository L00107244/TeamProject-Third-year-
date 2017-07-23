package Work_Block2_Doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class Dosage
{
	private int id;
	private String dosage;
	
	  //Database variables
	   private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
	   private String driver = "com.mysql.jdbc.Driver";
	   private static String userName = "root";
	   private static String password = "password";
	   private static Statement statement = null;
	   private static ResultSet resultSet = null;
	   
	   
	   //constructor
	   public Dosage(int ID, String D)
	   {
		   id = ID;
		   dosage=D;	   
	   }
	   
	 
	   public Dosage()
	   {
		   
	   }
	 //Accessor methods
	   public int getID()
	   {
		   return id;
	   }
	   public String getDosage()
	   {
		   return dosage;
	   }
	   public static Dosage getDosageByID(int DosageID)
	   {
		   Dosage dosage = new Dosage();
	 	  ArrayList<Dosage> AllDosages = new ArrayList<Dosage>();
	 	  AllDosages=viewAllDosages();
	 	  for(Dosage t : AllDosages) { 
	 		  	if(t.id == DosageID)
	 		  		dosage = t;
	 		   }
	 	  return dosage;
	   }
	   public static ArrayList<Dosage> viewAllDosages()
	   {
		  ArrayList<Dosage> Alldosages = new ArrayList<Dosage>();
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection conn = DriverManager.getConnection(url,userName, password);
			  statement = conn.createStatement();
			  resultSet = statement.executeQuery("select * from hospital. Dosage");
			  
			  while(resultSet.next ())
			  {
				  Dosage nextdosage = new Dosage( resultSet.getInt("id"),
								                  resultSet.getString("dosage"));
				  Alldosages.add(nextdosage);
			  }
			  conn.close();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		   return  Alldosages;
	   }
	   public String toString(){
		   return this.id+" "+this.dosage;
	  }
}
