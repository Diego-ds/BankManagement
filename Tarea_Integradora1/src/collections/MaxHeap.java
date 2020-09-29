package collections;

public class MaxHeap <T extends Comparable<T>> implements IMaxHeap<T> {
	
	
	private int heapSize;
	private int heapLength;
	private Instance<T>[] array;
	
	public MaxHeap(Instance <T> [] array) {
		this.array=array;
		heapLength=array.length;
		this.heapSize=0;
	}

	@Override
	public boolean insert(Instance<T> element) {
		
		if(heapSize<heapLength) {
		    increase_value(element,heapSize);
		    ++heapSize;
		}	
		return true;
	}

	@Override
	public void heapify(int i) {
		int largest = 0;
		int left = (2*i)+1;
		int right = (2*i)+2;   
		if(left <= heapSize && array[left].getElement().compareTo(array[i].getElement()) > 0) {
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
			heapify(largest);}
	}

	@Override
	public void buildMaxHeap() {
		for(int i = heapLength/2; i > 2; i--) {
			heapify(i);
		}
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
	
	@Override
	public T getMax() {
		if(array[0] != null) {
			return array[0].getElement();
		}else return null;
	}
	
	public T extractMaxAndDelete() {
		Instance <T> aux = array[0];
		array[0]=array[heapSize-1];
		heapSize--;
		heapify(0);	
		
				
		return aux.getElement();
	}
	
	
	public void increase_value (Instance<T> val,int i){
	    array[i] = val;
	    while( i > 1 && array[i/2].getElement().compareTo(array[i].getElement()) < 0)
	    {
	    	Instance <T> aux = array[i/2];
			array[i/2]=array[i];
			array[i]=aux;
			i = i/2;
	    }
	    heapify(0);
	}
	
}
