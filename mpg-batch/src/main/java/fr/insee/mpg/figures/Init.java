package fr.insee.mpg.figures;

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
import fr.insee.mpg.figures.Fenetre;
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


public class Init extends JFrame implements IBatch {

  private JMenuBar menuBar = new JMenuBar();

  private JMenu test1 = new JMenu("Add a triangle");

  private JMenu test2 = new JMenu("Add a quadrangle");

  private JMenu test3 = new JMenu("Move an image");
  
  private JMenu test4 = new JMenu("Change color");
  
  private JMenu test5 = new JMenu("Create random objects");
  
  private JMenu test6 = new JMenu("Print an image");

  private JMenuItem item1 = new JMenuItem("Add");

  private JMenuItem item2 = new JMenuItem("Add quadrangle");
  
  private JMenuItem item2bis = new JMenuItem("Add rectangle");
  
  private JMenuItem item2ter = new JMenuItem("Add square");
  
  private JMenuItem item3 = new JMenuItem("Move");
  
  private JMenuItem item4 = new JMenuItem("Change");
  
  private JMenuItem item5 = new JMenuItem("Create");

  private JMenuItem item6 = new JMenuItem("Print");
 
  private JPopupMenu jpm = new JPopupMenu();
  
  private List<Triangle> listeT;
  
  private List<Quadrangle> listeQ;
 
  public void executer(String[] args) {
	  Init i = new Init(args[0]);
  }


  public Init(String color) {

    this.setSize(800, 400);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLocationRelativeTo(null);


    //On initialise nos menus      






    //On met nos radios dans un ButtonGroup


    //On présélectionne la première radio



    //Ajout du sous-menu dans notre menu

    this.test1.add(this.item1);
    
    this.test2.add(this.item2);
    
    this.test2.add(this.item2bis);
    
    this.test2.add(this.item2ter);
    
    this.test3.add(this.item3);
    
    this.test4.add(this.item4);
    
    this.test5.add(this.item5);
    this.test6.add(this.item6);

    //Ajout d'un séparateur

    this.test1.addSeparator();

    item1.addActionListener(new AjoutListener(this, "triangle", color));
    
    item2.addActionListener(new AjoutListener(this, "quadrangle", color));
    
    item2bis.addActionListener(new AjoutListener(this, "rectangle", color));
    
    item2ter.addActionListener(new AjoutListener(this, "square", color));
    
    item3.addActionListener(new MoveListener(this, color));
    
    item4.addActionListener(new ColorListener(this, color));
    
    item4.addActionListener(new RandomListener(this, color));

    item6.addActionListener(new StartAnimationListener(this));

    //L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de gauche à droite

    //Le premier ajouté sera tout à gauche de la barre de menu et inversement pour le dernier

    this.menuBar.add(test1);

    this.menuBar.add(test2);
    
    this.menuBar.add(test3);

    this.menuBar.add(test4);
    
    this.menuBar.add(test5);
    
    this.menuBar.add(test6);

    this.setJMenuBar(menuBar);

    this.setVisible(true);

  }
  
  public class StartAnimationListener implements ActionListener{
	  	public Init test;
	  	public StartAnimationListener(Init test) {
	  		this.test = test;
	  	}
	  	
	    public void actionPerformed(ActionEvent arg0) {

	      JOptionPane jop = new JOptionPane();     

	      int option = jop.showConfirmDialog(null, 

	        "Do you want to print images ?", 

	        "Print images", 

	        JOptionPane.YES_NO_OPTION, 

	        JOptionPane.QUESTION_MESSAGE);


	      if(option == JOptionPane.OK_OPTION){

	        JCanvas jc = new JCanvas();
	    	jc.setBackground(Color.WHITE);
	    	jc.setPreferredSize(new Dimension(400,200));
	    	List<IDrawable> l = new ArrayList<IDrawable>();
	    	if (this.test.getListeT() != null) {
	    		for (Triangle t : this.test.getListeT()) {
	    			List<java.awt.Point> liste = new ArrayList<java.awt.Point>();
	    			liste.add(t.getLine1().getDepart());
	    			liste.add(t.getLine2().getDepart());
	    			liste.add(t.getLine3().getDepart());
	    			l.add(new LineDrawable(t.getColor(),liste));
	    		}
	    	}
	    	if (this.test.getListeQ() != null) {
	    		for (Quadrangle q : this.test.getListeQ()) {
	    			List<java.awt.Point> liste = new ArrayList<java.awt.Point>();
	    			liste.add(q.getLine1().getDepart());
	    			liste.add(q.getLine2().getDepart());
	    			liste.add(q.getLine3().getDepart());
	    			liste.add(q.getLine4().getDepart());
	    			l.add(new LineDrawable(q.getColor(),liste));
	    		}
	    	}
	    	for (IDrawable id : l) {
	    		jc.addDrawable(id);
	    	}

	    	GUIHelper.showOnFrame(jc,"test JCanvas with IDrawables");

	      }

	    }    

	  }
  
  
  public class AjoutListener implements ActionListener{

	  public Init test;
	  public String type;
	  public String color;
	  public AjoutListener(Init test, String type, String color) {
		  this.test = test;
		  this.type = type;
		  this.color = color;
	  }
	  
	  public void actionPerformed(ActionEvent arg0) {
		  if (StringUtils.equalsIgnoreCase(type, "triangle")) {
    	  Fenetre fen = new Fenetre(this.test, "Add triangle", color);
		  } else if (StringUtils.equalsIgnoreCase(type, "quadrangle")) {
			  Fenetre fen = new Fenetre(this.test, "Add quadrangle", color);
		  } else if (StringUtils.equalsIgnoreCase(type, "rectangle")) {
			  Fenetre fen = new Fenetre(this.test, "Add rectangle", color);
		  } else {
			  Fenetre fen = new Fenetre(this.test, "Add square", color);
		  }
//    	  jop2.showMessageDialog(null, "Votre nom est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);;

      }      

	  }
  
  public class MoveListener implements ActionListener{

	  public Init test;
	  public String color;
	  public MoveListener(Init test, String color) {
		  this.test = test;
		  this.color = color;
	  }
	  
	  public void actionPerformed(ActionEvent arg0) {
		  Fenetre fen = new Fenetre(this.test, "Move object", color);
//    	  jop2.showMessageDialog(null, "Votre nom est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);;

      }      

	  }

  public class ColorListener implements ActionListener{

	  public Init test;
	  public String color;
	  public ColorListener(Init test, String color) {
		  this.test = test;
		  this.color = color;
	  }
	  
	  public void actionPerformed(ActionEvent arg0) {
		  Fenetre fen = new Fenetre(this.test, "Change color", color);
//    	  jop2.showMessageDialog(null, "Votre nom est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);;

      }      

	  }
  
  public class RandomListener implements ActionListener{

	  public Init test;
	  public String color;
	  public RandomListener(Init test, String color) {
		  this.test = test;
		  this.color = color;
	  }
	  
	  public void actionPerformed(ActionEvent arg0) {
		  Fenetre fen = new Fenetre(this.test, "Create Random Objects", color);
//    	  jop2.showMessageDialog(null, "Votre nom est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);;

      }      

	  }
  
public List<Triangle> getListeT() {
	return listeT;
}


public void setListeT(List<Triangle> listeT) {
	this.listeT = listeT;
}


public List<Quadrangle> getListeQ() {
	return listeQ;
}


public void setListeQ(List<Quadrangle> listeQ) {
	this.listeQ = listeQ;
}




	  /**

	  * Écouteur du menu Quitter

	  * @author CHerby

	  */
	  
	
  

}