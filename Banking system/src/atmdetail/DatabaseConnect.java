package atmdetail;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {
	static Connection database() throws Exception {
		String url="jdbc:mysql://localhost:3306/atmdetail";

		String uname="root";

		String pass="";
	   // Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass );
		return con;
	}

}
