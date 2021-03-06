package banksystem;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Dashboard {
    public Scanner scan = new Scanner(System.in);
    public double balance = 0;
	public int choice;
	public double bal[] = new double[]{0};

    //Pound sign
	public String pound = "\u00a3";

    public static void main(String[] args) {

        Account account = new Account();
        Dashboard transaction = new Dashboard();

        account.getUsername();
        
        account.getPassword();
        account.getCorrectLogin();
        boolean correctLogin = account.getCorrectLogin();
        String username = account.getUsername();

		account.checksForAccount();
        
        if (correctLogin = true) {
            transaction.transaction(correctLogin, username);
        }
	}

    // Main transaction method
    public void transaction(boolean correctLogin, String username) {
        System.out.println("--------- Welcome ---------");
        DecimalFormat df = new DecimalFormat("#.##");
        
        //ATM menu. Choose type of transaction here.
        System.out.println("Please select a choice: \n");

        System.out.println("1) View Balance");
        System.out.println("2) Withdraw");
        System.out.println("3) Deposit");

        choice = scan.nextInt();

        //Check balance
        switch(choice) {
        case 1:
            double newAmount = bal[0];
            System.out.println("Your balance is £" + df.format(newAmount) + "\n");
            anotherTransaction(correctLogin);
        }

        //Withdraw
        switch(choice) {
        case 2:
            double amount;

            System.out.println("How much do you want to withdraw? \n");
            balance = bal[0];
            amount = scan.nextDouble();

            if (amount > balance)  {
                System.out.println("You don't have sufficient funds \n");
                anotherTransaction(correctLogin);
            }

            else {
                double newAmount = balance - amount;
                bal[0] = newAmount;
                System.out.println("You now have £" + df.format(newAmount) + " in your account \n");

                anotherTransaction(correctLogin);
            }
        }

        //Deposit
        switch(choice) {
        case 3:
            System.out.println("How much would you like to deposit? \n");
            double amount = scan.nextDouble();

            double newAmount = balance + amount;
            bal[0] = newAmount;
            System.out.println("Your new balance is £" + df.format(newAmount) + "\n");

            anotherTransaction(correctLogin);

            break;
        }
    }

    //Method to ask user if they want to go to the menu and select a new option.
    public void anotherTransaction(boolean correctLogin) {
        Account account = new Account();
        account.getCorrectLogin();
        account.getUsername();

        String username = account.getUsername();

        System.out.println("Would you like to do another transaction? (Y/N) \n");
        String anotherTransaction = scan.next();
        
        if (anotherTransaction .equalsIgnoreCase("Y")) {
            transaction(correctLogin, username);
        }
        
        else if (anotherTransaction .equalsIgnoreCase("N")) {
            System.out.println("Goodbye :)");
            close();
        }
        
        else {
            System.out.println("Invalid choice \n");
            anotherTransaction(correctLogin);
        }
    }

    public void close() {
        scan.close();
    }
}
