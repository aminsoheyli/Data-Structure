package Data_Structure.linear;

import Data_Structure.non_linear.Heap;
import Data_Structure.non_linear.MaxHeap;

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
