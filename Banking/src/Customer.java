
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.*;


public class Customer  {

	static Scanner sc =  new Scanner(System.in);
	// create Connetion
	static Connection connection  ;
			// Create Statement 
	static	Statement statement ;
	// prepare statement
	static PreparedStatement pstmt ;
//	
	//result Set
	static ResultSet rs, rs1;
	
     
     static    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    static{
        System.out.println("***********************************************"); 
        System.out.println("\t\t Wel-Come to");
        System.out.println("\t\tStudent Bank");
        System.out.println("\t\t\t\tCo-founder : Nitesh Kharose");

    }
   
    
    
	public static void main(String[] args)  throws Exception {
        // vPin.add(PIN);
    	connection = jdbcConn .getBankConnet();
    	statement  = connection.createStatement();  
    	if(connection .isClosed()) {
    		System.out.println("*Connection Closed ");
    	}
    	if(statement .isClosed()) {
    		System.out.println("*Statement Closed");
    	}     
            while(true){
              
        System.out.println("\n*******************WEL-COME****************************");
        System.out.println("1.Login");
        System.out.println("2.Create Account");      
        System.out.println("3.Exit");
        
        int choice=0;
         boolean flag = true;
     
      while(flag == true){

      try{
          System.out.print("\nEnter your choice:  ");
        choice =  sc.nextInt();
            flag = false;
            
      }catch(InputMismatchException   e){
        
        System.out.println("\nInvalid Input..Please try again............!");

          flag = true;
         sc.nextLine();
      }
      }
       
       // System.out.println("\n*******************************");

        switch(choice)
        {
             
            case 1:
            {
                System.out.println("\n\n1.Login for Manager");
                System.out.println("2.Login for Customer");
                System.out.println("3.Exit");
                int op =0;

          flag = true;
     
      while(flag == true){

      try{
          System.out.print("\nEnter your choice:  ");
        op = sc.nextInt();
            flag = false;
            
      }catch(InputMismatchException   e){
        
         System.out.println("\nInvalid Input..Please try again............!");

          flag = true;
         sc.nextLine();
      }
      }
    
        switch(op)
            {
            case 1:
            {
                // LOGIN MANAGER
                // System.out.println("coming soon!");
                                boolean ans=false; 
                ArrayList <Object >al = new ArrayList<>() ; 

                Manager mgr =  new Manager();
                Manager mgr2 =  new Manager();

               al =  Manager.loginManager();

                  try{
            
                    mgr2 = (Manager)al.get(1);
                    ans =  al.contains(true);
                 
                  }catch(IndexOutOfBoundsException n){
                    ans = false ;
                    System.out.println("\n\nSomething Wrong Please try again............!");
                    break;

                  }

                  
                  
                   char res ='y';
                  do{
                    if(ans) {

                    // lable1:
                    System.out.println("\n**************Wel-Come "+"Mr/Ms."+mgr2.fname+"*****************************\n");
                   // System.out.println("Please select your Choice:");
                    System.out.println("1.Search By Name");
                    System.out.println("2.Search By Mobil Number");
                    System.out.println("3.Search By Email");
                    System.out.println("4.Deposit Amount :");
                    System.out.println("5.Display All the Account:");
                    System.out.println("6.Display Pin of the Customer");
                    System.out.println("7.Exit");
                   
                    int ch1 = 0;
                    
          flag = true;
     
      while(flag == true){

      try{
          System.out.print("\nEnter your choice:  ");
        ch1 =  sc.nextInt();
            flag = false;
            
      }catch(InputMismatchException   e){
        
          System.out.println("\nInvalid Input..Please try again............!");
          flag = true;
         sc.nextLine();
      }
      }
                    
                    System.out.println();
                //    previous();
                    switch(ch1)
                    {
                        case 1:
                            {
                                        mgr.searchName();


                            
                         break;
                            }
            
                        case 2:
                         {
                             
                             mgr.searchMobile();
                             
                             break;
                      
                         }
            
            
                        case 3: 
                        mgr.searchEmail();
                            break;

                        case 4: 
                                 mgr.addAmount(); 
                             break;
                        case 5:
                    
                              // mgr.display(Banking.v);
                                     break;
                        
                               
                        case 7:
                                res= 'N';                              
                           break;
                       }
                    }       // inside switch end               
               
                 }while(res!='N');
                                    
                

            }
            
                        break;
            
            case 2 :
            {
            	
                //LOGIN CUSTOMER
                boolean ans=false; 
                ArrayList<Object> al = new ArrayList<Object>() ; 
                

                al =  Banking.login();
                
                try{
                              
                rs= (ResultSet)al.get(1);
                ans =  al.contains(true);
                }catch(IndexOutOfBoundsException e) {
                	
                }
                  try{
            // checking result set 
                    if(rs.isClosed()) {
                    	System.out.println("closed ....login");
                    	break;
                    }
                  }catch( NullPointerException n){
                    ans = false ;
                    if(rs==null)
                	System.out.println("\n*****Details Not Found....!****");
                   // System.out.println("Wrong Credential Please try again............!");
                    break;

                  }
                  
//                  
//                  System.out.println("Account blocked");
//                  }

                   char res ='y';
                   
                  do{
                	  if(connection .isClosed()) {
                  		System.out.println("Connection Not Build ");
                  	}
                  	if(statement .isClosed()) {
                  		System.out.println("Statement Not Build");
                  	}
	                	  
                	//  rs1= (ResultSet)al.get(1);
                    if(ans) {
                    	
                    	
                    	 if(rs.isClosed()) 
                         	System.out.println("closed ... login loop");
                    	 if( rs.getBoolean("accountMode")==true) {
                    	

                    // lable1:
                    System.out.println("\n****************"+"Mr/Ms."+rs.getString("fname")+"***************************\n");
                   // System.out.println("Please select your Choice:");
                    System.out.println("1.Cash Withdrawal  Or Tansfer Amount");
                    System.out.println("2.Balance Enquiry");
                    System.out.println("3.Deposit Amount");
                    System.out.println("4.Mini Statement");
                    System.out.println("5.Change ATM pin");
                    System.out.println("6.Display ATM pin");
                    System.out.println("7.Deactivate Account");
                    // System.out.println("6.Pin display");
                    // System.out.println("7.Got to Login Page");
                    System.out.println("8.Exit");
                    int ch1=0;

                          
          flag = true;
     
      while(flag == true){

      try{
          System.out.print("\nEnter your choice:  ");
        ch1 =  sc.nextInt();
            flag = false;
            
      }catch(InputMismatchException   e){
        
          System.out.println("\nInvalid Input..Please try again............!");
          flag = true;
         sc.nextLine();
      }
      }
                //    previous();
                    switch(ch1)
                    {
                        case 1:
                            {
                               rs = Banking.withdraw( rs);
                               if(rs!=null)
                               {
                                System.out.println("\n Please Collect your Cash.....\n");
                               try {
                            	   System.out.println("\t Current Balance:"+rs.getString("balance")+"*");
                                   
							} catch (SQLException e) {
								
								System.out.println(e);
							}
                               }else{
                                System.out.println("Transaction Failed !");
                               }

                            }
                         break;

            
                        case 2:
                         {
                             
                             System.out.println("Available Balance: "+rs.getDouble("balance")+" RS");
                            
                             
                             break;
                         }
            
            
                        case 3: 
                        	   {
                        		 ArrayList<Object> val = Banking.deposit(rs);
       
                        		  
                        		  rs =(ResultSet) val.get(0);
                        		   double amount = (Double)val.get(1);
                        		   if(rs.isClosed()) {
                           			   System.out.println(" return deposit Result Set  closed..");
                           		   }  
                        		   System.out.println("***Successfully Deposited Amount : " + amount+" RS");
                        	   try {
                        		   if(rs.isClosed()) {
                        			   System.out.println("deposit Result Set  closed..");
                        		   }  
                        		   System.out.println("*\tCurrent  Balance:"+rs.getDouble("balance")+"*");
                        		   
                              	 
                        	   }catch(SQLException e)
                        	   {
                        		   System.out.println("Error");
                        	   }
                        	   }
                            break;

                        case 4: Banking.miniDisplay(rs);
                             break;
                        case 5:
                             rs.getInt("pin");
//                             o.vPin.add(changePin);
                             System.out.println("Successfully changed...\n");
                           break;
                               
                        case 6:
                                 int pin  =rs.getInt("pin");
                                 System.out.println("your Pin :"+pin);
                                  break;
                        case 7:
                        	System.out.println(" Customer Requesting to manager Deactivate Account........!");
                        	//	new Manager(). removeAccount();
                        			break;
                        	
                        case 8:
                                res= 'N';   
                                System.out.println(" \n ***Thank You for Visiting Bank...***\n");
                                                           
                           break;
                       }   // inside switch end 
                    
                    	}  else {
                    	System.out.println("Account is Deactive Please Active Account...!"
                    			+ "\n \t Contact to manager......!");
                    	res = 'N';
                    }
                    }
                                 
               
                 }while(res!='N');
                  
            
              }  // inside case 2 :end
              case 3:
              {
            	  break;
              }
             
           }
                break;             // inside while end
                
         }       //outside case 1 end
        
        case 2:{

            
                System.out.println("\n\n1.Create Account for Manager");
                System.out.println("2.Create Account for Customer");
                System.out.println("3.Exit");
                int op = 0;
                      
          flag = true;
     
      while(flag == true){

      try{
          System.out.print("\nEnter your choice:  ");
        op =  sc.nextInt();
            flag = false;
            
      }catch(InputMismatchException   e){
        
          System.out.println("\nInvalid Input..Please try again............!");
          flag = true;
         sc.nextLine();
      }
      }

        switch(op)
            {
                case 1:
                {
                        Manager mgr =  new Manager();
                         Manager ret = mgr  .openAccount();
                              mgr.show(ret);
            try{
                if(ret!=null)
                {   
                    System.out.println("your account is Created Succesfully....");   
                  System.out.println("               Thank you!");   
                
                }
            }catch(NullPointerException e){
                System.out.println("your account is not  Created............. ");
            }
                

                }break;
            case 2:
            {
          // Banking bank =  new Banking();
          Create ret = jdbcConn.insertDetails(); //Banking .openAccount();
          
          
//            Banking.show(ret);
            jdbcConn.displayDetails(ret);
            try{
                if(ret!=null)
                {   System.out.println("your account is Created Succesfully....\n Thank you!");   
                
                }
            }catch(NullPointerException e){
                System.out.println("your account is not  Created............. ");
            }
                
        } break; 
        case 3:

                break;
            
            }
        }
            case 3:
              System.out.println("*******************************************************\n");
             break;
                              
        }
     }
}
}
    




/**
 * @return
 */

