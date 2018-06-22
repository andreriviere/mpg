package fr.insee.mpg.bank;

import java.util.Comparator;

public class AccountNumberComparator implements Comparator<AccountOld> {

	@Override
	public int compare(AccountOld o1, AccountOld o2) {
		// TODO Auto-generated method stub
		return o1.getNumber().compareTo(o2.getNumber());
	}

}