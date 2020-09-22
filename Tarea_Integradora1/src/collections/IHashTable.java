package collections;

public interface IHashTable<K,V> {
	
	public int getSize();

    public boolean isEmpty();

    public int getArrayIndex(K key);

    public V getElement(K key);

    public V removeElement(K key);

    public void addElement(K key, V value);

}
