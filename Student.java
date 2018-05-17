import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class Student{

	private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String protocol = "jdbc:derby:";
    		
    
	static String studentName;
	static int StudentID;
	int nextStudent;
	Connection conn = null;
	static Statement s = null;
	   
	public Student(){
		studentName = "";
		StudentID = 0;
		
	}
	
	public Student(String a, int b){
		a = studentName;
		b = StudentID;		
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}
	
	public int getStudentID() {
		return StudentID;
	}
	
	//Connect to the database 
	private Connection connect(){
		
		String dbName = "GradeBook";
		try {
			conn = DriverManager.getConnection(protocol + dbName);
			Statement s = conn.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}

	//addGrade method
	public  void addGrade(String name, int ID, String Assignment, int grade) throws SQLException{
			
			//String name, int ID,
			String sql = "INSERT Into GradeBook(name,ID, Assignment,Grade) VALUES(?,?,?,?)";
			//String name;
			//int ID;
			
			try(Connection conn = this.connect();
					PreparedStatement ps = conn.prepareStatement(sql)){
				
				//String name1 = null;
				//int ID1 = null;
				
				ps.setString(1, name);
				ps.setInt(2, ID);
				ps.setString(3, Assignment);
				ps.setInt(4, grade);
				ps.executeUpdate();
			
				conn.close();
				ps.close();
				
			}catch(SQLException e){
				System.out.println(e.getMessage());
		}
			
			
	}
	
	//display the databse and the grade that was added
	public  static void displayGrades(ResultSet rs) throws SQLException{
		
		studentName = rs.getString("Name");
		StudentID = rs.getInt("ID");
		String assign = rs.getString("Assignment");
		int grade = rs.getInt("Grade");
		System.out.println(assign +"\t\t"+grade);		
	}
	
	
	public void findGrade(String Assignment) throws SQLException{
		
		String sql3 = "SELECT Assignment,Grade "
					+" FROM GradeBook "
					+" WHERE Assignment = ? ";
		
		try(Connection conn = this.connect();
			PreparedStatement ps = conn.prepareStatement(sql3)){
			
			ps.setString(1, Assignment);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("\n"+"Print all Grade: ");
			while(rs.next()){
				System.out.println(rs.getString("Assignment")+"\t\t"+
									rs.getInt("Grade"));
			}
			
		}
	}
				
	
		
	public  void modifyGrade(int grade,int id,String assignment) throws SQLException{
		
		String sql = " UPDATE GradeBook "
					+" SET grade = ?  "
					+" WHERE ID = ? "
					+ " AND assignment = ? ";
		
		try(Connection conn = this.connect();
			PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setInt(1, grade);
			ps.setInt(2, id);
			ps.setString(3, assignment);
			
			ps.executeUpdate();
			
		}
		System.out.println("\nUPDATE SUCCESSFULLY");
		
		
		
	}
	
	public void calculateAvg(int id) throws SQLException{
		String sql = "SELECT avg(GRADE) FROM GradeBook"
					+ " WHERE ID = ? ";
		
		try(Connection conn = this.connect();
				PreparedStatement ps = conn.prepareStatement(sql)){
			
			ps.setInt(1, id);
			
			ResultSet rs1 = ps.executeQuery();
			
			if(rs1.next()){
				System.out.println("\n"+"Average grade is : "+rs1.getFloat(1));
			}
		}	
		
			
	} 

	
	
}

