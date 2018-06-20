package fr.insee.mpg.bank;

import java.util.Comparator;

public class AccountNumberComparator implements Comparator<Account> {

	@Override
	public int compare(Account o1, Account o2) {
		// TODO Auto-generated method stub
		return o1.getNumber().compareTo(o2.getNumber());
	}

}