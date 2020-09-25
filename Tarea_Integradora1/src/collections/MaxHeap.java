package collections;

public class MaxHeap <T extends Comparable<T>> implements IMaxHeap<T> {
	
	
	private Instance<T> [] array;
	private int heapSize;
	private int heapLength;
	
	
	@SuppressWarnings("unchecked")
	public MaxHeap() {
		this.heapLength=10;
		this.array = new Instance [heapLength];
		this.heapSize=0;
	}

	@Override
	public void heapify(int i) {
		int largest =0;
		int left = 2*i;
		int right = 2*i+1;                     
		if(left<= heapSize && array[left].getElement().compareTo(array[i].getElement()) > 0) {
			largest = left;
		}else {
			largest=i;
		}
		if(right <= heapSize && array[right].getElement().compareTo(array[largest].getElement()) > 0) {
			largest=right;
		}
		if(largest != i) {
			Instance<T> p = array[i];
			array[i] = array[largest];
			array[largest] = p;
			heapify(largest);
		}
		
	}

	@Override
	public void buildMaxHeap() {
		heapSize=heapLength;
		for(int i = heapLength/2; i > 1; i--) {
			heapify(i);
		}
	}

	@Override
	public boolean insert(Instance<T> element) {
		if(heapSize<heapLength) {
			for(int i = 0; i < heapLength; i++) {
				if(array[i] == null) {
					array[i] = element;
					buildMaxHeap();	
					return true;
				}
			}
		}
		return false;	
	}

	@Override
	public T getMax() {
		if(array[0] != null) {
			return array[0].getElement();
		}else return null;
	}

	@Override
	public void heapSort() {
		buildMaxHeap();
		for(int i=heapLength;i<1;i--) {
			Instance <T> aux = array[0];
			array[0]=array[i];
			array[i]=aux;
			heapSize--;
			heapify(0);
		}	
	}
	
}
