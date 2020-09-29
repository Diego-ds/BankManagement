package collections;

public interface IMaxHeap<T extends Comparable<T>> {
		public void heapify(int i);
		public void buildMaxHeap();
		public boolean insert(Instance<T> element);
		public void increase_value(Instance<T> element,int i);
		public T getMax();
		public void heapSort();
}
