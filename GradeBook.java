import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//This file create a GradeBook database

public class GradeBook{
	
	public static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String protocol = "jdbc:derby:";

	public static void main(String[] args) {
		
		try
		{
			Class.forName(driver).newInstance();
			System.out.println("Loaded the embedded driver.");
		}
		catch (Exception err)  
		{
			System.err.println("Unable to load the embedded driver.");
			err.printStackTrace(System.err);
			System.exit(0);
        }
		
		String dbName = "GradeBook";
		Connection conn = null;
		try{

			System.out.println("Connecting to and creating the database...");
        	conn = DriverManager.getConnection(protocol + dbName + ";create=true");
			System.out.println("Database created.");

			// Create a statement object for running SQL statements
			Statement s = conn.createStatement();
			s.execute("Create Table GradeBook"+
						"(name varchar(50), ID int, Assignment varchar(50), Grade int)");

		}
		catch (SQLException err)
		{
			System.err.println("SQL error.");
			err.printStackTrace(System.err);
			System.exit(0);
		}	
		
	}

}
