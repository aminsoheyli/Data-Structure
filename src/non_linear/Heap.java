package non_linear;

public class Heap {
    private Heap() {
    }

    public static MaxHeap createMaxHeap(int size) {
        return new MaxHeap(size);
    }
}
