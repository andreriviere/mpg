package fr.insee.mpg.stack;

public class StackFullException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackFullException() {
		super("MyStack has already reached its maximum size ! Data not added.");
	}
}
