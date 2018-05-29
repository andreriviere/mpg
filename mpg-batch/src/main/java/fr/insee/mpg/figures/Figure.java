package fr.insee.mpg.figures;

import java.awt.Color;

import org.apache.commons.lang.StringUtils;

public class Figure {
	
	public Color color;
	
	public Figure(String color) {
		changeColor(color);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void changeColor(String color) {
		if (StringUtils.equalsIgnoreCase(color, "red")) {
			setColor(Color.RED);
		} else if (StringUtils.equalsIgnoreCase(color, "blue")) {
			setColor(Color.BLUE);
		} else if (StringUtils.equalsIgnoreCase(color, "yellow")) {
			setColor(Color.YELLOW);
		} else if (StringUtils.equalsIgnoreCase(color, "green")) {
			setColor(Color.GREEN);
		} else if (StringUtils.equalsIgnoreCase(color, "pink")) {
			setColor(Color.PINK);
		} else if (StringUtils.equalsIgnoreCase(color, "lightgray")) {
			setColor(Color.LIGHT_GRAY);
		} else if (StringUtils.equalsIgnoreCase(color, "gray")) {
			setColor(Color.GRAY);
		} else if (StringUtils.equalsIgnoreCase(color, "darkgray")) {
			setColor(Color.DARK_GRAY);
		} else if (StringUtils.equalsIgnoreCase(color, "black")) {
			setColor(Color.BLACK);
		} else if (StringUtils.equalsIgnoreCase(color, "orange")) {
			setColor(Color.ORANGE);
		} else if (StringUtils.equalsIgnoreCase(color, "magenta")) {
			setColor(Color.MAGENTA);
		} else if (StringUtils.equalsIgnoreCase(color, "cyan")) {
			setColor(Color.CYAN);
		}
	}
	
	public String toString() {
		return "Cette figure est de couleur " + this.color.toString();
	}
	
	
}
