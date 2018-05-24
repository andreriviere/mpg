package fr.insee.mpg.batch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.List;

public class LineDrawable extends FormDrawable{

	public LineDrawable(Color color, List<java.awt.Point> listePoints) {
		super(color, listePoints);
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillPolygon(lin);
		g.setColor(c);
		if (lin.xpoints.length==2) {
			g.drawLine(lin.xpoints[0], lin.ypoints[0], lin.xpoints[1], lin.ypoints[1]);
		}
	}

}
