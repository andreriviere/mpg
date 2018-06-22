package fr.insee.mpg.bank;
import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	List<Costumer> costumers = new ArrayList<Costumer>();
	List<Account> accounts = new ArrayList<Account>();
  
	public void addCostumer(Costumer costumer) {
		
		costumers.add(costumer);
	}
	
public void addAccount(Account account) {
		
		accounts.add(account);
	}

	public List<Costumer> getCostumers() {
		return costumers;
	}

	public void setCostumers(List<Costumer> costumers) {
		this.costumers = costumers;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	

}

