package collections;

public interface IQueue<T> {
	public void enqueue(T element);
	public T dequeue();
	public T top();
	public boolean isEmpty();
}
