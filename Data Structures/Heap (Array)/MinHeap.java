import java.util.ArrayList;

public class MinHeap {
    public ArrayList<Integer> heap;
    public int size;

    public MinHeap() {
        this.heap = new ArrayList<Integer>();
        this.heap.add(null);
        this.size = 0;
    }

    public void addElement(int value) {
        this.heap.add(value);
        this.size++;
        heapifyUp();
    }

    private boolean canSwap(int current, int left, int right) {
        return (this.exists(left) && (this.heap.get(current) > this.heap.get(left)))
                || (this.exists(right) && (this.heap.get(current) > this.heap.get(right)));
    }

    private boolean exists(int index) {
        return index <= this.size;
    }

    public void heapifyDown() {
        int current = 1;
        int leftChild = this.getLeft(current);
        int rightChild = this.getRight(current);
        while (this.canSwap(current, leftChild, rightChild)) {
            if (this.exists(leftChild) && this.exists(rightChild)) {
                if(this.heap.get(leftChild) < this.heap.get(rightChild)){
                    this.swap(current, leftChild);
                    current = leftChild;
                }
                else{
                    this.swap(current, rightChild);
                    current = rightChild;
                }
            } else {
                this.swap(current, leftChild);
                current = leftChild;
            }
            leftChild = this.getLeft(current);
            rightChild = this.getRight(current);

        }
    }

    public int pop() {
        if (this.size == 0)
            throw new RuntimeException("Heap is Empty");

        this.swap(1, this.size);

        int min = this.heap.remove(this.size);
        this.size --;
        heapifyDown();
        return min;
    }

    private void heapifyUp() {
        int current = this.size;
        while (current > 1 && this.heap.get(this.getParent(current)) > this.heap.get(current)) {

            this.swap(current, this.getParent(current));
            current = this.getParent(current);
        }

    }

    private void swap(int a, int b) {
        int temp = this.heap.get(b);
        this.heap.set(b, this.heap.get(a));
        this.heap.set(a, temp);
    }

    private int getParent(int current) {
        return (int) Math.floor(current / 2);
    }

    private int getLeft(int current) {
        return current * 2;
    }

    private int getRight(int current) {
        return current * 2 + 1;
    }
}
