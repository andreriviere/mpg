package fr.insee.mpg.batch;

public class Point {
	
	public int ordonnee;
	public int abscisse;
	
	public Point(int ordonnee, int abscisse) {
		setOrdonnee(ordonnee);
		setAbscisse(abscisse);
	}
	
	public int getOrdonnee() {
		return ordonnee;
	}
	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}
	public int getAbscisse() {
		return abscisse;
	}
	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}
	
	

}
