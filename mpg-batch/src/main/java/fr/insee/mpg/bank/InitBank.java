package fr.insee.mpg.bank;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import javax.swing.JMenu;

import javax.swing.JMenuBar;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import fr.insee.mpg.batch.IBatch;


public class InitBank extends JFrame implements IBatch {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private JMenuBar menuBar = new JMenuBar();

  private JMenu test1 = new JMenu("Account");

  private JMenu test2 = new JMenu("User");

  private JMenu test3 = new JMenu("List of accounts");

  private JMenuItem item1 = new JMenuItem("Add money");

  private JMenuItem item1bis = new JMenuItem("Draw money");
  
  private JMenuItem item1ter = new JMenuItem("Show money"); 
  
  private JMenuItem item1qua = new JMenuItem("Show owner(s)"); 
  
  private JMenuItem item2 = new JMenuItem("Show sum of money");
  
  private JMenuItem item3 = new JMenuItem("Ascending saved money");
  
  private JMenuItem item3bis = new JMenuItem("Descending saved money");
  
  private JMenuItem item3ter = new JMenuItem("Ascending owner names");
  private JMenuItem item3qua = new JMenuItem("Descending owner names");
  private JMenuItem item3qui = new JMenuItem("Ascending account numbers");
  private JMenuItem item3sex = new JMenuItem("Descending account numbers");
 
  private JPopupMenu jpm = new JPopupMenu();
  
  private List<User> listeU;
  
  private List<Account> listeA;
  
 
  public void executer(String[] args) {
	  InitBank i = new InitBank();
  }


  public InitBank() {

    this.setSize(800, 400);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLocationRelativeTo(null);
    List<Account> listeA = new ArrayList<Account>();
    List<Account> listeA1 = new ArrayList<Account>();
    List<Account> listeA2 = new ArrayList<Account>();
    List<Account> listeA3 = new ArrayList<Account>();
    List<Account> listeA4 = new ArrayList<Account>();
    List<Account> listeA5 = new ArrayList<Account>();
    Account account1 = new Account();
    account1.setAmount(1000);
    account1.setNumber("00001");
    Account account2 = new Account();
    account2.setAmount(1000);
    account2.setNumber("00002");
    Account account3 = new Account();
    account3.setAmount(1000);
    account3.setNumber("00003");
    Account account4 = new Account();
    account4.setAmount(1000);
    account4.setNumber("00004");
    Account account5 = new Account();
    account5.setAmount(1000);
    account5.setNumber("00005");
    Account account6 = new Account();
    account6.setAmount(1000);
    account6.setNumber("00006");
    Account account7 = new Account();
    account7.setAmount(1000);
    account7.setNumber("00007");
    Account account8 = new Account();
    account8.setAmount(1000);
    account8.setNumber("00008");
    Account account9 = new Account();
    account9.setAmount(1000);
    account9.setNumber("00009");
    Account account10 = new Account();
    account10.setAmount(1000);
    account10.setNumber("00010");
    listeA.add(account1);
    listeA.add(account2);
    listeA.add(account3);
    listeA.add(account4);
    listeA.add(account5);
    listeA.add(account6);
    listeA.add(account7);
    listeA.add(account8);
    listeA.add(account9);
    listeA.add(account10);
    listeA1.add(account1);
    listeA2.add(account2);
    listeA2.add(account3);
    listeA3.add(account3);
    listeA3.add(account4);
    listeA3.add(account5);
    listeA3.add(account6);
    listeA4.add(account6);
    listeA4.add(account7);
    listeA4.add(account8);
    listeA4.add(account9);
    listeA4.add(account10);
    listeA5.add(account1);
    listeA5.add(account3);
    listeA5.add(account6);
    listeA5.add(account10);
    List<User> listeU = new ArrayList<User>();
    User user1 = new User();
    user1.setName("DUPONT");
    user1.setListeA(listeA1);
    User user2 = new User();
    user2.setName("MARTIN");
    user2.setListeA(listeA2);
    User user3 = new User();
    user3.setName("RIBOU");
    user3.setListeA(listeA3);
    User user4 = new User();
    user4.setName("SCHNEIDERMAN");
    user4.setListeA(listeA4);
    User user5 = new User();
    user5.setName("PATULACCI");
    user5.setListeA(listeA5);
    listeU.add(user1);
    listeU.add(user2);
    listeU.add(user3);
    listeU.add(user4);
    listeU.add(user5);
    this.setListeA(listeA);
    this.setListeU(listeU);
    
    
    //On initialise nos menus      






    //On met nos radios dans un ButtonGroup


    //On présélectionne la première radio



    //Ajout du sous-menu dans notre menu

    this.test1.add(this.item1);
    
    this.test1.add(this.item1bis);
    this.test1.add(this.item1ter);
    this.test1.add(this.item1qua);
    
    this.test2.add(this.item2);
    
    this.test3.add(this.item3);
    
    this.test3.add(this.item3bis);
    this.test3.add(this.item3ter);
    this.test3.add(this.item3qua);
    this.test3.add(this.item3qui);
    this.test3.add(this.item3sex);

    //Ajout d'un séparateur

    this.test1.addSeparator();

    item1.addActionListener(new AccountListener(this, "add"));
    item1bis.addActionListener(new AccountListener(this, "draw"));
    item1ter.addActionListener(new AccountListener(this, "show m"));
    item1qua.addActionListener(new AccountListener(this, "show o"));
    item2.addActionListener(new AccountListener(this, "sum"));
    
    item3.addActionListener(new ListListener(this, "ascending saved"));
    
    item3bis.addActionListener(new ListListener(this, "descending saved"));
    
    item3ter.addActionListener(new ListListener(this, "ascending owner"));
    
    item3qua.addActionListener(new ListListener(this, "descending owner"));
    
    item3qui.addActionListener(new ListListener(this, "ascending account"));

    item3sex.addActionListener(new ListListener(this, "descending account"));

    //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite

    //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier

    this.menuBar.add(test1);

    this.menuBar.add(test2);
    
    this.menuBar.add(test3);

    this.setJMenuBar(menuBar);

    this.setVisible(true);

  }
  
  public class ListListener implements ActionListener{
	  public InitBank test;
	  public String type;
	  public ListListener(InitBank test, String type) {
		  this.test = test;
		  this.type = type;
	  }

	  public void actionPerformed(ActionEvent arg0) {

		  Fenetre fen = new Fenetre(this.test, type);

	  }

  }    

  
  
  public class AccountListener implements ActionListener{

	  public InitBank test;
	  public String type;
	  public AccountListener(InitBank test, String type) {
		  this.test = test;
		  this.type = type;
	  }
	  
	  public void actionPerformed(ActionEvent arg0) {
    	  Fenetre fen = new Fenetre(this.test, type);
//    	  jop2.showMessageDialog(null, "Votre nom est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);;

      }      

	  }

public List<User> getListeU() {
	return listeU;
}


public void setListeU(List<User> listeU) {
	this.listeU = listeU;
}


public List<Account> getListeA() {
	return listeA;
}


public void setListeA(List<Account> listeA) {
	this.listeA = listeA;
}

  
  





	  /**

	  * Écouteur du menu Quitter

	  * @author CHerby

	  */
	  
	
  

}
