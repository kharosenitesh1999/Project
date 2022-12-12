import java.sql.SQLException;
import java.text.SimpleDateFormat;

***********************************************
		 Wel-Come to
		Student Bank
				Co-founder : Nitesh Kharose
*Connection Build 
*Statement Build

*******************WEL-COME****************************
1.Login
2.Create Account
3.Exit

Enter your choice:  1


1.Login for Manager
2.Login for Customer
3.Exit

Enter your choice:  2

Enter UserName(Email):  kharose1@gmail.com
Enter Password(mobile Number):  7507535160
Connection  Build 
Statement  Build

****************Mr/Ms.Nikhil***************************

1.Cash Withdrawal  Or Tansfer Amount
2.Balance Enquiry
3.Deposit Amount
4.Mini Statement
5.Change ATM pin
6.Display ATM pin
7.Deactivate Account
8.Exit

Enter your choice:  3
Enter Deposit Amount: 100
ministatements
30/10/2022
17:11:17
table name:  nikhil7200027
***Successfully Deposited Amount : 100.0 RS
*	Current  Balance:14231.0*
Connection  Build 
Statement  Build

****************Mr/Ms.Nikhil***************************

1.Cash Withdrawal  Or Tansfer Amount
2.Balance Enquiry
3.Deposit Amount
4.Mini Statement
5.Change ATM pin
6.Display ATM pin
7.Deactivate Account
8.Exit

Enter your choice:  3
Enter Deposit Amount: 1200
1:->java.sql.SQLSyntaxErrorException: Table 'mini.custdetails' doesn't exist
ministatements
30/10/2022
17:12:45
table name:  nikhil7200027
***Successfully Deposited Amount : 1200.0 RS
*	Current  Balance:14231.0*
Connection  Build 
Statement  Build

****************Mr/Ms.Nikhil***************************

1.Cash Withdrawal  Or Tansfer Amount
2.Balance Enquiry
3.Deposit Amount
4.Mini Statement
5.Change ATM pin
6.Display ATM pin
7.Deactivate Account
8.Exit

Enter your choice:  3
Enter Deposit Amount: 300
1:->java.sql.SQLSyntaxErrorException: Table 'mini.custdetails' doesn't exist
ministatements
30/10/2022
17:13:46
table name:  nikhil7200027
***Successfully Deposited Amount : 300.0 RS
*	Current  Balance:14231.0*
Connection  Build 
Statement  Build

****************Mr/Ms.Nikhil***************************

1.Cash Withdrawal  Or Tansfer Amount
2.Balance Enquiry
3.Deposit Amount
4.Mini Statement
5.Change ATM pin
6.Display ATM pin
7.Deactivate Account
8.Exit

Enter your choice:  
	
	
	
	
	
	
	
	
	
{
	   connection = jdbcConn.getMiniConnet();
	   
	  
		 System.out.println("ministatements");
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		// Date date = new Date();
		 
		 try {
			 String  str  =  formatter.format(date);
			 String[] dts  = str.split(" ",0);
			  String dats =  dts[0] ;
			  String tims =  dts[1] ;
			  System.out.println(dats+"\n"+tims);
			 String tab = rs.getString("minitab");
			 System.out.println("table name:  "+tab);
			

	}catch(SQLException e) {
		System.out.println("2:->");
		
	}
		 
}