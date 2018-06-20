package fr.insee.mpg.bank;

import java.util.List;

public class Account implements Comparable {
	public Integer amount;
	public String number;
	public List<User> listeU;
	
	@Override
	public int compareTo (Object o) {
		if(o.getClass().equals(Account.class)){
			//Nous allons trier sur le nom d'artiste
			Account ac = (Account)o;
			if(this.amount.compareTo(ac.getAmount()) == 0) {
				return this.number.compareTo(ac.getNumber());
			}
			return this.amount.compareTo(ac.getAmount());
		}
		return -1;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public List<User> getListeU() {
		return listeU;
	}
	public void setListeU(List<User> listeU) {
		this.listeU = listeU;
	}
	public List<User> recuperListeU(int number) {
		return listeU;
	}
	
}
