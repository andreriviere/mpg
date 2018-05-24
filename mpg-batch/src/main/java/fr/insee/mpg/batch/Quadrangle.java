package fr.insee.mpg.batch;

import java.awt.Point;

public class Quadrangle extends Figure {
	
	public Line line1;
	public Line line2;
	public Line line3;
	public Line line4;
	
	public Quadrangle(String color, java.awt.Point point1, java.awt.Point point2, java.awt.Point point3, java.awt.Point point4) {
		super(color);
		setLine1(new Line(point1, point2));
		setLine2(new Line(point2, point3));
		setLine3(new Line(point3, point4));
		setLine4(new Line(point4, point1));
	}
	
	public Line getLine1() {
		return line1;
	}
	public void setLine1(Line line1) {
		this.line1 = line1;
	}
	public Line getLine2() {
		return line2;
	}
	public void setLine2(Line line2) {
		this.line2 = line2;
	}
	public Line getLine3() {
		return line3;
	}
	public void setLine3(Line line3) {
		this.line3 = line3;
	}
	public Line getLine4() {
		return line4;
	}
	public void setLine4(Line line4) {
		this.line4 = line4;
	}
	
	public String toString() {
		return "Ce quadrangle est de couleur " + this.getColor().toString() + ".";
	}
	

}
