package fr.insee.mpg.math;

import org.apache.commons.lang.StringUtils;

public class SquareRoot extends Expression {
	public Expression e1;
	
	public SquareRoot(Expression n1) {
		super(n1.getValue1());
		setE1(n1);
	}

	public float value() {
		return (float) Math.sqrt(Double.parseDouble(StringUtils.substringBefore(String.valueOf(getValue1()), ".")));
	}
	
	public String toString() {
		return StringUtils.substringBeforeLast(e1.toString(), "'") + " ^ (1/2)";
	}
	
	public Expression getE1() {
		return e1;
	}

	public void setE1(Expression e1) {
		this.e1 = e1;
	}
	
	
}
