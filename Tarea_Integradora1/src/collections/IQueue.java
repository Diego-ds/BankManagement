package collections;

import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;

public interface IQueue<T> {
	public void enqueue(T element) throws QueueIsAlreadyFullException;
	public T dequeue() throws QueueIsEmptyException;
	public T top();
	public boolean isEmpty();
}
