package atmdetail;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Scanner;

public class Depositsystem {
	void depositAccount()  throws Exception

	{


		Scanner sc=new Scanner(System.in);
		Connection con=DatabaseConnect.database();
        System.out.println("Enter your account number:");
        int accno=sc.nextInt();
        System.out.println("Enter the amount to deposit in bank  : ");
        int dep=sc.nextInt();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from account where account_no="+accno+"");
		rs.next();
		int i=rs.getInt(6);
		int tot=i+dep;
		String query="update ministatement set deposit="+dep+" where account_no="+accno+"";
	    st.executeUpdate("update account set deposit="+tot+" where account_no="+accno+"");
         st.executeUpdate(query);
	}



}


