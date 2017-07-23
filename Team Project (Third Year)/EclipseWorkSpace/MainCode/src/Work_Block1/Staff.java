package Work_Block1;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
public class Staff 
{

	

	public int id;
	public Title title;
	public Gender gender;
	public String first_name; 
	    public String last_name;  
	    public String address;
	    public String phone_Nb;
	    private String email;
	    public Speciality speciality;
	    private String staff_username;
	    private String staff_password;
	    
	    public static Staff connectedStaff;
	    public static Boolean isConnected=false;
	  
	    
	    //Database variables
	    //Database variables
	    private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
	    private String driver = "com.mysql.jdbc.Driver";
	    private static String username = "root";
	    private static String password = "password";
	    private static Statement statement = null;
	    private static ResultSet resultSet = null;
	  
	    
	    public Staff( Title t, Gender gen, String fn, String ln, String add, String pn, String em, Speciality sp,String user, String passwrd)
	    {
	   
	    title = t;
	    gender = gen; 
	    first_name = fn;
	    last_name = ln;
	    address = add;
	    phone_Nb = pn;
	    email = em;
	    speciality = sp;
	    staff_username=user;
	    staff_password=passwrd;
	    }
	    public Staff(int idin, Title t, Gender gen, String fn, String ln, String add, String pn, String em, Speciality sp,String user, String passwrd)
	    {
	    id=idin;
	    title = t;
	    gender = gen; 
	    first_name = fn;
	    last_name = ln;
	    address = add;
	    phone_Nb = pn;
	    email = em;
	    speciality = sp;
	    staff_username=user;
	    staff_password=passwrd;
	    }
	    public Staff()
	    {
	   
	    }
	    public int getID()
	    {
	    return id;
	    }
	    public Title gettitle()
	    {
	    return title;
	    }
	    public Gender getGender()
	    {
	    return gender;
	    }
	    public String getFirstName()
	    {
	    return first_name;
	    }
	    public String getLastName()
	    {
	    return last_name;
	    }
	    public String getAddress()
	    {
	    return address;
	    }
	    public String getPhoneNumber()
	    {
	    return phone_Nb;
	    }
	    public String getEmail()
	    {
	    return email;
	    }
	    public Speciality getSpeciality()
	    {
	    return speciality;
	    }
	    public String getUsername()
	    {
	    return staff_username;
	    }
	    public String getPassword()
	    {
	    return staff_password;
	    }
	    public static int add(Staff Sin)
	    {
	    int status = 0;
	    String sqlString= "insert into hospital.Staff(title, gender, first_name, last_name, address, phone_Nb, email,  speciality, username, Password) values(\'" +Sin.gettitle().getID()+ 
	   "\', \'"+Sin.getGender().getID()+ 
	    "\', \'"+Sin.getFirstName() + 
	  "\', \'"+ Sin.getLastName()+ "\', \'"  + Sin.getAddress()+ 
	             "\', \'" + Sin.getPhoneNumber() +  
	             "\', \'" + Sin.getEmail() +  
	    "\', \'" + Sin.getSpeciality().getID()+
	    "\', \'" + Sin.getUsername() +
	    "\', \'" + Sin.getPassword()+"\')";
	    status = databaseUpdate(sqlString);
	        System.out.print(sqlString); 
	        
	        if(status == 0) 
	        System.out.println("error");
	        return status;
	       
	    }
	    public static Staff getStaff(int searchNo)
	    {
	       Staff foundStaff= new Staff();
	       try{
	          Class.forName("com.mysql.jdbc.Driver");
	          Connection conn = DriverManager.getConnection(url,username,password);
	          statement=conn.createStatement();
	          resultSet=statement.executeQuery("select * from hospital.Staff where hospital.Staff.id=" + searchNo);
	                  
	          while ( resultSet.next() )      {
	             foundStaff = new Staff( resultSet.getInt("id"),
	                 Title.getTitleByID(resultSet.getInt("title")),
	                     Gender.getgenderByID( resultSet.getInt("gender")),
	             resultSet.getString("first_name"),
	             resultSet.getString("last_name"),
	             resultSet.getString("address"),
	             resultSet.getString("phone_Nb"),
	             resultSet.getString("email"),
	            Speciality.getSpecialityByID(resultSet.getInt("speciality")),
	             resultSet.getString("username"),
	             resultSet.getString("Password").toString() );                 
	          }   
	          conn.close();
	       } 
	       catch (Exception e) {
	          e.printStackTrace();
	       }  
	       return foundStaff;
	    }
	    public static ArrayList<Staff> viewAllStaff()
	    {
	   ArrayList<Staff> AllStaff = new ArrayList<Staff>();
	   try{
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection conn = DriverManager.getConnection(url,username, password);
	   statement = conn.createStatement();
	   resultSet = statement.executeQuery("select * from hospital.Staff");
	   
	   while(resultSet.next ())
	   {
	   Staff nextStaff = new Staff(resultSet.getInt("id"),
	                       Title.getTitleByID(resultSet.getInt("title")),
	                       Gender.getgenderByID( resultSet.getInt("gender")),
	               resultSet.getString("first_name"),
	               resultSet.getString("last_name"),
	               resultSet.getString("address"),
	               resultSet.getString("phone_Nb"),
	               resultSet.getString("email"),
	              Speciality.getSpecialityByID(resultSet.getInt("speciality")),
	               resultSet.getString("username"),
	               resultSet.getString("Password"));
	   AllStaff.add(nextStaff);
	   }
	   conn.close();
	   }
	   catch(Exception e)
	   {
	   e.printStackTrace();
	   }
	    return AllStaff; 
	  }
	    public static int delete(int staffNoIn)   {
	        int status=0;  
	        String sqlString= "delete from hospital.Staff where id=" + staffNoIn;     
	        status = databaseUpdate(sqlString);                                        
	        return status;
	     }
	    
	    private  static int databaseUpdate(String sqlUpdate)
	    {
	    int status = 0;
	    
	    try{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn = DriverManager.getConnection(url, username, password);
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
	    public String toString(){
	    return "\n" +"Staff ID :" +this.id +" "+ "Title :" +this.title.getTitle()+ " "+"First Name :" +  this.first_name+" "+"Last Name :" + this.last_name+" "+"Speciality :" +this.speciality. getSpeciality()+ " "+"Gender :" +this.gender.getgender()+"\t";
	    }
	    
	    
	   
	}


	/*package Prototype;
	import java.sql.*;
	import java.util.ArrayList;
	import java.util.Date;
	public class Staff 
	{

	public int id;
	public Title title;
	public Gender gender;
	public String first_name; 
	    public String last_name;  
	    public String address;
	    public String phone_Nb;
	    private String email;
	    public Speciality speciality;
	    private String username;
	    private String Password;
	  
	    
	    //Database variables
	    //Database variables
	    private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
	    private String driver = "com.mysql.jdbc.Driver";
	    private static String userName = "root";
	    private static String password = "password";
	    private static Statement statement = null;
	    private static ResultSet resultSet = null;
	  
	    
	    public Staff( Title t, Gender gen, String fn, String ln, String add, String pn, String em, Speciality sp,String user, String passwrd)
	    {
	   
	    title = t;
	    gender = gen; 
	    first_name = fn;
	    last_name = ln;
	    address = add;
	    phone_Nb = pn;
	    email = em;
	    speciality = sp;
	    username=user;
	    password=passwrd;
	    }
	    public Staff(int idin, Title t, Gender gen, String fn, String ln, String add, String pn, String em, Speciality sp,String user, String passwrd)
	    {
	    id=idin;
	    title = t;
	    gender = gen; 
	    first_name = fn;
	    last_name = ln;
	    address = add;
	    phone_Nb = pn;
	    email = em;
	    speciality = sp;
	    username=user;
	    password=passwrd;
	    }
	    public Staff()
	    {
	   
	    }
	    public int getID()
	    {
	    return id;
	    }
	    public Title gettitle()
	    {
	    return title;
	    }
	    public Gender getGender()
	    {
	    return gender;
	    }
	    public String getFirstName()
	    {
	    return first_name;
	    }
	    public String getLastName()
	    {
	    return last_name;
	    }
	    public String getAddress()
	    {
	    return address;
	    }
	    public String getPhoneNumber()
	    {
	    return phone_Nb;
	    }
	    public String getEmail()
	    {
	    return email;
	    }
	    public Speciality getSpeciality()
	    {
	    return speciality;
	    }
	    public String getUsername()
	    {
	    return username;
	    }
	    public String getPassword()
	    {
	    return password;
	    }
	    public int add(Staff Sin)
	    {
	    int status = 0;
	    String sqlString= "insert into hospital.Staff(title, gender, first_name, last_name, address, phone_Nb, email,  speciality, username, Password) values(\'" +Sin.gettitle().getID()+ 
	   "\', \'"+Sin.getGender().getID()+ 
	    "\', \'"+Sin.getFirstName() + 
	  "\', \'"+ Sin.getLastName()+ "\', \'"  + Sin.getAddress()+ 
	             "\', \'" + Sin.getPhoneNumber() +  
	             "\', \'" + Sin.getEmail() +  
	    "\', \'" + Sin.getSpeciality().getID()+
	    "\', \'" + Sin.getUsername() +
	    "\', \'" + Sin.getPassword()+"\')";
	    status = databaseUpdate(sqlString);
	        System.out.print(sqlString); 
	        
	        if(status == 0) 
	        System.out.println("error");
	        return status;
	       
	    }
	    public Staff getStaff(int searchNo)
	    {
	       Staff foundStaff= new Staff();
	       try{
	          Class.forName("com.mysql.jdbc.Driver");
	          Connection conn = DriverManager.getConnection(url,userName,password);
	          statement=conn.createStatement();
	          resultSet=statement.executeQuery("select * from hospital.Staff where hospital.Staff.id=" + searchNo);
	                  
	          while ( resultSet.next() )      {
	             foundStaff = new Staff( resultSet.getInt("id"),
	                 Title.getTitleByID(resultSet.getInt("title")),
	                     Gender.getgenderByID( resultSet.getInt("gender")),
	             resultSet.getString("first_name"),
	             resultSet.getString("last_name"),
	             resultSet.getString("address"),
	             resultSet.getString("phone_Nb"),
	             resultSet.getString("email"),
	            Speciality.getSpecialityByID(resultSet.getInt("speciality")),
	             resultSet.getString("username"),
	             resultSet.getString("Password").toString() );                 
	          }   
	          conn.close();
	       } 
	       catch (Exception e) {
	          e.printStackTrace();
	       }  
	       return foundStaff;
	    }
	    public static ArrayList<Staff> viewAllStaff()
	    {
	   ArrayList<Staff> AllStaff = new ArrayList<Staff>();
	   try{
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection conn = DriverManager.getConnection(url,userName, password);
	   statement = conn.createStatement();
	   resultSet = statement.executeQuery("select * from hospital.Staff");
	   
	   while(resultSet.next ())
	   {
	   Staff nextStaff = new Staff(resultSet.getInt("id"),
	                       Title.getTitleByID(resultSet.getInt("title")),
	                       Gender.getgenderByID( resultSet.getInt("gender")),
	               resultSet.getString("first_name"),
	               resultSet.getString("last_name"),
	               resultSet.getString("address"),
	               resultSet.getString("phone_Nb"),
	               resultSet.getString("email"),
	              Speciality.getSpecialityByID(resultSet.getInt("speciality")),
	               resultSet.getString("username"),
	               resultSet.getString("Password"));
	   AllStaff.add(nextStaff);
	   }
	   conn.close();
	   }
	   catch(Exception e)
	   {
	   e.printStackTrace();
	   }
	    return AllStaff; 
	  }
	    public static int delete(int staffNoIn)   {
	        int status=0;  
	        String sqlString= "delete from hospital.Staff where id=" + staffNoIn;     
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
	    public String toString(){
	    return this.title.getTitle()+ " " + this.gender.getgender()+" "+  this.first_name+" "+ this.last_name+" "+this.speciality. getSpeciality();
	    }
	    
	    
	   
	}*/


/*package Prototype;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
public class Staff 
{

	public int id;
	public Title title;
	public Gender gender;
	public String first_name; 
    public String last_name;  
    public String address;
    public String phone_Nb;
    private String email;
    public Speciality speciality;
    private String username;
    private String Password;
  
    
    //Database variables
    //Database variables
    private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
    private String driver = "com.mysql.jdbc.Driver";
    private static String userName = "root";
    private static String password = "password";
    private static Statement statement = null;
    private static ResultSet resultSet = null;
  
    
    public Staff( Title t, Gender gen, String fn, String ln, String add, String pn, String em, Speciality sp,String user, String passwrd)
    {
    	
    	 title = t;
    	 gender = gen; 
    	 first_name = fn;
    	 last_name = ln;
    	 address = add;
    	 phone_Nb = pn;
    	 email = em;
    	 speciality = sp;
    	 username=user;
    	 password=passwrd;
    }
    public Staff(int idin, Title t, Gender gen, String fn, String ln, String add, String pn, String em, Speciality sp,String user, String passwrd)
    {
    	 id=idin;
    	 title = t;
    	 gender = gen; 
    	 first_name = fn;
    	 last_name = ln;
    	 address = add;
    	 phone_Nb = pn;
    	 email = em;
    	 speciality = sp;
    	 username=user;
    	 password=passwrd;
    }
    public Staff()
    {
    	
    }
    public int getID()
    {
    	return id;
    }
    public Title gettitle()
    {
    	return title;
    }
    public Gender getGender()
    {
    	return gender;
    }
    public String getFirstName()
    {
    	return first_name;
    }
    public String getLastName()
    {
    	return last_name;
    }
    public String getAddress()
    {
    	return address;
    }
    public String getPhoneNumber()
    {
    	return phone_Nb;
    }
    public String getEmail()
    {
    	return email;
    }
    public Speciality getSpeciality()
    {
    	return speciality;
    }
    public String getUsername()
    {
    	return username;
    }
    public String getPassword()
    {
    	return password;
    }
    public int add(Staff Sin)
    {
 	   int status = 0;
 	   String sqlString= "insert into hospital.Staff(title, gender, first_name, last_name, address, phone_Nb, email,  speciality, username, Password) values(\'" +Sin.gettitle().getID()+ 
 	 	 	  "\', \'"+Sin.getGender().getID()+ 
 	 	   "\', \'"+Sin.getFirstName() + 
 			"\', \'"+ Sin.getLastName()+ "\', \'"  + Sin.getAddress()+ 
             "\', \'" + Sin.getPhoneNumber() +  
             "\', \'" + Sin.getEmail() +  
 	   		"\', \'" + Sin.getSpeciality().getID()+
 	   	"\', \'" + Sin.getUsername() +
 	   "\', \'" + Sin.getPassword()+"\')";
 	   status = databaseUpdate(sqlString);
        System.out.print(sqlString); 
        
        if(status == 0) 
        	System.out.println("error");
        return status;
 	      
    }
    public Staff getStaff(int searchNo)
    {
       Staff foundStaff= new Staff();
       try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection(url,userName,password);
          statement=conn.createStatement();
          resultSet=statement.executeQuery("select * from hospital.Staff where hospital.Staff.id=" + searchNo);
                  
          while ( resultSet.next() )      {
             foundStaff = new Staff( resultSet.getInt("id"),
            		      Title.getTitleByID(resultSet.getInt("title")),
	                      Gender.getgenderByID( resultSet.getInt("gender")),
			              resultSet.getString("first_name"),
			              resultSet.getString("last_name"),
			              resultSet.getString("address"),
			              resultSet.getString("phone_Nb"),
			              resultSet.getString("email"),
			             Speciality.getSpecialityByID(resultSet.getInt("speciality")),
			              resultSet.getString("username"),
			              resultSet.getString("Password").toString() );                 
          }   
          conn.close();
       } 
       catch (Exception e) {
          e.printStackTrace();
       }  
       return foundStaff;
    }
    public static ArrayList<Staff> viewAllStaff()
    {
  	  ArrayList<Staff> AllStaff = new ArrayList<Staff>();
  	  try{
  		  Class.forName("com.mysql.jdbc.Driver");
  		  Connection conn = DriverManager.getConnection(url,userName, password);
  		  statement = conn.createStatement();
  		  resultSet = statement.executeQuery("select * from hospital.Staff");
  		  
  		  while(resultSet.next ())
  		  {
  			  Staff nextStaff = new Staff(resultSet.getInt("id"),
  					                      Title.getTitleByID(resultSet.getInt("title")),
  					                      Gender.getgenderByID( resultSet.getInt("gender")),
  							              resultSet.getString("first_name"),
  							              resultSet.getString("last_name"),
  							              resultSet.getString("address"),
  							              resultSet.getString("phone_Nb"),
  							              resultSet.getString("email"),
  							             Speciality.getSpecialityByID(resultSet.getInt("speciality")),
  							              resultSet.getString("username"),
  							              resultSet.getString("Password"));
  			  AllStaff.add(nextStaff);
  		  }
  	  conn.close();
  	  }
  	  catch(Exception e)
  	  {
  		  e.printStackTrace();
  	  }
  	   return AllStaff; 
  	}
    public static int delete(int staffNoIn)   {
        int status=0;  
        String sqlString= "delete from hospital.Staff where id=" + staffNoIn;     
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
    public String toString(){
 	   return this.title.getTitle()+ " " + this.gender.getgender()+" "+  this.first_name+" "+ this.last_name+" "+this.speciality. getSpeciality();
    }
    
    
   
}*/
