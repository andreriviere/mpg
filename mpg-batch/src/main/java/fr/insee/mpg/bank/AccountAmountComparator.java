package fr.insee.mpg.bank;

import java.util.Comparator;

public class AccountAmountComparator implements Comparator<AccountOld> {

	@Override
	public int compare(AccountOld o1, AccountOld o2) {
		// TODO Auto-generated method stub
		return o1.getAmount().compareTo(o2.getAmount());
	}

}
