package atmdetail;
import java.sql.*;

import java.util.Scanner;



public class Withdrawsystem {
	public void withDraw() throws Exception

	{

		Scanner s=new Scanner(System.in);
		Connection con=DatabaseConnect.database();
        System.out.println("Enter the account number:");
        int ac=s.nextInt();
        System.out.println("Enter the amount to be withdraw:");
        int withdraw=s.nextInt();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from account where account_no="+ac+"");
		rs.next();
		int i=rs.getInt(6);
		int tot=i-withdraw;
		String query="update ministatement set withdraw="+withdraw+ "where account_no="+ac+"";
		
		st.executeUpdate("update account set deposit="+tot+" where account_no="+ac+"");
		System.out.println("Thank you");
		

	

	}



}

