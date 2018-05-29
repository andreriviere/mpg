package fr.insee.mpg.batch;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;

public class Fenetre extends JFrame {
	
  public ZDialogInfo zI;
  
  public Fenetre(String title) {
	  if (StringUtils.equalsIgnoreCase(title, "ajouter")) {
		  ZDialog zd = new ZDialog(null, title, true);
		
	  }
  }
  
  public Fenetre(Test test, String title, String color){      
	  if (StringUtils.containsIgnoreCase(title, "triangle")) {
		ZDialog zd = new ZDialog(null, title, color, true);
		ZDialogInfo zInfo = zd.showZDialog(); 
		setzI(zInfo);
		if (zInfo.getImage().getListeTriangles() != null && zInfo.getImage().getListeTriangles().size() > 0) {
			List<Triangle> list = test.getListeT();
			if (list == null) {
				list = new ArrayList<Triangle>();
			}
			list.add(zInfo.getImage().getListeTriangles().get(0));
			test.setListeT(list);
		}
		JOptionPane jop = new JOptionPane();
		jop.showMessageDialog(null, zInfo.toString(), "Informations about the triangle", JOptionPane.INFORMATION_MESSAGE);
	  } else if (StringUtils.containsIgnoreCase(title, "quadrangle") || StringUtils.containsIgnoreCase(title, "rectangle") || StringUtils.containsIgnoreCase(title, "square")){
		 ZDialog zd = new ZDialog(null, title, color, true);
		 ZDialogInfo zInfo = zd.showZDialog(); 
		 setzI(zInfo);
		 if (zInfo.getImage().getListeQuadrangles() != null && zInfo.getImage().getListeQuadrangles().size() > 0) {
			 List<Quadrangle> list = test.getListeQ();
				if (list == null) {
					list = new ArrayList<Quadrangle>();
				}
			 list.add(zInfo.getImage().getListeQuadrangles().get(0));
			 test.setListeQ(list);
		 }
		 JOptionPane jop = new JOptionPane();
		 jop.showMessageDialog(null, zInfo.toString(), "Informations about the quadrangle", JOptionPane.INFORMATION_MESSAGE);
	  } else if (StringUtils.containsIgnoreCase(title, "move")) {
		  ZDialog zd = new ZDialog(null, title, color, true);
		  ZDialogInfo zInfo = zd.showZDialog();
		  List<Triangle> listeTrianglesFinale = new ArrayList<Triangle>();
		  List<Quadrangle> listeQuadranglesFinale = new ArrayList<Quadrangle>();
		  List<Triangle> listeTriangles = test.getListeT();
		  List<Quadrangle> listeQuadrangles = test.getListeQ();
		  if (listeTriangles != null) {
			  for (Triangle triangle : listeTriangles) {
				  int[] xpoints = {(int) Math.round(triangle.getLine1().getDepart().getX()), (int) Math.round(triangle.getLine2().getDepart().getX()), (int) Math.round(triangle.getLine3().getDepart().getX())};
				  int[] ypoints = {(int) Math.round(triangle.getLine1().getDepart().getY()), (int) Math.round(triangle.getLine2().getDepart().getY()), (int) Math.round(triangle.getLine3().getDepart().getY())};
				  Polygon p = new Polygon(xpoints, ypoints, 3);
				  p.translate(Integer.parseInt(zInfo.getAbscisse1()), Integer.parseInt(zInfo.getOrdonnee1()));
				  listeTrianglesFinale.add(new Triangle(color, new java.awt.Point(p.xpoints[0], p.ypoints[0]), new java.awt.Point(p.xpoints[1], p.ypoints[1]), new java.awt.Point(p.xpoints[2], p.ypoints[2])));
			  }
		  }
		  if (listeQuadrangles != null) {
			  for (Quadrangle quadrangle : listeQuadrangles) {
				  int[] xpoints = {(int) Math.round(quadrangle.getLine1().getDepart().getX()), (int) Math.round(quadrangle.getLine2().getDepart().getX()), (int) Math.round(quadrangle.getLine3().getDepart().getX()), (int) Math.round(quadrangle.getLine4().getDepart().getX())};
				  int[] ypoints = {(int) Math.round(quadrangle.getLine1().getDepart().getY()), (int) Math.round(quadrangle.getLine2().getDepart().getY()), (int) Math.round(quadrangle.getLine3().getDepart().getY()), (int) Math.round(quadrangle.getLine4().getDepart().getY())};
				  Polygon p = new Polygon(xpoints, ypoints, 4);
				  p.translate(Integer.parseInt(zInfo.getAbscisse1()), Integer.parseInt(zInfo.getOrdonnee1()));
				  listeQuadranglesFinale.add(new Quadrangle(color, new java.awt.Point(p.xpoints[0], p.ypoints[0]), new java.awt.Point(p.xpoints[1], p.ypoints[1]), new java.awt.Point(p.xpoints[2], p.ypoints[2]), new java.awt.Point(p.xpoints[3], p.ypoints[3])));
			  }
		  }
		  test.setListeQ(listeQuadranglesFinale);
		  test.setListeT(listeTrianglesFinale);
	  } else if (StringUtils.containsIgnoreCase(title, "change")) {
		  ZDialog zd = new ZDialog(null, title, color, true);
		  ZDialogInfo zInfo = zd.showZDialog();
		  List<Triangle> listeTrianglesFinale = new ArrayList<Triangle>();
		  List<Quadrangle> listeQuadranglesFinale = new ArrayList<Quadrangle>();
		  List<Triangle> listeTriangles = test.getListeT();
		  List<Quadrangle> listeQuadrangles = test.getListeQ();
		  if (listeTriangles != null) {
			  for (Triangle triangle : listeTriangles) {
				  triangle.changeColor(zInfo.getCol());
				  listeTrianglesFinale.add(triangle);
			  }
		  }
		  if (listeQuadrangles != null) {
			  for (Quadrangle quadrangle : listeQuadrangles) {
				  quadrangle.changeColor(zInfo.getCol());
				  listeQuadranglesFinale.add(quadrangle);
			  }
		  }
		  test.setListeQ(listeQuadranglesFinale);
		  test.setListeT(listeTrianglesFinale);
	  } else {
		  ZDialog zd = new ZDialog(null, title, color, true);
		  ZDialogInfo zInfo = zd.showZDialog();
		  List<Triangle> listeTrianglesFinale = new ArrayList<Triangle>();
		  List<Quadrangle> listeQuadranglesFinale = new ArrayList<Quadrangle>();
		  List<Triangle> listeTriangles = test.getListeT();
		  List<Quadrangle> listeQuadrangles = test.getListeQ();
		  if (listeTriangles != null) {
			  for (Triangle triangle : listeTriangles) {
				  triangle.changeColor(zInfo.getCol());
				  listeTrianglesFinale.add(triangle);
			  }
		  }
		  if (listeQuadrangles != null) {
			  for (Quadrangle quadrangle : listeQuadrangles) {
				  quadrangle.changeColor(zInfo.getCol());
				  listeQuadranglesFinale.add(quadrangle);
			  }
		  }
		  test.setListeQ(listeQuadranglesFinale);
		  test.setListeT(listeTrianglesFinale);
	  }
//	  this.setVisible(true);      
  }
  public ZDialogInfo getzI() {
	  return zI;
  }
  public void setzI(ZDialogInfo zI) {
	  this.zI = zI;
  }
  
}
