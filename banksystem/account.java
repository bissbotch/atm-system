package banksystem;
import java.util.Scanner;

public class Account {
	public static Scanner scan = new Scanner(System.in);

	private String username;
	private String password;
	private boolean correctLogin;

	//Checks for account
	public void checksForAccount() {
		boolean hasAccount = false;

		//Asks if user has an account
		System.out.println("Do you have an account? Type (Y/N)\n");
		String checkAccount = scan.next();

		while (!hasAccount) {
			if (checkAccount.equalsIgnoreCase("N")) {
				register();
				hasAccount = true;
				
			} else if (checkAccount.equalsIgnoreCase("Y")) {
				hasAccount = true;
				login();
			} else {
				System.out.println("Error. Please try again.");
			}
		}
	}

	//Register
    public void register() {
		System.out.println("-------- Welcome to the ATM Register -------- \n");

		//Asks for username
		System.out.println("Please enter a username: \n");
		username = scan.next();

		setUsername(username);


		//Asks for password
		System.out.println("Please enter a password: \n");
		password = scan.next();

		setPassword(password);
	}

	//Login
    public void login() {

		System.out.println("--- Welcome back --- \n")

		getUsername();
		getPassword();

		System.out.println("Enter a username: \n");
		String nameInput = scan.next();


		System.out.println("Enter a password: \n");
		String passInput = scan.next();

		correctLogin = false;
		while (!correctLogin) {
			if (nameInput.equals(username) && passInput.equals(password)) {
				System.out.println("Welcome back, " + username + "\n");
				correctLogin = true;
			} 
			
			else {
				System.out.println("Incorrect Login, try again");
				login();
			}
		}

		setCorrectLogin(correctLogin);
	}

	/*******************************************************************/


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getCorrectLogin() {
		return correctLogin;
	}

	public void setCorrectLogin(boolean correctLogin) {
		this.correctLogin = correctLogin;
	}
}
