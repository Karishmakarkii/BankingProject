package atmdetail;
import java.sql.*;

import java.util.Scanner;

public class Createaccount {
	public void method() throws Exception

	{

	
	Scanner sc=new Scanner(System.in);
    Connection con=DatabaseConnect.database();
	System.out.println("Enter the Account No:");
    int acc=sc.nextInt();
	System.out.println("Enter the first Name:");
    String fn=sc.next();
    System.out.println("Enter the last name:");
    String ln=sc.next();
    System.out.println("Enter the address:");
    String add=sc.next();
    System.out.println("Enter contact No:");
    int contact=sc.nextInt();
	System.out.println("Enter the pin ");
	int PIN=sc.nextInt();
    String query="insert into account(account_no,first_name,last_name,address,contact_no,pin)values("+acc+",'"+fn+"','"+ln+"','"+add+"',"+contact+","+PIN+")";
    Statement st= con.createStatement();
    String query1="insert into ministatement(account_no)value("+acc+")";
    System.out.println("Thank you for Creating account");
    st.executeUpdate(query);
    st.executeUpdate(query1);
    st.close();
    con.close();
	
	

	

	}

}


