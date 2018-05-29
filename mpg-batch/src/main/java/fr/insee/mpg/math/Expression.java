package fr.insee.mpg.math;

public abstract class Expression {
	
	public float value1;
	public float value2;
	
	public Expression(Expression e1, Expression e2) {
		setValue1(e1.value());
		setValue2(e2.value());
	}
	
	public Expression(float value) {
		setValue1(value);
	}
	
	public abstract float value();
	
	public abstract String toString();

	public float getValue1() {
		return value1;
	}

	public void setValue1(float value1) {
		this.value1 = value1;
	}

	public float getValue2() {
		return value2;
	}

	public void setValue2(float value2) {
		this.value2 = value2;
	}

	
	
	
}
