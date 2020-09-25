package collections;



public class Instance<T extends Comparable<T>> implements Comparable<T>{
	
	private T element;
	
	public Instance(T element) {
		this.element = element;
	}

	public T getElement() {
		return element;
	}

	@Override
	public int compareTo(T o) {
		return element.compareTo(o);
	}
	
	
}
