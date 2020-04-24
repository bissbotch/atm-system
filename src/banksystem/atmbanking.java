/*
 * By: shushhhhhh
 * Description: Simple ATM styled banking system to check balance, deposit money and withdraw money. 
 */

package banksystem;

import java.util.Scanner;

public class atmbanking {
	
	private static Scanner scan = new Scanner(System.in);
	private static float balance = 0;
	static int choice;
	
	//Calls the transaction method
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		transaction();
	}
	
	
public static void transaction() {
	
	//ATM menu. Choose type of transaction here.
		
		System.out.println("Please select a choice: \n");
		
		System.out.println("1) View Balance");
		System.out.println("2) Withdraw");
		System.out.println("3) Deposit");
		
		choice = scan.nextInt();
		
		
		//Check balance
		
		switch(choice) {
		case 1:
			System.out.println("Your balance is £" + balance + "\n");
			anotherTransaction();
		}
		
		//Withdraw
		
		switch(choice) {
		case 2:
			float amount;
			System.out.println("How much do you want to withdraw? \n");
			amount = scan.nextFloat();
			
			if (amount > balance)  {
				System.out.println("You don't have sufficient funds \n");
				break;
			}
			
			else {
				float newAmount = balance - amount;
				System.out.println("You now have £" + newAmount + "in your account \n");
				
				anotherTransaction();
			}
		}
		
		//Deposit
		
		switch(choice) {
		case 3:
			System.out.println("How much would you like to deposit? \n");
			float amount = scan.nextFloat();
			
			float newAmount = balance + amount;
			System.out.println("Your new balance is £" + newAmount);
			
			anotherTransaction();
			
			break;
		}
	}

	//Method to ask user if they want to go to the menu and select a new option.
	
	private static void anotherTransaction() {
		System.out.println("Would you like to do another transaction? 1 = Yes\n 2 = No \n");
		int anotherTransaction = scan.nextInt();
		
		if (anotherTransaction == 1) {
			transaction();
		}
		
		else if (anotherTransaction == 2) {
			System.out.println("Goodbye :)");
		}
		
		else {
			System.out.println("Invalid choice \n");
			anotherTransaction();
		}
	}
	
}
	
	
