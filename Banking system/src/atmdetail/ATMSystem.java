package atmdetail;
import java.util.Scanner;

public class ATMSystem {
	public static void main(String [] args) throws Exception{
		while(true)
		{
			System.out.println("Karki Commerical Bank");
		    System.out.println("Automated Teller Machine");
	        System.out.println("Choose 1 Go to account");
	        System.out.println("Choose 2 for ATM details"); 
	        System.out.println("Choose 3 for EXIT");
	        System.out.print("Choose the operation you want to perform:");
	        Scanner s=new Scanner(System.in);

			int choice=s.nextInt();
			switch(choice)
			{
			case 1:
			{
				System.out.println("Enter your choice:\n1.Create Account \n2.Deposit amount \n3.Exit");
				int choice1=s.nextInt();
				switch(choice1)
				{
				case 1:
					Createaccount obj=new Createaccount();
					obj.method();
					break;
				case 2:
					Depositsystem obj1=new Depositsystem();
					obj1.depositAccount();
					break;
				case 3:
					System.out.println("!!   Dhanyabaad  !!");
					System.exit(0); 
					break;
				}
			}
				break;
			case 2:
				System.out.println("\nEnter your choice :\n1.General  Information \n 2.Withdraw 3.Accountinfo\n 4. Bank Statement \n5.Change pin number .\n 6.Exit");
				int ch2=s.nextInt();

				switch(ch2)

				{

				case 1:

					Balanceinfo obj2=new Balanceinfo();
					obj2.balance();

					break;

				case 2:

					Withdrawsystem obj3=new Withdrawsystem();
					obj3.withDraw();

					break;
				case 3:

					Accountinfo obj4=new Accountinfo();
					obj4.generalInformation();

					break;
				case 4:

					BankStatement obj5=new BankStatement();
					obj5.statement();
					break;

				case 5:
                    ChangePin obj6= new ChangePin();
                    obj6.Change();
					break;
				case 6:
					System.exit(0);

				}

				break;

				

			case 3:

				System.exit(0);

				break;

			}

	

		}

	}

}

