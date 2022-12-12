package JDBC_Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


//1.Load Driver
//2.Create Connection
//3.Create Query
//4.Execute Query
//5.close Connection

public class jdbc1 {
	public static void main(String[] args)   {
		Scanner sc =  new Scanner(System.in);
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		String url= "jdbc:mysql://localhost:3306/Student";
		String username = "Student";
		String password = "root";
		ResultSet rs = null;
		Statement statement = null;
		try {
			
		//Create Connection
		Connection connection = DriverManager.getConnection(url,username,password);
		//Create Query
		 statement = connection.createStatement();
		 
		 rs =  statement.executeQuery("select *from qspider");
		 
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		try {
		//  load register
		
//		statement.execute("insert Into qspiders(name ,loc) VALUES('"+name+"','"+loc+"')");
		
	while(	rs.next())
		{
		System.out.print(rs.getInt("id"));
		System.out.print("\t"+rs.getString("name"));
		System.out.println("\t"+rs.getString("loc"));
		
		}
		
	char ch ='y';
		
		while(ch=='y') {					System.out.println("Insert:");		System.out.println("Enter the name");		String name= sc.next();		System.out.println("Enter the location:");		String loc= sc.next();		statement.execute("insert Into qspider(name ,loc) VALUES('"+name+"','"+loc+"')");//	 	statement.executeUpdate();		System.out.println("Do want to countinue?:");		ch=sc.next().charAt(0);				 		}
	while(ch=='y') {
		
		System.out.println("Updated:");
		System.out.print("Enter the name");
		String name= sc.next();
		System.out.print("Enter the id:");
		int id= sc.nextInt();
		statement.execute("UPDATE  QSPIDER  SET id = "+id+" WHERE name='"+name+"'");
		
		rs = statement.executeQuery("Select *from qspider");
		
		while(	rs.next())
		{ 
		System.out.print(rs.getInt("id"));
		System.out.print("\t"+rs.getString("name"));
		System.out.println("\t"+rs.getString("loc"));
		
		}
		System.out.println("Do want to countinue?:");
		ch=sc.next().charAt(0);
	}
	System.out.println("DELETE:");
	System.out.print("Enter the id:");
	int id= sc.nextInt();
	statement.execute("DELETE FROM QSPIDER WHERE ID='"+id+"'");
	 rs = statement.executeQuery("SELECT * FROM QSPIDER");
	while(	rs.next())
	{ 
	System.out.print(rs.getInt("id"));
	System.out.print("\t"+rs.getString("name"));
	System.out.println("\t"+rs.getString("loc"));
	
	}
	}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
//			PreparedStatement or CallableStatement
		}
	}
}




/*
 * 
 * 
 * 
 * 
 * 
 */
	
		
		
		