package HeapTree;

public class HeapTree {
    private final int[] heap = new int[20];
    private int size;

    private int parent(int index) {
        return (index - 1) / 2;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public void insert(int value) {
        if (!isFull()) heap[size++] = value;
        bubbleUp();
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void swap(int index, int parent) {
        int temp = heap[index];
        heap[index] = heap[parent];
        heap[parent] = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + ",");
        }
    }

    public static void main(String[] args) {
        HeapTree heapTree = new HeapTree();

        heapTree.insert(23);
        heapTree.insert(32);
        heapTree.insert(91);
        heapTree.insert(100);
        heapTree.insert(2);
        heapTree.insert(600);
        heapTree.insert(1010);

        heapTree.print();
    }
}
