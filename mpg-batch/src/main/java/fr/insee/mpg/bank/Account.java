package fr.insee.mpg.bank;


public class Account {
	private double balance = 0;
	private static int numberOfAccounts = 1000000;
	private String code;

   Account(){
	   
   }
   
   public double getBalance() {
	   return balance;
   }
  
   
   public void withdrawal(double amount) {
	   if(amount > balance) {
		   System.out.println("You have insufficient amount");
		   return;
	   }
	   setBalance(balance - amount);
	   System.out.println("You have withdrawn " + amount + "dollars");
	   System.out.println("Tha balance now is " + getBalance());
   }
   
   public void deposit(double amount) {
	   setBalance(balance + amount);
	   System.out.println("You have deposited " + amount + "dollars");
   }

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public void setBalance(double balance) {
	this.balance = balance;
}
   
}

