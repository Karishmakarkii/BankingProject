package atmdetail;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class ChangePin {
	public void Change() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		Connection con=DatabaseConnect.database();
        System.out.println("Enter your account number:");
        int accno=sc.nextInt();
        System.out.println("Enter New Pin");
        int p=sc.nextInt();
        String query="update account set pin ="+p+" where account_no ="+accno+"";
        Statement st=con.createStatement();
        st.executeUpdate(query);
        st.close();
        con.close();
	}

}
