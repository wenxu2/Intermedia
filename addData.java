import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.ResultSetMetaData;

public class addData{
	
	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";
    
    
	public static void main(String[] args) 
		{	
		
		
		//connect with the database GradeBook
		//
		//
		try
		{
			Class.forName(driver).newInstance();
		}
		catch (Exception err)
		{
			System.err.println("Unable to load the embedded driver.");
			err.printStackTrace(System.err);
			System.exit(0);
        }
		
        String dbName = "GradeBook";
        Connection conn = null;
        
        try
        {
        	conn = DriverManager.getConnection(protocol + dbName);
        
			Student s = new Student();
			
			//add records to Student 1
        	Student s1 = new Student();
			s1.addGrade("Michale W",879872, "Homewwork1", 98);
			s1.addGrade("Michale W",879872, "Project 1", 70);
			s1.addGrade("Michale W",879872, "Exam 1   ", 68);
        	
			//add record to Student 2 
			Student s2 = new Student();
	        s2.addGrade("Kenn Jogn",987772, "Homework1", 78);
			s2.addGrade("Kenn Jogn",987772, "Project 1", 90);
			s2.addGrade("Kenn Jogn",987772, "Exam 1   ", 88);
			
			
			//Student 3
			Student s3 = new Student();
			s3.addGrade("Mary Key",987972, "Homework1", 79);
			s3.addGrade("Mary Key",987972, "Project 1", 91);
			s3.addGrade("Mary Key",987972, "Exam 1   ", 97);
			
			
			//Student 4
			Student s4 = new Student();	
			s4.addGrade("Sarah Wong",878833, "Homework1", 79);
			s4.addGrade("Sarah Wong",878833, "Project 1", 91);
			s4.addGrade("Sarah Wong",878833, "Exam 1   ", 77);
			
			
			System.out.println("DATA INSERTED SUCCESSFULLY!");
			
			conn.close();
			
        	}catch (SQLException err){
        		System.out.println("Error");
        		err.printStackTrace(System.err);
        	}
		}
	}
