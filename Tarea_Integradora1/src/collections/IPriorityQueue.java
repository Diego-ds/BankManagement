package collections;

import exceptions.QueueIsEmptyException;

public interface IPriorityQueue<T extends Comparable<T>> {
	
	public T extract_max() throws QueueIsEmptyException;
	public T maximun() throws QueueIsEmptyException;
	public boolean insertValue(Instance<T> element);
	
}
