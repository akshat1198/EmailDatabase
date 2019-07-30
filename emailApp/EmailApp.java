package emailApp;

import java.util.Scanner;

public class EmailApp {
	public static void main(String[] args) {
		
		Email em1 = new Email("John", "Smith");
		em1.setMode();
		//System.out.println(em1.showInfo());
		//em1.logIn();
		
	}
}


/*
 * Ask for Mode
 * If(admin)
 * 		admin id and password
 * 			if(success)
 * 				Ask of 2 admin activities
 * 				if(View Data)		
 * 					showInfo();
 * 				if(Add Data)
 * 					Add info still asked
 * 					showInfo();
 * 				Data stored();
 * 
 * 			if(fail)
 * 				Go back to ask Mode
 * If(user)
 * 		show Name
 * 		user id and temp password
 * 		change password
 * 		setAltEmail
 * 		showInfo();
 * Prompt to exit the project
 */	
