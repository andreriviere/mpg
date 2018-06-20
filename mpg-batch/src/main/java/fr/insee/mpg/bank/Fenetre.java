package fr.insee.mpg.bank;

import java.awt.Polygon;
import java.util.ArrayList;
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
  
  public Fenetre(InitBank test, String title){      
	  if (StringUtils.containsIgnoreCase(title, "add")) {
		ZDialog zd = new ZDialog(null, title, true);
		ZDialogInfo zInfo = zd.showZDialog(); 
		setzI(zInfo);
		List<Account> liste = test.getListeA();
		for (Account account : liste) {
			if (account.getNumber() == Integer.parseInt(zInfo.getNumber())) {
				liste.remove(account);
				account.setNumber(account.getAmount() + zInfo.getSomme());
				liste.add(account);
			}
		}
		test.setListeA(liste);

	  } else if (StringUtils.containsIgnoreCase(title, "quadrangle") || StringUtils.containsIgnoreCase(title, "rectangle") || StringUtils.containsIgnoreCase(title, "square")){
		 ZDialog zd = new ZDialog(null, title, true);
		 ZDialogInfo zInfo = zd.showZDialog(); 
		 setzI(zInfo);
		
		 JOptionPane jop = new JOptionPane();
		 jop.showMessageDialog(null, zInfo.toString(), "Informations about the quadrangle", JOptionPane.INFORMATION_MESSAGE);
	  } else if (StringUtils.containsIgnoreCase(title, "move")) {
		  ZDialog zd = new ZDialog(null, title, true);
		  ZDialogInfo zInfo = zd.showZDialog();
		 
		
	  } else if (StringUtils.containsIgnoreCase(title, "change")) {
		  ZDialog zd = new ZDialog(null, title, true);
		  ZDialogInfo zInfo = zd.showZDialog();
		 
	  } else {
		  ZDialog zd = new ZDialog(null, title, true);
		  ZDialogInfo zInfo = zd.showZDialog();
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

