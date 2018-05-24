package fr.insee.mpg.batch;

import java.awt.geom.Point2D;

public class Line {
	
	public java.awt.Point depart;
	public java.awt.Point arrivee;
	
	public Line(java.awt.Point point1, java.awt.Point point2) {
		setDepart(point1);
		setArrivee(point2);
	}
	
	public java.awt.Point getDepart() {
		return depart;
	}
	public void setDepart(java.awt.Point depart) {
		this.depart = depart;
	}
	public java.awt.Point getArrivee() {
		return arrivee;
	}
	public void setArrivee(java.awt.Point arrivee) {
		this.arrivee = arrivee;
	}
	
	
	

}
