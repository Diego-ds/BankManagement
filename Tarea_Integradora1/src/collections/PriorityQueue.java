package collections;

public class PriorityQueue<T extends Comparable<T>> implements IPriorityQueue<T> {
	
	private MaxHeap <T> heap;
	private Instance<T> [] array;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue() {
		array= new Instance[10];
		heap= new MaxHeap<T>(array);
	}

	@Override
	public T extact_max() {
		if(heap.getSize()!=0) {
			T element = heap.extractMaxAndDelete();
			return element;
		}
		return null;
	}

	@Override
	public T maximun() {
		heap.heapSort();
		return heap.getMax();
		
	}

	@Override
	public boolean insertValue(Instance<T> element) {
		T add = element.getElement();
		return heap.insert(add);
	}
	

}
