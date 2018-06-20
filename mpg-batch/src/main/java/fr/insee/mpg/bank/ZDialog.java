package fr.insee.mpg.bank;

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Dimension;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JComboBox;

import javax.swing.JDialog;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;

import javax.swing.ButtonGroup;

import javax.swing.JTextField;

import org.apache.commons.lang.StringUtils;


public class ZDialog extends JDialog {

  private ZDialogInfo zInfo = new ZDialogInfo();
  


  private boolean sendData;

  private JLabel sommeLabel, numberLabel, nomLabel, icon;


  private JTextField somme, number, nom;


  public ZDialog(JFrame parent, String title, boolean modal){

	    super(parent, title, modal);

	    this.setSize(550, 550);

	    this.setLocationRelativeTo(null);

	    this.setResizable(false);

	    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

	    this.initComponent(title);

	  }



  public ZDialogInfo showZDialog(){

    this.sendData = false;

    this.setVisible(true);      

    return this.zInfo;      

  }

  
  private void initComponent(String title){

	    //Icône
		  
	    icon = new JLabel(new ImageIcon("images/icone.jpg"));

	    JPanel panIcon = new JPanel();

	    panIcon.setBackground(Color.white);

	    panIcon.setLayout(new BorderLayout());

	    panIcon.add(icon);


	    //Le nom
	    
	    JPanel content = new JPanel();

	   
	    if (StringUtils.containsIgnoreCase(title, "add") || StringUtils.containsIgnoreCase(title, "draw") || StringUtils.containsIgnoreCase(title, "show m") || StringUtils.containsIgnoreCase(title, "show o")) {
	    	JPanel panNumber = new JPanel();
	    	JPanel panSomme = new JPanel();
	    	panNumber.setBackground(Color.white);
	    	panNumber.setPreferredSize(new Dimension(220, 60));
	    	panNumber.setBorder(BorderFactory.createTitledBorder("Number"));
	    	number = new JTextField();
	    	number.setPreferredSize(new Dimension(100, 25));
	    	numberLabel = new JLabel("Saisir numéro compte : ");
	    	panNumber.add(numberLabel);
	    	panNumber.add(number);
	    	content.add(panNumber);
	    	if (StringUtils.containsIgnoreCase(title, "add") || StringUtils.containsIgnoreCase(title, "draw")) {
	    		panSomme.setBackground(Color.white);
	    		panSomme.setPreferredSize(new Dimension(220, 60));
	    		panSomme.setBorder(BorderFactory.createTitledBorder("Amount"));
	    		somme = new JTextField();
	    		somme.setPreferredSize(new Dimension(100, 25));
	    		sommeLabel = new JLabel("Saisir somme : ");
	    		panSomme.add(sommeLabel);
	    		panSomme.add(somme);
	    		content.add(panSomme);
	    	}
	    } else if (StringUtils.containsIgnoreCase(title, "sum")) {
	    	JPanel panNom = new JPanel();
	    	panNom.setBackground(Color.white);
	    	panNom.setPreferredSize(new Dimension(220, 60));
	    	panNom.setBorder(BorderFactory.createTitledBorder("Number"));
	    	nom = new JTextField();
	    	nom.setPreferredSize(new Dimension(100, 25));
	    	nomLabel = new JLabel("Saisir nom client : ");
	    	panNom.add(nomLabel);
	    	panNom.add(nom);
	    	content.add(panNom);
	    }
	   
	    
	    JPanel control = new JPanel();

	    JButton okBouton = new JButton("OK");

	    
	    okBouton.addActionListener(new ActionListener(){

	      public void actionPerformed(ActionEvent arg0) {        
	    	if (somme != null) {
	    		zInfo = new ZDialogInfo(number.getText(), somme.getText());
	    	} else if (number != null) {
	    		zInfo = new ZDialogInfo(number.getText(), null);
	    	} else if (nom != null) {
	    		zInfo = new ZDialogInfo(nom.getText(), null);
	    	} else {
	    		zInfo = new ZDialogInfo(null, null);
	    	}

	        setVisible(false);

	      }
	     

	    });


	    JButton cancelBouton = new JButton("Annuler");

	    cancelBouton.addActionListener(new ActionListener(){

	      public void actionPerformed(ActionEvent arg0) {

	        setVisible(false);

	      }      

	    });


	    control.add(okBouton);

	    control.add(cancelBouton);


	    this.getContentPane().add(panIcon, BorderLayout.WEST);

	    this.getContentPane().add(content, BorderLayout.CENTER);

	    this.getContentPane().add(control, BorderLayout.SOUTH);

	  }

public ZDialogInfo getzInfo() {
	return zInfo;
}


public void setzInfo(ZDialogInfo zInfo) {
	this.zInfo = zInfo;
}  

  
  
}

