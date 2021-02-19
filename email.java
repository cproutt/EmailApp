package EmailApp;

import java.util.Scanner;

public class email {
	private String company = "aig.com";
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String emailAddress;
	private int mailCap = 500;
	private int defaultPasswordLength = 10;
	private String altEmail;
	
	// Constructor receives first name and last name
	public email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		// call method to ask for department
		this.department = setDepartment();
		// call method to create a password
		this.password = setPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		// Combine elements to generate email
		emailAddress = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + company;
	}
	
	// Ask for the department
	private String setDepartment() {
		System.out.print("Enter the department\n 1 for Sales\n 2 for Development\n 3 for Accounting\n 0 for none");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {
			return "sales";
		} else if(depChoice == 2) {
			return "dev";
		} else if(depChoice == 3) {
			return "acct";
		} else {
			return "";
		}
	}
	
	// Generate a random password
	private String setPassword(int length) {
		String passwordSet = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&";
		char[] newPassword = new char[length];
		for(int i = 0; i < length; i++ ) {
			int rand = (int) (Math.random() * passwordSet.length());
			newPassword[i] = passwordSet.charAt(rand);
		}
		return new String(newPassword);
	}
	
	// Set Mailbox Capacity
	public void setMailCap(int capacity){
		this.mailCap = capacity;
	}
	
	// Set Alternative email
	public void setAltEmail(String email) {
		this.altEmail = email;
	}
	
	// Change Password
	public void changePassword(String password) {
		this.password = password;
	}
	
	// Getters
	public int getMailboxCap() {return mailCap;}
	public String getAltEmail() {return altEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME IS: " + firstName + " " + lastName + "\n" +
				"COMPANY EMAIL IS: " + emailAddress + "\n" +
				"MAILBOX CAPACITY IS: " + mailCap;}
}
