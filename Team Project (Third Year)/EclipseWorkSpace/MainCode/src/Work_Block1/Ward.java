package Work_Block1;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
public class Ward extends Patient
{
	//class attributes////////////
  private int id;
  private String ward_name;
  private String room_type;
  private int bed_number;
  private int bed_free;
  
  //Database variables/////////////////
  private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
  private String driver = "com.mysql.jdbc.Driver";
  private static String userName = "root";
  private static String password = "password";
  private static Statement statement = null;
  private static ResultSet resultSet = null;
  ////////////constructor/////////////
  public Ward(int idin, String Wardn, String roomT, int bedNum, int bedFree)
  {
	  super();
	  id = idin;
	  ward_name = Wardn;
	  room_type = roomT;
	  bed_number = bedNum;
	  bed_free = bedFree;
	 
  }
  public Ward()
  {
	  
  }
  ////////////////accessor elements//////////
  public int getid()
  {
	  return id;
  }
  public String getward_name()
  {
	  return ward_name;
  }
  public String getroom_type()
  {
	  return room_type;
  }
  public int getbed_number()
  {
	  return id;
  }
  public int getbed_free()
  {
	  return id;
  }
  ///////////search ward//////////////////
  public Ward search(int searchNum)
  {
	  Ward ward = new Ward();
	   try{
		   Class.forName("com.mysql.jdbc.Driver");
		   Connection conn = DriverManager.getConnection(url, userName, password);
		   resultSet=statement.executeQuery("select * from hospital.Patient where hospital.Person.host_id=" + ward);
		   while( resultSet.next());
		   {
			   ward = new Ward(resultSet.getInt("id"),
			                   resultSet.getString("ward_name"),
			                   resultSet.getString("room_type"),
			                   resultSet.getInt("bed_number"),
			                   resultSet.getInt("bed_free"));
		   }
		   conn.close();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return ward;
  }
  ///////////view all wards//////////////
  public static ArrayList<Ward> viewAllWards()
  {
	  ArrayList<Ward> AllWards = new ArrayList<Ward>();
	  try{
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection conn = DriverManager.getConnection(url,userName, password);
		  statement = conn.createStatement();
		  resultSet = statement.executeQuery("select * from hospital.Ward");
		  
		  while(resultSet.next ())
		  {
			  Ward nextWard = new Ward(resultSet.getInt("id"),
							           resultSet.getString("ward_name"),
							           resultSet.getString("room_type"),
							           resultSet.getInt("bed_number"),
							           resultSet.getInt("bed_free"));
			  AllWards.add(nextWard);
		  }
	  conn.close();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	   return AllWards; 
	}
  ///////////////////////add to ward///////////////
  public static int assignWard(Ward ward, String patientid)
  {
	   int status = 0;
	   ward.bed_free--;
	   String sqlString= "update patient set ward_id= "
	   		+ward.id+" where id="+patientid;
	   status = databaseUpdate(sqlString);
                         
	   return status;  
  }

  /////////////////update bed////////////
  public static int updateBedNb(Ward ward, Boolean ar)
  {
	   int status = 0;
	   if (ar)
		   ward.bed_free--;
	   else
		   ward.bed_free++;
	   String sqlString= "update ward set bed_free="+ward.bed_free+" where id="+ward.id;
	   status = databaseUpdate(sqlString);
                         
	   return status;  
  }
  ////////////remove form ward////////////////
  public static int removeFromWard(String string)
  {
	   int status = 0;
	   String sqlString= "update patient set ward_id=null where id="+string;
	   status = databaseUpdate(sqlString);
                         
	   return status;  
  }

///////////database update/////////////////
  private static int databaseUpdate(String sqlUpdate)
  {
     int status=0;
  
     try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,userName,password);
        statement=conn.createStatement();
        status=statement.executeUpdate(sqlUpdate);
        conn.close(); 
     }       
      
     catch (Exception e) {
        e.printStackTrace();
     }   
     return status;
  }
  
  public static Ward getWardByID(int wardID)
  {
	  Ward ward = new Ward();
	  ArrayList<Ward> AllWards = new ArrayList<Ward>();
	  AllWards=viewAllWards();
	  for(Ward w : AllWards) { 
		  	if(w.id == wardID)
		  		ward = w;
		   }
	  return ward;
  }
  
  public String toString(){
	   return this.id+" "+" "+this.ward_name;
  }
}
