package fr.insee.mpg.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

public class ZDialogInfo {
	  private String number, equipe, poste, abscisse1, ordonnee1, abscisse2, ordonnee2, abscisse3, ordonnee3, abscisse4, ordonnee4;
	  
	  private int somme, longueurCarre;


	  public ZDialogInfo(){}
	  
	  public ZDialogInfo(String number, String som){

		  if (number != null) {
			  setNumber(number);
		  }
		  if (som != null) {
			  setSomme(Integer.valueOf(som).intValue());
		  }

	  }

	  
	  
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getSomme() {
		return somme;
	}

	public void setSomme(int somme) {
		this.somme = somme;
	}
	  
	  

	}