

import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.lang.Exception;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


  class Create {

  int PIN =1234;
  String fname  ;
  String lname ;
  String email;
  String userName;
  String gender ;
  String bdate ;
  long MobNo;
  long password;
  String MarriedStatus  ;
  String type;
  String address ; 
  String state ;
  String country ;
  String city ;
  int pin;
  double balance ;
  int ac =2200 ;
    Create(){

  }
        Create(double bal){

          this.balance =bal;
          this.ac=1000;
        }
}



public class Banking  extends connect{
   
  
  static ArrayList<Create> v = new ArrayList<Create>();
  static  Scanner sc = new Scanner(System.in);
  static PreparedStatement pstmt =null;
  static {
		connection = connect.getConnections("Student","root","root");
		try {
		statement = connection.createStatement();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
// Create Account
   public static Create openAccount()
    {
      // object for customer
        int ch;
        // Scanner sc =  new Scanner(System.in);
        Create c =  new Create();
        // ArrayList v = new ArrayList<>();
    
        do{
      //  Create c =  new Create();
        // fname
      System.out.println("\n***********************************************"); 
       System.out.print("Enter your First Name:");
       c.fname = sc.next();
       //lname
       System.out.print("Enter your Last Name:");
        c. lname = sc.next();
        //email
       System.out.print("Enter your Email:");
      c.email =sc.next();
        //mobile
        boolean flag = true;
        while(flag==true)  
          try{
             System.out.print("Enter your Mobile:");
            
             c.MobNo =sc.nextLong();
              flag = false;
        }catch( InputMismatchException  e)
        {
          System.out.println("\n Please Enter the Integer value......\n");
         sc.nextLine();
         flag = true;
        
        
       }
        //gender
        System.out.println("Gender:");
        System.out.println("\t1.Male");
        System.out.println("\t2.Female");
        System.out.print("Enter your Gender:");
        int ch0 =sc.nextInt();
        switch(ch0) {
        
        case 1:
        {
       	 c.gender = "Male";
        }
        break;
       	 
        case 2:{
       	 c.gender = "Female";
        }
        default :
        	c.gender =null;
        }
        // bdate
//        System.out.print("Enter Birth date(YYYY-MM-DD):");
//        c.bdate = sc.next();
            // status
        	 System.out.println("Maaried status:");
             System.out.println("\t1.Single");
             System.out.println("\t2.Married");
             System.out.print("Enter your Maaried status:");
             int ch1 =sc.nextInt();
             switch(ch1) {
             
             case 1:
                	 c.MarriedStatus = "Single";
             break;
            	 
             case 2:{
            	 c.MarriedStatus = "Married";
             } break; 
            default :
            	 c.MarriedStatus = null;
            break;
             }
             
             // account type
             System.out.println("Account Type:");
             System.out.println("\t1.Saving");
             System.out.println("\t2.Current");
             System.out.print("Enter your Account Type:");
             int ch2 =sc.nextInt();
             switch(ch2) {
             
             case 1:
             {
            	 c.type = "Saving";
             }
             break;
            	 
             case 2:{
            	 c.type = "Current";
             }
             default :
             	c.type =null;
             }
            // sc.nextLine();
             // address
             //System.out.print("Enter your Address:");
             c.address ="Pune";//sc.next();
             //country
            // System.out.print("Enter your Country:");
             c.country ="India";//sc.next();
             //state
            // System.out.print("Enter your State:");
             c.state ="Maharastra";
             //city
             //System.out.print("Enter your city:");
             c.city ="Pune" ;//sc.next();
       // deposit
       flag = true;
     while(flag==true){
     try{ 
      System.out.print("Enter Deposit Amount in account:");
      c.balance = c.balance + sc.nextInt();
      flag = false;
     }catch(InputMismatchException e){

      
          System.out.println("\n please Enter the Integer Amount......\n");
          flag = true;
         sc.nextLine();

     }catch(Exception e){
      
          System.out.println("\nplease Enter the Integer Amount........ \n");
          flag = true;
         sc.nextLine();
     }   
     }
      new Create(c.balance);

      //user and password
          c.userName =c.email;
          c.password=c.MobNo;
      // acount generated automatically
      c.ac = c.ac + v.size()+1;    //100+5+1=106
      
      // 
      System.out.println("***********************************************"); 
      System.out.println("1.Submit");
      System.out.println("2.reset");
      System.out.print("\nEnter your choice:");
      ch = sc.nextInt();
        // s=c;
       }while(ch==2);

        v.add(c);
      //  System.out.println("\n**Size:"+v.size());
    
        return c;
    }
   
   


   public  static void show(Create info)
   {
             System.out.println("\n**********Account Details*************");
             System.out.println(" Account Number :"+info.ac);
             System.out.println("UserName :"+info.userName);
             System.out.println("Password :"+info.password);
             System.out.println("First Name :"+info.fname);
             System.out.println("Last Name :"+info.lname);
             System.out.println("Email :"+info.email);
             System.out.println("Mobile Number :"+info.MobNo);
            //  System.out.println("Gender :"+info.gender);
            //  System.out.println("Adhar :"+info.adhar);
             System.out.println("******************************************\n");
        
 } 

	
   
     // toatal accoounts
    
  // login 
     public  static  ArrayList<Object> login(){

      ArrayList<Object> val= new ArrayList<>();
       
  
          System.out.print("\nEnter UserName(Email):  ");
           String usr = sc.next();
      
      boolean flag = true;
      long pass =0 ;
      while(flag == true){

      try{
          System.out.print("Enter Password(mobile Number):  ");
            pass = sc.nextLong();
            flag = false;
            
      }catch(InputMismatchException   e){
        
          System.out.println("\nPlease  enter the Mobile Number...........");
          flag = true;
         sc.nextLine();
      }
      }
      // database resultset  getting 
      	ResultSet rs = jdbcConn.getResult();
      		
         
         try{
        	 while(rs.next()) {
            long pass2 =rs.getLong("mobile");
            String usr1 =rs.getString("email");
        	

            if(pass==pass2 && usr1.equalsIgnoreCase(usr) ){
              val.add(true);
              val.add(rs);
              break ;
             }
          }
         }
        catch(IndexOutOfBoundsException  e1)
        {
          System.out.println(" Don't have Customer Account Please Create New Account!...");
       }catch(NullPointerException e2)
      {
        System.out.println("2-Invalid data !");
      }catch(Exception e){

        System.out.println("Error.......");
      }
        
          
          return val ;
}

public static ArrayList<Object> deposit(ResultSet rs)
{
		ArrayList<Object> ret = new  ArrayList<>();
	 // Date date = new  Date();
      double creditAmount =0.0 ;
      
      
      do{
    	  try {
    	  System.out.print("Enter Deposit Amount (upto  200000): ");
    	  creditAmount =sc.nextLong();
    	  }catch(InputMismatchException  e ){
              System.out.print("Please Enter Integer Input........! ");

          }
    	  }while(creditAmount <0 || creditAmount>200000);
    	  
     
    	
      double bal =0;

      String email =null;
      long mobile =0;
     
   try {

	      connection=jdbcConn.getBankConnet();
	      if(connection.isClosed()) {
	    	  System.out.println("Deposit Connection Closed");
	      }
	      Statement statement = jdbcConn.getStatement();
       bal = rs.getDouble("balance") + creditAmount ;
       email = rs.getString("email");
       mobile =  rs.getLong("mobile");
      int ac = rs.getInt("ac");
      String sql = "UPDATE  custDetails  SET balance = "+bal+" WHERE ac='"+ac+"' AND email='"+email+"' AND mobile='"+mobile+"'";
	
      // ***** //--
      statement.executeUpdate(sql);
      
    rs = Banking. getResultSet(mobile,email);
    
//	rs = statement.executeQuery("Select *from qspider");
}catch(SQLException e) {
	   System.out.println("1:->"+e);
//	rs = statement.executeQuery("Select *from qspider");
}   
   try {
   if(rs.isClosed()) {
	   System.out.println("deposit after execution result set Closed");
   }
   }catch(SQLException e) {
	   System.out.println("deposit after execution result set Closed");

	   System.out.println(e);
   }
   jdbcConn.insertMiniDetails(creditAmount,"Deposit ",bal);
   
   	ret.add(rs);
    ret.add(creditAmount);

     
     return ret;
}

static ResultSet getResultSet( long mobile ,String email) {
	
	
	ResultSet rs =null;
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
  
    System.out.println("1-Invalid data !");
  }catch(Exception e){

    System.out.println("Error.......");
  }
	return rs;
}

// withdraw

public static ResultSet withdraw(ResultSet rs){
  
  long withdraws=0;
  do{
  System.out.print("Enter withdraw Amount (less than 200000): ");
   withdraws =sc.nextLong();
  }while(withdraws <0 || withdraws>200000);
  
try {
  if(withdraws <= (rs.getDouble("balance")))
      { 
	  connection=jdbcConn.getBankConnet();
      if(connection.isClosed()) {
    	  System.out.println("Deposit Connection Closed");
      }
      Statement statement = jdbcConn.getStatement();
	   
      double bal = rs.getDouble("balance") - withdraws ;
      String email = rs.getString("email");
      long mobile =  rs.getLong("mobile");
	
	statement.execute("UPDATE  custDetails  SET balance = "+bal+" WHERE email='"+email+"' AND mobile ='"+mobile+"'");  
				rs = Banking.getResultSet(mobile, email);
				jdbcConn.insertMiniDetails(withdraws,"Withdraw",bal);
				
				if(rs.isClosed()) {
					System.out.println("RS... null");
				}
//	o.miniWithdraw.add(withdraws);
//        o.bal.add(o.balance);
//        o.time.add(o.formatter.format(date));
//        o.deposited.add("Debited");

		// inserting value inside of table mini table
		
          return rs;
       } else { 
      System.out.println("Insufficient Funds!");
      return null;
     }
}catch(SQLException e)
{
	System.out.println(e);
}

return rs;
     
  }
  
        //miniDisplay
        public static  void miniDisplay( ResultSet rs){
          System.out.println("***********************************************************");
          System.out.println(" Sr\t* Date*\t\t*Time*\t\t*WithDrwal*\t*Status\t\t*Balance*");
          System.out.println("************************************************************");
//  
//          for(int i=0;i<miniWithdraw.size();i++)
//          {
//              System.out.println(o.time.get(i)+"    \t"+o.miniWithdraw.get(i)+" RS    "+o.bal.get(i) +" RS    "+o.deposited.get(i));
//          System.out.println("************************************************************");
//              // System.out.println(o.time.get(i)+"    \t"+o.miniWithdraw.get(i)+" RS    \t"+o.bal.get(i) +" RS");
//              System.out.println();
//          }
          try {
          long mobile = rs.getLong("mobile");
          String email = rs.getString("email");
          String tab=rs.getString("minitab");
       
          rs =jdbcConn.getMiniResultSet(mobile,email) ;
         
     		 connection= jdbcConn.getMiniConnet();
     		 if(connection.isClosed()) {
     			 System.out.println("miniconnection closed...!");
     		 }
     		 rs = statement.executeQuery("select * from "+tab+"");
     		
     	
          while(rs.next()) {
        	  System.out.println(rs.getInt("sr")+"\t"+rs.getString("dates")+"\t"+rs.getString("times")+"\t"+(long)rs.getDouble("amount")+"\t\t"+rs.getString("status")+"\t\t"+rs.getDouble("curBal"));
          }
          
          }catch(SQLException e) {
        	  System.out.println(e);
          }
  
        }

        
    // Pin 
     static int pin()
   {   
       boolean val =false;
       
       int num = 0 ;
       do{
       System.out.print("Enter four digit Pin : ");
       num = sc.nextInt();
      
       
           if(num >999 && num <10000)
           {
               val =true;
              // v.add(num);
               
//               for(int i=0;i<o.vPin.size();i++)
//               {
//                   if(o.vPin.get(i).equals(num) )
//                   {
//                    System.out.println("\tAlready exit !");
//                    val=false;
//                    break;
//                      // System.out.println("Pin: "+num+ " "+PIN);
//                   }
               
               break;
           }else
               System.out.println("Invalid PIN !"); 

     }while (val ==false) ;
            // System.out.println(PIN); 
           // Create.PIN = num ;
       return num ;

   }
  
   }























