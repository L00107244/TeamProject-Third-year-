package Work_Block1;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;
	
	public class Title {
		private int id;
		private String title;
		   
		   //Database variables
		   private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
		   //private static String dbName = "Hospital";
		   private String driver = "com.mysql.jdbc.Driver";
		   private static String userName = "root";
		   private static String password = "password";
		   private static Statement statement = null;
		   private static ResultSet resultSet = null;
		   
		   //constructor
		   public Title(int ID, String t)
		   {
			   id = ID;
			   title=t;	   
		   }
		   
		 
		   public Title()
		   {
			   
		   }
		   //Accessor methods
		   public int getID()
		   {
			   return id;
		   }
		   public String getTitle()
		   {
			   return title;
		   }
		   
		   public static Title getTitleByID(int titleID)
		   {
			   Title title = new Title();
		 	  ArrayList<Title> AllTitles = new ArrayList<Title>();
		 	  AllTitles=viewAlltitles();
		 	  for(Title t : AllTitles) { 
		 		  	if(t.id == titleID)
		 		  		title = t;
		 		   }
		 	  return title;
		   }
		   
		   public static ArrayList<Title> viewAlltitles()
		   {
			  ArrayList<Title> AllGender = new ArrayList<Title>();
			  try{
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection conn = DriverManager.getConnection(url,userName, password);
				  statement = conn.createStatement();
				  resultSet = statement.executeQuery("select * from hospital.Title");
				  
				  while(resultSet.next ())
				  {
					  Title nextTitle = new Title( resultSet.getInt("id"),
									                  resultSet.getString("title"));
					  AllGender.add(nextTitle);
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
			   return this.id+" "+this.title;
		  }
		  
	}
	
	

