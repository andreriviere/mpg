package fr.insee.mpg.batch;


import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public abstract class FormDrawable implements IDrawable {

	
	protected Polygon lin;
	protected Color color;
	
	
	public FormDrawable(Color color, java.util.List<java.awt.Point> listePoints){
		this.color=color;
		int[] xPoints = new int[listePoints.size()];
		int[] yPoints = new int[listePoints.size()];
		for (int i=0; i < listePoints.size() ; i++) {
			xPoints[i] = listePoints.get(i).x;
			yPoints[i] = listePoints.get(i).y;
		}
		this.lin = new java.awt.Polygon(xPoints, yPoints, listePoints.size());
	}
	
	
	public abstract void draw(Graphics g) ;
	
	
	public Polygon getLine(){
		return (Polygon) lin;
	}
	
}
