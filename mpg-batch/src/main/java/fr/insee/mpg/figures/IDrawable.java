package fr.insee.mpg.figures;


import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public interface IDrawable {
	
	public  void draw(Graphics g);
	
	public Polygon getLine();
}
