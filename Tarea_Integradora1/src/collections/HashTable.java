package collections;

public class HashTable<K,V> implements IHashTable<K,V> {

	private int size;
	private int maxElements;
	private Element<K,V>[] array;
	
	
	public HashTable() {
		this.maxElements = 50;
		array = new Element[maxElements];
	}

	@Override
	public int getSize() {	
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int getArrayIndex(K key) {
		
		return 0;
	}

	@Override
	public V getElement(K key) {

		return null;
	}

	@Override
	public V removeElement(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addElement(K key, V value) {
		// TODO Auto-generated method stub
		
	}

}
