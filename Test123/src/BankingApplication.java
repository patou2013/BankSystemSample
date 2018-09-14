import java.util.Scanner;

/**
 * @author Patrice N
 * @version 1.0
 * @Description: This program is to illustrate a simple banking system 
 */
public class BankingApplication {

	public static void main(String[] args) {
		
		BankAccount obj1 = new BankAccount("xyz","00000001");
		obj1.showMenu();

	}

}

class BankAccount {

	int balance;
	int previousTransaction;
	String CustomerName;
	String CustomerId;

	BankAccount(String cname, String cid) {

		CustomerName = cname;
		CustomerId = cid;

	}

	void deposit(int amount) {
		if (amount > -1) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}

	void withdraw(int amount) {
		if (amount > -1) {
			balance = balance - amount;
			previousTransaction = amount;
		}
	}

	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited : " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdraw: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction occured");
		}
	}

	void showMenu() {

		char option = '\0';
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome " + CustomerName);
		System.out.println("Your ID is: " + CustomerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous transaction");
		System.out.println("E. Exit");

		do {
			System.out.println("**********************************************************************");
			System.out.println("Enter and option");
			System.out.println("**********************************************************************");
			option = scanner.next().charAt(0);
			System.out.println("\n");

			switch (option) {
			case 'A':
				System.out.println("****************************");
				System.out.println("Balance = " + balance);
				System.out.println("*****************************");
				System.out.println("\n");
				break;

			case 'B':
				System.out.println("****************************");
				System.out.println("Enter amount to deposit: ");
				System.out.println("*****************************");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;

			case 'C':
				System.out.println("****************************");
				System.out.println("Enter an amount to withdraw: ");
				System.out.println("*****************************");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;

			case 'D':
				System.out.println("****************************");
				getPreviousTransaction();
				System.out.println("*****************************");
				System.out.println("\n");
				break;
				
			case 'E':
				System.out.println("***************************************");
				break;

			default:
				System.out.println("Invalid Option ! Please enter again");
				System.out.println("\n");
				break;
			}
		} while (option != 'E');

		System.out.println("Thank you for using our services.");
	}
}