package collections;

public class HashTable<K,V> implements IHashTable<K,V> {

	public static final String DELETED = "superDeleted";
	Element <K,V> eliminated;
	private int size;
	private int maxElements;
	private Element<K,V>[] array;
	
	
	@SuppressWarnings("unchecked")
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
		String id = (String)key;
		int value = 0;
		
		for(int i=0;i<id.length();i++) {
			value += Character.getNumericValue(id.charAt(i));
		}
				
		value = value*50;
		value = value/maxElements;
		return value;
	}

	@Override
	public V get(K key) {
		int index = getArrayIndex(key);
		
		for(int i=0;i<array.length;i++) {
			int probing = ((index % 50)+ i) % 50;
			Element<K,V> look = array[probing];
			
			
			if(look == null) {
				return null;
			}else if(look.getKey().equals(key)) {
					return look.getValue();
			 }		
		}
		return null;	
	}
		

	@Override
	public V removeElement(K key, Element<K,V> erased) {
		
		int index = getArrayIndex(key);
		
		for(int i =0;i<array.length;i++) {
			int probing = ((index % 50)+ i) % 50;
			Element<K,V> e = array[probing];
			if(e!=null) {
				if(e.getKey().equals(key)) {				
					Element<K,V> deleted = array[probing];
					array[probing]=erased;	
					size--;
					return deleted.getValue();
				}
			}else {
				return null;
			}
		}
		return null;
	}

	@Override
	public void addElement(K key, V value) {
		int arrayIndex = getArrayIndex(key);
		boolean val = false;
		for(int i=0;i<array.length && !val;i++) {
			int index = ((arrayIndex % 50) + i) % 50;
			Element <K,V> e = array[index];
			Element <K,V> toAdd = new Element<K, V>(key,value);
			
			if(e == null) {
				array[index]=toAdd;
				size++;
				val=true;
			}else if(e.getKey().equals(DELETED)){
				array[index]=toAdd;
				size++;
				val=true;
			 } 
		}
	}

}
