package atmdetail;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;

import java.util.Scanner;



public class Balanceinfo {
	void balance() throws Exception

	{

		Scanner s=new Scanner(System.in);
		Connection con=DatabaseConnect.database();
		System.out.println("Enter the account number");
		int AN=s.nextInt();
        //System.out.println("Enter the pin number:");
        //int pin_no1=s.nextInt();
        String query1="select deposit from account where account_no ="+AN+"";
        //Class.forName("com.mysql.cj.jdbc.Driver");
		Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query1);
        rs.next();
        System.out.println("\t  !!  Bank   Balance   Information   !! ");
        String depo="\nAvailable  Amount :  "+rs.getInt("deposit")+"\n";
        System.out.print(depo);	
        //st.executeUpdate(query1);
	}
}
