package JDBC_Connection;
import java.sql.*;
import java.util.*;

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;

class JDBCConnection{
 
	 static int ac =1;
    public static void main(String[] args)throws Exception{
         Scanner sc  = new Scanner(System.in);
         
     	System.out.println(":WEL-COME:");
  Connection con = null;
      while(true) {
        // register the driver
        // Class.forName("com.mysql.jdbc.Driver");
         System.out.println("register Success.");
        // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
             Class.forName("com.mysql.jdbc.Driver");
         System.out.println("driver load Successfully.");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Bank",
                "Student", "root");

        // Establish Connection Database and banknis a database name 
        //  con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","Student","root");
         System.out.println("Connection done.");
         int ch =1;
         
         System.out.println("\n1.Insert");
         System.out.println("2.show exits data");
         System.out.println("3.update  data using name");
         System.out.println("4.remove data");
         System.out.print("\nEnter your choice:");
         ch  = sc.nextInt();
         // PrepareStatemt
         PreparedStatement pstmt;
         //Create Statements
         Statement stmt = con.createStatement();
         // execute Query 
         ResultSet rs  =  stmt .executeQuery("select * from Customer");	//DQL

         int ac;
         String fnames ;
         String lnames ;
         String emails ;
         long mobiles;
         int bals;
        
        
         switch (ch) {
         //insert data
		case 1:{
			
			System.out.print("Enter the first name:");
			String fname = sc.next();
			System.out.print("Enter the Last name:");
			String lname = sc.next();
			System.out.print("Enter the Email:");
			String email = sc.next();
			System.out.print("Enter the Mobile:");
			long mobile = sc.nextLong();
			System.out.print("Enter the Amount:");
			int bal = sc.nextInt();
			
		 pstmt =  con.prepareStatement("insert into  customer "
				+ "(fname,lname,email,mobile,balance)values(?,?,?,?,?)");
//					st.setInt(1, ac);
					 pstmt.setString(1, fname);		// inserting value
					 pstmt.setString(2, lname);
					 pstmt.setString(3, email);
					 pstmt.setLong(4, mobile);
					 pstmt.setInt(5, bal);
					int count = pstmt.executeUpdate();  // DML
					if(count >0) {
						System.out.println("Success Fully Added:");
					}
				}
			break;

		case 2:
		{
			
			// retrieve data
			try {
		
        // Create  a SQL Statement
         stmt = con.createStatement();

    // Execute the statements 
    

            while(rs.next())
            {
                ac =  rs.getInt("ac");
                fnames =rs.getString("fname").trim();
                lnames =rs.getString("lname").trim();
                emails =rs.getString("email");
                mobiles = rs.getInt("Mobile");
                bals = rs.getInt("balance");
                System.out.print("ac: "+ac+" name : "+fnames+" "+lnames+" ");
                System.out.println("Email:"+emails+"Mobile: "+mobiles+" balance : "+bals);


            }
                    rs.close();
                    stmt.close();
                    con.close();
       }catch (Exception e) {
           
         System.out.println("Connection failed.");
          System.out.println(e);
           System.out.println(e.getMessage());

         }  //catch close
		} // closse case 2	
		break;
		case 3:
		{
			
			
			// update data
			/*
			 * UPDATE trainer
SET email = 'mike@tutorialandexamples.com'    
WHERE course_name = 'Java';  

PDATE table_name     
SET column_name1 = new-value1,   
        column_name2=new-value2, ...    
[WHERE Clause]  
			 */
			 System.out.println(" Enater the first name.");
			 String fname = sc.next();
			 System.out.println(" Enater the last name.");
			 String lname = sc.next();
			
			 System.out.println("case1");
			 rs  =  stmt .executeQuery("select * from Customer");	//DQL
			 System.out.println("case2");
			  stmt = con.createStatement();
			  boolean flag =false;
			 
			  System.out.println("case1.3");
			 while(rs.next()) {
				 try {
				 if(rs.getString("fname").equals(fname) && rs.getString("lname").equals(lname) )
				 {
					 System.out.println("Account is Available.......");
					 flag =true;
					 break;
				 }
				 }catch(Exception e) {
					 e.printStackTrace();
					 System.out.println(e);
				 }
			 }
			 if(flag==true) {

				 
				 System.out.println("Showing Client Data:");
				 
				    ac =  rs.getInt("ac");
	                fnames =rs.getString("fname").trim();
	                lnames =rs.getString("lname").trim();
	                emails =rs.getString("email");
	                mobiles = rs.getInt("Mobile");
	                bals = rs.getInt("balance");
	                System.out.println("ac: "+ac+" name : "+fnames+" "+lnames+" ");
	                System.out.println("Email:"+emails+"  Mobile: "+mobiles+" balance : "+bals);


				 System.out.println(" Enter the Amount.");
				 int amount = sc.nextInt();
				 bals = rs.getInt("balance");
				 
				 
				 
				 System.out.println("case3");
				 int prevBal =(Integer) bals;
				 int CurrBal=prevBal+amount ;
					 pstmt =  con.prepareStatement("UPDATE customer SET balance=? WHERE fname=? AND lname=?");
					 System.out.println("case4");
					 pstmt.setInt(1, CurrBal);
					 pstmt.setString(2, fname);		// inserting value
					 pstmt.setString(3, lname);	
					 System.out.println("case5");// inserting value
					
					 int count=0;
					try {
						count= pstmt.executeUpdate();
					 
					}catch(SQLException e)
					{
						System.out.println(e);
								e.printStackTrace();
					}
					if(count >0) {
						System.out.println("Successfully  Added Amount........"+bals);
						System.out.println("Current Balance:"+CurrBal);
					}
			 }else {
				 
					System.out.println("Data Not found...");
					break;
				 
			 }
				
				pstmt.close();
				stmt.close();
				
//				08069458181 manish 
				
		}//close case 3
		break;
		case 4:
		{
			// remove data
			boolean  flag =  false;
			System.out.println("Enter the Email: ");
			String email = sc.next();
			System.out.println("Enter the Mobile Number ");
			long mob =  sc.nextLong();
			rs = stmt.executeQuery("SELECT email,mobile FROM  CUSTOMER");
			while(rs.next()) {
				if(rs.getString("email").equals(email) && rs.getInt("mobile")==mob ) {
					
					flag = true;
					break;
				}
			}
			 
			if(flag ==true)
			{
				pstmt = con.prepareStatement("DELETE FROM customer WHERE email=? AND mobile=?"); 
				pstmt.setString(1, email);
				pstmt.setLong(2, mob);
				System.out.println("removed");
				
			}else {
				System.out.println("Account is not present...............!");
			}
			
		
		stmt.close();
		
			
		}
		break;
		
       }//switch close
      } // close while
    }   // fun close
    
}       // class end