import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.*;
// import Create;

public class Manager {
    
 

  int PIN =1234;
  String fname  ;
  String lname ;
  String email;
  String userName;
  String adhar ;
  String gender ;
  long MobNo;
  long password;
  
   int ID=2100;
  //  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
   
   ArrayList<String> time = new ArrayList<String>() ; 
   ArrayList<String> info = new ArrayList<String>() ; 
     Manager(){

          
}

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Manager> mgr =  new ArrayList<> ();


    
// Create Account
   public  Manager openAccount()
    {
      // object for customer
        int ch;
        // Scanner sc =  new Scanner(System.in);
        Manager c =  new Manager();
        // ArrayList v = new ArrayList<>();
    
        do{
      //  Create c =  new Create();
        
      System.out.println("***********************************************"); 
       System.out.println("Enter your First Name:");
       c.fname = sc.next();
       System.out.println("Enter your Last Name:");
        c. lname = sc.next();

        
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
          

       System.out.println("Enter your Adhar Number:");
       c.adhar =sc.next();
      System.out.print("Enter your Email:");
      c.email =sc.next();
     
      //user and password
          c.userName =c.email;
          c.password=c.MobNo;
      // acount generated automatically
      c.ID = c.ID + mgr.size()+1;    //100+5+1=106
      // 
      System.out.println("***********************************************"); 
      System.out.println("1.Submit");
      System.out.println("2.reset");
      System.out.print("Enter your choice:");
      ch = sc.nextInt();
        // s=c;
       }while(ch==2);

        mgr.add(c);
      //  System.out.println("\n**Size:"+v.size());
    
        return c;
    }

    
   public   void show(Manager info)
   {
             System.out.println("\n**********Account Details*************");
             System.out.println(" Account Number :"+info.ID);
             System.out.println("\n UserName :"+info.userName);
             System.out.println(" Password :"+info.password);
             System.out.println(" First Name :"+info.fname);
             System.out.println("Last Name :"+info.lname);
             System.out.println("Email :"+info.email);
             System.out.println(" Mobile Number :"+info.MobNo);
             System.out.println("Gender :"+info.gender);
             System.out.println("Adhar :"+info.adhar);
             System.out.println("******************************************\n");
        
         
 } 
    

     public  static  ArrayList<Object> loginManager(){

      ArrayList<Object> val= new ArrayList<>();
       
  
          System.out.print("Enter UserName(Email):  ");
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
         
         try{
          for(int i=0;i<Manager.mgr.size();i++){
         
            long pass2 =Manager.mgr .get(i).password;
            String usr1 =Manager. mgr.get(i).email;

            if(pass==pass2 && usr.equals(usr1)){
              val.add(true);
              val.add(Manager. mgr.get(i));
              break ;
             }
          }
         }
        catch(IndexOutOfBoundsException  e1)
        {
          System.out.println(" Don't have Customer Account Please Create New Account!...");
       }catch(NullPointerException e2)
      {
        System.out.println("\nInvalid data !");
      }catch(Exception e){

        System.out.println("Error.......");
      }
          
          return val ;
}

    void searchName(){

        System.out.println("Enter your the name:");
        String fname = sc.next();
       
       System.out.println("Enter your Last Name:");
               String lname = sc.next();



        for(int i=0;i<Banking.v.size();i++)
        {

            Create info =Banking.v.get(i);
            String str1 =  info.fname;
            String str2 =  info.lname;
                if(fname.equals(str1)&&lname.equals(str2)){
                    Banking.show(info);
                    System.out.println();
                }
        }
    }
    void searchMobile(){

        System.out.println("Enter the Mobile:");
        int mob = sc.nextInt();

        for(int i=0;i<Banking.v.size();i++)
        {

            Create info =Banking.v.get(i);
            long str =  info.MobNo;
                if(mob==str){
                    Banking.show(info);
                    System.out.println();
                    break;
                }
        }
    }
    void searchEmail(){

        System.out.println("Enter the Email:");
        String email = sc.next();

        for(int i=0;i<Banking.v.size();i++)
        {

            Create info =Banking.v.get(i);
            String str =  info.email;

            if(email.equals(str)){
                    Banking.show(info);
                    System.out.println();
                    break;
                }
        }
    }
    void addAmount(){

        System.out.println("Enter the Mobile:");
        long mob = sc.nextInt();
        Create info = new Create();

        for(int i=0;i<Banking.v.size();i++)
        {

            info =Banking.v.get(i);
            long str =  info.MobNo;
                if(mob!=str){
                    
                    System.out.println("\nMobile Number not registered!");
                }
        }
        Banking.show(info);
        System.out.println("Enter Amount:");
        double amount =  sc.nextDouble();
        double bal = info.balance;
        info.balance += amount;

        System.out.println("\n\t\tDeposited: "+( amount));
        System.out.println("\n\t\tCurrent Balance:"+bal);
        
    }

     
   void request(ResultSet rs ){

      Create o =  new Create();
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
         if(usr=="" && pass==0)
         try{
        	 
//          for(int i=0;i<Banking.v.size();i++){
//         
//            long pass2 =Banking. v.get(i).password;
//            String usr1 =Banking. v.get(i).email;
//
//            if(pass==pass2 && usr.equalsIgnoreCase(usr1)){
//             flag = true;
//              o = Banking.v.get(i);
//              break ;
//             }
//          }
        	 
        	// String req = sc.nextLine();
        	 
         }
        catch(IndexOutOfBoundsException  e1)
        {
          System.out.println(" Don't have Customer Account !...");
       }catch(NullPointerException e2)
      {
        System.out.println("Invalid data !");
      }catch(InputMismatchException e){

        System.out.println("Input  Mismatch  .......");
      }catch(Exception e){

        System.out.println("Error.......");
      }

    if(flag==true)
    {
      Banking.v.remove(o);
      System.out.println("Successfully Deactivated Account...!");
      System.out.println("*Thank you for visiting....");
    }

   }


}

