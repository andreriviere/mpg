package fr.insee.mpg.figures;

public class Square extends Rectangle {

	public Square(String color, java.awt.Point point1, int side) {
		super(color, point1, new java.awt.Point(point1.x + side, point1.y + side));
	}
	public String toString() {
		return "Ce carré est de couleur " + this.getColor().toString() + ".";
	}
}
