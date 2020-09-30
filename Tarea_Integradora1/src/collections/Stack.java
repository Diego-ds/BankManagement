package collections;

import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;

public class Stack <T> implements IStack<T>{
	
	Queue<T> cola1;
	Queue<T> aux;
	int size;
	int maxSize;
	
	
	public Stack(int maxSize) {
		this.cola1 = new Queue<T>(20);
		this.aux = new Queue<T>(20);
		this.maxSize=maxSize;
		size=0;
	}

	@Override
	public void apilar(T element) throws QueueIsAlreadyFullException {	
			if(size>=maxSize) {
				throw new QueueIsAlreadyFullException("stack");
			}else {
				cola1.enqueue(element);
				size++;
			}	
	}

	@Override
	public T desapilar() throws QueueIsAlreadyFullException, QueueIsEmptyException {
		T element =null;
		if(size==0) {
			throw new QueueIsEmptyException("stack");
		}else {
			while(!cola1.isEmpty()) {	
				element = cola1.dequeue();
				if(!cola1.isEmpty()) {
					aux.enqueue(element);
				}
			}
			cola1=aux;
			aux= new Queue<T>(20);
			size--;
		}	
		return element;
	}

	@Override
	public T top() throws QueueIsEmptyException, QueueIsAlreadyFullException {	
		T element =null;
		if(size==0) {
			
		}else {
			while(!cola1.isEmpty()) {	
				element = cola1.dequeue();
				if(!cola1.isEmpty()) {
					aux.enqueue(element);
				}
			}
			aux.enqueue(element);
			cola1=aux;
			aux= new Queue<T>(20);
		}	
		return element;
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
