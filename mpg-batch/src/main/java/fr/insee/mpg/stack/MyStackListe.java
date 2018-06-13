package fr.insee.mpg.stack;

import java.util.ArrayList;

import java.util.List;


public class MyStackListe implements MyStackInterface {


	List<Integer> maListe;

	String name;

	int maximumSize;


	public MyStackListe(){

		setMaximumSize(5);

	}


	public MyStackListe(int size) {

		setMaximumSize(size);

	}


	public MyStackListe(String name) {

		setMaximumSize(5);

		setName(name);

	}


	public MyStackListe(MyStackListe stack) {

		List<Integer> liste = new ArrayList<Integer>();

		for (Integer integ : stack.getMaListe()) {

			liste.add(integ);

		}

		setMaListe(liste);

		setName(stack.getName());

		setMaximumSize(stack.getMaximumSize());

	}


	public MyStackListe(String name, int size) {

		setName(name);

		setMaximumSize(size);

	}


	public String toString() {

		StringBuilder result = new StringBuilder();

		result.append("[" + getName() + "]");

		if (getMaListe() != null && getMaListe().size() > 0) {

			for (Integer integ : getMaListe()) {

				result.append(" " + integ);

			}

		} else {

			result.append(" empty");

		}

		return result.toString();

	}


	public void push(int i) throws StackFullException {

		List<Integer> liste = getMaListe(); 

		if (liste == null) {

			liste = new ArrayList<Integer>();

		}

		if (liste.size() < getMaximumSize()) {

			liste.add(liste.size(), new Integer(i));

			setMaListe(liste);

		} else {

			throw new StackFullException("MyStack has already reached its maximum size ! Data not added.");

		}

	}


	public boolean empty() {

		if (getMaListe() == null || getMaListe().size() == 0) {

			return true;

		} else {

			return false;

		}

	}


	public int top() throws StackEmptyException {

		List<Integer> liste = getMaListe();

		if (liste != null && liste.size() != 0 ) {

			return liste.get(liste.size() - 1).intValue();

		} else {

			throw new StackEmptyException("No data in MyStack");

		}

	}


	public void pop() throws StackEmptyException {

		List<Integer> liste = getMaListe();

		if (liste != null || liste.size() != 0 ) {

			liste.remove(liste.size() - 1);

		} else {
			throw new StackEmptyException("No data in MyStack");
		}

		setMaListe(liste);

	}


	public void changeName(String name) {

		setName(name);

	}


	public List<Integer> getMaListe() {

		return maListe;

	}


	public void setMaListe(List<Integer> maListe) {

		this.maListe = maListe;

	}


	public int getMaximumSize() {

		return maximumSize;

	}


	public void setMaximumSize(int maximumSize) {

		this.maximumSize = maximumSize;

	}


	public String getName() {

		return name;

	}


	public void setName(String name) {

		this.name = name;

	}




}


