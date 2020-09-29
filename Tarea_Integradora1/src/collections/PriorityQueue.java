package collections;

import java.util.Arrays;

import exceptions.QueueIsEmptyException;

public class PriorityQueue<T extends Comparable<T>> implements IPriorityQueue<T> {
	
	private MaxHeap <T> heap;
	private Instance<T> [] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue() {
		array= new Instance[10];
		heap= new MaxHeap<T>(array);
		this.size=0;
	}

	@Override
	public T extract_max() throws QueueIsEmptyException {
		if(size==0) {
			throw new QueueIsEmptyException("Priority Queue");
		}else {
			if(heap.getSize()!=0) {
				T element = heap.extractMaxAndDelete();
				size--;
				return element;
			}
		}	
		return null;
	}

	@Override
	public T maximun() throws QueueIsEmptyException {
		if(size==0) {
			throw new QueueIsEmptyException("Priority Queue");
		}else {
			//heap.buildMaxHeap();
			return heap.getMax();
		}	
	}

	@Override
	public boolean insertValue(Instance<T> element) {
		size++;
		return heap.insert(element);
	}
	
	public int getSize() {
		return size;
	}
	
	public String showArray() {
		return Arrays.toString(array);
	}

}
