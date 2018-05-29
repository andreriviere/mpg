package fr.insee.mpg.math;

import org.apache.commons.lang.StringUtils;

public class Number extends Expression {
	public Number(float value) {
		super(value);
	}
	
	public float value() {
		return Math.round(getValue1());
	}
	
	public String toString() {
		return StringUtils.substringBefore(String.valueOf(getValue1()), ".");
	}
}
