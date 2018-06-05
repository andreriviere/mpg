package fr.insee.mpg.iterable;

import java.util.Iterator;

import fr.insee.mpg.batch.IBatch;

public class InitIterable implements IBatch{
	public void executer(String[] args) {
        // create an array of strings
        String[] strings = new String[]{"Hello", "World"};

        // create a new array to hold these strings
        MyCollection<String> array = new MyCollection<String>(strings);

        // get and print the first values (prints "Hello")
        System.out.println(array.get(0));

        // set the second value
        array.set(1, "Javaland!");

        // iterate over the array, printing "Hello\nJavaland!"
        for (String s : array) {
            System.out.println(s);
        }
        Iterator<String> it = array.iterator();
        while (it.hasNext()) {
        	System.out.println(it.next());
        }
        it=array.iterator();
        it.remove();
        for (String s : array) {
            System.out.println(s);
        }
    }
}
