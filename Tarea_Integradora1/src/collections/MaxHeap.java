package collections;

public class MaxHeap <T extends Comparable<T>> implements IMaxHeap<T> {
	
	
	private Instance<T> [] array;
	private int heapSize;
	private int heapLength;
	
	
	public MaxHeap(Instance <T>[]array) {
		this.array = array;
		heapLength=array.length;
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
		for(int i = heapLength/2; i > 1; i--) {
			heapify(i);
		}
	}

	@Override
	public boolean insert(T element) {
		Instance<T> add = new Instance<T>(element);
		if(heapSize<heapLength) {
			for(int i = 0; i < heapLength; i++) {
				if(array[i] == null) {
					array[i] = add;
					heapSize++;
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
		int size = heapSize;
		buildMaxHeap();
		for(int i=heapLength;i<1;i--) {
			Instance <T> aux = array[0];
			array[0]=array[i];
			array[i]=aux;
			heapSize--;
			heapify(0);
		}
		this.heapSize=size;
	}
	
	public int getSize() {
		return heapSize;
	}
	
	public T extractMaxAndDelete() {
		Instance <T> aux = array[0];
		array[0]=array[heapSize];
		array[heapSize]=aux;
		heapSize--;
		array[heapSize]=null;
		heapify(0);
		return aux.getElement();
	}
	
}
