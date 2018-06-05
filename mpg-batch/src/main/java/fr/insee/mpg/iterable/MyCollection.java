package fr.insee.mpg.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ArrayList;
public class MyCollection<T> implements Iterable<T> {
	T[] values;
	
	//Constructor that takes a "raw" array and stores it
	public MyCollection(T[] values) {
		this.values = values;
	}
	
	class MyCollectionIterator implements Iterator<T> {
		int current;
		
		public boolean hasNext() {
			return getCurrent() != MyCollection.this.values.length;
		}
		@Override
		public T next() {
			// TODO Auto-generated method stub
			if (!hasNext()) {
				throw new NoSuchElementException("No more elements in the collection");
			}
			current += 1;
			setCurrent(current);
			return values[current - 1];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			Object valuesNew[] = new Object[MyCollection.this.values.length - 1];
			if (getCurrent() >= 1) {
				System.arraycopy(values, 0, valuesNew, 0, getCurrent());
			}
			if (getCurrent() < MyCollection.this.values.length) {
				System.arraycopy(values, getCurrent()+1, valuesNew, getCurrent(), MyCollection.this.values.length - getCurrent() - 1);

			}
			setValues(valuesNew);
		}
		
		public int getCurrent() {
			return current;
 		}

		public void setCurrent(int current) {
			this.current = current;
		}
		
		
	}
	// Return the value at a given index
    public T get(int index) {
        return values[index];
    }

    // Set the value at a given index
    public void set(int index, T value) {
        values[index] = value;
    }

    // Return the length of the array
    public int length() {
        return values.length;
    }

    // Return an iterator over the elements in the array. This is generally not
    // called directly, but is called by Java when used in a "simple" for loop.
    public Iterator<T> iterator() {
        return new MyCollectionIterator();
    }

	public T[] getValues() {
		return values;
	}

	public void setValues(Object[] values) {
		this.values = (T[]) values;
	}
    
    
    
}
