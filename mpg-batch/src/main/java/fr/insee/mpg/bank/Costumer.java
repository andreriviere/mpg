package fr.insee.mpg.bank;

import java.util.List;

public class Costumer {

	private String firstName;
	private String lastName;
	private List<Account> listAccount;

	Costumer(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "First Name" + firstName + "Last Name" + lastName ;
	}

	public List<Account> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}
}
