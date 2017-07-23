package Work_Block1;
import java.sql.*;


import java.util.ArrayList;
import java.util.Date;
public class Patient
{
	//Class attributes variables	
	private int id;

	private String first_name;
	private String last_name;
	private String DOB;
	private String address;
	private String email;
	private String phone_Nb;	
	private String PPSN;
	private String religion;
	private String next_of_kin;
	private String next_of_kin_pn;
	private String allergy;
	private String history;
	private String referral;
	private ReferralClass referral_class;
	private Ward ward;
	private String  date_of_admisson;
	private String length_of_stay;



	//Database variables
	private static String url = "jdbc:mysql://localhost:3306/Hospital?autoReconnect=true&useSSL=false";
	private String driver = "com.mysql.jdbc.Driver";
	private static String userName = "root";
	private static String password = "password";
	private static Statement statement = null;
	private static ResultSet resultSet = null;


	//constructor
	public Patient(/*int iDin,*/ String fn, String ln, String dob, String ad,String em, String  pn,String patientPPS, String rel,
			String nokIn, String nokpn, String allerIN, String histin, String reffIn, ReferralClass reffCIn, String doa, String los)
	{
		/*id = iDin;*/
		first_name = fn;
		last_name=ln;
		DOB=dob;
		address=ad;
		email=em;
		phone_Nb=pn;
		PPSN=patientPPS;
		religion = rel;
		next_of_kin=nokIn;
		next_of_kin_pn = nokpn;
		allergy=allerIN;
		history=histin;
		referral=reffIn;
		referral_class=reffCIn;
		date_of_admisson = doa;
		length_of_stay = los;


	}

	public Patient(int iDin, String fn, String ln, String dob, String ad,String em, String  pn,String patientPPS, String rel,
			String nokIn, String nokpn, String allerIN, String histin, String reffIn, ReferralClass reffCIn,Ward wid, String doa, String los)
	{
		id = iDin;
		first_name = fn;
		last_name=ln;
		DOB=dob;
		address=ad;
		email=em;
		phone_Nb=pn;
		PPSN=patientPPS;
		religion = rel;
		next_of_kin=nokIn;
		next_of_kin_pn = nokpn;
		allergy=allerIN;
		history=histin;
		referral=reffIn;
		referral_class=reffCIn;
		ward=wid;
		date_of_admisson = doa;
		length_of_stay = los;



	}
	public Patient()
	{

	}
	//Accessor methods
	public int getID()
	{
		return id;
	}
	public String getfirst_name()
	{
		return first_name;
	}
	public String getlastName()
	{
		return last_name;
	}
	public String getDOB()
	{
		return DOB;
	}
	public String getAddress()
	{
		return address;
	}
	public String getemail()
	{
		return email;
	}
	public String getphone_nb()
	{
		return phone_Nb;
	}
	public String getPPS()
	{
		return PPSN;
	}
	private String getReligion()
	{
		return religion;
	}
	public String getkin()
	{
		return next_of_kin;
	}
	public String getkin_pn()
	{
		return next_of_kin_pn;
	}
	public String Getallergy()
	{
		return allergy;
	}
	public String GetHistory()
	{
		return history;
	}
	public String GetRefferal()
	{
		return referral;
	}
	public ReferralClass GetRefferalClass()
	{
		return referral_class;
	}
	public Ward WardID()
	{
		return ward;
	}
	public String getdateOfAdmisson()
	{
		return  date_of_admisson;
	}
	public String getlengthOfStay()
	{
		return length_of_stay;  
	}

	//database access and update methods
	//ADD//
	public int add(Patient Pin)
	{

		int status = 0;
		String sqlString= "insert into hospital.Patient(first_name, last_name, DOB, address, email, phone_Nb, PPSN,religion, next_of_kin, next_of_kin_pn, allergy, history, referral, referral_class, date_of_admisson,length_of_stay ) values(\'"+Pin.getfirst_name() + 
				"\', \'"+ Pin.getlastName()+ "\', \'" + Pin.getDOB() + "\', \'" + Pin.getAddress()+ 
				"\', \'" + Pin.getemail() + "\', \'"+ Pin.getphone_nb() + "\', \'" +Pin.getPPS() + "\', \'"+ Pin.getReligion() + "\', \'" +Pin.getkin() + "\', \'"+ Pin.getkin_pn() + "\', \'" + Pin.Getallergy()+ "\', \'" + Pin.GetHistory() + "\', \'" + Pin.GetRefferal()+ 
				"\', \'" + Pin.GetRefferalClass().getID()+ "\', \'"+Pin.getdateOfAdmisson() + "\', \'"+Pin.getlengthOfStay() +"\')";
		status = databaseUpdate(sqlString);
		System.out.print(sqlString);              
		return status;
	}
	//Veiw all patients 
	public static ArrayList<Patient> viewAllPatients()
	{
		ArrayList<Patient> AllPatients = new ArrayList<Patient>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, userName, password);
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from hospital.Patient");

			while(resultSet.next ())
			{
				Patient nextPatient = new Patient(resultSet.getInt("id"),
						resultSet.getString("first_name"),
						resultSet.getString("last_name"),
						resultSet.getString("DOB"),
						resultSet.getString("address"),
						resultSet.getString("email"),
						resultSet.getString("phone_Nb"),
						resultSet.getString("PPSN"),
						resultSet.getString("religion"),
						resultSet.getString("next_of_kin"),
						resultSet.getString("next_of_kin_pn"),
						resultSet.getString("allergy"),
						resultSet.getString("history"),
						resultSet.getString("referral"),
						ReferralClass.getReferralClassByID( resultSet.getInt("id")) ,
						Ward.getWardByID(resultSet.getInt("ward_id")),
						resultSet.getString("date_of_admisson"),
						resultSet.getString("length_of_stay"));
				AllPatients.add(nextPatient);
			}
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return AllPatients; 
	}
////////search for a certain patient/////////
	public static Patient getPatient(int searchNo)
    {
       Patient foundPatient= new Patient();
       try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection(url,userName,password);
          statement=conn.createStatement();
          resultSet=statement.executeQuery("select * from hospital.Patient where hospital.Patient.id=" + searchNo);
                  
          while ( resultSet.next() )      {
             foundPatient = new Patient(resultSet.getInt("id"),
						resultSet.getString("first_name"),
						resultSet.getString("last_name"),
						resultSet.getString("DOB"),
						resultSet.getString("address"),
						resultSet.getString("email"),
						resultSet.getString("phone_Nb"),
						resultSet.getString("PPSN"),
						resultSet.getString("religion"),
						resultSet.getString("next_of_kin"),
						resultSet.getString("next_of_kin_pn"),
						resultSet.getString("allergy"),
						resultSet.getString("history"),
						resultSet.getString("referral"),
						ReferralClass.getReferralClassByID(resultSet.getInt("id")),
						Ward.getWardByID(resultSet.getInt("ward_id")),
						resultSet.getString("date_of_admisson"),
						resultSet.getString("length_of_stay").toString());                 
          }   
          conn.close();
       } 
       catch (Exception e) {
           e.printStackTrace();
        }  
        return foundPatient;
     }

	public static int updatePatient(int IDNoIn, String history)   {
		int status = 0;
		String sqlString="update hospital.Patient set history=\'"+history+ "\' where id="+IDNoIn;
		status = databaseUpdate(sqlString);                                           

		return status;
	}

	private static int databaseUpdate(String sqlUpdate)
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
		return "\n" +" ID: "+this.id+" "+" "+this.first_name+" "+ " "+this.last_name+" "+" "+this.PPSN+" "+" "+this.ward;
	}
}
