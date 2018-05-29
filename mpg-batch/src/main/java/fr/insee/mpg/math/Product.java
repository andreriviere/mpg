package fr.insee.mpg.math;

import org.apache.commons.lang.StringUtils;

public class Product extends Expression {
	public Expression e1;
	public Expression e2;
	
	
	public Product(Expression n1, Expression n2) {
		super(n1, n2);
		setE1(n1);
		setE2(n2);
	}
	
	public float value() {
		return Math.round(getValue1() * getValue2());
	}
	
	public String toString() {
		return StringUtils.substringBeforeLast(e1.toString(), "'") + " * " + StringUtils.substringBeforeLast(e2.toString(), "'");
	}

	public Expression getE1() {
		return e1;
	}

	public void setE1(Expression e1) {
		this.e1 = e1;
	}

	public Expression getE2() {
		return e2;
	}

	public void setE2(Expression e2) {
		this.e2 = e2;
	}
}
