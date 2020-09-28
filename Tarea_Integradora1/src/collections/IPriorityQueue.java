package collections;

public interface IPriorityQueue<T extends Comparable<T>> {
	
	public T extact_max();
	public T maximun();
	public boolean insertValue(Instance<T> element);
	
}
