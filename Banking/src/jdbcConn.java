


import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class jdbcConn extends connect {
	
	static Scanner sc =  new Scanner(System.in);
	// create Connetion
	static Connection connection  ;
			// Create Statement 
	static	Statement statement ;
	// prepare statement
	static PreparedStatement pstmt ;
//	
	//result Set
	static ResultSet rs ;
	
	static {
		connection = connect.getConnections("bank","root","root");
		try {
			statement = connection.createStatement();
			
		} catch (SQLException e) {

				System.out.println(e);
		}	
	}
		// get bank connection
	  static Connection getBankConnet(){
		connection = connect.getConnections("bank","root","root");
		try {
			statement = connection.createStatement();
			
		} catch (SQLException e) {

				System.out.println(e);
		}	
		return connection ;
	}
	// get mini connection
	  static Connection getMiniConnet(){
			connection = connect.getConnections("mini","root","root");
			try {
				statement = connection.createStatement();
				
			} catch (SQLException e) {

					System.out.println(e);
			}	
			return connection;
		}
		
	
// getting bank result set
	  static ResultSet getResult()
	{
		try {
			rs = statement.executeQuery("Select *from custDetails");
			}catch(SQLException e)
			{
				System.out.println(e);
			}
		
			return rs;
	}
	  // get mini result set
	  static ResultSet getMiniResult(String minitab)
		{
		  
			try {
				
				rs = statement.executeQuery("Select *from "+minitab+"");
				}catch(SQLException e)
				{
					System.out.println(e);
				}
			
				return rs;
		}
	  // get  statement
	  
	static Statement getStatement() {
		
		return statement ;
	}
	
	
	// display
		static boolean displayDetails(Create o) {
			
			
			
			try {
				  jdbcConn.getBankConnet();
			rs = statement.executeQuery("Select *from custDetails");
			}catch(SQLException e)
			{
				System.out.println(e);
			}
			String email = o.email;
			long pass = o.MobNo ;
			try {
			while(rs.next() ) {
				
				if(email.equalsIgnoreCase(rs.getString("email")) && pass == rs.getLong("mobile")) {
				System.out.println("  Account NO:\t"+rs.getLong("AC")); 
				System.out.print("       Name :\t"+rs.getString("fname"));
				System.out.println("\t"+rs.getString("lname"));
				System.out.println("       Email:\t"+rs.getString("email"));
				System.out.println("   Mobile No:\t"+rs.getString("mobile"));
				System.out.println("      Gender:\t"+rs.getString("gender"));
				System.out.println("  Birth Date:\t"+rs.getString("bdate"));
				System.out.println("      Gender:\t"+rs.getString("marriedStatus"));
				System.out.println("      Gender:\t"+rs.getString("type"));
				System.out.println("     Address:\t"+rs.getString("address"));
				System.out.println("      Gender:\t"+rs.getString("country"));
				System.out.println("      Gender:\t"+rs.getString("state"));
				System.out.println("        City:\t"+rs.getString("city"));
				System.out.println("     Balance:\t"+rs.getString("balance"));
				System.out.println("Account Type:\t"+rs.getString("accountMode"));
				System.out.println("***************************************************");
				}
			}
			
			}catch(Exception e) {
			
				System.out.println(e);
				
			}
			return true;
			
		} 
	
	  
	

static ResultSet getResultSet( long mobile ,String email) {
	
	ResultSet rs =null;
	 connection= getBankConnet();
	
	try{
		
		rs = jdbcConn.getResult();
    	 while(rs.next()) {
        long mob =rs.getLong("mobile");
        
        String usr1 =rs.getString("email");
    	

        if(mobile ==mob  && usr1.equalsIgnoreCase(email) ){
        	 
              break ;
         }
      }
     }
    catch(IndexOutOfBoundsException  e1)
    {
      System.out.println(" Don't have Customer Account Please Create New Account!...");
   }catch(NullPointerException e2){
  
    System.out.println("Invalid data !");
  }catch(Exception e){

    System.out.println("Error.......");
  }
	return rs;
}

static ResultSet getMiniResultSet( long mobile ,String email) throws SQLException {
	
	String tab="";
	
	
	boolean flag =false;
	
	
	
	try{                            
    	 while(rs.next()) {
        long mob =rs.getLong("mobile");
        
        String usr1 =rs.getString("email");
    	

        if(mobile ==mob  && usr1.equalsIgnoreCase(email) ){
        	 flag =true;
        	 tab= rs.getString("minitab");
              break ;
         }else {
        	 System.out.println("wrong mini connection table.......!");
         }
      }
     }
    catch(IndexOutOfBoundsException  e1)
    {
      System.out.println(" Don't have Customer Account Please Create New Account!...");
   }catch(NullPointerException e2){
  
    System.out.println("Invalid data !");
  }catch(Exception e){

    System.out.println("Error.......");
  }
	if (flag==true) {
		 connection= getMiniConnet();
		 rs = statement.executeQuery("select * from "+tab+"");
		
	}
	return rs;
}
//
static void miniDisplay() {
	
	
}
	
	public static void miniTable(String mail ,long  mobile) {

		  // mini table connection will create 
		//  jdbcConn.getMiniConnet();
		
	
		
//		 return result set  
		  rs = getResultSet(mobile,mail);
		  // execute query 
			// rs = getResult();
		 String tname=null  ;
		  try {
			 String name = rs.getString("fname");
			int acc =  rs.getInt("ac");
		    tname =name + acc ;
		
		  String sql ="UPDATE  bank.custDetails  SET minitab = '"+tname+"' WHERE ac ='"+acc+"'";
		  statement.executeUpdate(sql);
		//	UPDATE `bank`.`custdetails` SET `minitab` = 'rutesh7200021' WHERE (`AC` = '7200021');

		  
		  
  }catch(SQLException e) {
			  System.out.println(e);
		  }
			if(statement !=null) {
			System.out.println("connection Build..."+tname);
			}
			
			// create tabel
			
			 String sql = String.format("create table %s (sr int not null auto_increment "
					+ " ,dates varchar(50) , times varchar(50) , amount double not null"
					+ " , status varchar(45) "
					+ " , curBal DOUBLE ,primary key(sr))", tname);
					
			 
		
		
		try {
			 connection= getMiniConnet();
			 
			statement.execute(sql);
			System.out.println("Table Created Successfully....");
			} catch (Exception e) {
				// TODO: handle exception
				 e.printStackTrace();
			}
			
		}
	
	// insert  mini statements details in table
	static void insertMiniDetails( double amount,String status,double curBal){
		
		connection = jdbcConn.getMiniConnet();
		
		//System.out.println("ministatements");
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		 Date date = new Date();
		 
		 String  str  =  formatter.format(date);
		 String[] dts  = str.split(" ",0);
		  String dats =  dts[0] ;
		  String tims = dts[1] ;
		 
		  try {
		  
//		 
//		  i=i++;
//		 String sql ="insert into ? values("+i+",?,?,?,?,?)";
//		 // (dates ,times,amount,status,curBal)"
//		 i=i++;
//			
//		 try {
			 String tabName = rs.getString("minitab");
			 //System.out.println("table name:"+tabName);
//			 // insert query
		  statement.execute("insert into "+tabName+" (dates,times,amount,status ,curBal) "
			  		+ "values('"+dats+"','"+tims+"',"+amount+",'"+status+"',"+curBal+")");
//			 pstmt =connection.prepareStatement(sql);
//
//			pstmt.setString(1, tabName);6
//			pstmt.setString(2, dats);
//			pstmt.setString(3, tims);
//			pstmt.setDouble(4, amount);
//			pstmt.setString(5, status);
//			pstmt.setDouble(6, curBal);
//			
//			int count = pstmt.executeUpdate();  // DML
//			if(count >0) {
//				
//				System.out.println("\t\t*data added....*");
//			}else {
//				System.out.println("data Not Added...");
//			}

	}catch(SQLException e) {
		System.out.println("5-->:"+e);
		
	}
	}
		 
	
	// insert  new account details in table
	static Create insertDetails(){
		
		  jdbcConn.getBankConnet();
		
		Create ref =Banking.openAccount();
		try {
		pstmt =connection.prepareStatement("insert into custdetails (fname,lname,email,mobile,gender,bdate,marriedStatus,type,"
				+ "country,state,city,address,balance,accountMode)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 pstmt.setString(1, ref.fname);
		 pstmt.setString(2, ref.lname);
		 pstmt.setString(3, ref.email);
		 pstmt.setLong(4, ref.MobNo);
		 pstmt.setString(5, ref.gender);// 
		 pstmt.setString(6, ref.bdate);
		 pstmt.setString(7, ref.MarriedStatus);
		 pstmt.setString(8, ref.type);
		 pstmt.setString(9, ref.address);
		 pstmt.setString(10, ref.country);
		 pstmt.setString(11, ref.state);
		 pstmt.setString(12, ref.city);
		 pstmt.setDouble(13, ref.balance);
		 pstmt.setBoolean(14,true );
			int count = pstmt.executeUpdate();  // DML
			
			if(count >0) {
				//creating mini table 
				miniTable((String)ref.email,ref.MobNo);
			      
				System.out.println("\t\t*Success Fully Added...!*");
			}
		 		
		}catch(SQLException e) {
			System.out.println(e);
			e.printStackTrace();		}
		return ref;
		
	}
//	public static void main(String[] args) {
//		displayDetails(statement);
//		insertDetails();
//		displayDetails(statement);
//		insertDetails();
//	}
}

	
	


