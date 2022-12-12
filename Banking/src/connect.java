
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

 public class connect {

	static Connection connection = null;
	static Statement statement = null;
	static String username ="Student";
	static String password="root";
//	static {
//		//StudentCreateTable.getConnection();
//		System.out.println("Started...");
//	}
	

	public static Connection  getConnections(String dbName ,String username ,String password) {
		
	
		try {
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e)
			{
				System.out.println(e);
			}
		String url ="jdbc:mysql://localhost:3306/"+dbName+"";
//		 username ="Student";
//		 password="root";
	
		// create connection 
		try {
		 connection =DriverManager.getConnection(url,username,password);
		 if(connection.isClosed()) {
			 System.out.println("yes yes.");
		 }
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		
	// Create statement 
		
		try {
			statement = connection.createStatement();
			
		} catch (SQLException e) {

				System.out.println(e);
		}	
		
		return connection;
	}
}
