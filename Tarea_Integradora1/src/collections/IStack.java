package collections;

public interface IStack<T> {
	public void apilar(T element);
	public T desapilar();
	public T top();
	public boolean isEmpty();
}
