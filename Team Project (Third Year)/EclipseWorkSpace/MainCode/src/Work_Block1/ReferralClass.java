package Work_Block1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
public class ReferralClass {
	
	private int id; 
	private String rf;



		   
		   //Database variables
		   private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
		   private String driver = "com.mysql.jdbc.Driver";
		   private static String userName = "root";
		   private static String password = "password";
		   private static Statement statement = null;
		   private static ResultSet resultSet = null;

		   
		   //constructor
		   public ReferralClass(int ID, String r)
		   {
			   id = ID;
			   rf=r;	   
		   }
		   public ReferralClass()
		   {
			   
		   }
		 
		  
		   //Accessor methods
		   public int getID()
		   {
			   return id;
		   }
		   public String getreferralclass()
		   {
			   return rf;
		   }
		   
		   public static ReferralClass getReferralClassByID(int referralCID)
		   {
			   ReferralClass refC = new ReferralClass();
		 	  ArrayList<ReferralClass> AllrefC = new ArrayList<ReferralClass>();
		 	  AllrefC=viewAllReferralClass();
		 	  for(ReferralClass t : AllrefC) { 
		 		  	if(t.id == referralCID)
		 		  		refC = t;
		 		   }
		 	  return refC;
		   }
		   
		   public static ArrayList<ReferralClass> viewAllReferralClass()
		   {
			  ArrayList<ReferralClass> AllGender = new ArrayList<ReferralClass>();
			  try{
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection conn = DriverManager.getConnection(url,userName, password);
				  statement = conn.createStatement();
				  resultSet = statement.executeQuery("select * from hospital.referral_class");
				  
				  while(resultSet.next ())
				  {
					  ReferralClass nextReferralClass = new ReferralClass( resultSet.getInt("id"),
									                  resultSet.getString("rf"));
					  AllGender.add(nextReferralClass);
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
			   return this.id+" "+this.rf;
		  }

}
