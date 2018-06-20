package fr.insee.mpg.bank;

import java.util.List;

public class User implements Comparable {
	public String name;
	public List<Account> listeA;
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

	public List<Account> getListeA() {
		return listeA;
	}

	public void setListeA(List<Account> listeA) {
		this.listeA = listeA;
	}
	
	
	
	
}
