package Work_Block2_Doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class bloodType
{
	private int id;
	private String type;
	
	   //Database variables
	   private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
	   private String driver = "com.mysql.jdbc.Driver";
	   private static String userName = "root";
	   private static String password = "password";
	   private static Statement statement = null;
	   private static ResultSet resultSet = null;
	   
	   public bloodType(int ID, String types)
	   {
		   id = ID;
		   type=types;	   
	   }
	   
	 
	   public bloodType()
	   {
		   
	   }
	   //Accessor methods
	   public int getID()
	   {
		   return id;
	   }
	   public String getTitle()
	   {
		   return type;
	   }
	   
	   public static bloodType getTypeByID(int typeID)
	   {
		   bloodType Type = new bloodType();
	 	  ArrayList<bloodType> AllTypes = new ArrayList<bloodType>();
	 	  AllTypes=viewAllTypes();
	 	  for(bloodType t : AllTypes) { 
	 		  	if(t.id == typeID)
	 		  		Type = t;
	 		   }
	 	  return Type;
	   }
	   public static ArrayList<bloodType> viewAllTypes()
	   {
		  ArrayList<bloodType> AllGender = new ArrayList<bloodType>();
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection conn = DriverManager.getConnection(url,userName, password);
			  statement = conn.createStatement();
			  resultSet = statement.executeQuery("select * from hospital.Blood_type");
			  
			  while(resultSet.next ())
			  {
				  bloodType nextType = new bloodType( resultSet.getInt("id"),
								                  resultSet.getString("type"));
				  AllGender.add(nextType);
			  }
			  conn.close();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		   return AllGender;
	   }
	   public String toString(){
		   return this.id+" "+this.type;
	  }
}
