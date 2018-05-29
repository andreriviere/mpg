package fr.insee.mpg.math;

import org.apache.commons.lang.StringUtils;

public class Sinus extends Expression {
	public Expression e1;
	
	public Sinus(Expression n1) {
		super(n1.getValue1());
		setE1(n1);
	}

	public float value() {
		return (float) Math.sin(Double.valueOf(StringUtils.substringBefore(String.valueOf(getValue1()), ".")));
	}
	
	public String toString() {
		return "' sin(" + StringUtils.substringBeforeLast(e1.toString(), "'") + ") '";
	}
	
	public Expression getE1() {
		return e1;
	}

	public void setE1(Expression e1) {
		this.e1 = e1;
	}
	
	
}
