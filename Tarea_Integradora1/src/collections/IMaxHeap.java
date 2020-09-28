package collections;

public interface IMaxHeap<T extends Comparable<T>> {
		public void heapify(int i);
		public void buildMaxHeap();
		public boolean insert(T element);
		public T getMax();
		public void heapSort();
}
