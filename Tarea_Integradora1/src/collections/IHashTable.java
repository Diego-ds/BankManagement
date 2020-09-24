package collections;

public interface IHashTable<K,V> {
	
	public int getSize();

    public boolean isEmpty();

    public int getArrayIndex(K key);

    public V get(K key);

    public V removeElement(K key, Element<K,V> erased);

    public void addElement(K key, V value);


}
