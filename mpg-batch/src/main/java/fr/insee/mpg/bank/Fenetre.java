package fr.insee.mpg.bank;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;

public class Fenetre extends JFrame {
	
  public ZDialogInfo zI;

  
  public Fenetre(String title) {
	  if (StringUtils.equalsIgnoreCase(title, "ajouter")) {
		  ZDialog zd = new ZDialog(null, title, true);
		  ZDialogInfo zInfo = zd.showZDialog(); 
		setzI(zInfo);
	  }
  }
  
  public Fenetre(InitBank test, String title) {    
	  ZDialog zd = new ZDialog(null, title, true);
	  ZDialogInfo zInfo = zd.showZDialog(); 
	  setzI(zInfo);
	  List<AccountOld> liste = test.getListeA();
	  List<User> listeU = test.getListeU();
	  if (StringUtils.containsIgnoreCase(title, "add") || StringUtils.containsIgnoreCase(title, "draw") || StringUtils.containsIgnoreCase(title, "show m") || StringUtils.containsIgnoreCase(title, "show o")) {
		if (liste != null) {
			int compteur = 0;
			for (AccountOld account : liste) {
				if (StringUtils.equalsIgnoreCase(account.getNumber(), zInfo.getNumber())) {
					liste.remove(account);
					if (StringUtils.containsIgnoreCase(title, "add")) {
						if (zInfo.getSomme() >=0) {
							account.setAmount(account.getAmount() + zInfo.getSomme());
						} else {
							JOptionPane jop = new JOptionPane();
							jop.showMessageDialog(null, "You cannot add a negative amount", "Alert", JOptionPane.INFORMATION_MESSAGE);
						}
					} else if (StringUtils.containsIgnoreCase(title, "draw")){
						if (zInfo.getSomme() >=0) {
							if (zInfo.getSomme() <= account.getAmount()) {
								account.setAmount(account.getAmount() - zInfo.getSomme());
							} else {
								JOptionPane jop = new JOptionPane();
								jop.showMessageDialog(null, "You have not enough money on the account number " + account.getNumber(), "Alert", JOptionPane.INFORMATION_MESSAGE);
							}
						} else {
							JOptionPane jop = new JOptionPane();
							jop.showMessageDialog(null, "You cannot draw a negative amount", "Alert", JOptionPane.INFORMATION_MESSAGE);
						}
					} else if (StringUtils.containsIgnoreCase(title, "show m")) {
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null, "There is " + account.getAmount() + " zlotys on the account number " + account.getNumber(), "Information", JOptionPane.INFORMATION_MESSAGE);
					} else {
						List<User> owners = new ArrayList<User>();
						StringBuilder result = new StringBuilder();
						for (User user : listeU) {
							for (AccountOld acc : user.getListeA()) {
								if (StringUtils.equalsIgnoreCase(acc.getNumber(), account.getNumber())) {
									owners.add(user);
									break;
								}
							}
						}
						if (owners.isEmpty()) {
							JOptionPane jop = new JOptionPane();
							jop.showMessageDialog(null, "No owners registered for this account or this account doesn't exist", "Alert", JOptionPane.INFORMATION_MESSAGE);
						} else if (owners.size() == 1) {
							result.append("The owner of the account number " + account.getNumber() + " is : \n");
						} else {
							result.append("The owners of the account number " + account.getNumber() + " are : \n");
						}
						for (User user : owners) {
							result.append("" + user.getName() + " \n");
						}
						JOptionPane jop = new JOptionPane();
						jop.showMessageDialog(null, result.toString(), "Information", JOptionPane.INFORMATION_MESSAGE);
					}
					liste.add(account);
					compteur ++;
					break;
				}
			}
			if (compteur == 0 && zInfo.getNumber() != null) {
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(null, "No account with the number " + zInfo.getNumber() + " found !", "Alert", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane jop = new JOptionPane();
			jop.showMessageDialog(null, "No accounts registered", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		test.setListeA(liste);
	  } else if (StringUtils.containsIgnoreCase(title, "sum")) {
		  List<AccountOld> listeA = new ArrayList<AccountOld>();
		  int somme = 0;
		  if (listeU != null) {
			  for (User user : listeU) {
				  if (StringUtils.equalsIgnoreCase(user.getName(), zInfo.getNumber())) {
					  listeA = user.getListeA();
					  break;
				  }
			  }
			  for (AccountOld acc : listeA) {
				  somme += acc.getAmount();
			  }
			  JOptionPane jop = new JOptionPane();
			  if (listeA == null || listeA.isEmpty()) {
				  jop.showMessageDialog(null, zInfo.getNumber() + " has no accounts in our bank", "Alert", JOptionPane.INFORMATION_MESSAGE);
			  } else if (listeA.size() == 1) {
				  jop.showMessageDialog(null, zInfo.getNumber() + " has " + somme + " zlotys in his account", "Information", JOptionPane.INFORMATION_MESSAGE);
			  } else {
				  jop.showMessageDialog(null, zInfo.getNumber() + " has " + somme + " zlotys in his accounts", "Information", JOptionPane.INFORMATION_MESSAGE);
			  }
		  }
	  } else if (StringUtils.containsIgnoreCase(title, "ascending saved") || StringUtils.containsIgnoreCase(title, "descending saved")) {
		  StringBuilder sb = new StringBuilder();
		  Collections.sort(liste, new AccountAmountComparator());
		  if (StringUtils.containsIgnoreCase(title, "descending saved")) {
			  Collections.reverse(liste);
		  }
		  JOptionPane jop = new JOptionPane();
		  sb.append("The list of accounts sorted by amounts is : \n ");
		  for (AccountOld acc : liste) {
			  sb.append("Number : " + acc.getNumber() + " with " + acc.getAmount() + " zlotys. \n"); 
		  }
		  jop.showMessageDialog(null, sb.toString(), "Information", JOptionPane.INFORMATION_MESSAGE);
	  } else if (StringUtils.containsIgnoreCase(title, "ascending owner") || StringUtils.containsIgnoreCase(title, "descending owner")) {
		  StringBuilder sb = new StringBuilder();
		  Collections.sort(liste, new AccountOwnerNameComparator(test));
		  if (StringUtils.containsIgnoreCase(title, "ascending owner")) {
			  Collections.reverse(liste);
		  }
		  JOptionPane jop = new JOptionPane();
		  sb.append("The list of accounts sorted by owner's names is : \n ");
		  for (AccountOld acc : liste) {
			  List<User> listU = new ArrayList<User>();
			  for (User u : listeU) {
				  for (AccountOld a : u.getListeA()) {
					  if (StringUtils.equalsIgnoreCase(acc.getNumber(), a.getNumber())) {
						  listU.add(u);
						  break;
					  }
				  }
			  }
			  Collections.sort(listU);
			  sb.append("Number : " + acc.getNumber() + " possessed by " + listU.get(0).getName() + ". \n"); 
		  }
		  jop.showMessageDialog(null, sb.toString(), "Information", JOptionPane.INFORMATION_MESSAGE);
	  } else if (StringUtils.containsIgnoreCase(title, "ascending account") || StringUtils.containsIgnoreCase(title, "descending account")) {
		  StringBuilder sb = new StringBuilder();
		  Collections.sort(liste, new AccountNumberComparator());
		  if (StringUtils.containsIgnoreCase(title, "descending account")) {
			  Collections.reverse(liste);
		  }
		  JOptionPane jop = new JOptionPane();
		  sb.append("The list of accounts sorted by number is : \n ");
		  for (AccountOld acc : liste) {
			  sb.append("Number : " + acc.getNumber() + ". \n"); 
		  }
		  jop.showMessageDialog(null, sb.toString(), "Information", JOptionPane.INFORMATION_MESSAGE);
	  }


//	  this.setVisible(true);      
  }
  public ZDialogInfo getzI() {
	  return zI;
  }
  public void setzI(ZDialogInfo zI) {
	  this.zI = zI;
  }
  
}

