package fr.insee.mpg.math;

import fr.insee.mpg.batch.IBatch;

public class InitMath implements IBatch {
	
	public void executer(String[] args) {
	Expression e = new Sum(new Product(new Number(2), new Number(3)), new Number(5));

	System.out.println(e.value());

	System.out.println(e);

	Expression f = new SquareRoot(new Number(4));

	System.out.println(f.value());

	System.out.println(f);
	
	Expression g = new Product(new Sum(new Number(2), new Number(3)), new Number(5));

	System.out.println(g.value());

	System.out.println(g);
	
	Expression h = new Sinus(new Number(2));

	System.out.println(h.value());

	System.out.println(h);

	}
}
