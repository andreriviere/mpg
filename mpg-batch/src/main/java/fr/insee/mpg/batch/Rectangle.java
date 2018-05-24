package fr.insee.mpg.batch;

public class Rectangle extends Quadrangle {
		
		public Rectangle(String color, java.awt.Point point1, java.awt.Point point3) {
			super(color, point1, new java.awt.Point(point3.x, point1.y), point3, new java.awt.Point(point1.x, point3.y));
		}
		public String toString() {
			return "Ce rectangle est de couleur " + this.getColor().toString() + ".";
		}
}
