package collections;

import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;

public interface IStack<T> {
	public void apilar(T element) throws QueueIsAlreadyFullException;
	public T desapilar() throws QueueIsAlreadyFullException, QueueIsEmptyException;
	public T top() throws QueueIsEmptyException, QueueIsAlreadyFullException;
	public boolean isEmpty();
}
