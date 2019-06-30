package atmdetail;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BankStatement {
	
	public void statement() throws Exception {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter your account number");
		int Acc= s.nextInt();
		Document document=new Document();
		PdfWriter.getInstance(document, new FileOutputStream("E:\\pdf\\Trans3.pdf"));
		document.open();
		document.add(new Paragraph("Date:"+new Date().toString()));
		document.add(new Paragraph("BANK STATEMENT",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.GREEN)));
		document.add(new Paragraph("_____________________________________________________________________________"));
		document.add(new Paragraph("Account Number: "+Acc));
		document.add(new Paragraph(" "));
		PdfPTable table=new PdfPTable(3);
		table.addCell("Transaction Type");
		table.addCell("Amount");
		table.addCell("Date");
	
		
		int amount,i=0;
		System.out.println("----------------------------------------------------------------------------------");
		Connection con=DatabaseConnect.database();
		Statement st=con.createStatement();
		String query="select * from ministatement where account_no="+Acc+" ";
		ResultSet rs=st.executeQuery(query);
		
			while(rs.next() && i<=5)
			{
				System.out.println("---------------------------------------------------");
			//System.out.println("Transaction type:"+rs.getString(6)); 
			//table.addCell(rs.getString(6));
			if(rs.getInt("deposit")==0)
			{
			
				amount=rs.getInt("withdraw");
				table.addCell(amount+"");
				System.out.println("Transaction type:"+rs.getInt("withdraw"));
				table.addCell("withdraw");
			}
			else
			{
				amount=rs.getInt("deposit");
				table.addCell(amount+"");
				System.out.println("Transcation type:"+rs.getInt("deposit"));
				table.addCell("deposit");
			}
				System.out.println("Amount:"+ amount);
			//System.out.println(rs.getDate(5));
		System.out.println(rs.getTimestamp(4));
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(rs.getTimestamp(4));
		table.addCell(timeStamp);
		}
			rs.close();
			String query1="select * from account where account_no="+Acc+" ";
			ResultSet rs1=st.executeQuery(query1);

			rs1.next();
			//query=rs1.getInt(6)+"";
			//document.add(new Paragraph("Main Balance:"+query));
			document.add(new Paragraph("Sent by: Karki commercial Bank"));
			
			System.out.println("----------------------------------------------------------------------------------");
			document.add(new Paragraph(" "));
			document.add(table);
			document.close();
		
	}

	

}