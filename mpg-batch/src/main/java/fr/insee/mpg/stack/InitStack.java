package fr.insee.mpg.stack;


import fr.insee.mpg.batch.IBatch;

public class InitStack implements IBatch {
	public void executer(String[] args) {
		MyStackListe s1 = new MyStackListe("stack1", 10);

		try {
			s1.top();
		} catch (StackEmptyException e) {
			e.getMessage();
		}
		try {
			s1.push(1);
			s1.push(2);
			s1.push(3);
			s1.push(4);
			s1.push(5);
			s1.push(6);
			s1.push(7);
			s1.push(8);
			s1.push(9);
			s1.push(10);
			s1.push(11);
		} catch (StackFullException e1) {
			// TODO Auto-generated catch block
			e1.getStackTrace();
		}


		}
}

