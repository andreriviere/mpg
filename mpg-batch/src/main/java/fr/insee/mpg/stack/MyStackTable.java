package fr.insee.mpg.stack;

public class MyStackTable implements MyStackInterface {


	Integer[] maListe;

	String name;

	int maximumSize;


	public MyStackTable(){

		setMaximumSize(5);

	}


	public MyStackTable(int size) {

		setMaximumSize(size);

	}


	public MyStackTable(String name) {

		setMaximumSize(5);

		setName(name);

	}


	public MyStackTable(MyStackTable stack) {

		setName(stack.getName());

		setMaximumSize(stack.getMaximumSize());

		Integer[] liste = new Integer[getMaximumSize()];

		for (int i=0; i<stack.getMaListe().length; i++) {

			liste[i] = stack.getMaListe()[i];

		}

		setMaListe(liste);

	}


	public MyStackTable(String name, int size) {

		setName(name);

		setMaximumSize(size);

	}


	public String toString() {

		StringBuilder result = new StringBuilder();

		result.append("[" + getName() + "]");

		if (getMaListe() != null && getMaListe().length > 0) {

			for (int i=0; i<getMaListe().length; i++) {

				if (getMaListe()[i] != null) {

					result.append(" " + getMaListe()[i]);

				}

			}

		} else {

			result.append(" empty");

		}

		return result.toString();

	}


	public void push(int i) throws StackFullException {

		Integer[] liste = getMaListe(); 

		if (liste == null) {

			liste = new Integer[getMaximumSize()];

		}

		for (int j=0; j<getMaximumSize();j++) {

			if (j==getMaximumSize()-1 && liste[j] != null) {

				throw new StackFullException("MyStack has already reached its maximum size ! Data not added.");

			} 

			if (liste[j] == null) {

				liste[j] = new Integer(i);

				setMaListe(liste);

				break;

			} 

		}

	}


	public boolean empty() {

		if (getMaListe() == null || getMaListe().length == 0) {

			return true;

		} else {

			return false;

		}

	}


	public int top() throws StackEmptyException {

		Integer[] liste = getMaListe();

		if (liste != null || liste.length != 0 ) {

			return liste[liste.length - 1].intValue();

		} else {

			throw new StackEmptyException("No data in MyStack");

		}

	}


	public void pop() throws StackEmptyException {

		Integer[] liste = getMaListe();

		Integer[] listeFinale = new Integer[getMaListe().length - 1];

		if (liste != null || liste.length != 0 ) {

			for (int i=0; i<listeFinale.length; i++) {

				listeFinale[i]=getMaListe()[i];

			}

			setMaListe(listeFinale);

		} else {
			throw new StackEmptyException("No data in MyStack");
		}

	}


	public void changeName(String name) {

		setName(name);

	}


	public Integer[] getMaListe() {

		return maListe;

	}


	public void setMaListe(Integer[] maListe) {

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


