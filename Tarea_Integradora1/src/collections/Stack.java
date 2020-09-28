package collections;

import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;

public class Stack <T> implements IStack<T>{
	
	Queue<T> cola1;
	Queue<T> aux;
	
	
	public Stack() {
		this.cola1 = new Queue<T>(20);
		this.aux = new Queue<T>(20);
	}

	@Override
	public void apilar(T element) throws QueueIsAlreadyFullException {
			cola1.enqueue(element);
	}

	@Override
	public T desapilar() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		T element =null;
		while(!cola1.isEmpty()) {
			
			element = cola1.dequeue();
			if(!cola1.isEmpty()) {
				aux.enqueue(element);
			}
		}
		cola1=aux;
		aux= new Queue<T>(20);
		return element;
	}

	@Override
	public T top() {	
		return cola1.top();
	}

	@Override
	public boolean isEmpty() {
		if(cola1.top()==null) {
			return true;
		}else {
			return false;
		}	
	}

}
