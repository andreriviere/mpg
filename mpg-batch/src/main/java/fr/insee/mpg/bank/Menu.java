package fr.insee.mpg.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

public class Menu {

	Scanner keyboard = new Scanner(System.in);
	Bank bank = new Bank();
	boolean exit;
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.runMenu();
	}
	
	public void runMenu() {
		printHeader();
		while(!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
	}

	private void performAction(int choice) {
		
		switch(choice) {
		
		case 0:
		  System.out.println("Thank for using the application");
		  System.exit(0);
		  break;
		
		case 1:
			createAccount();
			break;
		case 2:
			makeDeposit();
			break;
		case 3:
			makeWithdrawal();
			break;
		case 4:
			accountBalance();
			break;
		default:
		System.out.println("Error");
		
		}
	}

	private void accountBalance() {
		// TODO Auto-generated method stub
		System.out.println("Please enter the code of the account you want to check");
		String code = "";
		try {
			code = keyboard.nextLine();
		} catch(NumberFormatException e) {
			System.out.println("Please enter only numbers");
		}
		Account account = null;
		List<Account> liste = bank.getAccounts();
		for (Account acc : liste) {
			if (StringUtils.equalsIgnoreCase(acc.getCode(), code)) {
				account = acc;
				break;
			}
		}
		if (account == null) {
			System.out.println("There is no account with the code " + code);
		} else {
			System.out.println("You have " + account.getBalance() + " zlotys on your account number " + code);
		}
	}

	private void makeWithdrawal() {
		// TODO Auto-generated method stub
		String code = "";
		Account account = null;
		System.out.println("Please enter the code of the account you want to draw");
		try {
			code=keyboard.nextLine();
		} catch(NumberFormatException e) {
			System.out.println("Please enter only numbers");
		}
		List<Account> liste = bank.getAccounts();
		for (Account acc : liste) {
			if (StringUtils.equalsIgnoreCase(acc.getCode(), code)) {
				account = acc;
				break;
			}
		}
		if (account == null) {
			System.out.println("There is no account with the code " + code);
		} else {
			System.out.println("Please enter the amount of your withdrawal");
			try {
				account.withdrawal(Double.parseDouble(keyboard.nextLine()));
			}
			catch(NumberFormatException e) {
				System.out.println("Please enter only numbers");
			}
		}
	}

	private void makeDeposit() {
		String code = "";
		Account account = null;
		System.out.println("Please enter the code of the account you want to credit");
		try {
			code=keyboard.nextLine();
		} catch(NumberFormatException e) {
			System.out.println("Please enter only numbers");
		}
		List<Account> liste = bank.getAccounts();
		for (Account acc : liste) {
			if (StringUtils.equalsIgnoreCase(acc.getCode(), code)) {
				account = acc;
				break;
			}
		}
		if (account == null) {
			System.out.println("There is no account with the code " + code);
		} else {
			System.out.println("Please enter the amount of your deposit");
			try {
				account.deposit(Double.parseDouble(keyboard.nextLine()));
			}
			catch(NumberFormatException e) {
				System.out.println("Please enter only numbers");
			}
		}
		
	}

	private void createAccount() {
		
		String firstName, lastName, code;
		double deposit;
		Account account = new Account();
		System.out.println("Please enter your fist name");
		firstName = keyboard.nextLine();
		System.out.println("Please enter your last name");
		lastName = keyboard.nextLine();
		System.out.println("Enter your account code");
			
		try {
			code = keyboard.nextLine();
			account.setCode(code);
			System.out.println("Please enter your deposit");
			deposit = Double.parseDouble(keyboard.nextLine());
			account.setBalance(deposit);
		}
		catch(NumberFormatException e) {
			System.out.println("Please enter only numbers");
		}
		List<Account> liste = new ArrayList<Account>();
		liste.add(account);
		Costumer costumer = new Costumer(firstName, lastName);
		costumer.setListAccount(liste);
		bank.addAccount(account);
		bank.addCostumer(costumer);
	}

	private int getInput() {
		int choice = -1;
		do {
			System.out.println("Enter your choice");
		try {
			
			choice  = Integer.parseInt(keyboard.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Invalid Selection");
			
		}
         if(choice < 0 || choice > 4) {
        	 System.out.println("Choice outside of range");
         }
         
		}while(choice < 0 || choice > 4);
		return choice;
}

	private void printMenu() {
		
		System.out.println("Please make a selection");
		System.out.println("1) Create a new Account");
		System.out.println("2) Make a deposit");
		System.out.println("3) Make a withdrawal");
		System.out.println("4) Account balance");
	}

	private void printHeader() {
		
		System.out.println("Bank Program");
	}
}

