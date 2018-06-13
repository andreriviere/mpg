package fr.insee.mpg.stack;

public class StackEmptyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackEmptyException() {
		super("No data in MyStack");
	}
}
