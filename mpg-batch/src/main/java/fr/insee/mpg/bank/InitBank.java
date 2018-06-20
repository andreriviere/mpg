package fr.insee.mpg.bank;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.math.RoundingMode;
import java.text.AttributedCharacterIterator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;

import javax.swing.JCheckBoxMenuItem;

import javax.swing.JFrame;

import javax.swing.JMenu;

import javax.swing.JMenuBar;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

import org.apache.commons.lang.StringUtils;

import fr.insee.mpg.batch.IBatch;
import fr.insee.mpg.figures.GUIHelper;
import fr.insee.mpg.figures.IDrawable;
import fr.insee.mpg.figures.JCanvas;
import fr.insee.mpg.figures.LineDrawable;
import fr.insee.mpg.figures.Quadrangle;
import fr.insee.mpg.figures.Triangle;
import fr.insee.mpg.math.Expression;
import fr.insee.mpg.math.Sum;
import fr.insee.mpg.math.Product;
import fr.insee.mpg.math.SquareRoot;
import fr.insee.mpg.math.Number;


public class InitBank extends JFrame implements IBatch {

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
	  InitBank i = new InitBank(args[0]);
  }


  public InitBank(String color) {

    this.setSize(800, 400);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLocationRelativeTo(null);


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
    item2.addActionListener(new UserListener(this, "sum"));
    
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
	  public String color;
	  public AccountListener(InitBank test, String type) {
		  this.test = test;
		  this.type = type;
		  this.color = color;
	  }
	  
	  public void actionPerformed(ActionEvent arg0) {
    	  Fenetre fen = new Fenetre(this.test, type);
//    	  jop2.showMessageDialog(null, "Votre nom est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);;

      }      

	  }
  
  public class UserListener implements ActionListener{

	  public InitBank test;
	  public String type;
	  public UserListener(InitBank test, String type) {
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
