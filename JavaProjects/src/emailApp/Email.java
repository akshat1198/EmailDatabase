package emailApp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int defaultPasswordLength = 10;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "aeycompany.com";

	// Constructor receiving first and last name

	public Email(String firstName, String lastName) {
		// "this" refers to class variable and the other one refers to local variable
		this.firstName = firstName;
		this.lastName = lastName;
		// System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

		// Call a method to ask for department and return it
		this.department = setDepartment();
		// System.out.println("Department: " + this.department);

		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		System.out.println("Your email is: " + email);

		// Call method to return random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your temporary password is" + " " + this.password);

	}

	// Ask the department
	private String setDepartment() {
		System.out.println("New Worker: " + firstName + ", Department Codes: \n1 for Sale"
				+ " \n2 for Development\n3 for Accounting\n0 for none" + "\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {
			return "sales";
		} else if (depChoice == 2) {
			return "dev";
		} else if (depChoice == 3) {
			return "acct";
		} else {
			return "";
		}

	}

	// Generate Random password
	private String randomPassword(int length) {
		String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	// Set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity; // "this" not really needed
	}

	// Set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail; // "this" not really needed
	}

	// Change the password
	public void changePassword() {
		String password;
		Scanner x = new Scanner(System.in);
		System.out.println("Enter your new password: ");
		password = x.nextLine();
		this.password = password;
		System.out.println("Password changed to: " + this.password);
		
	}

	public void logIn() {
		Scanner check = new Scanner(System.in);
		System.out.println("Enter your email: ");
		String email = check.nextLine();
		System.out.println("Enter your password: ");
		String password = check.nextLine();
		if ((email.equals(this.email)) && (password.equals(this.password))) {
			System.out.println("Login Successful");
			changePassword();
		} else {
			System.out.println("Login Failed");
		}
	}

	public void adminMode() {
		
		System.out.println("Choose an admin activity:\n1 View Data \n2 Add Data");
		Scanner y = new Scanner(System.in);
		int act = y.nextInt();
		if (act == 1) {
			System.out.println("VIEWING DATA");
			showInfo();
		} else if (act == 2) {
			System.out.println("INSERTING DATA");
		}

	}
	public void userMode() {
		showInfo();
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}

	public String showInfo() {
		return "Display Name: " + firstName + " " + lastName + "\nCompany Email:" + email + "\nMailBox Capacity: "
				+ mailboxCapacity + "mb";
	}

	public void setMode() {
		Scanner select = new Scanner(System.in);
		System.out.println("Two Modes to Login to the system:\n1 For Admin Mode \n2 For User Mode");
		System.out.println("Choose mode code:");
		int mode = select.nextInt();

		switch (mode) {
		case 1:

			System.out.println("Admin Mode Chosen");
			Scanner q = new Scanner(System.in);
			System.out.println("Enter the admin username: ");
			email = q.nextLine();
			System.out.println("Enter the admin password: ");
			password = q.nextLine();
			if ((email.equals("admin")) && (password.equals("admin"))) {
				System.out.println("Welcome ADMIN");
				adminMode();
			} else {
				System.out.println("Incorrect Admin Login. Try Again.");
				setMode();
			}

			/*
			 * Admin login to enter Admin credentials can never be changed Admin has choice
			 * to add or just view employee data Admin adds employees in the system Admin
			 * prints all the employees record once it is done adding There should be a way
			 * to exit from adminMode and be asked the mode question again
			 */
			break;
		case 2:
			System.out.println("User Mode Chosen");
			userMode();
			/*
			 * User must type their first and last name User will get a random password to
			 * use with company email User must change it's temporary password the first
			 * time they login User should be able to login with new password User can login
			 * to add alternate email User can login to just view their own data
			 */
			break;
		default:
			System.out.println("Invalid Choice");
			setMode();
			break;

		}
	}

}
