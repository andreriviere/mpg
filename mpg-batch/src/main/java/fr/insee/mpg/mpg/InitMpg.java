package fr.insee.mpg.mpg;

import java.awt.Color;
import java.io.*;
import java.net.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.math.RoundingMode;
import java.text.AttributedCharacterIterator;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;

import javax.swing.JCheckBoxMenuItem;

import javax.swing.JFrame;

import javax.swing.JMenu;

import javax.swing.JMenuBar;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

import org.apache.commons.lang.StringUtils;

import fr.insee.mpg.batch.IBatch;
import fr.insee.mpg.figures.Fenetre;

public class InitMpg extends JFrame implements IBatch {

	private JMenuBar menuBar = new JMenuBar();

	private JMenu test1 = new JMenu("Mettre à jour notes équipe");

	private JMenu test2 = new JMenu("Ajouter joueur");

	private JMenu test3 = new JMenu("Produire équipe de la journée");

	private JMenu test4 = new JMenu("Mettre à jour résultats");

	private JMenu test5 = new JMenu("Afficher classement");

	private JMenuItem item1 = new JMenuItem("Mettre à jour");

	private JMenuItem item2 = new JMenuItem("Ajouter");

	private JMenuItem item3 = new JMenuItem("Produire");

	private JMenuItem item4 = new JMenuItem("Mettre à jour");

	private JMenuItem item5 = new JMenuItem("Afficher");

	private JPopupMenu jpm = new JPopupMenu();

	public void executer(String[] args) {
		try {
			URL url = new URL("http://www.monpetitgazon.com/championships/1/match/920898");
			URLConnection con = url
					.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy-rie.http.insee.fr", 8080)));
			// System.out.println(con.getContent());
			InputStream input = con.getInputStream();
			System.out.println(input);
			int next = 0;
			while ((next = input.read()) != -1) {
				System.out.println(next);
				System.out.print((char) next);
			}
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public InitMpg() {

		this.setSize(800, 400);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);

		// On initialise nos menus

		// On met nos radios dans un ButtonGroup

		// On présélectionne la première radio

		// Ajout du sous-menu dans notre menu

		this.test1.add(this.item1);

		this.test2.add(this.item2);

		this.test3.add(this.item3);

		this.test4.add(this.item4);

		this.test5.add(this.item5);

		// Ajout d'un séparateur

		this.test1.addSeparator();

		item1.addActionListener(new AjoutListener("mettre à jour notes"));

		item2.addActionListener(new AjoutListener("ajouter"));

		item3.addActionListener(new AjoutListener("produire"));

		item4.addActionListener(new AjoutListener("mettre à jour résultats"));

		item5.addActionListener(new AjoutListener("afficher"));

		// L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de
		// gauche à droite

		// Le premier ajouté sera tout à gauche de la barre de menu et
		// inversement pour le dernier

		this.menuBar.add(test1);

		this.menuBar.add(test2);

		this.menuBar.add(test3);

		this.menuBar.add(test4);

		this.menuBar.add(test5);

		this.setJMenuBar(menuBar);

		this.setVisible(true);

	}

	public class AjoutListener implements ActionListener {

		public String type;

		public AjoutListener(String type) {
			this.type = type;
		}

		public void actionPerformed(ActionEvent arg0) {
			Fenetre fen = new Fenetre(type);
			// jop2.showMessageDialog(null, "Votre nom est " + nom, "Identité",
			// JOptionPane.INFORMATION_MESSAGE);;

		}

	}

	/**
	 * 
	 * Écouteur du menu Quitter
	 * 
	 * @author CHerby
	 * 
	 */

}
