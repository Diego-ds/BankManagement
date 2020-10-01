package collections;

import exceptions.QueueIsAlreadyFullException;
import exceptions.QueueIsEmptyException;

public class Queue <T> implements IQueue<T> {

	private Node<T> top;
	private int size;
	private int maxSize;
	
	public Queue(int maxSize) {
		this.top = null;
		this.size=0;
		this.maxSize = maxSize;
	}

	@Override
	public void enqueue(T element) throws QueueIsAlreadyFullException {
		if(size>=maxSize) {
			throw new QueueIsAlreadyFullException("queue");
		}else {
			Node<T> toAdd = new Node<T>(element);
			if(top==null) {
				top=toAdd;
				size++;
			}else {
				Node<T> cabeza=top;
				while(cabeza.getNext()!=null) {
					cabeza=cabeza.getNext();
				}
				cabeza.setNext(toAdd);
				size++;
			}
		}
		
	
		
	}

	@Override
	public T dequeue() throws QueueIsEmptyException {
		if(size==0) {
			throw new QueueIsEmptyException("queue");
		}else {
			T element = null;
			if(top!=null) {
				element = top.getElement();
				top=top.getNext();
				size--;
				return element;
			}else {
				return element;
			}	
		}
				
	}

	@Override
	public T top() {
		T element=null;
		if(top!=null) {
			return element =top.getElement();	
		}else {
			return element;
		}

	}


	@Override
	public boolean isEmpty() {
		if(top==null) {
			return true;
		}else {
			return false;
		}

	}
	
	public int getSize() {
		return size;
	}

}
