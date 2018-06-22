package fr.insee.mpg.bank;

import java.util.List;

public class User implements Comparable {
	public String name;
	public List<AccountOld> listeA;
	@Override
	public int compareTo (Object o) {
		if(o.getClass().equals(User.class)){
			//Nous allons trier sur le nom d'artiste
			User u = (User)o;
			return u.getName().compareTo(this.name);
		}
		return -1;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AccountOld> getListeA() {
		return listeA;
	}

	public void setListeA(List<AccountOld> listeA) {
		this.listeA = listeA;
	}
	
	
	
	
}
