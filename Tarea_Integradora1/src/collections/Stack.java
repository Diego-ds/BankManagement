package collections;

public class Stack <T> implements IStack<T>{
	
	Queue<T> cola1;
	Queue<T> aux;
	
	
	public Stack() {
		this.cola1 = new Queue<T>();
		this.aux = new Queue<T>();
	}

	@Override
	public void apilar(T element) {
			cola1.enqueue(element);
	}

	@Override
	public T desapilar() {
		T element =null;
		while(!cola1.isEmpty()) {
			
			element = cola1.dequeue();
			if(!cola1.isEmpty()) {
				aux.enqueue(element);
			}
		}
		cola1=aux;
		aux= new Queue<T>();
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
