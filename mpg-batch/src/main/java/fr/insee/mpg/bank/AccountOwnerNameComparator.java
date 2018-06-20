package fr.insee.mpg.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.StringUtils;




public class AccountOwnerNameComparator implements Comparator<Account> {
	public InitBank ib;
	public AccountOwnerNameComparator(InitBank test) {
		// TODO Auto-generated constructor stub
		setIb(test);
		
	}
	@Override
	public int compare(Account o1, Account o2) {
		// TODO Auto-generated method stub
		List<User> listeU = getIb().getListeU();
		List<User> liste1 = new ArrayList<User>();
		List<User> liste2 = new ArrayList<User>();
		for (User u : listeU) {
			for (Account acc : u.getListeA()) {
				if (StringUtils.equalsIgnoreCase(acc.getNumber(), o1.getNumber())) {
					liste1.add(u);
					break;
				}
			}
			for (Account acc : u.getListeA()) {
				if (StringUtils.equalsIgnoreCase(acc.getNumber(), o2.getNumber())) {
					liste2.add(u);
					break;
				}
			}
		}
		o1.setListeU(liste1);
		o2.setListeU(liste2);
		Collections.sort(o1.getListeU());
		Collections.sort(o2.getListeU());
		return o1.getListeU().get(0).compareTo(o2.getListeU().get(0));
	}
	public InitBank getIb() {
		return ib;
	}
	public void setIb(InitBank ib) {
		this.ib = ib;
	}
	
	

}
