package fr.insee.mpg.stack;

public interface MyStackInterface {
	 
	 public String toString();
	 
	 public void push(int i) throws StackFullException;
	 
	 public boolean empty();
	 
	 public int top() throws StackEmptyException;
	 
	 public void pop() throws StackEmptyException;
	 
	 public void changeName(String name); 
	 
	} 

