package fr.insee.mpg.batch;

public class ZDialogInfo {
		private Image image;
	  private String col, abscisse1, ordonnee1, abscisse2, ordonnee2, abscisse3, ordonnee3, abscisse4, ordonnee4;
	  
	  private int longueurCarre;


	  public ZDialogInfo(){}

	  public ZDialogInfo(String color){

		  setCol(color);

	  }
	  
	  public ZDialogInfo(String abscisse1, String ordonnee1){

		  setAbscisse1(abscisse1);

		  setOrdonnee1(ordonnee1);

	  }
	  
	  public ZDialogInfo(String color, String abscisse1, String ordonnee1, String abscisse3, String ordonnee3) {

		  setAbscisse1(abscisse1);

		  setOrdonnee1(ordonnee1);
		  
		  setAbscisse3(abscisse3);
		  
		  setOrdonnee3(ordonnee3);
		  
		  java.awt.Point point1 = new java.awt.Point(Integer.parseInt(ordonnee1), Integer.parseInt(abscisse1));

		  java.awt.Point point3 = new java.awt.Point(Integer.parseInt(ordonnee3), Integer.parseInt(abscisse3));

		  Image image = getImage();
		  if (image == null) {
			  image = new Image();
		  }
		  image.addObject(new Rectangle(color, point1, point3));
		  setImage(image);

	  }
	  
	  public ZDialogInfo(String color, String abscisse1, String ordonnee1, String longueur) {

		  setAbscisse1(abscisse1);

		  setOrdonnee1(ordonnee1);
		  
		  setLongueurCarre(Integer.parseInt(longueur));
		  
		  java.awt.Point point1 = new java.awt.Point(Integer.parseInt(ordonnee1), Integer.parseInt(abscisse1));

		  Image image = getImage();
		  if (image == null) {
			  image = new Image();
		  }
		  image.addObject(new Square(color, point1, this.getLongueurCarre()));
		  setImage(image);

	  }
	  
	  
	  public ZDialogInfo(String color, String abscisse1, String ordonnee1, String abscisse2, String ordonnee2, String abscisse3, String ordonnee3){

		  setCol(color);
		  
		  setAbscisse1(abscisse1);

		  setOrdonnee1(ordonnee1);

		  setAbscisse2(abscisse2);

		  setOrdonnee2(ordonnee2);

		  setAbscisse3(abscisse3);

		  setOrdonnee3(ordonnee3);
	    
		  java.awt.Point point1 = new java.awt.Point(Integer.parseInt(ordonnee1), Integer.parseInt(abscisse1));

		  java.awt.Point point2 = new java.awt.Point(Integer.parseInt(ordonnee2), Integer.parseInt(abscisse2));
		  java.awt.Point point3 = new java.awt.Point(Integer.parseInt(ordonnee3), Integer.parseInt(abscisse3));

		  Image image = getImage();
		  if (image == null) {
			  image = new Image();
		  }
		  image.addObject(new Triangle(color, point1, point2, point3));
		  setImage(image);

	  }
	  
	  public ZDialogInfo(String color, String abscisse1, String ordonnee1, String abscisse2, String ordonnee2, String abscisse3, String ordonnee3, String abscisse4, String ordonnee4){

		    setCol(color);
		  
		  	setAbscisse1(abscisse1);

		    setOrdonnee1(ordonnee1);

		    setAbscisse2(abscisse2);

		    setOrdonnee2(ordonnee2);

		    setAbscisse3(abscisse3);
		    
		    setOrdonnee3(ordonnee3);
		    
		    setAbscisse4(abscisse4);
		    
		    setOrdonnee4(ordonnee4);
		    
		    java.awt.Point point1 = new java.awt.Point(Integer.parseInt(ordonnee1), Integer.parseInt(abscisse1));

			  java.awt.Point point2 = new java.awt.Point(Integer.parseInt(ordonnee2), Integer.parseInt(abscisse2));
			  java.awt.Point point3 = new java.awt.Point(Integer.parseInt(ordonnee3), Integer.parseInt(abscisse3));
			  java.awt.Point point4 = new java.awt.Point(Integer.parseInt(ordonnee4), Integer.parseInt(abscisse4));

			  Image image = getImage();
			  if (image == null) {
				  image = new Image();
			  }
			  image.addObject(new Quadrangle(color, point1, point2, point3, point4));
			  setImage(image);

		  }


	  public String toString(){

	    String str;

	    if(getCol() != null || getAbscisse1() != null || getOrdonnee1() != null || getAbscisse2() != null || getOrdonnee2() != null || getAbscisse3() != null || getOrdonnee3() != null || getAbscisse4() != null && getOrdonnee4() != null){

	      str = "Description de l'objet ";
	      
	      str += "Couleur : " + getCol() + "\n";

	      str += "Abscisse 1 : " + getAbscisse1() + "\n";

	      str += "Ordonnée 1 : " + getOrdonnee1() + "\n";

	      str += "Abscisse 2 : " + getAbscisse2() + "\n";

	      str += "Ordonnée 2 : " + getOrdonnee2() + "\n";

	      str += "Abscisse 3 : " + getAbscisse3() + "\n";
	      
	      str += "Ordonnée 3 : " + getOrdonnee3() + "\n";

	      str += "Abscisse 4 : " + getAbscisse4() + "\n";

	      str += "Ordonnée 4 : " + getOrdonnee4() + "\n";

	    }

	    else{

	      str = "Aucune information !";

	    }

	    return str;

	  }

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getAbscisse1() {
		return abscisse1;
	}

	public void setAbscisse1(String abscisse1) {
		this.abscisse1 = abscisse1;
	}

	public String getOrdonnee1() {
		return ordonnee1;
	}

	public void setOrdonnee1(String ordonnee1) {
		this.ordonnee1 = ordonnee1;
	}

	public String getAbscisse2() {
		return abscisse2;
	}

	public void setAbscisse2(String abscisse2) {
		this.abscisse2 = abscisse2;
	}

	public String getOrdonnee2() {
		return ordonnee2;
	}

	public void setOrdonnee2(String ordonnee2) {
		this.ordonnee2 = ordonnee2;
	}

	public String getAbscisse3() {
		return abscisse3;
	}

	public void setAbscisse3(String abscisse3) {
		this.abscisse3 = abscisse3;
	}

	public String getOrdonnee3() {
		return ordonnee3;
	}

	public void setOrdonnee3(String ordonnee3) {
		this.ordonnee3 = ordonnee3;
	}

	public String getAbscisse4() {
		return abscisse4;
	}

	public void setAbscisse4(String abscisse4) {
		this.abscisse4 = abscisse4;
	}

	public String getOrdonnee4() {
		return ordonnee4;
	}

	public void setOrdonnee4(String ordonnee4) {
		this.ordonnee4 = ordonnee4;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public int getLongueurCarre() {
		return longueurCarre;
	}

	public void setLongueurCarre(int longueurCarre) {
		this.longueurCarre = longueurCarre;
	}
	  
	  

	}