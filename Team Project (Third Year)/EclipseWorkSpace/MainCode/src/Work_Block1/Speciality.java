package Work_Block1;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class Speciality
{
	private int id;
	private String speciality;
	
	   //Database variables
	   private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
	   private String driver = "com.mysql.jdbc.Driver";
	   private static String userName = "root";
	   private static String password = "password";
	   private static Statement statement = null;
	   private static ResultSet resultSet = null;
	   
	 //constructor
	   public Speciality(int ID, String spec)
	   {
		   id = ID;
		   speciality=spec;	   
	   }
	   
	 
	   public Speciality()
	   {
		   
	   }
	   //Accessor methods
	   public int getID()
	   {
		   return id;
	   }
	   public String getSpeciality()
	   {
		   return speciality;
	   }
	   
	   public static Speciality getSpecialityByID(int specialityID)
	   {
		   Speciality special = new Speciality();
	 	  ArrayList<Speciality> Allspecialities = new ArrayList<Speciality>();
	 	 Allspecialities=viewAllspecialities();
	 	  for(Speciality t : Allspecialities) { 
	 		  	if(t.id == specialityID)
	 		  		special = t;
	 		   }
	 	  return special;
	   }
	   public static ArrayList<Speciality> viewAllspecialities()
	   {
		  ArrayList<Speciality> Allspecialities = new ArrayList<Speciality>();
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection conn = DriverManager.getConnection(url,userName, password);
			  statement = conn.createStatement();
			  resultSet = statement.executeQuery("select * from hospital.speciality");
			  
			  while(resultSet.next ())
			  {
				  Speciality nextspecial = new Speciality( resultSet.getInt("id"),
								                  resultSet.getString("speciality"));
				  Allspecialities.add(nextspecial);
			  }
			  conn.close();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		   return Allspecialities;
	   }
	   public String toString(){
		   return this.id+" "+this.speciality;
	  }
}
