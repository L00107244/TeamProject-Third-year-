package Work_Block2_Doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class TreatmentType
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
	   
	   //constructor
	   public TreatmentType(int ID, String t)
	   {
		   id = ID;
		   type=t;	   
	   }
	   
	 
	   public TreatmentType()
	   {
		   
	   }
	 //Accessor methods
	   public int getID()
	   {
		   return id;
	   }
	   public String getType()
	   {
		   return type;
	   }
	   public static TreatmentType getTypeByID(int typeID)
	   {
		   TreatmentType type = new TreatmentType();
	 	  ArrayList<TreatmentType> Alltypes = new ArrayList<TreatmentType>();
	 	  Alltypes=viewAlltypes();
	 	  for(TreatmentType t : Alltypes) { 
	 		  	if(t.id == typeID)
	 		  		type = t;
	 		   }
	 	  return type;
	   }
	   public static ArrayList<TreatmentType> viewAlltypes()
	   {
		  ArrayList<TreatmentType> Alltypes = new ArrayList<TreatmentType>();
		  try{
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection conn = DriverManager.getConnection(url,userName, password);
			  statement = conn.createStatement();
			  resultSet = statement.executeQuery("select * from hospital.Treatment_type");
			  
			  while(resultSet.next ())
			  {
				  TreatmentType nextType = new TreatmentType( resultSet.getInt("id"),
								                  resultSet.getString("type"));
				  Alltypes.add(nextType);
			  }
			  conn.close();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		   return Alltypes;
	   }
	   public String toString(){
		   return this.id+" "+this.type;
	  }
	
	
}
