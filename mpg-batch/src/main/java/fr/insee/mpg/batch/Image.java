package fr.insee.mpg.batch;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Image {

	public List<Triangle> listeTriangles;
	public List<Quadrangle> listeQuadrangles;
	
	public void addObject(Object object) {
		if (StringUtils.containsIgnoreCase(object.getClass().getName(), "Triangle")) {
			List<Triangle> liste = getListeTriangles();
			if (liste == null) {
				liste = new ArrayList<Triangle>();
			}
			liste.add((Triangle) object);
			setListeTriangles(liste);
		} else {
			List<Quadrangle> liste = getListeQuadrangles();
			if (liste == null) {
				liste = new ArrayList<Quadrangle>();
			}
			liste.add((Quadrangle) object);
			setListeQuadrangles(liste);
		}
	}
	 
	public List<Triangle> getListeTriangles() {
		return listeTriangles;
	}
	public void setListeTriangles(List<Triangle> listeTriangles) {
		this.listeTriangles = listeTriangles;
	}
	public List<Quadrangle> getListeQuadrangles() {
		return listeQuadrangles;
	}
	public void setListeQuadrangles(List<Quadrangle> listeQuadrangles) {
		this.listeQuadrangles = listeQuadrangles;
	}
	
	
	
}
