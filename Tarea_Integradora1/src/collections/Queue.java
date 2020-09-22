package collections;

public class Queue <T> implements IQueue<T> {

	private Node<T> top;
	private int size;
	
	public Queue() {
		this.top = null;
		this.size=0;
	}

	@Override
	public void enqueue(T element) {
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
		}
	
		
	}

	@Override
	public T dequeue() {
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

}
