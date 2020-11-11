package linear;

import non_linear.Heap;
import non_linear.MaxHeap;

public class PriorityQueueWithHeap {
    private MaxHeap heap;

    public PriorityQueueWithHeap(int size) {
        heap = Heap.createMaxHeap(size);
    }

    public void add(int item) {
        heap.insert(item);
    }

    public int remove() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
