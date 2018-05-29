package fr.insee.mpg.batch;

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

  private JLabel nomLabel, prenomLabel, equipeLabel, posteLabel, colorLabel, abscisse1Label, ordonnee1Label, abscisse2Label, ordonnee2Label, abscisse3Label,ordonnee3Label, abscisse4Label, ordonnee4Label, icon;


  private JTextField nom, prenom, equipe, poste, colorfigures, abscisse1, ordonnee1, abscisse2, ordonnee2, abscisse3, ordonnee3, abscisse4, ordonnee4;
  
  private String col;


  public ZDialog(JFrame parent, String title, boolean modal){

	    super(parent, title, modal);

	    this.setSize(550, 550);

	    this.setLocationRelativeTo(null);

	    this.setResizable(false);

	    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

	    this.initComponent(title);

	  }
  
  public ZDialog(JFrame parent, String title, String color, boolean modal){

    super(parent, title, modal);

    this.setSize(550, 550);

    this.setLocationRelativeTo(null);

    this.setResizable(false);

    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

    this.initComponent(title, color);

  }


  public ZDialogInfo showZDialog(){

    this.sendData = false;

    this.setVisible(true);      

    return this.zInfo;      

  }


  private void initComponent(String title, String color){

    //Icône
	col = new String(color);
	  
    icon = new JLabel(new ImageIcon("images/icone.jpg"));

    JPanel panIcon = new JPanel();

    panIcon.setBackground(Color.white);

    panIcon.setLayout(new BorderLayout());

    panIcon.add(icon);


    //Le nom
    
    JPanel content = new JPanel();

   
    if (StringUtils.containsIgnoreCase(title, "Change")) {
    	JPanel panColor = new JPanel();
    	panColor.setBackground(Color.white);
    	panColor.setPreferredSize(new Dimension(220, 60));
    	panColor.setBorder(BorderFactory.createTitledBorder("Choix couleur"));
    	colorfigures = new JTextField();
    	colorfigures.setPreferredSize(new Dimension(100, 25));
    	colorLabel = new JLabel("Saisir couleur :");
    	panColor.add(colorLabel);
    	panColor.add(colorfigures);
    	content.add(panColor);
    } else {
    	JPanel panAbscisse1 = new JPanel();

    	panAbscisse1.setBackground(Color.white);

    	panAbscisse1.setPreferredSize(new Dimension(220, 60));
    	abscisse1 = new JTextField();

    	abscisse1.setPreferredSize(new Dimension(100, 25));
    	if (StringUtils.containsIgnoreCase(title, "Move")) {
    		panAbscisse1.setBorder(BorderFactory.createTitledBorder("Translation de l'abscisse"));
    		abscisse1Label = new JLabel("Saisir translation abscisse :");
    	} else {

    		panAbscisse1.setBorder(BorderFactory.createTitledBorder("Abscisse du premier point"));

    		abscisse1Label = new JLabel("Saisir abscisse premier point :");
    	}

    	panAbscisse1.add(abscisse1Label);

    	panAbscisse1.add(abscisse1);


    	//L'ordonnée du premier point

    	JPanel panOrdonnee1 = new JPanel();

    	panOrdonnee1.setBackground(Color.white);

    	panOrdonnee1.setPreferredSize(new Dimension(220, 60));

    	ordonnee1 = new JTextField();

    	ordonnee1.setPreferredSize(new Dimension(100, 25));

    	if (StringUtils.containsIgnoreCase(title, "Move")) {
    		panOrdonnee1.setBorder(BorderFactory.createTitledBorder("Translation de l'ordonnée"));

    		ordonnee1Label = new JLabel("Saisir translation ordonnée :");
    	} else {

    		panOrdonnee1.setBorder(BorderFactory.createTitledBorder("Ordonnée du premier point"));

    		ordonnee1Label = new JLabel("Saisir ordonnée premier point :");
    	}

    	panOrdonnee1.add(ordonnee1Label);

    	panOrdonnee1.add(ordonnee1);

    	

    	content.setBackground(Color.white);

    	content.add(panAbscisse1);

    	content.add(panOrdonnee1);
    	//Le nom
    	if (!StringUtils.containsIgnoreCase(title, "Move")) {
    		
    		
    		
    		if (StringUtils.containsIgnoreCase(title, "square") || StringUtils.containsIgnoreCase(title, "create")) {
    			
    			JPanel panAbscisse2 = new JPanel();

        		panAbscisse2.setBackground(Color.white);

        		panAbscisse2.setPreferredSize(new Dimension(220, 60));

        		abscisse2 = new JTextField();

        		abscisse2.setPreferredSize(new Dimension(100, 25));
    			panAbscisse2.setBorder(BorderFactory.createTitledBorder("Longueur du carré"));

        		abscisse2Label = new JLabel("Saisir longueur du carré :");

        		panAbscisse2.add(abscisse2Label);

        		panAbscisse2.add(abscisse2);
        		content.add(panAbscisse2);
    		} else {
    			if (!StringUtils.containsIgnoreCase(title, "rectangle")) {
    				JPanel panAbscisse2 = new JPanel();

    				panAbscisse2.setBackground(Color.white);

    				panAbscisse2.setPreferredSize(new Dimension(220, 60));

    				abscisse2 = new JTextField();

    				abscisse2.setPreferredSize(new Dimension(100, 25));
    				panAbscisse2.setBorder(BorderFactory.createTitledBorder("Abscisse du second point"));

    				abscisse2Label = new JLabel("Saisir abscisse second point :");

    				panAbscisse2.add(abscisse2Label);

    				panAbscisse2.add(abscisse2);


    				//L'ordonnée du premier point

    				JPanel panOrdonnee2 = new JPanel();

    				panOrdonnee2.setBackground(Color.white);

    				panOrdonnee2.setPreferredSize(new Dimension(220, 60));

    				ordonnee2 = new JTextField();

    				ordonnee2.setPreferredSize(new Dimension(100, 25));

    				panOrdonnee2.setBorder(BorderFactory.createTitledBorder("Ordonnée du second point"));

    				ordonnee2Label = new JLabel("Saisir ordonnée second point :");

    				panOrdonnee2.add(ordonnee2Label);

    				panOrdonnee2.add(ordonnee2);
        			content.add(panAbscisse2);

        			content.add(panOrdonnee2);
    			}

    			//Le nom

    			JPanel panAbscisse3 = new JPanel();

    			panAbscisse3.setBackground(Color.white);

    			panAbscisse3.setPreferredSize(new Dimension(220, 60));

    			abscisse3 = new JTextField();

    			abscisse3.setPreferredSize(new Dimension(100, 25));

    			panAbscisse3.setBorder(BorderFactory.createTitledBorder("Abscisse du troisième point"));

    			abscisse3Label = new JLabel("Saisir abscisse troisième point :");

    			panAbscisse3.add(abscisse3Label);

    			panAbscisse3.add(abscisse3);


    			//L'ordonnée du premier point

    			JPanel panOrdonnee3 = new JPanel();

    			panOrdonnee3.setBackground(Color.white);

    			panOrdonnee3.setPreferredSize(new Dimension(220, 60));

    			ordonnee3 = new JTextField();

    			ordonnee3.setPreferredSize(new Dimension(100, 25));

    			panOrdonnee3.setBorder(BorderFactory.createTitledBorder("Ordonnée du troisième point"));

    			ordonnee3Label = new JLabel("Saisir ordonnée troisième point :");

    			panOrdonnee3.add(ordonnee3Label);

    			panOrdonnee3.add(ordonnee3);







    			content.add(panAbscisse3);

    			content.add(panOrdonnee3);


    			if (!StringUtils.containsIgnoreCase(title, "triangle") && !StringUtils.containsIgnoreCase(title, "rectangle")) {
    				
        			JPanel panAbscisse4 = new JPanel();


        			JPanel panOrdonnee4 = new JPanel();

    				panAbscisse4.setBackground(Color.white);

    				panAbscisse4.setPreferredSize(new Dimension(220, 60));

    				abscisse4 = new JTextField();

    				abscisse4.setPreferredSize(new Dimension(100, 25));

    				panAbscisse4.setBorder(BorderFactory.createTitledBorder("Abscisse du quatrième point"));

    				abscisse4Label = new JLabel("Saisir abscisse quatrième point :");

    				panAbscisse4.add(abscisse4Label);

    				panAbscisse4.add(abscisse4);


    				//L'ordonnée du premier point


    				panOrdonnee4.setBackground(Color.white);

    				panOrdonnee4.setPreferredSize(new Dimension(220, 60));

    				ordonnee4 = new JTextField();

    				ordonnee4.setPreferredSize(new Dimension(100, 25));

    				panOrdonnee4.setBorder(BorderFactory.createTitledBorder("Ordonnée du quatrième point"));

    				ordonnee4Label = new JLabel("Saisir ordonnée quatrième point :");

    				panOrdonnee4.add(ordonnee4Label);

    				panOrdonnee4.add(ordonnee4);


    				content.add(panAbscisse4);

    				content.add(panOrdonnee4);
    			}

    		}
    	}
    }
   

    JPanel control = new JPanel();

    JButton okBouton = new JButton("OK");

    
    if (StringUtils.containsIgnoreCase(title, "triangle")) {
    okBouton.addActionListener(new ActionListener(){

      public void actionPerformed(ActionEvent arg0) {        
 
        zInfo = new ZDialogInfo(col, abscisse1.getText(), ordonnee1.getText(), abscisse2.getText(), ordonnee2.getText(), abscisse3.getText(), ordonnee3.getText());

        setVisible(false);

      }
     

    });
    } else if (StringUtils.containsIgnoreCase(title, "quadrangle")){
    	okBouton.addActionListener(new ActionListener(){

    	      public void actionPerformed(ActionEvent arg0) {        
    	 
    	        zInfo = new ZDialogInfo(col, abscisse1.getText(), ordonnee1.getText(), abscisse2.getText(), ordonnee2.getText(), abscisse3.getText(), ordonnee3.getText(), abscisse4.getText(), ordonnee4.getText());

    	        setVisible(false);

    	      }
    	     

    	    });
    } else if (StringUtils.containsIgnoreCase(title, "rectangle")){
    	okBouton.addActionListener(new ActionListener(){

  	      public void actionPerformed(ActionEvent arg0) {        
  	 
  	        zInfo = new ZDialogInfo(col, abscisse1.getText(), ordonnee1.getText(), abscisse3.getText(), ordonnee3.getText());

  	        setVisible(false);

  	      }
  	     

  	    });
  } else if (StringUtils.containsIgnoreCase(title, "square")){
  	okBouton.addActionListener(new ActionListener(){

	      public void actionPerformed(ActionEvent arg0) {        
	 
	        try {
				zInfo = new ZDialogInfo(col, abscisse1.getText(), ordonnee1.getText(), abscisse2.getText());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        setVisible(false);

	      }
	     

	    });
} else if (StringUtils.containsIgnoreCase(title, "move")){
    	okBouton.addActionListener(new ActionListener(){

  	      public void actionPerformed(ActionEvent arg0) {        
  	 
  	        zInfo = new ZDialogInfo(abscisse1.getText(), ordonnee1.getText());

  	        setVisible(false);

  	      }
  	     

  	    });
    } else {
    	okBouton.addActionListener(new ActionListener(){

    	      public void actionPerformed(ActionEvent arg0) {        
    	 
    	        zInfo = new ZDialogInfo(colorfigures.getText());

    	        setVisible(false);

    	      }
    	     

    	    });
      }


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

  
  private void initComponent(String title){

	    //Icône
		  
	    icon = new JLabel(new ImageIcon("images/icone.jpg"));

	    JPanel panIcon = new JPanel();

	    panIcon.setBackground(Color.white);

	    panIcon.setLayout(new BorderLayout());

	    panIcon.add(icon);


	    //Le nom
	    
	    JPanel content = new JPanel();

	   
	    if (StringUtils.containsIgnoreCase(title, "ajouter")) {
	    	JPanel panNom = new JPanel();
	    	panNom.setBackground(Color.white);
	    	panNom.setPreferredSize(new Dimension(220, 60));
	    	panNom.setBorder(BorderFactory.createTitledBorder("Ajouter joueur"));
	    	nom = new JTextField();
	    	nom.setPreferredSize(new Dimension(100, 25));
	    	nomLabel = new JLabel("Saisir nom :");
	    	panNom.add(nomLabel);
	    	panNom.add(nom);
	    	prenom = new JTextField();
	    	prenom.setPreferredSize(new Dimension(100, 25));
	    	prenomLabel = new JLabel("Saisir prénom :");
	    	panNom.add(prenomLabel);
	    	panNom.add(prenom);
	    	equipe = new JTextField();
	    	equipe.setPreferredSize(new Dimension(100, 25));
	    	equipeLabel = new JLabel("Saisir équipe :");
	    	panNom.add(equipeLabel);
	    	panNom.add(equipe);
	    	poste = new JTextField();
	    	poste.setPreferredSize(new Dimension(100, 25));
	    	posteLabel = new JLabel("Saisir poste :");
	    	panNom.add(posteLabel);
	    	panNom.add(poste);
	    	content.add(panNom);
	    }
	   

	    JPanel control = new JPanel();

	    JButton okBouton = new JButton("OK");

	    
	    if (StringUtils.containsIgnoreCase(title, "ajouter")) {
	    okBouton.addActionListener(new ActionListener(){

	      public void actionPerformed(ActionEvent arg0) {        
	 
	        try {
				zInfo = new ZDialogInfo(nom.getText(), prenom.getText(), equipe.getText(), poste.getText());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        setVisible(false);

	      }
	     

	    });
	    } 


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
